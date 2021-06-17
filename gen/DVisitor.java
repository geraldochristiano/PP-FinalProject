// Generated from C:/Users/Twam/Documents/PP-FinalProject/src\D.g4 by ANTLR 4.9.1
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
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(DParser.PrefixExprContext ctx);
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
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link DParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(DParser.ParensExprContext ctx);
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
	 * Visit a parse tree produced by {@link DParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(DParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(DParser.ArrayContext ctx);
}