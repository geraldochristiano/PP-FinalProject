// Generated from /Users/geraldochristiano/IdeaProjects/PP-FinalProject/src/D.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DParser}.
 */
public interface DListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declareStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStat(DParser.DeclareStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declareStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStat(DParser.DeclareStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(DParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(DParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code incrStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIncrStat(DParser.IncrStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code incrStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIncrStat(DParser.IncrStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decrStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDecrStat(DParser.DecrStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decrStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDecrStat(DParser.DecrStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whilstStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhilstStat(DParser.WhilstStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whilstStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhilstStat(DParser.WhilstStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code wheneverStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWheneverStat(DParser.WheneverStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code wheneverStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWheneverStat(DParser.WheneverStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loopStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterLoopStat(DParser.LoopStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loopStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitLoopStat(DParser.LoopStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(DParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(DParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parallelStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterParallelStat(DParser.ParallelStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parallelStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitParallelStat(DParser.ParallelStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doNothingStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDoNothingStat(DParser.DoNothingStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doNothingStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDoNothingStat(DParser.DoNothingStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCharExpr(DParser.CharExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCharExpr(DParser.CharExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntegerExpr(DParser.IntegerExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntegerExpr(DParser.IntegerExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(DParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(DParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addMinExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddMinExpr(DParser.AddMinExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addMinExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddMinExpr(DParser.AddMinExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(DParser.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(DParser.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(DParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(DParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(DParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(DParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(DParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(DParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expoExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpoExpr(DParser.ExpoExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expoExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpoExpr(DParser.ExpoExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDivExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultDivExpr(DParser.MultDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDivExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultDivExpr(DParser.MultDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andOrExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndOrExpr(DParser.AndOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andOrExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndOrExpr(DParser.AndOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(DParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(DParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(DParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(DParser.CompareExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negate}
	 * labeled alternative in {@link DParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void enterNegate(DParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negate}
	 * labeled alternative in {@link DParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void exitNegate(DParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link DParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void enterNot(DParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link DParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void exitNot(DParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterEqual(DParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitEqual(DParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterNotEqual(DParser.NotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitNotEqual(DParser.NotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(DParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(DParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterThan}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThan(DParser.GreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterThan}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThan(DParser.GreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessEqual}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterLessEqual(DParser.LessEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessEqual}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitLessEqual(DParser.LessEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterEqual}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterGreaterEqual(DParser.GreaterEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterEqual}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitGreaterEqual(DParser.GreaterEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link DParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(DParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link DParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(DParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divide}
	 * labeled alternative in {@link DParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterDivide(DParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divide}
	 * labeled alternative in {@link DParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitDivide(DParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link DParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterPlus(DParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link DParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitPlus(DParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minus}
	 * labeled alternative in {@link DParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterMinus(DParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link DParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitMinus(DParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link DParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterAnd(DParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link DParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitAnd(DParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link DParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterOr(DParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link DParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitOr(DParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link DParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(DParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link DParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(DParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primType}
	 * labeled alternative in {@link DParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterPrimType(DParser.PrimTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primType}
	 * labeled alternative in {@link DParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitPrimType(DParser.PrimTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterIntType(DParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitIntType(DParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(DParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(DParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterCharType(DParser.CharTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitCharType(DParser.CharTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterStringType(DParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitStringType(DParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(DParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link DParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(DParser.ArrayContext ctx);
}