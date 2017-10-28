// Generated from .\src\MicroC_language\parsing\MicroC.g4 by ANTLR 4.7
package microC.parsing;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroCLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TRUE", "FALSE", "AND", "OR", "ASSIGN", "SEMI", "GT", "GE", "LT", "LE", 
		"EQ", "NEQ", "PLUS", "MINUS", "MUL", "DIV", "NOT", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "LBRACKET", "RBRACKET", "COLON", "IF", "ELSE", "WHILE", 
		"CONTINUE", "BREAK", "WRITE", "READ", "INT", "COMMENT", "INTEGER", "IDENTIFIER", 
		"LETTER", "WS"
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


	public MicroCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MicroC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u00dc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u00bb\n\"\f\"\16\"\u00be\13"+
		"\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\7#\u00c8\n#\f#\16#\u00cb\13#\5#\u00cd"+
		"\n#\3$\3$\3$\7$\u00d2\n$\f$\16$\u00d5\13$\3%\3%\3&\3&\3&\3&\3\u00bc\2"+
		"\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I\2K&\3\2\4\5\2C\\aac|\5\2\13\f\16\17\"\"\2\u00df\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2K\3"+
		"\2\2\2\3M\3\2\2\2\5R\3\2\2\2\7X\3\2\2\2\tZ\3\2\2\2\13\\\3\2\2\2\r^\3\2"+
		"\2\2\17`\3\2\2\2\21b\3\2\2\2\23e\3\2\2\2\25g\3\2\2\2\27j\3\2\2\2\31m\3"+
		"\2\2\2\33p\3\2\2\2\35r\3\2\2\2\37t\3\2\2\2!v\3\2\2\2#x\3\2\2\2%|\3\2\2"+
		"\2\'~\3\2\2\2)\u0080\3\2\2\2+\u0082\3\2\2\2-\u0084\3\2\2\2/\u0086\3\2"+
		"\2\2\61\u0088\3\2\2\2\63\u008a\3\2\2\2\65\u008d\3\2\2\2\67\u0092\3\2\2"+
		"\29\u0098\3\2\2\2;\u00a1\3\2\2\2=\u00a7\3\2\2\2?\u00ad\3\2\2\2A\u00b2"+
		"\3\2\2\2C\u00b6\3\2\2\2E\u00cc\3\2\2\2G\u00ce\3\2\2\2I\u00d6\3\2\2\2K"+
		"\u00d8\3\2\2\2MN\7v\2\2NO\7t\2\2OP\7w\2\2PQ\7g\2\2Q\4\3\2\2\2RS\7h\2\2"+
		"ST\7c\2\2TU\7n\2\2UV\7u\2\2VW\7g\2\2W\6\3\2\2\2XY\7(\2\2Y\b\3\2\2\2Z["+
		"\7~\2\2[\n\3\2\2\2\\]\7?\2\2]\f\3\2\2\2^_\7=\2\2_\16\3\2\2\2`a\7@\2\2"+
		"a\20\3\2\2\2bc\7@\2\2cd\7?\2\2d\22\3\2\2\2ef\7>\2\2f\24\3\2\2\2gh\7>\2"+
		"\2hi\7?\2\2i\26\3\2\2\2jk\7?\2\2kl\7?\2\2l\30\3\2\2\2mn\7#\2\2no\7?\2"+
		"\2o\32\3\2\2\2pq\7-\2\2q\34\3\2\2\2rs\7/\2\2s\36\3\2\2\2tu\7,\2\2u \3"+
		"\2\2\2vw\7\61\2\2w\"\3\2\2\2xy\7p\2\2yz\7q\2\2z{\7v\2\2{$\3\2\2\2|}\7"+
		"*\2\2}&\3\2\2\2~\177\7+\2\2\177(\3\2\2\2\u0080\u0081\7}\2\2\u0081*\3\2"+
		"\2\2\u0082\u0083\7\177\2\2\u0083,\3\2\2\2\u0084\u0085\7]\2\2\u0085.\3"+
		"\2\2\2\u0086\u0087\7_\2\2\u0087\60\3\2\2\2\u0088\u0089\7<\2\2\u0089\62"+
		"\3\2\2\2\u008a\u008b\7k\2\2\u008b\u008c\7h\2\2\u008c\64\3\2\2\2\u008d"+
		"\u008e\7g\2\2\u008e\u008f\7n\2\2\u008f\u0090\7u\2\2\u0090\u0091\7g\2\2"+
		"\u0091\66\3\2\2\2\u0092\u0093\7y\2\2\u0093\u0094\7j\2\2\u0094\u0095\7"+
		"k\2\2\u0095\u0096\7n\2\2\u0096\u0097\7g\2\2\u00978\3\2\2\2\u0098\u0099"+
		"\7e\2\2\u0099\u009a\7q\2\2\u009a\u009b\7p\2\2\u009b\u009c\7v\2\2\u009c"+
		"\u009d\7k\2\2\u009d\u009e\7p\2\2\u009e\u009f\7w\2\2\u009f\u00a0\7g\2\2"+
		"\u00a0:\3\2\2\2\u00a1\u00a2\7d\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4\7g\2"+
		"\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7m\2\2\u00a6<\3\2\2\2\u00a7\u00a8\7"+
		"y\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7v\2\2\u00ab\u00ac"+
		"\7g\2\2\u00ac>\3\2\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7g\2\2\u00af\u00b0"+
		"\7c\2\2\u00b0\u00b1\7f\2\2\u00b1@\3\2\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4"+
		"\7p\2\2\u00b4\u00b5\7v\2\2\u00b5B\3\2\2\2\u00b6\u00b7\7\61\2\2\u00b7\u00b8"+
		"\7,\2\2\u00b8\u00bc\3\2\2\2\u00b9\u00bb\13\2\2\2\u00ba\u00b9\3\2\2\2\u00bb"+
		"\u00be\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00bf\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7,\2\2\u00c0\u00c1\7\61\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c3\b\"\2\2\u00c3D\3\2\2\2\u00c4\u00cd\7\62\2\2"+
		"\u00c5\u00c9\4\63;\2\u00c6\u00c8\4\62;\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb"+
		"\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cc\u00c4\3\2\2\2\u00cc\u00c5\3\2\2\2\u00cdF\3\2\2\2"+
		"\u00ce\u00d3\5I%\2\u00cf\u00d2\5I%\2\u00d0\u00d2\4\62;\2\u00d1\u00cf\3"+
		"\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4H\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\t\2\2\2"+
		"\u00d7J\3\2\2\2\u00d8\u00d9\t\3\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\b"+
		"&\3\2\u00dbL\3\2\2\2\b\2\u00bc\u00c9\u00cc\u00d1\u00d3\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}