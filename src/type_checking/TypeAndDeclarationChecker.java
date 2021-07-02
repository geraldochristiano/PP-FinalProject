package type_checking;

import error_listener.ParsingErrorListener;
import grammar.DBaseListener;
import grammar.DLexer;
import grammar.DParser;
import grammar.DParser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class for checking the correctness of type of expressions, declaration of variables and their assignment, and
 * correct usage and placing of statements.
 */
public class TypeAndDeclarationChecker extends DBaseListener {

    public final static TypeAndDeclarationChecker INSTANCE = new TypeAndDeclarationChecker();

    private ParseTreeProperty<Type> nodeType;
    private DSymbolTable symbolTable;
    private ArrayList<String> errors;
    private Set<String> sharedVariables;
    private ArrayList<ArrayList<String>> currentParallelLocalVar;

    @Override
    public void enterDeclareStat(DeclareStatContext ctx){
        // Check redeclaration of shared variable
        // Redeclaration of a shared variable is not allowed
        String id = ctx.ID().getText();
        if (sharedVariables.contains(id)){
            addError("Shared variables can not be redeclared anywhere with the same or different type." +
                    " Only assignment is allowed.", ctx);
        }

        // Check scope of declaration of shared variable
        // Only global level declaration is allowed
        if (ctx.SHARED() != null) {
            if (!(ctx.parent instanceof ProgramContext)) {
                addError("Shared variables can only be declared at global level.", ctx);
            } else {
                sharedVariables.add(id);
            }
        }
        // Check if the current statement is the 'then statement' or 'else statement' of a whenever statement
        boolean isWheneverStatement = ctx.parent instanceof WheneverStatContext;
        if (isWheneverStatement) symbolTable.openScope();


        if (!declareInSymbolTable(ctx.dataType(), id,false))
            addError("Can not redeclare '" + id + "' in the same scope.", ctx);
        else {
            if (currentParallelLocalVar.size() != 0 && !sharedVariables.contains(id)){
                // Declaration in parallel block
                currentParallelLocalVar.get(currentParallelLocalVar.size() - 1).add(id);
            }
        }

        if (isWheneverStatement) symbolTable.closeScope();

    }

    @Override
    public void exitAssignStat(AssignStatContext ctx){
        // Check if the current statement is the 'then statement' or 'else statement' of a whenever statement
        boolean isWheneverStatement = ctx.parent instanceof WheneverStatContext;
        if (isWheneverStatement) symbolTable.openScope();

        if (ctx.dataType() != null){ // Variable is declared and assigned
            // Check redeclaration of shared variable
            // Redeclaration of a shared variable is not allowed
            String id = ctx.ID().getText();
            if (sharedVariables.contains(id)){
                addError("Shared variables can not be redeclared with the same or different type." +
                        " Only assignment is permitted.", ctx);
            }

            // Check scope of declaration of shared variable
            // Only global level declaration is allowed
            if (ctx.SHARED() != null) {
                if (!(ctx.parent instanceof ProgramContext)) {
                    addError("Shared variables can only be declared at global level.", ctx);
                } else {
                    sharedVariables.add(id);
                }
            }

            if (!declareInSymbolTable(ctx.dataType(), id, true))
                addError("Can not redeclare '" + id + "' in the same scope.", ctx);
            else if (!nodeType.get(ctx.expr()).equals(symbolTable.getType(id)))
                addError("Can not assign to '" + id + "' because expected and actual type is different.", ctx);
            else if (currentParallelLocalVar.size() != 0 && !sharedVariables.contains(id)){
                // Declaration and assignment in parallel block
                if (!onlyLocalAndSharedVariablesUsed(ctx.expr()))
                    addError("Can not declare and assign to '" + id + "' because it uses local variable(s)" +
                            " outside the current parallel block", ctx);
                else currentParallelLocalVar.get(currentParallelLocalVar.size() - 1).add(id);
            }

        } else { // Variable is only assigned
            String id = ctx.ID().getText();
            if (!symbolTable.contains(id)){
                addError("Can not assign to '" + id + "' as it has not been declared before.", ctx);
            } else if (!nodeType.get(ctx.expr()).equals(symbolTable.getType(id))){
                addError("Can not assign to '" + id + "' because expected and actual type is different.",ctx);
            } else if (currentParallelLocalVar.size() != 0 && !sharedVariables.contains(id)){
                // Assignment in parallel block
                ArrayList<String> localVars = currentParallelLocalVar.get(currentParallelLocalVar.size() - 1);
                if (!localVars.contains(id))
                    addError("Can not assign to '" + id + "' because it is a local variable " +
                            "outside current parallel block.", ctx);
                else if (!onlyLocalAndSharedVariablesUsed(ctx.expr()))
                    addError("Can not assign to '" + id + "' because it uses local variable(s) " +
                            "outside the current parallel block", ctx);
                else symbolTable.initialize(id);
            } else symbolTable.initialize(id);

        }

        if (isWheneverStatement) symbolTable.closeScope();
    }

