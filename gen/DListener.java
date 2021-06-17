// Generated from C:/Users/Twam/Documents/PP-FinalProject/src\D.g4 by ANTLR 4.9.1
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
	 * Enter a parse tree produced by {@link DParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(DParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(DParser.TypeContext ctx);
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