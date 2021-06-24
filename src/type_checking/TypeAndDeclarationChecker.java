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

public class TypeAndDeclarationChecker extends DBaseListener {

    public final static TypeAndDeclarationChecker INSTANCE = new TypeAndDeclarationChecker();

    private ParseTreeProperty<Type> nodeType;
    private DSymbolTable symbolTable;
    private ArrayList<String> errors;

    @Override
    public void enterDeclareStat(DeclareStatContext ctx){
        boolean isWheneverStatement = ctx.parent instanceof WheneverStatContext;
        if (isWheneverStatement) symbolTable.openScope();

        for (int i = 0; i < ctx.ID().size(); i ++){
            String id = ctx.ID(i).getText();
            if (!declareInSymbolTable(ctx.dataType(), id,false))
                addError("Can not redeclare '" + id + "' in the same scope.", ctx);
        }

        if (isWheneverStatement) symbolTable.closeScope();

    }

    @Override
    public void exitAssignStat(AssignStatContext ctx){
        boolean isWheneverStatement = ctx.parent instanceof WheneverStatContext;
        if (isWheneverStatement) symbolTable.openScope();

        if (ctx.ID().size() != ctx.expr().size()){
            addError("Number of variables and expressions do not match", ctx);
        } else if (ctx.dataType() != null){ // Variable(s) are declared and assigned
            for (int i = 0; i < ctx.ID().size(); i++){
                String id = ctx.ID(i).getText();
                if (!declareInSymbolTable(ctx.dataType(), id, true))
                    addError("Can not redeclare '" + id + "' in the same scope.", ctx);
                else {
                    if (!nodeType.get(ctx.expr(i)).equals(symbolTable.getType(id))){
                        addError("Can not assign to '" + id + "' because expected and actual type is different",ctx);
                    }
                }
            }
        } else { // Variable(s) are only assigned
            for (int i = 0; i < ctx.ID().size(); i++){
                String id = ctx.ID(i).getText();
                if (!symbolTable.contains(id)){
                    addError("Can not assign to '" + id + "' as it has not been declared before.", ctx);
                } else {
                    if (!nodeType.get(ctx.expr(i)).equals(symbolTable.getType(id))){
                        addError("Can not assign to '" + id + "' because expected and actual type is different",ctx);
                    } else symbolTable.initialize(id);
                }
            }
        }

        if (isWheneverStatement) symbolTable.closeScope();
    }

