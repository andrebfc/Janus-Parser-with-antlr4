// Generated from janus.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class janusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, Text=54, Digit=55, TextDigit=56, WS=57, BlockComment=58, LineComment=59;
	public static final int
		RULE_program = 0, RULE_functions = 1, RULE_function = 2, RULE_mainFun = 3, 
		RULE_functionDeclaration = 4, RULE_procedure = 5, RULE_parametersDeclaration = 6, 
		RULE_block = 7, RULE_portDeclare = 8, RULE_loopConstructor = 9, RULE_doExp = 10, 
		RULE_loopExp = 11, RULE_ifConstructor = 12, RULE_ifExpression = 13, RULE_elseExpression = 14, 
		RULE_fiExpression = 15, RULE_forkandjoin = 16, RULE_functionCall = 17, 
		RULE_condition = 18, RULE_assignmentExpression = 19, RULE_paramDecFun = 20, 
		RULE_paramDeclare = 21, RULE_localParamDeclare = 22, RULE_arguments = 23, 
		RULE_print = 24, RULE_struct = 25, RULE_msgpass = 26, RULE_typemsg = 27, 
		RULE_array = 28, RULE_opcondition = 29, RULE_assignmentOperator = 30, 
		RULE_operator = 31, RULE_logicalExpression = 32, RULE_value = 33, RULE_variableName = 34, 
		RULE_local = 35, RULE_type = 36, RULE_call = 37, RULE_port = 38, RULE_tagName = 39;
	public static final String[] ruleNames = {
		"program", "functions", "function", "mainFun", "functionDeclaration", 
		"procedure", "parametersDeclaration", "block", "portDeclare", "loopConstructor", 
		"doExp", "loopExp", "ifConstructor", "ifExpression", "elseExpression", 
		"fiExpression", "forkandjoin", "functionCall", "condition", "assignmentExpression", 
		"paramDecFun", "paramDeclare", "localParamDeclare", "arguments", "print", 
		"struct", "msgpass", "typemsg", "array", "opcondition", "assignmentOperator", 
		"operator", "logicalExpression", "value", "variableName", "local", "type", 
		"call", "port", "tagName"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'procedure'", "','", "'port'", "'from'", "'until'", 
		"'do'", "'loop'", "'if'", "'then'", "'else'", "'fi'", "'fork'", "'and'", 
		"'join'", "'.'", "'print'", "'struct'", "'end'", "'ssend'", "'srcv'", 
		"'asend'", "'arcv'", "'['", "']'", "'='", "'!='", "'<'", "'>'", "'<='", 
		"'>='", "'+='", "'-='", "'<=>'", "'^='", "'*'", "'+'", "'-'", "'/'", "'%'", 
		"'^'", "'&'", "'~'", "'&&'", "'||'", "'!'", "'local'", "'delocal'", "'int'", 
		"'call'", "'uncall'", "'_'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "Text", "Digit", "TextDigit", "WS", 
		"BlockComment", "LineComment"
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
	public String getGrammarFileName() { return "janus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public janusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public MainFunContext mainFun() {
			return getRuleContext(MainFunContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(80);
				functions(0);
				}
				break;
			}
			setState(83);
			mainFun();
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

	public static class FunctionsContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitFunctions(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		return functions(0);
	}

	private FunctionsContext functions(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FunctionsContext _localctx = new FunctionsContext(_ctx, _parentState);
		FunctionsContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_functions, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(86);
			function();
			}
			_ctx.stop = _input.LT(-1);
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FunctionsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_functions);
					setState(88);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(89);
					function();
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class FunctionContext extends ParserRuleContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public PortDeclareContext portDeclare() {
			return getRuleContext(PortDeclareContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			functionDeclaration();
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(96);
				portDeclare();
				}
				break;
			}
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(99);
				block();
				}
				break;
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

	public static class MainFunContext extends ParserRuleContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public PortDeclareContext portDeclare() {
			return getRuleContext(PortDeclareContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterMainFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitMainFun(this);
		}
	}

	public final MainFunContext mainFun() throws RecognitionException {
		MainFunContext _localctx = new MainFunContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mainFun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			functionDeclaration();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(103);
				portDeclare();
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__9) | (1L << T__13) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << Text) | (1L << Digit) | (1L << TextDigit))) != 0)) {
				{
				setState(106);
				block();
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public ProcedureContext procedure() {
			return getRuleContext(ProcedureContext.class,0);
		}
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public ParametersDeclarationContext parametersDeclaration() {
			return getRuleContext(ParametersDeclarationContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			procedure();
			setState(110);
			tagName();
			setState(111);
			match(T__0);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__49) {
				{
				setState(112);
				parametersDeclaration();
				}
			}

			setState(115);
			match(T__1);
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

	public static class ProcedureContext extends ParserRuleContext {
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterProcedure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitProcedure(this);
		}
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_procedure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__2);
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

	public static class ParametersDeclarationContext extends ParserRuleContext {
		public ParamDecFunContext paramDecFun() {
			return getRuleContext(ParamDecFunContext.class,0);
		}
		public ParametersDeclarationContext parametersDeclaration() {
			return getRuleContext(ParametersDeclarationContext.class,0);
		}
		public ParametersDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterParametersDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitParametersDeclaration(this);
		}
	}

	public final ParametersDeclarationContext parametersDeclaration() throws RecognitionException {
		ParametersDeclarationContext _localctx = new ParametersDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parametersDeclaration);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				paramDecFun();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				paramDecFun();
				setState(121);
				match(T__3);
				setState(122);
				parametersDeclaration();
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

	public static class BlockContext extends ParserRuleContext {
		public LocalParamDeclareContext localParamDeclare() {
			return getRuleContext(LocalParamDeclareContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamDeclareContext paramDeclare() {
			return getRuleContext(ParamDeclareContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public IfConstructorContext ifConstructor() {
			return getRuleContext(IfConstructorContext.class,0);
		}
		public LoopConstructorContext loopConstructor() {
			return getRuleContext(LoopConstructorContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ForkandjoinContext forkandjoin() {
			return getRuleContext(ForkandjoinContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public MsgpassContext msgpass() {
			return getRuleContext(MsgpassContext.class,0);
		}
		public StructContext struct() {
			return getRuleContext(StructContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				localParamDeclare();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				localParamDeclare();
				setState(128);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				paramDeclare();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				paramDeclare();
				setState(132);
				block();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(134);
				assignmentExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(135);
				assignmentExpression();
				setState(136);
				block();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(138);
				ifConstructor();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(139);
				ifConstructor();
				setState(140);
				block();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(142);
				loopConstructor();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(143);
				loopConstructor();
				setState(144);
				block();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(146);
				functionCall();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(147);
				functionCall();
				setState(148);
				block();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(150);
				forkandjoin();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(151);
				forkandjoin();
				setState(152);
				block();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(154);
				print();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(155);
				print();
				setState(156);
				block();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(158);
				msgpass();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(159);
				msgpass();
				setState(160);
				block();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(162);
				struct();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(163);
				struct();
				setState(164);
				block();
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

	public static class PortDeclareContext extends ParserRuleContext {
		public PortContext port() {
			return getRuleContext(PortContext.class,0);
		}
		public PortDeclareContext portDeclare() {
			return getRuleContext(PortDeclareContext.class,0);
		}
		public PortDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_portDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterPortDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitPortDeclare(this);
		}
	}

	public final PortDeclareContext portDeclare() throws RecognitionException {
		PortDeclareContext _localctx = new PortDeclareContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_portDeclare);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(T__4);
				setState(169);
				port();
				setState(171);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(170);
					portDeclare();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(T__4);
				setState(174);
				port();
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

	public static class LoopConstructorContext extends ParserRuleContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public DoExpContext doExp() {
			return getRuleContext(DoExpContext.class,0);
		}
		public LoopExpContext loopExp() {
			return getRuleContext(LoopExpContext.class,0);
		}
		public LoopConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterLoopConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitLoopConstructor(this);
		}
	}

	public final LoopConstructorContext loopConstructor() throws RecognitionException {
		LoopConstructorContext _localctx = new LoopConstructorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_loopConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(T__5);
			setState(178);
			condition(0);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(179);
				doExp();
				}
			}

			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(182);
				loopExp();
				}
			}

			setState(185);
			match(T__6);
			setState(186);
			condition(0);
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

	public static class DoExpContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DoExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterDoExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitDoExp(this);
		}
	}

	public final DoExpContext doExp() throws RecognitionException {
		DoExpContext _localctx = new DoExpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_doExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__7);
			setState(189);
			block();
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

	public static class LoopExpContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LoopExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterLoopExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitLoopExp(this);
		}
	}

	public final LoopExpContext loopExp() throws RecognitionException {
		LoopExpContext _localctx = new LoopExpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_loopExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__8);
			setState(192);
			block();
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

	public static class IfConstructorContext extends ParserRuleContext {
		public IfExpressionContext ifExpression() {
			return getRuleContext(IfExpressionContext.class,0);
		}
		public FiExpressionContext fiExpression() {
			return getRuleContext(FiExpressionContext.class,0);
		}
		public ElseExpressionContext elseExpression() {
			return getRuleContext(ElseExpressionContext.class,0);
		}
		public IfConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterIfConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitIfConstructor(this);
		}
	}

	public final IfConstructorContext ifConstructor() throws RecognitionException {
		IfConstructorContext _localctx = new IfConstructorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifConstructor);
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				ifExpression();
				setState(195);
				fiExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				ifExpression();
				setState(198);
				elseExpression();
				setState(199);
				fiExpression();
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

	public static class IfExpressionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterIfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitIfExpression(this);
		}
	}

	public final IfExpressionContext ifExpression() throws RecognitionException {
		IfExpressionContext _localctx = new IfExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__9);
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(204);
				match(T__0);
				}
				break;
			}
			setState(207);
			condition(0);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(208);
				match(T__1);
				}
			}

			setState(211);
			match(T__10);
			setState(212);
			block();
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

	public static class ElseExpressionContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterElseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitElseExpression(this);
		}
	}

	public final ElseExpressionContext elseExpression() throws RecognitionException {
		ElseExpressionContext _localctx = new ElseExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elseExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(T__11);
			setState(215);
			block();
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

	public static class FiExpressionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public FiExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fiExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterFiExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitFiExpression(this);
		}
	}

	public final FiExpressionContext fiExpression() throws RecognitionException {
		FiExpressionContext _localctx = new FiExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fiExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__12);
			setState(218);
			condition(0);
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

	public static class ForkandjoinContext extends ParserRuleContext {
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public ForkandjoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forkandjoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterForkandjoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitForkandjoin(this);
		}
	}

	public final ForkandjoinContext forkandjoin() throws RecognitionException {
		ForkandjoinContext _localctx = new ForkandjoinContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forkandjoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__13);
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(221);
				tagName();
				}
				break;
			}
			setState(224);
			block();
			setState(225);
			match(T__14);
			setState(226);
			block();
			setState(227);
			match(T__15);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			call();
			setState(230);
			tagName();
			setState(231);
			match(T__0);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Text || _la==TextDigit) {
				{
				setState(232);
				arguments();
				}
			}

			setState(235);
			match(T__1);
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public OpconditionContext opcondition() {
			return getRuleContext(OpconditionContext.class,0);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(238);
				match(T__0);
				}
				break;
			}
			setState(241);
			value(0);
			setState(242);
			opcondition();
			setState(243);
			value(0);
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(244);
				match(T__1);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(253);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(247);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(248);
					logicalExpression();
					setState(249);
					condition(2);
					}
					} 
				}
				setState(255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitAssignmentExpression(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignmentExpression);
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				value(0);
				setState(257);
				assignmentOperator();
				setState(258);
				value(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				tagName();
				setState(261);
				match(T__16);
				setState(262);
				value(0);
				setState(263);
				assignmentOperator();
				setState(264);
				value(0);
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

	public static class ParamDecFunContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ParamDecFunContext paramDecFun() {
			return getRuleContext(ParamDecFunContext.class,0);
		}
		public ParamDecFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDecFun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterParamDecFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitParamDecFun(this);
		}
	}

	public final ParamDecFunContext paramDecFun() throws RecognitionException {
		ParamDecFunContext _localctx = new ParamDecFunContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_paramDecFun);
		int _la;
		try {
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				type();
				setState(269);
				variableName();
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(270);
					array();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				type();
				setState(274);
				variableName();
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(275);
					array();
					}
				}

				setState(278);
				paramDecFun();
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

	public static class ParamDeclareContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ParamDeclareContext paramDeclare() {
			return getRuleContext(ParamDeclareContext.class,0);
		}
		public TerminalNode Digit() { return getToken(janusParser.Digit, 0); }
		public ParamDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterParamDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitParamDeclare(this);
		}
	}

	public final ParamDeclareContext paramDeclare() throws RecognitionException {
		ParamDeclareContext _localctx = new ParamDeclareContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_paramDeclare);
		int _la;
		try {
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				type();
				setState(283);
				variableName();
				setState(285);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(284);
					array();
					}
					break;
				}
				setState(288);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(287);
					assignmentOperator();
					}
					break;
				}
				setState(291);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(290);
					value(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				type();
				setState(294);
				variableName();
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(295);
					array();
					}
				}

				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) {
					{
					setState(298);
					assignmentOperator();
					}
				}

				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Digit) {
					{
					setState(301);
					match(Digit);
					}
				}

				setState(304);
				paramDeclare();
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

	public static class LocalParamDeclareContext extends ParserRuleContext {
		public LocalContext local() {
			return getRuleContext(LocalContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public OpconditionContext opcondition() {
			return getRuleContext(OpconditionContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public LocalParamDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localParamDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterLocalParamDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitLocalParamDeclare(this);
		}
	}

	public final LocalParamDeclareContext localParamDeclare() throws RecognitionException {
		LocalParamDeclareContext _localctx = new LocalParamDeclareContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_localParamDeclare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			local();
			setState(309);
			type();
			setState(310);
			variableName();
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(311);
				array();
				}
				break;
			}
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(314);
				opcondition();
				setState(315);
				value(0);
				}
				break;
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

	public static class ArgumentsContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arguments);
		int _la;
		try {
			setState(330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				variableName();
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(320);
					array();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(323);
				variableName();
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(324);
					array();
					}
				}

				setState(327);
				match(T__3);
				setState(328);
				arguments();
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

	public static class PrintContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(T__17);
			setState(333);
			value(0);
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

	public static class StructContext extends ParserRuleContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public ParamDeclareContext paramDeclare() {
			return getRuleContext(ParamDeclareContext.class,0);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitStruct(this);
		}
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(T__18);
			setState(336);
			tagName();
			setState(337);
			paramDeclare();
			setState(338);
			match(T__19);
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

	public static class MsgpassContext extends ParserRuleContext {
		public TypemsgContext typemsg() {
			return getRuleContext(TypemsgContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public PortContext port() {
			return getRuleContext(PortContext.class,0);
		}
		public MsgpassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_msgpass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterMsgpass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitMsgpass(this);
		}
	}

	public final MsgpassContext msgpass() throws RecognitionException {
		MsgpassContext _localctx = new MsgpassContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_msgpass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			typemsg();
			setState(341);
			match(T__0);
			setState(342);
			variableName();
			setState(343);
			match(T__3);
			setState(344);
			port();
			setState(345);
			match(T__1);
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

	public static class TypemsgContext extends ParserRuleContext {
		public TypemsgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typemsg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterTypemsg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitTypemsg(this);
		}
	}

	public final TypemsgContext typemsg() throws RecognitionException {
		TypemsgContext _localctx = new TypemsgContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_typemsg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
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
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_array);
		try {
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				match(T__24);
				setState(350);
				match(T__25);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(351);
				match(T__24);
				setState(352);
				value(0);
				setState(353);
				match(T__25);
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

	public static class OpconditionContext extends ParserRuleContext {
		public OpconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterOpcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitOpcondition(this);
		}
	}

	public final OpconditionContext opcondition() throws RecognitionException {
		OpconditionContext _localctx = new OpconditionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_opcondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
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

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitAssignmentOperator(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
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

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
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

	public static class LogicalExpressionContext extends ParserRuleContext {
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitLogicalExpression(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_logicalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__45) | (1L << T__46))) != 0)) ) {
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

	public static class ValueContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode Digit() { return getToken(janusParser.Digit, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		return value(0);
	}

	private ValueContext value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueContext _localctx = new ValueContext(_ctx, _parentState);
		ValueContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_value, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Text:
			case TextDigit:
				{
				setState(366);
				variableName();
				setState(368);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(367);
					array();
					}
					break;
				}
				}
				break;
			case Digit:
				{
				setState(370);
				match(Digit);
				}
				break;
			case T__0:
				{
				setState(371);
				match(T__0);
				setState(372);
				value(0);
				setState(373);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(383);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ValueContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_value);
					setState(377);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(378);
					operator();
					setState(379);
					value(2);
					}
					} 
				}
				setState(385);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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

	public static class VariableNameContext extends ParserRuleContext {
		public TerminalNode Text() { return getToken(janusParser.Text, 0); }
		public TerminalNode TextDigit() { return getToken(janusParser.TextDigit, 0); }
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitVariableName(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_variableName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			_la = _input.LA(1);
			if ( !(_la==Text || _la==TextDigit) ) {
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

	public static class LocalContext extends ParserRuleContext {
		public LocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterLocal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitLocal(this);
		}
	}

	public final LocalContext local() throws RecognitionException {
		LocalContext _localctx = new LocalContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_local);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			_la = _input.LA(1);
			if ( !(_la==T__47 || _la==T__48) ) {
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(T__49);
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

	public static class CallContext extends ParserRuleContext {
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitCall(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			_la = _input.LA(1);
			if ( !(_la==T__50 || _la==T__51) ) {
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

	public static class PortContext extends ParserRuleContext {
		public TerminalNode Text() { return getToken(janusParser.Text, 0); }
		public PortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_port; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterPort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitPort(this);
		}
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_port);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(Text);
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

	public static class TagNameContext extends ParserRuleContext {
		public List<TerminalNode> Text() { return getTokens(janusParser.Text); }
		public TerminalNode Text(int i) {
			return getToken(janusParser.Text, i);
		}
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof janusListener ) ((janusListener)listener).exitTagName(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_tagName);
		try {
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				match(Text);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				match(Text);
				setState(398);
				match(T__52);
				setState(399);
				match(Text);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return functions_sempred((FunctionsContext)_localctx, predIndex);
		case 18:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		case 33:
			return value_sempred((ValueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean functions_sempred(FunctionsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean value_sempred(ValueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u0195\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\5\2T\n\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3]\n\3\f\3\16\3`\13\3\3\4\3\4\5\4d\n\4\3"+
		"\4\5\4g\n\4\3\5\3\5\5\5k\n\5\3\5\5\5n\n\5\3\6\3\6\3\6\3\6\5\6t\n\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b\177\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a9"+
		"\n\t\3\n\3\n\3\n\5\n\u00ae\n\n\3\n\3\n\5\n\u00b2\n\n\3\13\3\13\3\13\5"+
		"\13\u00b7\n\13\3\13\5\13\u00ba\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00cc\n\16\3\17\3\17\5\17"+
		"\u00d0\n\17\3\17\3\17\5\17\u00d4\n\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\5\22\u00e1\n\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\5\23\u00ec\n\23\3\23\3\23\3\24\3\24\5\24\u00f2\n\24\3"+
		"\24\3\24\3\24\3\24\5\24\u00f8\n\24\3\24\3\24\3\24\3\24\7\24\u00fe\n\24"+
		"\f\24\16\24\u0101\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\5\25\u010d\n\25\3\26\3\26\3\26\5\26\u0112\n\26\3\26\3\26\3\26\5\26"+
		"\u0117\n\26\3\26\3\26\5\26\u011b\n\26\3\27\3\27\3\27\5\27\u0120\n\27\3"+
		"\27\5\27\u0123\n\27\3\27\5\27\u0126\n\27\3\27\3\27\3\27\5\27\u012b\n\27"+
		"\3\27\5\27\u012e\n\27\3\27\5\27\u0131\n\27\3\27\3\27\5\27\u0135\n\27\3"+
		"\30\3\30\3\30\3\30\5\30\u013b\n\30\3\30\3\30\3\30\5\30\u0140\n\30\3\31"+
		"\3\31\5\31\u0144\n\31\3\31\3\31\5\31\u0148\n\31\3\31\3\31\3\31\5\31\u014d"+
		"\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0166\n\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\5#\u0173\n#\3#\3#\3#\3#\3#\5#\u017a"+
		"\n#\3#\3#\3#\3#\7#\u0180\n#\f#\16#\u0183\13#\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3(\3(\3)\3)\3)\3)\5)\u0193\n)\3)\2\5\4&D*\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP\2\n\3\2\27\32\3\2\35\""+
		"\4\2\35\35#&\3\2\'.\3\2/\61\4\288::\3\2\62\63\3\2\65\66\2\u01a9\2S\3\2"+
		"\2\2\4W\3\2\2\2\6a\3\2\2\2\bh\3\2\2\2\no\3\2\2\2\fw\3\2\2\2\16~\3\2\2"+
		"\2\20\u00a8\3\2\2\2\22\u00b1\3\2\2\2\24\u00b3\3\2\2\2\26\u00be\3\2\2\2"+
		"\30\u00c1\3\2\2\2\32\u00cb\3\2\2\2\34\u00cd\3\2\2\2\36\u00d8\3\2\2\2 "+
		"\u00db\3\2\2\2\"\u00de\3\2\2\2$\u00e7\3\2\2\2&\u00ef\3\2\2\2(\u010c\3"+
		"\2\2\2*\u011a\3\2\2\2,\u0134\3\2\2\2.\u0136\3\2\2\2\60\u014c\3\2\2\2\62"+
		"\u014e\3\2\2\2\64\u0151\3\2\2\2\66\u0156\3\2\2\28\u015d\3\2\2\2:\u0165"+
		"\3\2\2\2<\u0167\3\2\2\2>\u0169\3\2\2\2@\u016b\3\2\2\2B\u016d\3\2\2\2D"+
		"\u0179\3\2\2\2F\u0184\3\2\2\2H\u0186\3\2\2\2J\u0188\3\2\2\2L\u018a\3\2"+
		"\2\2N\u018c\3\2\2\2P\u0192\3\2\2\2RT\5\4\3\2SR\3\2\2\2ST\3\2\2\2TU\3\2"+
		"\2\2UV\5\b\5\2V\3\3\2\2\2WX\b\3\1\2XY\5\6\4\2Y^\3\2\2\2Z[\f\3\2\2[]\5"+
		"\6\4\2\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\5\3\2\2\2`^\3\2\2\2"+
		"ac\5\n\6\2bd\5\22\n\2cb\3\2\2\2cd\3\2\2\2df\3\2\2\2eg\5\20\t\2fe\3\2\2"+
		"\2fg\3\2\2\2g\7\3\2\2\2hj\5\n\6\2ik\5\22\n\2ji\3\2\2\2jk\3\2\2\2km\3\2"+
		"\2\2ln\5\20\t\2ml\3\2\2\2mn\3\2\2\2n\t\3\2\2\2op\5\f\7\2pq\5P)\2qs\7\3"+
		"\2\2rt\5\16\b\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\4\2\2v\13\3\2\2\2wx"+
		"\7\5\2\2x\r\3\2\2\2y\177\5*\26\2z{\5*\26\2{|\7\6\2\2|}\5\16\b\2}\177\3"+
		"\2\2\2~y\3\2\2\2~z\3\2\2\2\177\17\3\2\2\2\u0080\u00a9\5.\30\2\u0081\u0082"+
		"\5.\30\2\u0082\u0083\5\20\t\2\u0083\u00a9\3\2\2\2\u0084\u00a9\5,\27\2"+
		"\u0085\u0086\5,\27\2\u0086\u0087\5\20\t\2\u0087\u00a9\3\2\2\2\u0088\u00a9"+
		"\5(\25\2\u0089\u008a\5(\25\2\u008a\u008b\5\20\t\2\u008b\u00a9\3\2\2\2"+
		"\u008c\u00a9\5\32\16\2\u008d\u008e\5\32\16\2\u008e\u008f\5\20\t\2\u008f"+
		"\u00a9\3\2\2\2\u0090\u00a9\5\24\13\2\u0091\u0092\5\24\13\2\u0092\u0093"+
		"\5\20\t\2\u0093\u00a9\3\2\2\2\u0094\u00a9\5$\23\2\u0095\u0096\5$\23\2"+
		"\u0096\u0097\5\20\t\2\u0097\u00a9\3\2\2\2\u0098\u00a9\5\"\22\2\u0099\u009a"+
		"\5\"\22\2\u009a\u009b\5\20\t\2\u009b\u00a9\3\2\2\2\u009c\u00a9\5\62\32"+
		"\2\u009d\u009e\5\62\32\2\u009e\u009f\5\20\t\2\u009f\u00a9\3\2\2\2\u00a0"+
		"\u00a9\5\66\34\2\u00a1\u00a2\5\66\34\2\u00a2\u00a3\5\20\t\2\u00a3\u00a9"+
		"\3\2\2\2\u00a4\u00a9\5\64\33\2\u00a5\u00a6\5\64\33\2\u00a6\u00a7\5\20"+
		"\t\2\u00a7\u00a9\3\2\2\2\u00a8\u0080\3\2\2\2\u00a8\u0081\3\2\2\2\u00a8"+
		"\u0084\3\2\2\2\u00a8\u0085\3\2\2\2\u00a8\u0088\3\2\2\2\u00a8\u0089\3\2"+
		"\2\2\u00a8\u008c\3\2\2\2\u00a8\u008d\3\2\2\2\u00a8\u0090\3\2\2\2\u00a8"+
		"\u0091\3\2\2\2\u00a8\u0094\3\2\2\2\u00a8\u0095\3\2\2\2\u00a8\u0098\3\2"+
		"\2\2\u00a8\u0099\3\2\2\2\u00a8\u009c\3\2\2\2\u00a8\u009d\3\2\2\2\u00a8"+
		"\u00a0\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a8\u00a5\3\2"+
		"\2\2\u00a9\21\3\2\2\2\u00aa\u00ab\7\7\2\2\u00ab\u00ad\5N(\2\u00ac\u00ae"+
		"\5\22\n\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b2\3\2\2\2"+
		"\u00af\u00b0\7\7\2\2\u00b0\u00b2\5N(\2\u00b1\u00aa\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b2\23\3\2\2\2\u00b3\u00b4\7\b\2\2\u00b4\u00b6\5&\24\2\u00b5"+
		"\u00b7\5\26\f\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3"+
		"\2\2\2\u00b8\u00ba\5\30\r\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00bc\7\t\2\2\u00bc\u00bd\5&\24\2\u00bd\25\3\2\2"+
		"\2\u00be\u00bf\7\n\2\2\u00bf\u00c0\5\20\t\2\u00c0\27\3\2\2\2\u00c1\u00c2"+
		"\7\13\2\2\u00c2\u00c3\5\20\t\2\u00c3\31\3\2\2\2\u00c4\u00c5\5\34\17\2"+
		"\u00c5\u00c6\5 \21\2\u00c6\u00cc\3\2\2\2\u00c7\u00c8\5\34\17\2\u00c8\u00c9"+
		"\5\36\20\2\u00c9\u00ca\5 \21\2\u00ca\u00cc\3\2\2\2\u00cb\u00c4\3\2\2\2"+
		"\u00cb\u00c7\3\2\2\2\u00cc\33\3\2\2\2\u00cd\u00cf\7\f\2\2\u00ce\u00d0"+
		"\7\3\2\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d3\5&\24\2\u00d2\u00d4\7\4\2\2\u00d3\u00d2\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7\r\2\2\u00d6\u00d7\5\20\t\2\u00d7"+
		"\35\3\2\2\2\u00d8\u00d9\7\16\2\2\u00d9\u00da\5\20\t\2\u00da\37\3\2\2\2"+
		"\u00db\u00dc\7\17\2\2\u00dc\u00dd\5&\24\2\u00dd!\3\2\2\2\u00de\u00e0\7"+
		"\20\2\2\u00df\u00e1\5P)\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e3\5\20\t\2\u00e3\u00e4\7\21\2\2\u00e4\u00e5\5"+
		"\20\t\2\u00e5\u00e6\7\22\2\2\u00e6#\3\2\2\2\u00e7\u00e8\5L\'\2\u00e8\u00e9"+
		"\5P)\2\u00e9\u00eb\7\3\2\2\u00ea\u00ec\5\60\31\2\u00eb\u00ea\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\7\4\2\2\u00ee%\3\2\2\2"+
		"\u00ef\u00f1\b\24\1\2\u00f0\u00f2\7\3\2\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\5D#\2\u00f4\u00f5\5<\37\2\u00f5"+
		"\u00f7\5D#\2\u00f6\u00f8\7\4\2\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2"+
		"\2\u00f8\u00ff\3\2\2\2\u00f9\u00fa\f\3\2\2\u00fa\u00fb\5B\"\2\u00fb\u00fc"+
		"\5&\24\4\u00fc\u00fe\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\'\3\2\2\2\u0101\u00ff\3\2\2\2"+
		"\u0102\u0103\5D#\2\u0103\u0104\5> \2\u0104\u0105\5D#\2\u0105\u010d\3\2"+
		"\2\2\u0106\u0107\5P)\2\u0107\u0108\7\23\2\2\u0108\u0109\5D#\2\u0109\u010a"+
		"\5> \2\u010a\u010b\5D#\2\u010b\u010d\3\2\2\2\u010c\u0102\3\2\2\2\u010c"+
		"\u0106\3\2\2\2\u010d)\3\2\2\2\u010e\u010f\5J&\2\u010f\u0111\5F$\2\u0110"+
		"\u0112\5:\36\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u011b\3\2"+
		"\2\2\u0113\u0114\5J&\2\u0114\u0116\5F$\2\u0115\u0117\5:\36\2\u0116\u0115"+
		"\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\5*\26\2\u0119"+
		"\u011b\3\2\2\2\u011a\u010e\3\2\2\2\u011a\u0113\3\2\2\2\u011b+\3\2\2\2"+
		"\u011c\u011d\5J&\2\u011d\u011f\5F$\2\u011e\u0120\5:\36\2\u011f\u011e\3"+
		"\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u0123\5> \2\u0122"+
		"\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\3\2\2\2\u0124\u0126\5D"+
		"#\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0135\3\2\2\2\u0127"+
		"\u0128\5J&\2\u0128\u012a\5F$\2\u0129\u012b\5:\36\2\u012a\u0129\3\2\2\2"+
		"\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012e\5> \2\u012d\u012c"+
		"\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2\2\2\u012f\u0131\79\2\2\u0130"+
		"\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\5,"+
		"\27\2\u0133\u0135\3\2\2\2\u0134\u011c\3\2\2\2\u0134\u0127\3\2\2\2\u0135"+
		"-\3\2\2\2\u0136\u0137\5H%\2\u0137\u0138\5J&\2\u0138\u013a\5F$\2\u0139"+
		"\u013b\5:\36\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013f\3\2"+
		"\2\2\u013c\u013d\5<\37\2\u013d\u013e\5D#\2\u013e\u0140\3\2\2\2\u013f\u013c"+
		"\3\2\2\2\u013f\u0140\3\2\2\2\u0140/\3\2\2\2\u0141\u0143\5F$\2\u0142\u0144"+
		"\5:\36\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u014d\3\2\2\2\u0145"+
		"\u0147\5F$\2\u0146\u0148\5:\36\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2"+
		"\2\u0148\u0149\3\2\2\2\u0149\u014a\7\6\2\2\u014a\u014b\5\60\31\2\u014b"+
		"\u014d\3\2\2\2\u014c\u0141\3\2\2\2\u014c\u0145\3\2\2\2\u014d\61\3\2\2"+
		"\2\u014e\u014f\7\24\2\2\u014f\u0150\5D#\2\u0150\63\3\2\2\2\u0151\u0152"+
		"\7\25\2\2\u0152\u0153\5P)\2\u0153\u0154\5,\27\2\u0154\u0155\7\26\2\2\u0155"+
		"\65\3\2\2\2\u0156\u0157\58\35\2\u0157\u0158\7\3\2\2\u0158\u0159\5F$\2"+
		"\u0159\u015a\7\6\2\2\u015a\u015b\5N(\2\u015b\u015c\7\4\2\2\u015c\67\3"+
		"\2\2\2\u015d\u015e\t\2\2\2\u015e9\3\2\2\2\u015f\u0160\7\33\2\2\u0160\u0166"+
		"\7\34\2\2\u0161\u0162\7\33\2\2\u0162\u0163\5D#\2\u0163\u0164\7\34\2\2"+
		"\u0164\u0166\3\2\2\2\u0165\u015f\3\2\2\2\u0165\u0161\3\2\2\2\u0166;\3"+
		"\2\2\2\u0167\u0168\t\3\2\2\u0168=\3\2\2\2\u0169\u016a\t\4\2\2\u016a?\3"+
		"\2\2\2\u016b\u016c\t\5\2\2\u016cA\3\2\2\2\u016d\u016e\t\6\2\2\u016eC\3"+
		"\2\2\2\u016f\u0170\b#\1\2\u0170\u0172\5F$\2\u0171\u0173\5:\36\2\u0172"+
		"\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u017a\3\2\2\2\u0174\u017a\79"+
		"\2\2\u0175\u0176\7\3\2\2\u0176\u0177\5D#\2\u0177\u0178\7\4\2\2\u0178\u017a"+
		"\3\2\2\2\u0179\u016f\3\2\2\2\u0179\u0174\3\2\2\2\u0179\u0175\3\2\2\2\u017a"+
		"\u0181\3\2\2\2\u017b\u017c\f\3\2\2\u017c\u017d\5@!\2\u017d\u017e\5D#\4"+
		"\u017e\u0180\3\2\2\2\u017f\u017b\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f"+
		"\3\2\2\2\u0181\u0182\3\2\2\2\u0182E\3\2\2\2\u0183\u0181\3\2\2\2\u0184"+
		"\u0185\t\7\2\2\u0185G\3\2\2\2\u0186\u0187\t\b\2\2\u0187I\3\2\2\2\u0188"+
		"\u0189\7\64\2\2\u0189K\3\2\2\2\u018a\u018b\t\t\2\2\u018bM\3\2\2\2\u018c"+
		"\u018d\78\2\2\u018dO\3\2\2\2\u018e\u0193\78\2\2\u018f\u0190\78\2\2\u0190"+
		"\u0191\7\67\2\2\u0191\u0193\78\2\2\u0192\u018e\3\2\2\2\u0192\u018f\3\2"+
		"\2\2\u0193Q\3\2\2\2,S^cfjms~\u00a8\u00ad\u00b1\u00b6\u00b9\u00cb\u00cf"+
		"\u00d3\u00e0\u00eb\u00f1\u00f7\u00ff\u010c\u0111\u0116\u011a\u011f\u0122"+
		"\u0125\u012a\u012d\u0130\u0134\u013a\u013f\u0143\u0147\u014c\u0165\u0172"+
		"\u0179\u0181\u0192";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}