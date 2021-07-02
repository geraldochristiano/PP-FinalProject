// Generated from /Users/geraldochristiano/IdeaProjects/PP-FinalProject/src/grammar/D.g4 by ANTLR 4.9.1
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, EQ=2, NEQ=3, LT=4, GT=5, LEQ=6, GEQ=7, INCR=8, DECR=9, POW=10, 
		NOT=11, PLUS=12, MINUS=13, MULT=14, DIV=15, LPAR=16, RPAR=17, LCURLY=18, 
		RCURLY=19, LBAR=20, RBAR=21, AND=22, OR=23, XOR=24, LSHIFT=25, RSHIFT=26, 
		QUOTE=27, DQUOTE=28, COMMA=29, VERTSLASH=30, SEMI=31, PRINT=32, SHARED=33, 
		CRITICAL=34, WHILST=35, WHENEVER=36, ELSEWAYS=37, LOOP=38, INT=39, BOOL=40, 
		CHAR=41, PARALLEL=42, BREAK=43, CONTINUE=44, BOOLEAN=45, CHARLITERAL=46, 
		ID=47, INTEGER=48, WS=49;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_expr = 2, RULE_prefixOp = 3, RULE_compOp = 4, 
		RULE_multOp = 5, RULE_addOp = 6, RULE_bitwiseOp = 7, RULE_shiftOp = 8, 
		RULE_dataType = 9, RULE_primitive = 10, RULE_array = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "expr", "prefixOp", "compOp", "multOp", "addOp", "bitwiseOp", 
			"shiftOp", "dataType", "primitive", "array"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'++'", "'--'", 
			"'^'", "'!'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "'and'", "'or'", "'xor'", "'<<'", "'>>'", "'''", "'\"'", 
			"','", "'|'", "';'", "'print'", "'shared'", "'critical'", "'whilst'", 
			"'whenever'", "'elseways'", "'loop'", "'int'", "'bool'", "'char'", "'parallel'", 
			"'break'", "'continue'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "EQ", "NEQ", "LT", "GT", "LEQ", "GEQ", "INCR", "DECR", "POW", 
			"NOT", "PLUS", "MINUS", "MULT", "DIV", "LPAR", "RPAR", "LCURLY", "RCURLY", 
			"LBAR", "RBAR", "AND", "OR", "XOR", "LSHIFT", "RSHIFT", "QUOTE", "DQUOTE", 
			"COMMA", "VERTSLASH", "SEMI", "PRINT", "SHARED", "CRITICAL", "WHILST", 
			"WHENEVER", "ELSEWAYS", "LOOP", "INT", "BOOL", "CHAR", "PARALLEL", "BREAK", 
			"CONTINUE", "BOOLEAN", "CHARLITERAL", "ID", "INTEGER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "D.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << SEMI) | (1L << PRINT) | (1L << SHARED) | (1L << CRITICAL) | (1L << WHILST) | (1L << WHENEVER) | (1L << LOOP) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << PARALLEL) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID))) != 0)) {
				{
				{
				setState(24);
				stat();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlockStatContext extends StatContext {
		public TerminalNode LCURLY() { return getToken(DParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DParser.RCURLY, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStatContext extends StatContext {
		public TerminalNode PRINT() { return getToken(DParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(DParser.LPAR, 0); }
		public TerminalNode ID() { return getToken(DParser.ID, 0); }
		public TerminalNode RPAR() { return getToken(DParser.RPAR, 0); }
		public TerminalNode SEMI() { return getToken(DParser.SEMI, 0); }
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitPrintStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStatContext extends StatContext {
		public TerminalNode CONTINUE() { return getToken(DParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(DParser.SEMI, 0); }
		public ContinueStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterContinueStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitContinueStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitContinueStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecrStatContext extends StatContext {
		public TerminalNode ID() { return getToken(DParser.ID, 0); }
		public TerminalNode DECR() { return getToken(DParser.DECR, 0); }
		public TerminalNode SEMI() { return getToken(DParser.SEMI, 0); }
		public DecrStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterDecrStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitDecrStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitDecrStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStatContext extends StatContext {
		public TerminalNode BREAK() { return getToken(DParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(DParser.SEMI, 0); }
		public BreakStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitBreakStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncrStatContext extends StatContext {
		public TerminalNode ID() { return getToken(DParser.ID, 0); }
		public TerminalNode INCR() { return getToken(DParser.INCR, 0); }
		public TerminalNode SEMI() { return getToken(DParser.SEMI, 0); }
		public IncrStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterIncrStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitIncrStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitIncrStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParallelStatContext extends StatContext {
		public TerminalNode PARALLEL() { return getToken(DParser.PARALLEL, 0); }
		public TerminalNode LCURLY() { return getToken(DParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DParser.RCURLY, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ParallelStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterParallelStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitParallelStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitParallelStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoopStatContext extends StatContext {
		public TerminalNode LOOP() { return getToken(DParser.LOOP, 0); }
		public TerminalNode LPAR() { return getToken(DParser.LPAR, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<TerminalNode> VERTSLASH() { return getTokens(DParser.VERTSLASH); }
		public TerminalNode VERTSLASH(int i) {
			return getToken(DParser.VERTSLASH, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(DParser.RPAR, 0); }
		public LoopStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterLoopStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitLoopStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitLoopStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WheneverStatContext extends StatContext {
		public TerminalNode WHENEVER() { return getToken(DParser.WHENEVER, 0); }
		public TerminalNode LPAR() { return getToken(DParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(DParser.RPAR, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSEWAYS() { return getToken(DParser.ELSEWAYS, 0); }
		public WheneverStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterWheneverStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitWheneverStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitWheneverStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CritSectionStatContext extends StatContext {
		public TerminalNode CRITICAL() { return getToken(DParser.CRITICAL, 0); }
		public TerminalNode LCURLY() { return getToken(DParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DParser.RCURLY, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public CritSectionStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterCritSectionStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitCritSectionStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitCritSectionStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoNothingStatContext extends StatContext {
		public TerminalNode SEMI() { return getToken(DParser.SEMI, 0); }
		public DoNothingStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterDoNothingStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitDoNothingStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitDoNothingStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignStatContext extends StatContext {
		public TerminalNode ID() { return getToken(DParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(DParser.SEMI, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode SHARED() { return getToken(DParser.SHARED, 0); }
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitAssignStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitAssignStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhilstStatContext extends StatContext {
		public TerminalNode WHILST() { return getToken(DParser.WHILST, 0); }
		public TerminalNode LPAR() { return getToken(DParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(DParser.RPAR, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhilstStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterWhilstStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitWhilstStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitWhilstStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclareStatContext extends StatContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(DParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(DParser.SEMI, 0); }
		public TerminalNode SHARED() { return getToken(DParser.SHARED, 0); }
		public DeclareStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterDeclareStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitDeclareStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitDeclareStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new DeclareStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SHARED) {
					{
					setState(30);
					match(SHARED);
					}
				}

				setState(33);
				dataType();
				setState(34);
				match(ID);
				setState(35);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SHARED) | (1L << INT) | (1L << BOOL) | (1L << CHAR))) != 0)) {
					{
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SHARED) {
						{
						setState(37);
						match(SHARED);
						}
					}

					setState(40);
					dataType();
					}
				}

				setState(43);
				match(ID);
				setState(44);
				match(T__0);
				setState(45);
				expr(0);
				setState(46);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new IncrStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				match(ID);
				setState(49);
				match(INCR);
				setState(50);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new DecrStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				match(ID);
				setState(52);
				match(DECR);
				setState(53);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new WhilstStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(54);
				match(WHILST);
				setState(55);
				match(LPAR);
				setState(56);
				expr(0);
				setState(57);
				match(RPAR);
				setState(58);
				stat();
				}
				break;
			case 6:
				_localctx = new WheneverStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(60);
				match(WHENEVER);
				setState(61);
				match(LPAR);
				setState(62);
				expr(0);
				setState(63);
				match(RPAR);
				setState(64);
				stat();
				setState(67);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(65);
					match(ELSEWAYS);
					setState(66);
					stat();
					}
					break;
				}
				}
				break;
			case 7:
				_localctx = new LoopStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(69);
				match(LOOP);
				setState(70);
				match(LPAR);
				setState(71);
				stat();
				setState(72);
				match(VERTSLASH);
				setState(73);
				expr(0);
				setState(74);
				match(VERTSLASH);
				setState(75);
				stat();
				setState(76);
				match(RPAR);
				setState(77);
				stat();
				}
				break;
			case 8:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(79);
				match(LCURLY);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << SEMI) | (1L << PRINT) | (1L << SHARED) | (1L << CRITICAL) | (1L << WHILST) | (1L << WHENEVER) | (1L << LOOP) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << PARALLEL) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID))) != 0)) {
					{
					{
					setState(80);
					stat();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				match(RCURLY);
				}
				break;
			case 9:
				_localctx = new ParallelStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(87);
				match(PARALLEL);
				setState(88);
				match(LCURLY);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << SEMI) | (1L << PRINT) | (1L << SHARED) | (1L << CRITICAL) | (1L << WHILST) | (1L << WHENEVER) | (1L << LOOP) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << PARALLEL) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID))) != 0)) {
					{
					{
					setState(89);
					stat();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				match(RCURLY);
				}
				break;
			case 10:
				_localctx = new CritSectionStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(96);
				match(CRITICAL);
				setState(97);
				match(LCURLY);
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << SEMI) | (1L << PRINT) | (1L << SHARED) | (1L << CRITICAL) | (1L << WHILST) | (1L << WHENEVER) | (1L << LOOP) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << PARALLEL) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID))) != 0)) {
					{
					{
					setState(98);
					stat();
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(104);
				match(RCURLY);
				}
				break;
			case 11:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(105);
				match(BREAK);
				setState(106);
				match(SEMI);
				}
				break;
			case 12:
				_localctx = new ContinueStatContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(107);
				match(CONTINUE);
				setState(108);
				match(SEMI);
				}
				break;
			case 13:
				_localctx = new DoNothingStatContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(109);
				match(SEMI);
				}
				break;
			case 14:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(110);
				match(PRINT);
				setState(111);
				match(LPAR);
				setState(112);
				match(ID);
				setState(113);
				match(RPAR);
				setState(114);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CharExprContext extends ExprContext {
		public TerminalNode CHARLITERAL() { return getToken(DParser.CHARLITERAL, 0); }
		public CharExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterCharExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitCharExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitCharExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerExprContext extends ExprContext {
		public TerminalNode INTEGER() { return getToken(DParser.INTEGER, 0); }
		public IntegerExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterIntegerExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitIntegerExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitIntegerExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public TerminalNode LBAR() { return getToken(DParser.LBAR, 0); }
		public TerminalNode RBAR() { return getToken(DParser.RBAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DParser.COMMA, i);
		}
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddMinExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public AddMinExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterAddMinExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitAddMinExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitAddMinExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExprContext extends ExprContext {
		public TerminalNode BOOLEAN() { return getToken(DParser.BOOLEAN, 0); }
		public BooleanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterBooleanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitBooleanExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensExprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(DParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(DParser.RPAR, 0); }
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShiftOpExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ShiftOpContext shiftOp() {
			return getRuleContext(ShiftOpContext.class,0);
		}
		public ShiftOpExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterShiftOpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitShiftOpExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitShiftOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExprContext extends ExprContext {
		public PrefixOpContext prefixOp() {
			return getRuleContext(PrefixOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitPrefixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseOpExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BitwiseOpContext bitwiseOp() {
			return getRuleContext(BitwiseOpContext.class,0);
		}
		public BitwiseOpExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterBitwiseOpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitBitwiseOpExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitBitwiseOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpoExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POW() { return getToken(DParser.POW, 0); }
		public ExpoExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterExpoExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitExpoExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitExpoExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultOpContext multOp() {
			return getRuleContext(MultOpContext.class,0);
		}
		public MultDivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterMultDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitMultDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitMultDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(DParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public CompareExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterCompareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitCompareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case MINUS:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(118);
				prefixOp();
				setState(119);
				expr(13);
				}
				break;
			case LPAR:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(LPAR);
				setState(122);
				expr(0);
				setState(123);
				match(RPAR);
				}
				break;
			case ID:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(ID);
				}
				break;
			case INTEGER:
				{
				_localctx = new IntegerExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				match(INTEGER);
				}
				break;
			case BOOLEAN:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(BOOLEAN);
				}
				break;
			case CHARLITERAL:
				{
				_localctx = new CharExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(CHARLITERAL);
				}
				break;
			case LBAR:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(LBAR);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << LPAR) | (1L << LBAR) | (1L << BOOLEAN) | (1L << CHARLITERAL) | (1L << ID) | (1L << INTEGER))) != 0)) {
					{
					setState(130);
					expr(0);
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(131);
						match(COMMA);
						setState(132);
						expr(0);
						}
						}
						setState(137);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(140);
				match(RBAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(166);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExpoExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(144);
						match(POW);
						setState(145);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new MultDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(147);
						multOp();
						setState(148);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new AddMinExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(151);
						addOp();
						setState(152);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(155);
						compOp();
						setState(156);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new BitwiseOpExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(159);
						bitwiseOp();
						setState(160);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new ShiftOpExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(163);
						shiftOp();
						setState(164);
						expr(8);
						}
						break;
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrefixOpContext extends ParserRuleContext {
		public PrefixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOp; }
	 
		public PrefixOpContext() { }
		public void copyFrom(PrefixOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends PrefixOpContext {
		public TerminalNode NOT() { return getToken(DParser.NOT, 0); }
		public NotContext(PrefixOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegateContext extends PrefixOpContext {
		public TerminalNode MINUS() { return getToken(DParser.MINUS, 0); }
		public NegateContext(PrefixOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterNegate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitNegate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitNegate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixOpContext prefixOp() throws RecognitionException {
		PrefixOpContext _localctx = new PrefixOpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_prefixOp);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				_localctx = new NegateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(MINUS);
				}
				break;
			case NOT:
				_localctx = new NotContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(NOT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
	 
		public CompOpContext() { }
		public void copyFrom(CompOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualContext extends CompOpContext {
		public TerminalNode EQ() { return getToken(DParser.EQ, 0); }
		public EqualContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanContext extends CompOpContext {
		public TerminalNode LT() { return getToken(DParser.LT, 0); }
		public LessThanContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotEqualContext extends CompOpContext {
		public TerminalNode NEQ() { return getToken(DParser.NEQ, 0); }
		public NotEqualContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterNotEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitNotEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitNotEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterEqualContext extends CompOpContext {
		public TerminalNode GEQ() { return getToken(DParser.GEQ, 0); }
		public GreaterEqualContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterGreaterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitGreaterEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitGreaterEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessEqualContext extends CompOpContext {
		public TerminalNode LEQ() { return getToken(DParser.LEQ, 0); }
		public LessEqualContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterLessEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitLessEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitLessEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanContext extends CompOpContext {
		public TerminalNode GT() { return getToken(DParser.GT, 0); }
		public GreaterThanContext(CompOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterGreaterThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitGreaterThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_compOp);
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQ:
				_localctx = new EqualContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(EQ);
				}
				break;
			case NEQ:
				_localctx = new NotEqualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(NEQ);
				}
				break;
			case LT:
				_localctx = new LessThanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				match(LT);
				}
				break;
			case GT:
				_localctx = new GreaterThanContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				match(GT);
				}
				break;
			case LEQ:
				_localctx = new LessEqualContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				match(LEQ);
				}
				break;
			case GEQ:
				_localctx = new GreaterEqualContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(180);
				match(GEQ);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultOpContext extends ParserRuleContext {
		public MultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOp; }
	 
		public MultOpContext() { }
		public void copyFrom(MultOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivideContext extends MultOpContext {
		public TerminalNode DIV() { return getToken(DParser.DIV, 0); }
		public DivideContext(MultOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyContext extends MultOpContext {
		public TerminalNode MULT() { return getToken(DParser.MULT, 0); }
		public MultiplyContext(MultOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitMultiply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_multOp);
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MULT:
				_localctx = new MultiplyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(MULT);
				}
				break;
			case DIV:
				_localctx = new DivideContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(DIV);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddOpContext extends ParserRuleContext {
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
	 
		public AddOpContext() { }
		public void copyFrom(AddOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MinusContext extends AddOpContext {
		public TerminalNode MINUS() { return getToken(DParser.MINUS, 0); }
		public MinusContext(AddOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusContext extends AddOpContext {
		public TerminalNode PLUS() { return getToken(DParser.PLUS, 0); }
		public PlusContext(AddOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_addOp);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				_localctx = new PlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new MinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(MINUS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BitwiseOpContext extends ParserRuleContext {
		public BitwiseOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwiseOp; }
	 
		public BitwiseOpContext() { }
		public void copyFrom(BitwiseOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OrContext extends BitwiseOpContext {
		public TerminalNode OR() { return getToken(DParser.OR, 0); }
		public OrContext(BitwiseOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends BitwiseOpContext {
		public TerminalNode AND() { return getToken(DParser.AND, 0); }
		public AndContext(BitwiseOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XorContext extends BitwiseOpContext {
		public TerminalNode XOR() { return getToken(DParser.XOR, 0); }
		public XorContext(BitwiseOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitXor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitXor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitwiseOpContext bitwiseOp() throws RecognitionException {
		BitwiseOpContext _localctx = new BitwiseOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bitwiseOp);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				_localctx = new AndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(AND);
				}
				break;
			case OR:
				_localctx = new OrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(OR);
				}
				break;
			case XOR:
				_localctx = new XorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				match(XOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShiftOpContext extends ParserRuleContext {
		public ShiftOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftOp; }
	 
		public ShiftOpContext() { }
		public void copyFrom(ShiftOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LshiftContext extends ShiftOpContext {
		public TerminalNode LSHIFT() { return getToken(DParser.LSHIFT, 0); }
		public LshiftContext(ShiftOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterLshift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitLshift(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitLshift(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RshiftContext extends ShiftOpContext {
		public TerminalNode RSHIFT() { return getToken(DParser.RSHIFT, 0); }
		public RshiftContext(ShiftOpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterRshift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitRshift(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitRshift(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftOpContext shiftOp() throws RecognitionException {
		ShiftOpContext _localctx = new ShiftOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_shiftOp);
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LSHIFT:
				_localctx = new LshiftContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(LSHIFT);
				}
				break;
			case RSHIFT:
				_localctx = new RshiftContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(RSHIFT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	 
		public DataTypeContext() { }
		public void copyFrom(DataTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeContext extends DataTypeContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimTypeContext extends DataTypeContext {
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public PrimTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterPrimType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitPrimType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitPrimType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dataType);
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				array();
				}
				break;
			case 2:
				_localctx = new PrimTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				primitive();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveContext extends ParserRuleContext {
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
	 
		public PrimitiveContext() { }
		public void copyFrom(PrimitiveContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CharTypeContext extends PrimitiveContext {
		public TerminalNode CHAR() { return getToken(DParser.CHAR, 0); }
		public CharTypeContext(PrimitiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterCharType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitCharType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitCharType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends PrimitiveContext {
		public TerminalNode INT() { return getToken(DParser.INT, 0); }
		public IntTypeContext(PrimitiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends PrimitiveContext {
		public TerminalNode BOOL() { return getToken(DParser.BOOL, 0); }
		public BoolTypeContext(PrimitiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_primitive);
		try {
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(INT);
				}
				break;
			case BOOL:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(BOOL);
				}
				break;
			case CHAR:
				_localctx = new CharTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				match(CHAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public List<TerminalNode> LBAR() { return getTokens(DParser.LBAR); }
		public TerminalNode LBAR(int i) {
			return getToken(DParser.LBAR, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(DParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(DParser.INTEGER, i);
		}
		public List<TerminalNode> RBAR() { return getTokens(DParser.RBAR); }
		public TerminalNode RBAR(int i) {
			return getToken(DParser.RBAR, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			primitive();
			setState(213); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(210);
				match(LBAR);
				setState(211);
				match(INTEGER);
				setState(212);
				match(RBAR);
				}
				}
				setState(215); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LBAR );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u00dc\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\3\5\3\"\n\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3)\n\3\3\3\5\3,\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"F\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3T\n\3\f\3\16"+
		"\3W\13\3\3\3\3\3\3\3\3\3\7\3]\n\3\f\3\16\3`\13\3\3\3\3\3\3\3\3\3\7\3f"+
		"\n\3\f\3\16\3i\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3v\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4"+
		"\u0088\n\4\f\4\16\4\u008b\13\4\5\4\u008d\n\4\3\4\5\4\u0090\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\4\u00a9\n\4\f\4\16\4\u00ac\13\4\3\5\3\5\5\5\u00b0\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00b8\n\6\3\7\3\7\5\7\u00bc\n\7\3\b\3\b\5"+
		"\b\u00c0\n\b\3\t\3\t\3\t\5\t\u00c5\n\t\3\n\3\n\5\n\u00c9\n\n\3\13\3\13"+
		"\5\13\u00cd\n\13\3\f\3\f\3\f\5\f\u00d2\n\f\3\r\3\r\3\r\3\r\6\r\u00d8\n"+
		"\r\r\r\16\r\u00d9\3\r\2\3\6\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u0101"+
		"\2\35\3\2\2\2\4u\3\2\2\2\6\u008f\3\2\2\2\b\u00af\3\2\2\2\n\u00b7\3\2\2"+
		"\2\f\u00bb\3\2\2\2\16\u00bf\3\2\2\2\20\u00c4\3\2\2\2\22\u00c8\3\2\2\2"+
		"\24\u00cc\3\2\2\2\26\u00d1\3\2\2\2\30\u00d3\3\2\2\2\32\34\5\4\3\2\33\32"+
		"\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37\35"+
		"\3\2\2\2 \"\7#\2\2! \3\2\2\2!\"\3\2\2\2\"#\3\2\2\2#$\5\24\13\2$%\7\61"+
		"\2\2%&\7!\2\2&v\3\2\2\2\')\7#\2\2(\'\3\2\2\2()\3\2\2\2)*\3\2\2\2*,\5\24"+
		"\13\2+(\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\61\2\2./\7\3\2\2/\60\5\6\4\2\60"+
		"\61\7!\2\2\61v\3\2\2\2\62\63\7\61\2\2\63\64\7\n\2\2\64v\7!\2\2\65\66\7"+
		"\61\2\2\66\67\7\13\2\2\67v\7!\2\289\7%\2\29:\7\22\2\2:;\5\6\4\2;<\7\23"+
		"\2\2<=\5\4\3\2=v\3\2\2\2>?\7&\2\2?@\7\22\2\2@A\5\6\4\2AB\7\23\2\2BE\5"+
		"\4\3\2CD\7\'\2\2DF\5\4\3\2EC\3\2\2\2EF\3\2\2\2Fv\3\2\2\2GH\7(\2\2HI\7"+
		"\22\2\2IJ\5\4\3\2JK\7 \2\2KL\5\6\4\2LM\7 \2\2MN\5\4\3\2NO\7\23\2\2OP\5"+
		"\4\3\2Pv\3\2\2\2QU\7\24\2\2RT\5\4\3\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV"+
		"\3\2\2\2VX\3\2\2\2WU\3\2\2\2Xv\7\25\2\2YZ\7,\2\2Z^\7\24\2\2[]\5\4\3\2"+
		"\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2av\7\25"+
		"\2\2bc\7$\2\2cg\7\24\2\2df\5\4\3\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2"+
		"\2\2hj\3\2\2\2ig\3\2\2\2jv\7\25\2\2kl\7-\2\2lv\7!\2\2mn\7.\2\2nv\7!\2"+
		"\2ov\7!\2\2pq\7\"\2\2qr\7\22\2\2rs\7\61\2\2st\7\23\2\2tv\7!\2\2u!\3\2"+
		"\2\2u+\3\2\2\2u\62\3\2\2\2u\65\3\2\2\2u8\3\2\2\2u>\3\2\2\2uG\3\2\2\2u"+
		"Q\3\2\2\2uY\3\2\2\2ub\3\2\2\2uk\3\2\2\2um\3\2\2\2uo\3\2\2\2up\3\2\2\2"+
		"v\5\3\2\2\2wx\b\4\1\2xy\5\b\5\2yz\5\6\4\17z\u0090\3\2\2\2{|\7\22\2\2|"+
		"}\5\6\4\2}~\7\23\2\2~\u0090\3\2\2\2\177\u0090\7\61\2\2\u0080\u0090\7\62"+
		"\2\2\u0081\u0090\7/\2\2\u0082\u0090\7\60\2\2\u0083\u008c\7\26\2\2\u0084"+
		"\u0089\5\6\4\2\u0085\u0086\7\37\2\2\u0086\u0088\5\6\4\2\u0087\u0085\3"+
		"\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u0084\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u0090\7\27\2\2\u008fw\3\2\2\2\u008f{\3"+
		"\2\2\2\u008f\177\3\2\2\2\u008f\u0080\3\2\2\2\u008f\u0081\3\2\2\2\u008f"+
		"\u0082\3\2\2\2\u008f\u0083\3\2\2\2\u0090\u00aa\3\2\2\2\u0091\u0092\f\16"+
		"\2\2\u0092\u0093\7\f\2\2\u0093\u00a9\5\6\4\16\u0094\u0095\f\r\2\2\u0095"+
		"\u0096\5\f\7\2\u0096\u0097\5\6\4\16\u0097\u00a9\3\2\2\2\u0098\u0099\f"+
		"\f\2\2\u0099\u009a\5\16\b\2\u009a\u009b\5\6\4\r\u009b\u00a9\3\2\2\2\u009c"+
		"\u009d\f\13\2\2\u009d\u009e\5\n\6\2\u009e\u009f\5\6\4\f\u009f\u00a9\3"+
		"\2\2\2\u00a0\u00a1\f\n\2\2\u00a1\u00a2\5\20\t\2\u00a2\u00a3\5\6\4\13\u00a3"+
		"\u00a9\3\2\2\2\u00a4\u00a5\f\t\2\2\u00a5\u00a6\5\22\n\2\u00a6\u00a7\5"+
		"\6\4\n\u00a7\u00a9\3\2\2\2\u00a8\u0091\3\2\2\2\u00a8\u0094\3\2\2\2\u00a8"+
		"\u0098\3\2\2\2\u00a8\u009c\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a4\3\2"+
		"\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\7\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00b0\7\17\2\2\u00ae\u00b0\7\r\2"+
		"\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\t\3\2\2\2\u00b1\u00b8"+
		"\7\4\2\2\u00b2\u00b8\7\5\2\2\u00b3\u00b8\7\6\2\2\u00b4\u00b8\7\7\2\2\u00b5"+
		"\u00b8\7\b\2\2\u00b6\u00b8\7\t\2\2\u00b7\u00b1\3\2\2\2\u00b7\u00b2\3\2"+
		"\2\2\u00b7\u00b3\3\2\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\13\3\2\2\2\u00b9\u00bc\7\20\2\2\u00ba\u00bc\7\21"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\r\3\2\2\2\u00bd\u00c0"+
		"\7\16\2\2\u00be\u00c0\7\17\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2"+
		"\u00c0\17\3\2\2\2\u00c1\u00c5\7\30\2\2\u00c2\u00c5\7\31\2\2\u00c3\u00c5"+
		"\7\32\2\2\u00c4\u00c1\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2"+
		"\u00c5\21\3\2\2\2\u00c6\u00c9\7\33\2\2\u00c7\u00c9\7\34\2\2\u00c8\u00c6"+
		"\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\23\3\2\2\2\u00ca\u00cd\5\30\r\2\u00cb"+
		"\u00cd\5\26\f\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\25\3\2\2"+
		"\2\u00ce\u00d2\7)\2\2\u00cf\u00d2\7*\2\2\u00d0\u00d2\7+\2\2\u00d1\u00ce"+
		"\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\27\3\2\2\2\u00d3"+
		"\u00d7\5\26\f\2\u00d4\u00d5\7\26\2\2\u00d5\u00d6\7\62\2\2\u00d6\u00d8"+
		"\7\27\2\2\u00d7\u00d4\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2"+
		"\u00d9\u00da\3\2\2\2\u00da\31\3\2\2\2\31\35!(+EU^gu\u0089\u008c\u008f"+
		"\u00a8\u00aa\u00af\u00b7\u00bb\u00bf\u00c4\u00c8\u00cc\u00d1\u00d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}