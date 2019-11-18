// walk for forward
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

public class janusWriteF extends janusBaseListener {

    static int countforkandjoin = 0;
    int nidfork = 0;
    boolean structPass = true;
    static int numfaj = 0;

    List<String> typePar = new ArrayList<String>();
    List<String> namePar = new ArrayList<String>();
    List<Integer> argsTh = new ArrayList<>();

    //Parse for fork and join count
    ParseTreeWalker walker = new ParseTreeWalker();
    ParseTree parseTree;

    genereteCode gc;
    utility ut;
    janusRules r;

    //constructor
    janusWriteF(genereteCode genCode, utility u){
        this.gc = genCode;
        this.ut = u;

        //reset count fork and join
        countforkandjoin = 0;

        r = new janusRules(gc,u);

    }

    //constructor
    janusWriteF(genereteCode genCode, int nf, utility u){
        this.gc = genCode;
        this.nidfork = nf;
        this.ut = u;

        r = new janusRules(gc,u);
    }


    //mainFunction
    public void enterMainFun(janusParser.MainFunContext ctx){
        gc.declareFunction("main",2);
        ut.incIndent();
    }

    public void exitMainFun(janusParser.MainFunContext ctx){
        ut.decIndent();
        gc.setExitFunction();
    }


    //function
    public void enterFunction(janusParser.FunctionContext ctx){
        if(numfaj < 1) { //fork and join
            gc.declareFunction(ctx.functionDeclaration().tagName().getText(), 0);// 0 = forward
            ut.incIndent();
        }

    }

    public void exitFunction(janusParser.FunctionContext ctx){
        if(numfaj < 1) {//fork and join
            ut.decIndent();
            gc.setExitFunction();
            gc.setBlankLine();
        }
    }


    // parametersDeclaration function
    public void enterParametersDeclaration(janusParser.ParametersDeclarationContext ctx){
        if(numfaj < 1) {//fork and join
            // add type and variable name on string list
            typePar.add(ctx.paramDecFun().type().getText());
            namePar.add(ctx.paramDecFun().variableName().getText());
        }
    }

    //function declaration
    public void exitFunctionDeclaration(janusParser.FunctionDeclarationContext ctx){
        if(numfaj < 1) {
            try {
                if (ctx.parametersDeclaration().paramDecFun().array() == null) {
                    gc.setParamsDeclFunc(typePar, namePar, 0); // flag 0 = '&'
                } else {
                    gc.setParamsDeclFunc(typePar, namePar, 1); // flag 1 = '*'
                }
            } catch (NullPointerException e) {

            }
            gc.setExitFunctionDeclaration();

            //list reset
            typePar.clear();
            namePar.clear();
        }
    }

    public void exitIfConstructor(janusParser.IfConstructorContext ctx){
        if(numfaj < 1) {
            if (ctx.elseExpression() == null) {
                gc.setExitFunction();
            }

        }
    }

    //ifExpression
    public void enterIfExpression(janusParser.IfExpressionContext ctx){
        if(numfaj < 1) {
            if (ctx.condition() != null) {
                gc.openIfDec();

                r.condition(ctx.condition());
                gc.closeIfDec();

                ut.incIndent();
            }
        }
    }

    public void exitIfExpression(janusParser.IfExpressionContext ctx){
        if(numfaj < 1) {
            gc.openAssertCondition(0); // 0 = real condition
            this.getFiCondition((janusParser.IfConstructorContext) ctx.getParent());
            gc.closeAssertCondition(0);
            ut.decIndent();
        }
    }


    //elseExpression
    public void enterElseExpression(janusParser.ElseExpressionContext ctx){
        if(numfaj < 1) {
            gc.setElse();
            ut.incIndent();
        }
    }

    public void exitElseExpression(janusParser.ElseExpressionContext ctx){
        if(numfaj < 1) {
            gc.openAssertCondition(1); // 1 = neg
            this.getFiCondition((janusParser.IfConstructorContext) ctx.getParent());
            gc.closeAssertCondition(1);
            //indent--;
            ut.decIndent();
            gc.setExitFunction();
        }

    }

    public void getFiCondition(janusParser.IfConstructorContext ctx){
        if(numfaj < 1) {//fork and join
            //pass if condition context
            r.condition(ctx.fiExpression().condition());
        }
    }


    public void enterLocalParamDeclare(janusParser.LocalParamDeclareContext ctx){
        if(numfaj < 1) {//fork and join
            r.LocalParamDeclare(ctx,0);
        }
    }

    public void enterAssignmentExpression(janusParser.AssignmentExpressionContext ctx){
        if (numfaj < 1) {
            r.AssignmentExpression(ctx,true); // true = forward
        }
    }


    public void enterParamDeclare(janusParser.ParamDeclareContext ctx){
        if(numfaj < 1) {//fork and join
            if (structPass) {
                r.ParamDeclare(ctx);
            }
        }
    }