    /**
     * Tries to declare a variable in the symbol table.
     *
     * @param ctx parse tree node containing the data type keyword
     * @param id identifier of the variable
     * @param init whether the identifier is also initialized
     * @return <code>true</code> if the variable can be declared in the current scope, <code>false</code> otherwise.
     */
    public boolean declareInSymbolTable(DataTypeContext ctx, String id, boolean init){
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
                case "str":
                    return symbolTable.add(true, id, init, Type.STRING);
            }
        } else if (ctx instanceof ArrayTypeContext arr){
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
                case "str":
                    return symbolTable.add(true, id, init, new ArrayType(Type.STRING, lengths));
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
            addError("Can not increment '" + id + "' as it is not an integer", ctx);

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
            addError("Can not decrement '" + id + "' as it is not an integer", ctx);

        if (isWheneverStatement) symbolTable.closeScope();
    }

    @Override
    public void enterWhilstStat(WhilstStatContext ctx){
        symbolTable.openScope();
    }

    @Override
    public void exitWhilstStat(WhilstStatContext ctx){
        if (!nodeType.get(ctx.expr()).equals(Type.BOOLEAN))
            addError("Invalid expression. Whilst condition expression is not of type boolean", ctx);
       symbolTable.closeScope();
    }

    @Override
    public void exitWheneverStat(WheneverStatContext ctx){
        if (!nodeType.get(ctx.expr()).equals(Type.BOOLEAN))
            addError("Invalid expression. Whenever condition expression is not of type boolean",ctx);
    }

    @Override
    public void enterLoopStat(LoopStatContext ctx){
        if (ctx.stat(0) instanceof BlockStatContext)
            addError("Invalid statement. Begin statement can not be a block statement.", ctx);
        if (ctx.stat(1) instanceof BlockStatContext)
            addError("Invalid statement. End statement can not be a block statement", ctx);
        symbolTable.openScope();
    }

    @Override
    public void exitLoopStat(LoopStatContext ctx){
        if (!nodeType.get(ctx.expr()).equals(Type.BOOLEAN))
            addError("Invalid expression. Loop condition expression is not of type boolean",ctx);
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
        if (Integer.parseInt(ctx.INTEGER().getText()) < 2)
            addError("Parallel block must be at least executed by 2 threads", ctx);
        symbolTable.openScope();
    }

    @Override
    public void exitParallelStat(ParallelStatContext ctx){
        symbolTable.closeScope();
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
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitMultDivExpr(MultDivExprContext ctx){
        if ((nodeType.get(ctx.expr(0)).equals(Type.INTEGER)) && (nodeType.get(ctx.expr(1)).equals(Type.INTEGER))){
            nodeType.put(ctx, Type.INTEGER);
        } else {
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitAddMinExpr(AddMinExprContext ctx){
        if ((nodeType.get(ctx.expr(0)).equals(Type.INTEGER)) && (nodeType.get(ctx.expr(1)).equals(Type.INTEGER))){
            nodeType.put(ctx, Type.INTEGER);
        } else {
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitCompareExpr(CompareExprContext ctx){
        if ((nodeType.get(ctx.expr(0)).equals(Type.INTEGER)) && (nodeType.get(ctx.expr(1)).equals(Type.INTEGER))){
            nodeType.put(ctx, Type.BOOLEAN);
        } else {
            nodeType.put(ctx, Type.ERROR);
        }
    }

    @Override
    public void exitAndOrExpr(AndOrExprContext ctx){
        if ((nodeType.get(ctx.expr(0)).equals(Type.BOOLEAN)) && (nodeType.get(ctx.expr(1)).equals(Type.BOOLEAN))){
            nodeType.put(ctx, Type.BOOLEAN);
        } else {
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
    public void exitStringExpr(StringExprContext ctx){
        nodeType.put(ctx, Type.STRING);
    }

    @Override
    public void exitArrayExpr(ArrayExprContext ctx){
        if (ctx.expr().size() == 0){
            ArrayList<Integer> lst = new ArrayList<>();
            lst.add(0);
            nodeType.put(ctx, new ArrayType(Type.WILDCARD, lst));
            return;
        }

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

        if (curr instanceof ArrayType arrayType){
            ArrayList<Integer> lst = new ArrayList<>(arrayType.getLengths());
            lst.add(0,ctx.expr().size());
            nodeType.put(ctx, new ArrayType(arrayType.getBaseType(),lst));
        } else {
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
     * Check program for type and declaration usage correctness from the given stream.
     * @param stream stream of strings
     * @return <code>true</code> if type and declaration usage are correct, <code>false</code> otherwise
     */
    public boolean checkProgram(CharStream stream){
        ParsingErrorListener errorListener = new ParsingErrorListener();
        DLexer lexer = new DLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        DParser parser = new DParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.program();
        if (errorListener.hasErrors()){
            errorListener.getErrors().forEach(System.out::println);
            return false;
        }
        this.symbolTable = new DSymbolTable();
        this.nodeType = new ParseTreeProperty<>();
        this.errors = new ArrayList<>();
        ParseTreeWalker.DEFAULT.walk(this,tree);
        if (this.errors.size() > 0){
            this.errors.forEach(System.out::println);
            return false;
        }
        return true;
    }

    public boolean checkProgram(String text){
        return checkProgram(CharStreams.fromString(text));
    }

}