    /**
     * Check if an expression in a parallel block only uses shared variables or local variables on the current parallel
     * block.
     * @param ctx parse tree node of the expression
     * @return <code>true</code> if an expression only uses shared variables and parallel block local variables,
     * <code>false</code> otherwise
     */
    public boolean onlyLocalAndSharedVariablesUsed(ExprContext ctx){
        if (ctx instanceof PrefixExprContext cast)
            return onlyLocalAndSharedVariablesUsed(cast);
        else if (ctx instanceof ExpoExprContext cast)
            return onlyLocalAndSharedVariablesUsed(cast.expr(0)) && onlyLocalAndSharedVariablesUsed(cast.expr(1));
        else if (ctx instanceof MultDivExprContext cast)
            return onlyLocalAndSharedVariablesUsed(cast.expr(0)) && onlyLocalAndSharedVariablesUsed(cast.expr(1));
        else if (ctx instanceof AddMinExprContext cast)
            return onlyLocalAndSharedVariablesUsed(cast.expr(0)) && onlyLocalAndSharedVariablesUsed(cast.expr(1));
        else if (ctx instanceof CompareExprContext cast)
            return onlyLocalAndSharedVariablesUsed(cast.expr(0)) && onlyLocalAndSharedVariablesUsed(cast.expr(1));
        else if (ctx instanceof BitwiseOpExprContext cast)
            return onlyLocalAndSharedVariablesUsed(cast.expr(0)) && onlyLocalAndSharedVariablesUsed(cast.expr(1));
        else if (ctx instanceof ShiftOpExprContext cast)
            return onlyLocalAndSharedVariablesUsed(cast.expr(0)) && onlyLocalAndSharedVariablesUsed(cast.expr(1));
        else if (ctx instanceof ParensExprContext cast)
            return  onlyLocalAndSharedVariablesUsed(cast.expr());
        else if (ctx instanceof IdExprContext cast){
            String id = cast.ID().getText();
            return sharedVariables.contains(id) ||
                    currentParallelLocalVar.get(currentParallelLocalVar.size() - 1).contains(id);
        } else if (ctx instanceof ArrayExprContext cast){
            boolean c = true;
            for (ExprContext expr : cast.expr()){
                c &= onlyLocalAndSharedVariablesUsed(expr);
            }
            return c;
        } else {
            return true;
        }
    }

