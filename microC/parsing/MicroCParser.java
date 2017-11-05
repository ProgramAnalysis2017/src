// Generated from .\src\MicroC_language\parsing\MicroC.g4 by ANTLR 4.7
package microC.parsing;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, AND=3, OR=4, ASSIGN=5, SEMI=6, GT=7, GE=8, LT=9, LE=10, 
		EQ=11, NEQ=12, PLUS=13, MINUS=14, MUL=15, DIV=16, NOT=17, LPAREN=18, RPAREN=19, 
		LBRACE=20, RBRACE=21, LBRACKET=22, RBRACKET=23, COLON=24, IF=25, ELSE=26, 
		WHILE=27, CONTINUE=28, BREAK=29, WRITE=30, READ=31, INT=32, COMMENT=33, 
		INTEGER=34, IDENTIFIER=35, WS=36;
	public static final int
		RULE_aexpr = 0, RULE_aexpr1 = 1, RULE_aexpr2 = 2, RULE_aexpr3 = 3, RULE_bexpr = 4, 
		RULE_bexpr1 = 5, RULE_bexpr2 = 6, RULE_opr = 7, RULE_basicDecl = 8, RULE_decl = 9, 
		RULE_basicStmt = 10, RULE_stmt = 11, RULE_assignStmt = 12, RULE_continueStmt = 13, 
		RULE_readStmt = 14, RULE_breakStmt = 15, RULE_writeStmt = 16, RULE_ifelseStmt = 17, 
		RULE_whileStmt = 18, RULE_blockStmt = 19, RULE_program = 20, RULE_identifier = 21, 
		RULE_integer = 22;
	public static final String[] ruleNames = {
		"aexpr", "aexpr1", "aexpr2", "aexpr3", "bexpr", "bexpr1", "bexpr2", "opr", 
		"basicDecl", "decl", "basicStmt", "stmt", "assignStmt", "continueStmt", 
		"readStmt", "breakStmt", "writeStmt", "ifelseStmt", "whileStmt", "blockStmt", 
		"program", "identifier", "integer"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'true'", "'false'", "'&'", "'|'", "'='", "';'", "'>'", "'>='", 
		"'<'", "'<='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'not'", "'('", 
		"')'", "'{'", "'}'", "'['", "']'", "':'", "'if'", "'else'", "'while'", 
		"'continue'", "'break'", "'write'", "'read'", "'int'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "AND", "OR", "ASSIGN", "SEMI", "GT", "GE", "LT", 
		"LE", "EQ", "NEQ", "PLUS", "MINUS", "MUL", "DIV", "NOT", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "LBRACKET", "RBRACKET", "COLON", "IF", "ELSE", "WHILE", 
		"CONTINUE", "BREAK", "WRITE", "READ", "INT", "COMMENT", "INTEGER", "IDENTIFIER", 
		"WS"
	};
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
	public String getGrammarFileName() { return "MicroC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MicroCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AexprContext extends ParserRuleContext {
		public List<Aexpr1Context> aexpr1() {
			return getRuleContexts(Aexpr1Context.class);
		}
		public Aexpr1Context aexpr1(int i) {
			return getRuleContext(Aexpr1Context.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(MicroCParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(MicroCParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(MicroCParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(MicroCParser.MINUS, i);
		}
		public AexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAexpr(this);
		}
		@Override
		public <Expressions> Expressions accept(ParseTreeVisitor<? extends Expressions> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Expressions) ((MicroCVisitor<? extends Expressions>)visitor).visitAexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexprContext aexpr() throws RecognitionException {
		AexprContext _localctx = new AexprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_aexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			aexpr1();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(51);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(47);
					match(PLUS);
					setState(48);
					aexpr1();
					}
					break;
				case MINUS:
					{
					setState(49);
					match(MINUS);
					setState(50);
					aexpr1();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(55);
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

	public static class Aexpr1Context extends ParserRuleContext {
		public List<Aexpr2Context> aexpr2() {
			return getRuleContexts(Aexpr2Context.class);
		}
		public Aexpr2Context aexpr2(int i) {
			return getRuleContext(Aexpr2Context.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(MicroCParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(MicroCParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(MicroCParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(MicroCParser.DIV, i);
		}
		public Aexpr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAexpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAexpr1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitAexpr1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aexpr1Context aexpr1() throws RecognitionException {
		Aexpr1Context _localctx = new Aexpr1Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_aexpr1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			aexpr2();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				setState(61);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MUL:
					{
					setState(57);
					match(MUL);
					setState(58);
					aexpr2();
					}
					break;
				case DIV:
					{
					setState(59);
					match(DIV);
					setState(60);
					aexpr2();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(65);
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

	public static class Aexpr2Context extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(MicroCParser.MINUS, 0); }
		public Aexpr3Context aexpr3() {
			return getRuleContext(Aexpr3Context.class,0);
		}
		public Aexpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAexpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAexpr2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitAexpr2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aexpr2Context aexpr2() throws RecognitionException {
		Aexpr2Context _localctx = new Aexpr2Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_aexpr2);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(MINUS);
				setState(67);
				aexpr3();
				}
				break;
			case LPAREN:
			case INTEGER:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				aexpr3();
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

	public static class Aexpr3Context extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(MicroCParser.LBRACKET, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(MicroCParser.RBRACKET, 0); }
		public TerminalNode INTEGER() { return getToken(MicroCParser.INTEGER, 0); }
		public TerminalNode LPAREN() { return getToken(MicroCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MicroCParser.RPAREN, 0); }
		public Aexpr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAexpr3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAexpr3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitAexpr3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Aexpr3Context aexpr3() throws RecognitionException {
		Aexpr3Context _localctx = new Aexpr3Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_aexpr3);
		int _la;
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(IDENTIFIER);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(72);
					match(LBRACKET);
					setState(73);
					aexpr();
					setState(74);
					match(RBRACKET);
					}
				}

				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(INTEGER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(LPAREN);
				setState(80);
				aexpr();
				setState(81);
				match(RPAREN);
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

	public static class BexprContext extends ParserRuleContext {
		public List<Bexpr1Context> bexpr1() {
			return getRuleContexts(Bexpr1Context.class);
		}
		public Bexpr1Context bexpr1(int i) {
			return getRuleContext(Bexpr1Context.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(MicroCParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MicroCParser.OR, i);
		}
		public BexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBexpr(this);
		}
		@Override
		public <Expressions> Expressions accept(ParseTreeVisitor<? extends Expressions> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Expressions) ((MicroCVisitor<? extends Expressions>)visitor).visitBexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BexprContext bexpr() throws RecognitionException {
		BexprContext _localctx = new BexprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bexpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			bexpr1();
			setState(90);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(86);
					match(OR);
					setState(87);
					bexpr1();
					}
					} 
				}
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class Bexpr1Context extends ParserRuleContext {
		public List<Bexpr2Context> bexpr2() {
			return getRuleContexts(Bexpr2Context.class);
		}
		public Bexpr2Context bexpr2(int i) {
			return getRuleContext(Bexpr2Context.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(MicroCParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MicroCParser.AND, i);
		}
		public Bexpr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBexpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBexpr1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitBexpr1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bexpr1Context bexpr1() throws RecognitionException {
		Bexpr1Context _localctx = new Bexpr1Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_bexpr1);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			bexpr2();
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(94);
					match(AND);
					setState(95);
					bexpr2();
					}
					} 
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class Bexpr2Context extends ParserRuleContext {
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public OprContext opr() {
			return getRuleContext(OprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(MicroCParser.NOT, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(MicroCParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MicroCParser.FALSE, 0); }
		public TerminalNode LPAREN() { return getToken(MicroCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MicroCParser.RPAREN, 0); }
		public Bexpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBexpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBexpr2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitBexpr2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bexpr2Context bexpr2() throws RecognitionException {
		Bexpr2Context _localctx = new Bexpr2Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_bexpr2);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				aexpr();
				setState(102);
				opr();
				setState(103);
				aexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(NOT);
				setState(106);
				bexpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(109);
				match(LPAREN);
				setState(110);
				bexpr();
				setState(111);
				match(RPAREN);
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

	public static class OprContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(MicroCParser.GT, 0); }
		public TerminalNode GE() { return getToken(MicroCParser.GE, 0); }
		public TerminalNode LT() { return getToken(MicroCParser.LT, 0); }
		public TerminalNode LE() { return getToken(MicroCParser.LE, 0); }
		public TerminalNode EQ() { return getToken(MicroCParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MicroCParser.NEQ, 0); }
		public OprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterOpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitOpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitOpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OprContext opr() throws RecognitionException {
		OprContext _localctx = new OprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_opr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
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

	public static class BasicDeclContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MicroCParser.INT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public TerminalNode LBRACKET() { return getToken(MicroCParser.LBRACKET, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(MicroCParser.RBRACKET, 0); }
		public BasicDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBasicDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBasicDecl(this);
		}
		@Override
		public <Declarations> Declarations accept(ParseTreeVisitor<? extends Declarations> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Declarations) ((MicroCVisitor<? extends Declarations>)visitor).visitBasicDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicDeclContext basicDecl() throws RecognitionException {
		BasicDeclContext _localctx = new BasicDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_basicDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(INT);
			setState(118);
			identifier();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(119);
				match(LBRACKET);
				setState(120);
				integer();
				setState(121);
				match(RBRACKET);
				}
			}

			setState(125);
			match(SEMI);
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

	public static class DeclContext extends ParserRuleContext {
		public BasicDeclContext basicDecl() {
			return getRuleContext(BasicDeclContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitDecl(this);
		}
		@Override
		public <DeclarationsSeqs> DeclarationsSeqs accept(ParseTreeVisitor<? extends DeclarationsSeqs> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (DeclarationsSeqs) ((MicroCVisitor<? extends DeclarationsSeqs>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			basicDecl();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(128);
				decl();
				}
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

	public static class BasicStmtContext extends ParserRuleContext {
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ReadStmtContext readStmt() {
			return getRuleContext(ReadStmtContext.class,0);
		}
		public WriteStmtContext writeStmt() {
			return getRuleContext(WriteStmtContext.class,0);
		}
		public IfelseStmtContext ifelseStmt() {
			return getRuleContext(IfelseStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public BasicStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBasicStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBasicStmt(this);
		}
		@Override
		public <Statements> Statements accept(ParseTreeVisitor<? extends Statements> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Statements) ((MicroCVisitor<? extends Statements>)visitor).visitBasicStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicStmtContext basicStmt() throws RecognitionException {
		BasicStmtContext _localctx = new BasicStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_basicStmt);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				assignStmt();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				continueStmt();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				breakStmt();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				readStmt();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 5);
				{
				setState(135);
				writeStmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(136);
				ifelseStmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 7);
				{
				setState(137);
				whileStmt();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 8);
				{
				setState(138);
				blockStmt();
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

	public static class StmtContext extends ParserRuleContext {
		public BasicStmtContext basicStmt() {
			return getRuleContext(BasicStmtContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitStmt(this);
		}
		@Override
		public <StatementsSeqs> StatementsSeqs accept(ParseTreeVisitor<? extends StatementsSeqs> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (StatementsSeqs) ((MicroCVisitor<? extends StatementsSeqs>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			basicStmt();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << IF) | (1L << WHILE) | (1L << CONTINUE) | (1L << BREAK) | (1L << WRITE) | (1L << READ) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(142);
				stmt();
				}
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

	public static class AssignStmtContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MicroCParser.ASSIGN, 0); }
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public TerminalNode LBRACKET() { return getToken(MicroCParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(MicroCParser.RBRACKET, 0); }
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAssignStmt(this);
		}
		@Override
		public <Statements> Statements accept(ParseTreeVisitor<? extends Statements> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Statements) ((MicroCVisitor<? extends Statements>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			identifier();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(146);
				match(LBRACKET);
				setState(147);
				aexpr();
				setState(148);
				match(RBRACKET);
				}
			}

			setState(152);
			match(ASSIGN);
			setState(153);
			aexpr();
			setState(154);
			match(SEMI);
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

	public static class ContinueStmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MicroCParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterContinueStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitContinueStmt(this);
		}
		@Override
		public <Continue> Continue accept(ParseTreeVisitor<? extends Continue> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Continue) ((MicroCVisitor<? extends Continue>)visitor).visitContinueStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(CONTINUE);
			setState(157);
			match(SEMI);
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

	public static class ReadStmtContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(MicroCParser.READ, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public TerminalNode LBRACKET() { return getToken(MicroCParser.LBRACKET, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(MicroCParser.RBRACKET, 0); }
		public ReadStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterReadStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitReadStmt(this);
		}
		@Override
		public <Statements> Statements accept(ParseTreeVisitor<? extends Statements> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Statements) ((MicroCVisitor<? extends Statements>)visitor).visitReadStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadStmtContext readStmt() throws RecognitionException {
		ReadStmtContext _localctx = new ReadStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_readStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(READ);
			setState(160);
			identifier();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(161);
				match(LBRACKET);
				setState(162);
				aexpr();
				setState(163);
				match(RBRACKET);
				}
			}

			setState(167);
			match(SEMI);
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

	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MicroCParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBreakStmt(this);
		}
		@Override
		public <Break> Break accept(ParseTreeVisitor<? extends Break> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Break) ((MicroCVisitor<? extends Break>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(BREAK);
			setState(170);
			match(SEMI);
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

	public static class WriteStmtContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(MicroCParser.WRITE, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MicroCParser.SEMI, 0); }
		public WriteStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterWriteStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitWriteStmt(this);
		}
		@Override
		public <Statements> Statements accept(ParseTreeVisitor<? extends Statements> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Statements) ((MicroCVisitor<? extends Statements>)visitor).visitWriteStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStmtContext writeStmt() throws RecognitionException {
		WriteStmtContext _localctx = new WriteStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_writeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(WRITE);
			setState(173);
			aexpr();
			setState(174);
			match(SEMI);
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

	public static class IfelseStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MicroCParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MicroCParser.LPAREN, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MicroCParser.RPAREN, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(MicroCParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(MicroCParser.LBRACE, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(MicroCParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(MicroCParser.RBRACE, i);
		}
		public TerminalNode ELSE() { return getToken(MicroCParser.ELSE, 0); }
		public IfelseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifelseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterIfelseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitIfelseStmt(this);
		}
		@Override
		public <Statements> Statements accept(ParseTreeVisitor<? extends Statements> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Statements) ((MicroCVisitor<? extends Statements>)visitor).visitIfelseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfelseStmtContext ifelseStmt() throws RecognitionException {
		IfelseStmtContext _localctx = new IfelseStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifelseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(IF);
			setState(177);
			match(LPAREN);
			setState(178);
			bexpr();
			setState(179);
			match(RPAREN);
			setState(180);
			match(LBRACE);
			setState(181);
			stmt();
			setState(182);
			match(RBRACE);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(183);
				match(ELSE);
				setState(184);
				match(LBRACE);
				setState(185);
				stmt();
				setState(186);
				match(RBRACE);
				}
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MicroCParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MicroCParser.LPAREN, 0); }
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MicroCParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MicroCParser.LBRACE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(MicroCParser.RBRACE, 0); }
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitWhileStmt(this);
		}
		@Override
		public <While> While accept(ParseTreeVisitor<? extends While> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (While) ((MicroCVisitor<? extends While>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(WHILE);
			setState(191);
			match(LPAREN);
			setState(192);
			bexpr();
			setState(193);
			match(RPAREN);
			setState(194);
			match(LBRACE);
			setState(195);
			stmt();
			setState(196);
			match(RBRACE);
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

	public static class BlockStmtContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MicroCParser.LBRACE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(MicroCParser.RBRACE, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(LBRACE);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(199);
				decl();
				}
			}

			setState(202);
			stmt();
			setState(203);
			match(RBRACE);
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

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MicroCParser.LBRACE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(MicroCParser.RBRACE, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitProgram(this);
		}
		@Override
		public <Program> Program accept(ParseTreeVisitor<? extends Program> visitor) {
			if ( visitor instanceof MicroCVisitor ) return (Program) ((MicroCVisitor<? extends Program>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(LBRACE);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(206);
				decl();
				}
			}

			setState(209);
			stmt();
			setState(210);
			match(RBRACE);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(IDENTIFIER);
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MicroCParser.INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MicroCVisitor ) return ((MicroCVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(INTEGER);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u00db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\3\2\7\2\66\n\2\f\2\16\29\13\2\3\3\3\3\3\3\3\3\3\3\7\3@\n\3\f\3"+
		"\16\3C\13\3\3\4\3\4\3\4\5\4H\n\4\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5V\n\5\3\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\3\7\3\7\3\7"+
		"\7\7c\n\7\f\7\16\7f\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bt\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n~\n\n\3\n\3\n\3\13\3\13"+
		"\5\13\u0084\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008e\n\f\3\r\3\r"+
		"\5\r\u0092\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u0099\n\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a8\n\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00bf\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\5\25\u00cb\n\25\3\25\3\25\3\25\3\26\3\26\5\26"+
		"\u00d2\n\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\3\3\2\t\16\2\u00e0\2\60\3\2\2\2"+
		"\4:\3\2\2\2\6G\3\2\2\2\bU\3\2\2\2\nW\3\2\2\2\f_\3\2\2\2\16s\3\2\2\2\20"+
		"u\3\2\2\2\22w\3\2\2\2\24\u0081\3\2\2\2\26\u008d\3\2\2\2\30\u008f\3\2\2"+
		"\2\32\u0093\3\2\2\2\34\u009e\3\2\2\2\36\u00a1\3\2\2\2 \u00ab\3\2\2\2\""+
		"\u00ae\3\2\2\2$\u00b2\3\2\2\2&\u00c0\3\2\2\2(\u00c8\3\2\2\2*\u00cf\3\2"+
		"\2\2,\u00d6\3\2\2\2.\u00d8\3\2\2\2\60\67\5\4\3\2\61\62\7\17\2\2\62\66"+
		"\5\4\3\2\63\64\7\20\2\2\64\66\5\4\3\2\65\61\3\2\2\2\65\63\3\2\2\2\669"+
		"\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\3\3\2\2\29\67\3\2\2\2:A\5\6\4\2;<"+
		"\7\21\2\2<@\5\6\4\2=>\7\22\2\2>@\5\6\4\2?;\3\2\2\2?=\3\2\2\2@C\3\2\2\2"+
		"A?\3\2\2\2AB\3\2\2\2B\5\3\2\2\2CA\3\2\2\2DE\7\20\2\2EH\5\b\5\2FH\5\b\5"+
		"\2GD\3\2\2\2GF\3\2\2\2H\7\3\2\2\2IN\7%\2\2JK\7\30\2\2KL\5\2\2\2LM\7\31"+
		"\2\2MO\3\2\2\2NJ\3\2\2\2NO\3\2\2\2OV\3\2\2\2PV\7$\2\2QR\7\24\2\2RS\5\2"+
		"\2\2ST\7\25\2\2TV\3\2\2\2UI\3\2\2\2UP\3\2\2\2UQ\3\2\2\2V\t\3\2\2\2W\\"+
		"\5\f\7\2XY\7\6\2\2Y[\5\f\7\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2"+
		"]\13\3\2\2\2^\\\3\2\2\2_d\5\16\b\2`a\7\5\2\2ac\5\16\b\2b`\3\2\2\2cf\3"+
		"\2\2\2db\3\2\2\2de\3\2\2\2e\r\3\2\2\2fd\3\2\2\2gh\5\2\2\2hi\5\20\t\2i"+
		"j\5\2\2\2jt\3\2\2\2kl\7\23\2\2lt\5\n\6\2mt\7\3\2\2nt\7\4\2\2op\7\24\2"+
		"\2pq\5\n\6\2qr\7\25\2\2rt\3\2\2\2sg\3\2\2\2sk\3\2\2\2sm\3\2\2\2sn\3\2"+
		"\2\2so\3\2\2\2t\17\3\2\2\2uv\t\2\2\2v\21\3\2\2\2wx\7\"\2\2x}\5,\27\2y"+
		"z\7\30\2\2z{\5.\30\2{|\7\31\2\2|~\3\2\2\2}y\3\2\2\2}~\3\2\2\2~\177\3\2"+
		"\2\2\177\u0080\7\b\2\2\u0080\23\3\2\2\2\u0081\u0083\5\22\n\2\u0082\u0084"+
		"\5\24\13\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\25\3\2\2\2\u0085"+
		"\u008e\5\32\16\2\u0086\u008e\5\34\17\2\u0087\u008e\5 \21\2\u0088\u008e"+
		"\5\36\20\2\u0089\u008e\5\"\22\2\u008a\u008e\5$\23\2\u008b\u008e\5&\24"+
		"\2\u008c\u008e\5(\25\2\u008d\u0085\3\2\2\2\u008d\u0086\3\2\2\2\u008d\u0087"+
		"\3\2\2\2\u008d\u0088\3\2\2\2\u008d\u0089\3\2\2\2\u008d\u008a\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\27\3\2\2\2\u008f\u0091\5\26\f"+
		"\2\u0090\u0092\5\30\r\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\31\3\2\2\2\u0093\u0098\5,\27\2\u0094\u0095\7\30\2\2\u0095\u0096\5\2\2"+
		"\2\u0096\u0097\7\31\2\2\u0097\u0099\3\2\2\2\u0098\u0094\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7\7\2\2\u009b\u009c\5\2"+
		"\2\2\u009c\u009d\7\b\2\2\u009d\33\3\2\2\2\u009e\u009f\7\36\2\2\u009f\u00a0"+
		"\7\b\2\2\u00a0\35\3\2\2\2\u00a1\u00a2\7!\2\2\u00a2\u00a7\5,\27\2\u00a3"+
		"\u00a4\7\30\2\2\u00a4\u00a5\5\2\2\2\u00a5\u00a6\7\31\2\2\u00a6\u00a8\3"+
		"\2\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\7\b\2\2\u00aa\37\3\2\2\2\u00ab\u00ac\7\37\2\2\u00ac\u00ad\7\b\2"+
		"\2\u00ad!\3\2\2\2\u00ae\u00af\7 \2\2\u00af\u00b0\5\2\2\2\u00b0\u00b1\7"+
		"\b\2\2\u00b1#\3\2\2\2\u00b2\u00b3\7\33\2\2\u00b3\u00b4\7\24\2\2\u00b4"+
		"\u00b5\5\n\6\2\u00b5\u00b6\7\25\2\2\u00b6\u00b7\7\26\2\2\u00b7\u00b8\5"+
		"\30\r\2\u00b8\u00be\7\27\2\2\u00b9\u00ba\7\34\2\2\u00ba\u00bb\7\26\2\2"+
		"\u00bb\u00bc\5\30\r\2\u00bc\u00bd\7\27\2\2\u00bd\u00bf\3\2\2\2\u00be\u00b9"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf%\3\2\2\2\u00c0\u00c1\7\35\2\2\u00c1"+
		"\u00c2\7\24\2\2\u00c2\u00c3\5\n\6\2\u00c3\u00c4\7\25\2\2\u00c4\u00c5\7"+
		"\26\2\2\u00c5\u00c6\5\30\r\2\u00c6\u00c7\7\27\2\2\u00c7\'\3\2\2\2\u00c8"+
		"\u00ca\7\26\2\2\u00c9\u00cb\5\24\13\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\5\30\r\2\u00cd\u00ce\7\27\2\2"+
		"\u00ce)\3\2\2\2\u00cf\u00d1\7\26\2\2\u00d0\u00d2\5\24\13\2\u00d1\u00d0"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\5\30\r\2"+
		"\u00d4\u00d5\7\27\2\2\u00d5+\3\2\2\2\u00d6\u00d7\7%\2\2\u00d7-\3\2\2\2"+
		"\u00d8\u00d9\7$\2\2\u00d9/\3\2\2\2\25\65\67?AGNU\\ds}\u0083\u008d\u0091"+
		"\u0098\u00a7\u00be\u00ca\u00d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}