    //functionCall
    public void enterFunctionCall(janusParser.FunctionCallContext ctx){
        if(numfaj < 1) {//fork and join
            if (ctx.call().getText().compareTo("call") == 0) {
                gc.setFunctionCall(ctx.tagName().getText(), 0); // 0 = call forward
            }
            else {
                gc.setFunctionCall(ctx.tagName().getText(), 1); // 0 = uncall reverse
            }
        }
    }

    public void exitFunctionCall(janusParser.FunctionCallContext ctx){
        if(numfaj < 1) {//fork and join
            gc.setArgumentsFunction(namePar);
            namePar.clear();
        }
    }

    //argumentsFunction
    public void enterArguments(janusParser.ArgumentsContext ctx){
        if(numfaj < 1) {//fork and join
            namePar.add(ctx.variableName().getText());
        }
    }

    //loop constructor
    public void enterLoopConstructor(janusParser.LoopConstructorContext ctx){
        if(numfaj < 1) {//fork and join
            gc.openAssertCondition(0);
            r.condition(ctx.condition(0));
            gc.closeAssertCondition(0);
        }
    }



    public void exitLoopConstructor(janusParser.LoopConstructorContext ctx){
        if(numfaj < 1) {//fork and join
            if (ctx.loopExp() == null) { // not loop Expression set While
                gc.openWhileDec();
                r.condition(ctx.condition(1));
                gc.closeWhileDec();
                ut.incIndent();
            }
            gc.openAssertCondition(1);
            r.condition(ctx.condition(0));
            gc.closeAssertCondition(1);

            //for do exp
            if (ctx.doExp() != null) {
                ParseTree parseTree = ctx.doExp();
                ParseTreeWalker expWalk = new ParseTreeWalker();
                expWalk.walk(this, parseTree);
            }
            ut.decIndent();
            gc.setExitFunction();
        }
    }

    //Loop expression
    public void enterLoopExp(janusParser.LoopExpContext ctx){
        if(numfaj < 1) {//fork and join
            gc.openWhileDec();
            this.getLoopCondition((janusParser.LoopConstructorContext) ctx.getParent());
            gc.closeWhileDec();
            ut.incIndent();
        }
    }

    public void getLoopCondition(janusParser.LoopConstructorContext ctx){
        if(numfaj < 1) {//fork and join
            //pass loop condition context
            r.condition(ctx.condition(1));
        }
    }

    //print
    public void enterPrint(janusParser.PrintContext ctx){
        if(numfaj < 1) {//fork and join
            r.janusPrint(ctx);
        }
    }

    public void enterMsgpass(janusParser.MsgpassContext ctx){
        if(numfaj < 1){//fork and join
            if(ctx.tagName() != null){
                if(ut.getThreadArg()){//arg to thread
                    if(ut.getTypeMsg() == 0){ // 0 = message passing local struct

                        gc.setMsgpass(ctx.typemsg().getText(), ctx.tagName().getText()+ "." + ctx.value().getText(), ctx.port().getText());
                    }
                    else{ //type_msg_memory = 1 = shared memory
                        gc.setMsgpass(ctx.typemsg().getText(), "((struct "+ ctx.tagName().getText()+"*)arg)->" + ctx.value().getText(), ctx.port().getText());
                    }
                }
                else{ // if not a thread
                    gc.setMsgpass(ctx.typemsg().getText(), ctx.tagName().getText() + "->" + ctx.value().getText(), ctx.port().getText());
                }
            }
            else {
                gc.setMsgpass(ctx.typemsg().getText(), ctx.variableName().getText(), ctx.port().getText());
            }
        }
    }



    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){

        countforkandjoin += 2;
        numfaj ++;

        if(numfaj <= 1) {//fork and join
            if(ctx.tagName() != null) {
                if(nidfork > 1){//this for pass an struct address to thread
                    gc.setforkandjoin("&"+ctx.variableName().getText(),countforkandjoin + nidfork, 0); // flag 0 = forward
                }
                else {
                    gc.setforkandjoin(ctx.variableName().getText(),countforkandjoin + nidfork, 0); // flag 0 = forward
                }
            }
            else{
                gc.setforkandjoin("NULL", countforkandjoin + nidfork, 0); // flag 0 = forward
            }
        }
    }

    public void exitForkandjoin(janusParser.ForkandjoinContext ctx){

        numfaj--;
    }


    public void enterPortDeclare(janusParser.PortDeclareContext ctx){
        gc.setInitPort(ctx.port().getText());
    }

    public void enterLocalPortDeclare(janusParser.LocalPortDeclareContext ctx){
        gc.setInitPort(ctx.port().getText());
    }

    public void enterStruct(janusParser.StructContext ctx){
        structPass = false;
    }

    public void exitStruct(janusParser.StructContext ctx){
        structPass = true;
    }

    public void enterStructInit(janusParser.StructInitContext ctx){
        structPass = false;
        gc.initStruct(ctx.tagName().getText(),ctx.structName().getText());
    }

    public void exitStructInit(janusParser.StructInitContext ctx){
        structPass = true;
    }

}
