// Generated from C:/Users/Twam/Documents/PP-FinalProject/src\D.g4 by ANTLR 4.9.1
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
		T__0=1, T__1=2, EQ=3, NEQ=4, LT=5, GT=6, LEQ=7, GEQ=8, INCR=9, DECR=10, 
		POW=11, NOT=12, PLUS=13, MINUS=14, MULT=15, DIV=16, LPAR=17, RPAR=18, 
		LCURLY=19, RCURLY=20, LBAR=21, RBAR=22, AND=23, OR=24, INT=25, BOOL=26, 
		CHAR=27, FUNCTION=28, ID=29, INTEGER=30, BOOLEAN=31, ANYCHAR=32, SEMI=33, 
		WHILST=34, WHENEVER=35, ELSEWAYS=36, LOOP=37, WS=38;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_expr = 2, RULE_type = 3, RULE_array = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "expr", "type", "array"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'''", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'++'", 
			"'--'", "'^'", "'!'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "'and'", "'or'", "'int'", "'bool'", "'char'", "'F'", 
			null, null, null, null, "';'", "'whilst'", "'whenever'", "'elseways'", 
			"'loop'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "EQ", "NEQ", "LT", "GT", "LEQ", "GEQ", "INCR", "DECR", 
			"POW", "NOT", "PLUS", "MINUS", "MULT", "DIV", "LPAR", "RPAR", "LCURLY", 
			"RCURLY", "LBAR", "RBAR", "AND", "OR", "INT", "BOOL", "CHAR", "FUNCTION", 
			"ID", "INTEGER", "BOOLEAN", "ANYCHAR", "SEMI", "WHILST", "WHENEVER", 
			"ELSEWAYS", "LOOP", "WS"
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
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << ID) | (1L << WHILST) | (1L << WHENEVER) | (1L << LOOP))) != 0)) {
				{
				{
				setState(10);
				stat();
				}
				}
				setState(15);
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
	public static class LoopStatContext extends StatContext {
		public TerminalNode LOOP() { return getToken(DParser.LOOP, 0); }
		public TerminalNode LPAR() { return getToken(DParser.LPAR, 0); }
		public List<TerminalNode> SEMI() { return getTokens(DParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(DParser.SEMI, i);
		}
		public TerminalNode RPAR() { return getToken(DParser.RPAR, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
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
	public static class AssignStatContext extends StatContext {
		public TerminalNode ID() { return getToken(DParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(DParser.SEMI, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
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
		public TerminalNode ID() { return getToken(DParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(DParser.SEMI, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
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

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new DeclareStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(16);
					type();
					}
					break;
				case 2:
					{
					setState(17);
					array();
					}
					break;
				}
				setState(20);
				match(ID);
				setState(21);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(23);
					type();
					}
					break;
				case 2:
					{
					setState(24);
					array();
					}
					break;
				}
				setState(27);
				match(ID);
				setState(28);
				match(T__0);
				setState(29);
				expr(0);
				setState(30);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new IncrStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				match(ID);
				setState(33);
				match(INCR);
				setState(34);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new DecrStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				match(ID);
				setState(36);
				match(DECR);
				setState(37);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new WhilstStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				match(WHILST);
				setState(39);
				match(LPAR);
				setState(40);
				expr(0);
				setState(41);
				match(RPAR);
				setState(43);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(42);
					stat();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new WheneverStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				match(WHENEVER);
				setState(46);
				match(LPAR);
				setState(47);
				expr(0);
				setState(48);
				match(RPAR);
				setState(50);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(49);
					stat();
					}
					break;
				}
				setState(54);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(52);
					match(ELSEWAYS);
					setState(53);
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
				setState(56);
				match(LOOP);
				setState(57);
				match(LPAR);
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << ID) | (1L << WHILST) | (1L << WHENEVER) | (1L << LOOP))) != 0)) {
					{
					setState(58);
					stat();
					}
				}

				setState(61);
				match(SEMI);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << NOT) | (1L << MINUS) | (1L << LPAR) | (1L << ID) | (1L << INTEGER) | (1L << BOOLEAN))) != 0)) {
					{
					setState(62);
					expr(0);
					}
				}

				setState(65);
				match(SEMI);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << NOT) | (1L << MINUS) | (1L << LPAR) | (1L << ID) | (1L << INTEGER) | (1L << BOOLEAN))) != 0)) {
					{
					setState(66);
					expr(0);
					}
				}

				setState(69);
				match(RPAR);
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(70);
					stat();
					}
					break;
				}
				}
				break;
			case 8:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(73);
				match(LCURLY);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCURLY) | (1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << ID) | (1L << WHILST) | (1L << WHENEVER) | (1L << LOOP))) != 0)) {
					{
					{
					setState(74);
					stat();
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(80);
				match(RCURLY);
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
	public static class PrefixExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(DParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(DParser.NOT, 0); }
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
	public static class CharExprContext extends ExprContext {
		public TerminalNode ANYCHAR() { return getToken(DParser.ANYCHAR, 0); }
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
	public static class AddMinExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(DParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(DParser.MINUS, 0); }
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
		public TerminalNode MULT() { return getToken(DParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(DParser.DIV, 0); }
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
	public static class AndOrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(DParser.AND, 0); }
		public TerminalNode OR() { return getToken(DParser.OR, 0); }
		public AndOrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterAndOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitAndOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitAndOrExpr(this);
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
		public TerminalNode EQ() { return getToken(DParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(DParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(DParser.LT, 0); }
		public TerminalNode GT() { return getToken(DParser.GT, 0); }
		public TerminalNode LEQ() { return getToken(DParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(DParser.GEQ, 0); }
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
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case MINUS:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(84);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(85);
				expr(11);
				}
				break;
			case LPAR:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(LPAR);
				setState(87);
				expr(0);
				setState(88);
				match(RPAR);
				}
				break;
			case ID:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(ID);
				}
				break;
			case INTEGER:
				{
				_localctx = new IntegerExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(INTEGER);
				}
				break;
			case BOOLEAN:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				match(BOOLEAN);
				}
				break;
			case T__1:
				{
				_localctx = new CharExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(T__1);
				setState(94);
				match(ANYCHAR);
				setState(95);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(113);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpoExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(99);
						match(POW);
						setState(100);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new MultDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(102);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new AddMinExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(105);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(108);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LT) | (1L << GT) | (1L << LEQ) | (1L << GEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(109);
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new AndOrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(111);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(112);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(DParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(DParser.BOOL, 0); }
		public TerminalNode CHAR() { return getToken(DParser.CHAR, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DListener ) ((DListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DVisitor ) return ((DVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ArrayContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LBAR() { return getToken(DParser.LBAR, 0); }
		public TerminalNode INTEGER() { return getToken(DParser.INTEGER, 0); }
		public TerminalNode RBAR() { return getToken(DParser.RBAR, 0); }
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
		enterRule(_localctx, 8, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			type();
			setState(121);
			match(LBAR);
			setState(122);
			match(INTEGER);
			setState(123);
			match(RBAR);
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
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u0080\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\3\3\3"+
		"\5\3\25\n\3\3\3\3\3\3\3\3\3\3\3\5\3\34\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"\65\n\3\3\3\3\3\5\39\n\3\3\3\3\3\3\3\5\3>\n\3\3\3\3\3\5\3B\n\3\3\3\3\3"+
		"\5\3F\n\3\3\3\3\3\5\3J\n\3\3\3\3\3\7\3N\n\3\f\3\16\3Q\13\3\3\3\5\3T\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4c\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4t\n\4\f\4\16"+
		"\4w\13\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\2\3\6\7\2\4\6\b\n\2\b\4\2\16"+
		"\16\20\20\3\2\21\22\3\2\17\20\3\2\5\n\3\2\31\32\3\2\33\35\2\u0097\2\17"+
		"\3\2\2\2\4S\3\2\2\2\6b\3\2\2\2\bx\3\2\2\2\nz\3\2\2\2\f\16\5\4\3\2\r\f"+
		"\3\2\2\2\16\21\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\3\3\2\2\2\21\17\3"+
		"\2\2\2\22\25\5\b\5\2\23\25\5\n\6\2\24\22\3\2\2\2\24\23\3\2\2\2\25\26\3"+
		"\2\2\2\26\27\7\37\2\2\27\30\7#\2\2\30T\3\2\2\2\31\34\5\b\5\2\32\34\5\n"+
		"\6\2\33\31\3\2\2\2\33\32\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7\37"+
		"\2\2\36\37\7\3\2\2\37 \5\6\4\2 !\7#\2\2!T\3\2\2\2\"#\7\37\2\2#$\7\13\2"+
		"\2$T\7#\2\2%&\7\37\2\2&\'\7\f\2\2\'T\7#\2\2()\7$\2\2)*\7\23\2\2*+\5\6"+
		"\4\2+-\7\24\2\2,.\5\4\3\2-,\3\2\2\2-.\3\2\2\2.T\3\2\2\2/\60\7%\2\2\60"+
		"\61\7\23\2\2\61\62\5\6\4\2\62\64\7\24\2\2\63\65\5\4\3\2\64\63\3\2\2\2"+
		"\64\65\3\2\2\2\658\3\2\2\2\66\67\7&\2\2\679\5\4\3\28\66\3\2\2\289\3\2"+
		"\2\29T\3\2\2\2:;\7\'\2\2;=\7\23\2\2<>\5\4\3\2=<\3\2\2\2=>\3\2\2\2>?\3"+
		"\2\2\2?A\7#\2\2@B\5\6\4\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CE\7#\2\2DF\5\6"+
		"\4\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GI\7\24\2\2HJ\5\4\3\2IH\3\2\2\2IJ\3"+
		"\2\2\2JT\3\2\2\2KO\7\25\2\2LN\5\4\3\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP"+
		"\3\2\2\2PR\3\2\2\2QO\3\2\2\2RT\7\26\2\2S\24\3\2\2\2S\33\3\2\2\2S\"\3\2"+
		"\2\2S%\3\2\2\2S(\3\2\2\2S/\3\2\2\2S:\3\2\2\2SK\3\2\2\2T\5\3\2\2\2UV\b"+
		"\4\1\2VW\t\2\2\2Wc\5\6\4\rXY\7\23\2\2YZ\5\6\4\2Z[\7\24\2\2[c\3\2\2\2\\"+
		"c\7\37\2\2]c\7 \2\2^c\7!\2\2_`\7\4\2\2`a\7\"\2\2ac\7\4\2\2bU\3\2\2\2b"+
		"X\3\2\2\2b\\\3\2\2\2b]\3\2\2\2b^\3\2\2\2b_\3\2\2\2cu\3\2\2\2de\f\f\2\2"+
		"ef\7\r\2\2ft\5\6\4\rgh\f\13\2\2hi\t\3\2\2it\5\6\4\fjk\f\n\2\2kl\t\4\2"+
		"\2lt\5\6\4\13mn\f\t\2\2no\t\5\2\2ot\5\6\4\npq\f\b\2\2qr\t\6\2\2rt\5\6"+
		"\4\tsd\3\2\2\2sg\3\2\2\2sj\3\2\2\2sm\3\2\2\2sp\3\2\2\2tw\3\2\2\2us\3\2"+
		"\2\2uv\3\2\2\2v\7\3\2\2\2wu\3\2\2\2xy\t\7\2\2y\t\3\2\2\2z{\5\b\5\2{|\7"+
		"\27\2\2|}\7 \2\2}~\7\30\2\2~\13\3\2\2\2\21\17\24\33-\648=AEIOSbsu";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}