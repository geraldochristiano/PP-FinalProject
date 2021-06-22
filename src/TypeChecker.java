import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class TypeChecker extends DBaseListener{

    public final static TypeChecker INSTANCE = new TypeChecker();

    private ParseTreeProperty<Type> type = new ParseTreeProperty<>();

    @Override
    public void exitIntegerExpr(DParser.IntegerExprContext ctx){
        type.put(ctx, Type.INTEGER);
    }

    @Override
    public void exitBooleanExpr(DParser.BooleanExprContext ctx){
        type.put(ctx, Type.BOOLEAN);
    }

    @Override
    public void exitCharExpr(DParser.CharExprContext ctx){
        type.put(ctx, Type.CHARACTER);
    }

    @Override
    public void exitStringExpr(DParser.StringExprContext ctx){
        type.put(ctx, Type.STRING);
    }



}
