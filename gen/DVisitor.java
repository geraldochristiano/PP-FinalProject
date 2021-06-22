// Generated from /Users/geraldochristiano/IdeaProjects/PP-FinalProject/src/D.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declareStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareStat(DParser.DeclareStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(DParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code incrStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrStat(DParser.IncrStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decrStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecrStat(DParser.DecrStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whilstStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilstStat(DParser.WhilstStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wheneverStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWheneverStat(DParser.WheneverStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loopStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStat(DParser.LoopStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(DParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelStat(DParser.ParallelStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doNothingStat}
	 * labeled alternative in {@link DParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoNothingStat(DParser.DoNothingStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharExpr(DParser.CharExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerExpr(DParser.IntegerExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(DParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addMinExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddMinExpr(DParser.AddMinExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(DParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(DParser.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(DParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(DParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expoExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpoExpr(DParser.ExpoExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivExpr(DParser.MultDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOrExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOrExpr(DParser.AndOrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(DParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(DParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negate}
	 * labeled alternative in {@link DParser#prefixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(DParser.NegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link DParser#prefixOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(DParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(DParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(DParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(DParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterThan}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThan(DParser.GreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessEqual}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessEqual(DParser.LessEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterEqual}
	 * labeled alternative in {@link DParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterEqual(DParser.GreaterEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiply}
	 * labeled alternative in {@link DParser#multOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(DParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divide}
	 * labeled alternative in {@link DParser#multOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(DParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link DParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(DParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link DParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(DParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link DParser#boolOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(DParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link DParser#boolOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(DParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link DParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(DParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primType}
	 * labeled alternative in {@link DParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimType(DParser.PrimTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(DParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(DParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(DParser.CharTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link DParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(DParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(DParser.ArrayContext ctx);
}