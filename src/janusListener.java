// Generated from janus.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link janusParser}.
 */
public interface janusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link janusParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(janusParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(janusParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(janusParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(janusParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(janusParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(janusParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#mainFun}.
	 * @param ctx the parse tree
	 */
	void enterMainFun(janusParser.MainFunContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#mainFun}.
	 * @param ctx the parse tree
	 */
	void exitMainFun(janusParser.MainFunContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(janusParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(janusParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#procedure}.
	 * @param ctx the parse tree
	 */
	void enterProcedure(janusParser.ProcedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#procedure}.
	 * @param ctx the parse tree
	 */
	void exitProcedure(janusParser.ProcedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#parametersDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParametersDeclaration(janusParser.ParametersDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#parametersDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParametersDeclaration(janusParser.ParametersDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(janusParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(janusParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#portDeclare}.
	 * @param ctx the parse tree
	 */
	void enterPortDeclare(janusParser.PortDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#portDeclare}.
	 * @param ctx the parse tree
	 */
	void exitPortDeclare(janusParser.PortDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#loopConstructor}.
	 * @param ctx the parse tree
	 */
	void enterLoopConstructor(janusParser.LoopConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#loopConstructor}.
	 * @param ctx the parse tree
	 */
	void exitLoopConstructor(janusParser.LoopConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#doExp}.
	 * @param ctx the parse tree
	 */
	void enterDoExp(janusParser.DoExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#doExp}.
	 * @param ctx the parse tree
	 */
	void exitDoExp(janusParser.DoExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#loopExp}.
	 * @param ctx the parse tree
	 */
	void enterLoopExp(janusParser.LoopExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#loopExp}.
	 * @param ctx the parse tree
	 */
	void exitLoopExp(janusParser.LoopExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#ifConstructor}.
	 * @param ctx the parse tree
	 */
	void enterIfConstructor(janusParser.IfConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#ifConstructor}.
	 * @param ctx the parse tree
	 */
	void exitIfConstructor(janusParser.IfConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpression(janusParser.IfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpression(janusParser.IfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#elseExpression}.
	 * @param ctx the parse tree
	 */
	void enterElseExpression(janusParser.ElseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#elseExpression}.
	 * @param ctx the parse tree
	 */
	void exitElseExpression(janusParser.ElseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#fiExpression}.
	 * @param ctx the parse tree
	 */
	void enterFiExpression(janusParser.FiExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#fiExpression}.
	 * @param ctx the parse tree
	 */
	void exitFiExpression(janusParser.FiExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#forkandjoin}.
	 * @param ctx the parse tree
	 */
	void enterForkandjoin(janusParser.ForkandjoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#forkandjoin}.
	 * @param ctx the parse tree
	 */
	void exitForkandjoin(janusParser.ForkandjoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(janusParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(janusParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(janusParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(janusParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(janusParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(janusParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#paramDecFun}.
	 * @param ctx the parse tree
	 */
	void enterParamDecFun(janusParser.ParamDecFunContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#paramDecFun}.
	 * @param ctx the parse tree
	 */
	void exitParamDecFun(janusParser.ParamDecFunContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#paramDeclare}.
	 * @param ctx the parse tree
	 */
	void enterParamDeclare(janusParser.ParamDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#paramDeclare}.
	 * @param ctx the parse tree
	 */
	void exitParamDeclare(janusParser.ParamDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#localParamDeclare}.
	 * @param ctx the parse tree
	 */
	void enterLocalParamDeclare(janusParser.LocalParamDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#localParamDeclare}.
	 * @param ctx the parse tree
	 */
	void exitLocalParamDeclare(janusParser.LocalParamDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(janusParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(janusParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(janusParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(janusParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#struct}.
	 * @param ctx the parse tree
	 */
	void enterStruct(janusParser.StructContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#struct}.
	 * @param ctx the parse tree
	 */
	void exitStruct(janusParser.StructContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#msgpass}.
	 * @param ctx the parse tree
	 */
	void enterMsgpass(janusParser.MsgpassContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#msgpass}.
	 * @param ctx the parse tree
	 */
	void exitMsgpass(janusParser.MsgpassContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#typemsg}.
	 * @param ctx the parse tree
	 */
	void enterTypemsg(janusParser.TypemsgContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#typemsg}.
	 * @param ctx the parse tree
	 */
	void exitTypemsg(janusParser.TypemsgContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(janusParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(janusParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#opcondition}.
	 * @param ctx the parse tree
	 */
	void enterOpcondition(janusParser.OpconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#opcondition}.
	 * @param ctx the parse tree
	 */
	void exitOpcondition(janusParser.OpconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(janusParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(janusParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(janusParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(janusParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(janusParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(janusParser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(janusParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(janusParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(janusParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(janusParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#local}.
	 * @param ctx the parse tree
	 */
	void enterLocal(janusParser.LocalContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#local}.
	 * @param ctx the parse tree
	 */
	void exitLocal(janusParser.LocalContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(janusParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(janusParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(janusParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(janusParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#port}.
	 * @param ctx the parse tree
	 */
	void enterPort(janusParser.PortContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#port}.
	 * @param ctx the parse tree
	 */
	void exitPort(janusParser.PortContext ctx);
	/**
	 * Enter a parse tree produced by {@link janusParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(janusParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link janusParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(janusParser.TagNameContext ctx);
}