    /**
     * Tries to declare a variable in the symbol table.
     *
     * @param ctx parse tree node containing the data type keyword
     * @param id identifier of the variable
     * @param init whether the identifier is also initialized
     * @return <code>true</code> if the variable is declared successfully in the current scope,
     * <code>false</code> otherwise.
     */
    private boolean declareInSymbolTable(DataTypeContext ctx, String id, boolean init){
        if (ctx instanceof PrimTypeContext prim){
            PrimitiveContext primitive = prim.primitive();
            String typeKeyword = primitive.getText();
            switch (typeKeyword) {
                case "int":
                    return symbolTable.add(true, id, init, Type.INTEGER);
                case "bool":
                    return symbolTable.add(true, id, init, Type.BOOLEAN);
                case "char":
                    return symbolTable.add(true, id, init, Type.CHARACTER);
            }
        } else if (ctx instanceof ArrayTypeContext arr){
            addError("Can not declare array, ARRAY IS NOT SUPPORTED YET!", ctx);
            ArrayContext array = arr.array();
            ArrayList<Integer> lengths = new ArrayList<>();
            for (int i = 0; i < array.INTEGER().size(); i++){
                int len = Integer.parseInt(array.INTEGER(i).getText());
                lengths.add(len);
            }
            PrimitiveContext primitive = array.primitive();
            String typeKeyword = primitive.getText();
            switch (typeKeyword) {
                case "int":
                    return symbolTable.add(true, id, init, new ArrayType(Type.INTEGER, lengths));
                case "bool":
                    return symbolTable.add(true, id, init, new ArrayType(Type.BOOLEAN, lengths));
                case "char":
                    return symbolTable.add(true, id, init, new ArrayType(Type.CHARACTER, lengths));
            }
        }
        return false;
    }

    @Override
    public void enterIncrStat(IncrStatContext ctx){
        boolean isWheneverStatement = ctx.parent instanceof WheneverStatContext;
        if (isWheneverStatement) symbolTable.openScope();

        String id = ctx.ID().getText();
        if (!symbolTable.contains(id))
            addError("Can not increment '" + id + "' as it has not been declared.", ctx);
        else if (!symbolTable.isInitialized(id))
            addError("Can not increment '" + id + "' as it is not assigned any value.", ctx);
        else if (symbolTable.getType(id) != Type.INTEGER)
            addError("Can not increment '" + id + "' as it is not an integer.", ctx);

        if (isWheneverStatement) symbolTable.closeScope();
    }

    @Override
    public void enterDecrStat(DecrStatContext ctx){
        boolean isWheneverStatement = ctx.parent instanceof WheneverStatContext;
        if (isWheneverStatement) symbolTable.openScope();

        String id = ctx.ID().getText();
        if (!symbolTable.contains(id))
            addError("Can not decrement '" + id + "' as it has not been declared.", ctx);
        else if (!symbolTable.isInitialized(id))
            addError("Can not decrement '" + id + "' as it is not assigned any value.", ctx);
        else if (symbolTable.getType(id) != Type.INTEGER)
            addError("Can not decrement '" + id + "' as it is not an integer.", ctx);

        if (isWheneverStatement) symbolTable.closeScope();
    }

    @Override
    public void enterWhilstStat(WhilstStatContext ctx){
        if (ctx.stat() instanceof DeclareStatContext)
            addError("Invalid statement. Can not declare variable here.", ctx.stat());
        if (ctx.stat() instanceof AssignStatContext assign && assign.dataType() != null)
            addError("Invalid statement. Can not declare and assign variable here.", ctx.stat());
        symbolTable.openScope();
    }

    @Override
    public void exitWhilstStat(WhilstStatContext ctx){
        if (!nodeType.get(ctx.expr()).equals(Type.BOOLEAN))
            addError("Invalid expression. Whilst condition expression is not of type boolean.", ctx.expr());
        symbolTable.closeScope();
    }

    @Override
    public void enterWheneverStat(WheneverStatContext ctx){
        if (ctx.stat(0) instanceof DeclareStatContext)
            addError("Invalid statement. Can not declare variable here.", ctx.stat(0));
        if (ctx.stat(0) instanceof AssignStatContext assign && assign.dataType() != null)
            addError("Invalid statement. Can not declare variable here.", ctx.stat(0));
        if (ctx.stat(1) != null){
            if (ctx.stat(1) instanceof DeclareStatContext)
                addError("Invalid statement. Can not declare variable here.", ctx.stat(1));
            if (ctx.stat(1) instanceof AssignStatContext assign && assign.dataType() != null)
                addError("Invalid statement. Can not declare variable here.", ctx.stat(1));
        }
    }

    @Override
    public void exitWheneverStat(WheneverStatContext ctx){
        if (!nodeType.get(ctx.expr()).equals(Type.BOOLEAN))
            addError("Invalid expression. Whenever condition expression is not of type boolean.",ctx.expr());
    }

    @Override
    public void enterLoopStat(LoopStatContext ctx){
        StatContext beginStat = ctx.stat(0);
        StatContext endStat = ctx.stat(1);
        if (beginStat instanceof AssignStatContext || beginStat instanceof IncrStatContext
                || beginStat instanceof DecrStatContext || beginStat instanceof DoNothingStatContext);
        else addError("Invalid statement type in loop begin statement.", beginStat);

        if (endStat instanceof AssignStatContext || endStat instanceof IncrStatContext
                || endStat instanceof DecrStatContext || endStat instanceof DoNothingStatContext);
        else addError("Invalid statement type in loop end statement.", endStat);

        if (ctx.stat(2) instanceof DeclareStatContext)
            addError("Invalid statement. Can not declare variable here.", ctx.stat(2));
        if (ctx.stat(2) instanceof AssignStatContext assign && assign.dataType() != null)
            addError("Invalid statement. Can not declare and assign variable here.", ctx.stat(2));
        symbolTable.openScope();
    }

    @Override
    public void exitLoopStat(LoopStatContext ctx){
        if (!nodeType.get(ctx.expr()).equals(Type.BOOLEAN))
            addError("Invalid expression. Loop condition expression is not of type boolean.",ctx.expr());
        symbolTable.closeScope();
    }

    @Override
    public void enterBlockStat(BlockStatContext ctx){
        symbolTable.openScope();
    }

    @Override
    public void exitBlockStat(BlockStatContext ctx){
        symbolTable.closeScope();
    }

    @Override
    public void enterParallelStat(ParallelStatContext ctx){
        RuleContext curr = ctx.parent;
        while (!(curr instanceof ProgramContext)){
            if (curr instanceof CritSectionStatContext){
                addError("Critical section can not contain parallel statement", ctx);
                break;
            }
            curr = curr.parent;
        }
        symbolTable.openScope();
        currentParallelLocalVar.add(new ArrayList<>());
    }

    @Override
    public void exitParallelStat(ParallelStatContext ctx){
        symbolTable.closeScope();
        currentParallelLocalVar.remove(currentParallelLocalVar.size() - 1);
    }

    @Override
    public void enterCritSectionStat(CritSectionStatContext ctx){
        RuleContext curr = ctx.parent;
        while (!(curr instanceof ProgramContext)){
            if (curr instanceof CritSectionStatContext){
                addError("Critical section can not be inside another critical section.", ctx);
            }
            if (curr instanceof ParallelStatContext){
                symbolTable.openScope();
                return;
            }
            curr = curr.parent;
        }
        addError("Critical section is not allowed outside parallel block.", ctx);
        symbolTable.openScope();
    }

    @Override
    public void exitCritSectionStat(CritSectionStatContext ctx){
        symbolTable.closeScope();
    }

    @Override
    public void enterBreakStat(BreakStatContext ctx){
        if (!partOfLoop(ctx))
            addError("Invalid usage of break statement. " +
                    "Break statement must be inside a whilst or loop statement.", ctx);
    }

    @Override
    public void enterContinueStat(ContinueStatContext ctx){
        if (!partOfLoop(ctx))
            addError("Invalid usage of continue statement." +
                    "Continue statement must be inside a whilst or loop statement.", ctx);
    }

    /**
     * Check if a statement is inside a whilst or loop statement.
     * Generally used to check if a continue or break statement is inside them.
     * @param ctx the parse tree node of the statement
     * @return <code>true</code> if the statement is inside a whilst or loop statement, <code>false</code> otherwise.
     */
    private boolean partOfLoop(RuleContext ctx){
        RuleContext currentCtx = ctx;
        while (!(currentCtx instanceof ProgramContext)){
            if (currentCtx instanceof LoopStatContext || currentCtx instanceof WhilstStatContext) return true;
            currentCtx = currentCtx.parent;
        }
        return false;
    }

    @Override
    public void enterPrintStat(PrintStatContext ctx){
        String id = ctx.ID().getText();
        if (currentParallelLocalVar.size() > 0){ // in parallel block
            if (!sharedVariables.contains(id) &&
                    !currentParallelLocalVar.get(currentParallelLocalVar.size() - 1).contains(id))
                addError("Can not print. Variable has not been declared.", ctx);
        } else { // not in parallel block
            if (!symbolTable.contains(ctx.ID().getText()) && !sharedVariables.contains(ctx.ID().getText())) {
                addError("Can not print. Variable has not been declared.", ctx);
            }
        }
    }

    @Override
    public void exitPrefixExpr(PrefixExprContext ctx){
        PrefixOpContext prefix = ctx.prefixOp();
        Type type = nodeType.get(ctx.expr());
        if (prefix instanceof NegateContext){
            if (type.equals(Type.INTEGER)) nodeType.put(ctx, Type.INTEGER);
            else nodeType.put(ctx, Type.ERROR);
        } else if (prefix instanceof  NotContext){
            if (type.equals(Type.BOOLEAN)) nodeType.put(ctx, Type.BOOLEAN);
            else nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitExpoExpr(ExpoExprContext ctx){
        if ((nodeType.get(ctx.expr(0)).equals(Type.INTEGER)) && (nodeType.get(ctx.expr(1)).equals(Type.INTEGER))){
            nodeType.put(ctx, Type.INTEGER);
        } else {
            addError("Exponentiation only works for integers.", ctx);
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitMultDivExpr(MultDivExprContext ctx){
        if ((nodeType.get(ctx.expr(0)).equals(Type.INTEGER)) && (nodeType.get(ctx.expr(1)).equals(Type.INTEGER))){
            nodeType.put(ctx, Type.INTEGER);
        } else if ((nodeType.get(ctx.expr(0)).equals(Type.ERROR)) || (nodeType.get(ctx.expr(1)).equals(Type.ERROR))){
            nodeType.put(ctx, Type.ERROR);
        } else {
            addError("Multiplication and division only work for integers.", ctx);
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitAddMinExpr(AddMinExprContext ctx){
        if ((nodeType.get(ctx.expr(0)).equals(Type.INTEGER)) && (nodeType.get(ctx.expr(1)).equals(Type.INTEGER))) {
            nodeType.put(ctx, Type.INTEGER);
        } else if ((nodeType.get(ctx.expr(0)).equals(Type.ERROR)) || (nodeType.get(ctx.expr(1)).equals(Type.ERROR))){
            nodeType.put(ctx, Type.ERROR);
        } else {
            addError("Addition and subtraction only work for integers.", ctx);
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitCompareExpr(CompareExprContext ctx){
        Type expr0 = nodeType.get(ctx.expr(0));
        Type expr1 = nodeType.get(ctx.expr(1));
        if ((expr0 == Type.ERROR) || (expr1 == Type.ERROR)){
            nodeType.put(ctx, Type.ERROR);
        } else if (expr0.equals(expr1)){
            nodeType.put(ctx, Type.BOOLEAN);
        } else {
            addError("Incompatible types. Compare operation works with equal types", ctx);
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitBitwiseOpExpr(BitwiseOpExprContext ctx){
        Type expr0 = nodeType.get(ctx.expr(0));
        Type expr1 = nodeType.get(ctx.expr(1));

        if ((expr0 == Type.ERROR) || (expr1 == Type.ERROR)){
            nodeType.put(ctx, Type.ERROR);
        } else if (expr0.equals(expr1)){
            if ((expr0 == Type.INTEGER) || (expr0 == Type.BOOLEAN)){
                nodeType.put(ctx, expr0);
            } else {
                addError("Bitwise/logical operation only works for integers and booleans", ctx);
                nodeType.put(ctx, Type.ERROR);
            }
        } else {
            addError("Both operands of a bitwise/logical operation must be of equal type", ctx);
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitShiftOpExpr(ShiftOpExprContext ctx){
        Type expr0 = nodeType.get(ctx.expr(0));
        Type expr1 = nodeType.get(ctx.expr(1));

        if ((expr0 == Type.ERROR) || (expr1 == Type.ERROR)){
            nodeType.put(ctx, Type.ERROR);
        } else if (!(expr1 == Type.INTEGER)) {
            addError("Left operand of a shift operation must be an integer",ctx);
            nodeType.put(ctx, Type.ERROR);
        } else if (expr0 == Type.INTEGER || expr0 == Type.CHARACTER){
            nodeType.put(ctx, expr0);
        } else {
            addError("Shift operation only works for integers and characters", ctx);
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitParensExpr(ParensExprContext ctx){
        nodeType.put(ctx, nodeType.get(ctx.expr()));
    }

    @Override
    public void exitIdExpr(IdExprContext ctx){
        if (symbolTable.isInitialized(ctx.getText())){
            nodeType.put(ctx, symbolTable.getType(ctx.getText()));
        } else {
            addError("Can not use '" + ctx.ID().getText() + "' as it has not been initialized", ctx);
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitIntegerExpr(IntegerExprContext ctx){
        nodeType.put(ctx, Type.INTEGER);
    }

    @Override
    public void exitBooleanExpr(BooleanExprContext ctx){
        nodeType.put(ctx, Type.BOOLEAN);
    }

    @Override
    public void exitCharExpr(CharExprContext ctx){
        nodeType.put(ctx, Type.CHARACTER);
    }

    @Override
    public void exitArrayExpr(ArrayExprContext ctx){
        if (ctx.expr().size() == 0){ // Array is empty, can be of any type
            ArrayList<Integer> lst = new ArrayList<>();
            lst.add(0);
            nodeType.put(ctx, new ArrayType(Type.WILDCARD, lst));
            return;
        }
        // Check if all elements of the array are of the same type
        Type curr = nodeType.get(ctx.expr(0));
        for (int i = 0; i < ctx.expr().size(); i++){
            Type next = nodeType.get(ctx.expr(i));
            if (next.equals(Type.ERROR)){
                nodeType.put(ctx, Type.ERROR);
                return;
            }
            if (curr.equals(next)){
                curr = next;
            } else {
                nodeType.put(ctx, Type.ERROR);
                return;
            }
        }

        if (curr instanceof ArrayType arrayType){ // The elements of this array are also arrays
            ArrayList<Integer> lst = new ArrayList<>(arrayType.getLengths());
            lst.add(0,ctx.expr().size());
            nodeType.put(ctx, new ArrayType(arrayType.getBaseType(),lst));
        } else { // The elements of this array are of primitive types
            ArrayList<Integer> lst = new ArrayList<>();
            lst.add(ctx.expr().size());
            nodeType.put(ctx, new ArrayType(curr, lst));
        }
    }

    private void addError(String msg , ParserRuleContext ctx){
        errors.add("Line: " + ctx.getStart().getLine() + ", Start position: "
                + ctx.getStart().getCharPositionInLine() + "\n\tMessage: " + msg);
    }

    /**
     * Check program for type and declaration usage correctness from parse tree of the program.
     * @param tree parse tree of the program to be checked
     * @return <code>true</code> if type and declaration usage are correct, <code>false</code> otherwise
     */
    public boolean checkProgram(ParseTree tree){
        this.symbolTable = new DSymbolTable();
        this.nodeType = new ParseTreeProperty<>();
        this.errors = new ArrayList<>();
        this.sharedVariables = new HashSet<>();
        this.currentParallelLocalVar = new ArrayList<>();
        ParseTreeWalker.DEFAULT.walk(this,tree);
        if (this.errors.size() > 0){
            this.errors.forEach(System.out::println);
            return false;
        }
        return true;
    }

    /**
     * Check program for type and declaration usage correctness.
     * @param text the program text
     * @return <code>true</code> if type and declaration usage are correct, <code>false</code> otherwise
     */
    public boolean checkProgram(String text) {
        CharStream stream = CharStreams.fromString(text);
        ParsingErrorListener errorListener = new ParsingErrorListener();
        DLexer lexer = new DLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        DParser parser = new DParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.program();
        if (errorListener.hasErrors()) {
            System.out.println("Parsing error! Messages:");
            errorListener.getErrors().forEach(System.out::println);
            return false;
        }
        return checkProgram(tree);
    }

    public static void main(String[] args) {
        String str = """
                print(c);
                """;
        System.out.println(TypeAndDeclarationChecker.INSTANCE.checkProgram(str));
    }
}
