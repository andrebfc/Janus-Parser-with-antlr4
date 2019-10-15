import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

public class janusWriteF extends janusBaseListener {

    genereteCode gc;
    List<String> typePar = new ArrayList<String>();
    List<String> namePar = new ArrayList<String>();

    List<Integer> argsTh = new ArrayList<>();

    //Parse for fork and join count
    ParseTreeWalker walker = new ParseTreeWalker();
    ParseTree parseTree;


    int indent = 0;
    static int countforkandjoin = 0;
    int nidfork = 0;
    int depth = 0;
    int type_msg_memory = 0;
    int dec_struct_mp = 1; // struct declare for message passing local memory
    boolean structPass = true;
    static int numfaj = 0;
    boolean threadArg = false;
    int join = 0; //0 = write pthread_join

    //constructor
    janusWriteF(genereteCode genCode, int ind, int tmm, int j){
        this.gc = genCode;
        this.indent = ind;
        this.type_msg_memory = tmm;
        this.join = j;
        //reset count fork and join
        countforkandjoin = 0;
    }

    //constructor
    janusWriteF(genereteCode genCode, int ind, int nf, int d, boolean ta, int tmm){
        this.gc = genCode;
        this.indent = ind;
        this.nidfork = nf;
        this.depth = d;
        this.threadArg = ta; // for struct argument to thread
        this.type_msg_memory = tmm;
    }


    //mainFunction
    public void enterMainFun(janusParser.MainFunContext ctx){
        gc.declareFunction("main",2);
        indent++;
    }

    public void exitMainFun(janusParser.MainFunContext ctx){
        indent--;
        gc.setExitFunction(indent);
    }


    //function
    public void enterFunction(janusParser.FunctionContext ctx){
        if(numfaj < 1) { //fork and join
            gc.declareFunction(ctx.functionDeclaration().tagName().getText(), 0);// 0 = forward
            indent++;
        }

    }

    public void exitFunction(janusParser.FunctionContext ctx){
        if(numfaj < 1) {//fork and join
            //if(join == 1) {
                //parseTree = ctx;
                //threadJoin tj = new threadJoin();
                //walker.walk(tj, parseTree);
                //int count = tj.getForkCount();
                //gc.setJoinThread(indent,count);
            //}
            indent--;
            gc.setExitFunction(indent);
            gc.setBlankLine();
        }
    }


    public void exitFunctions(janusParser.FunctionsContext ctx){

    }

    //parametersDeclaration function
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
                    gc.setParamsDeclFunc(typePar, namePar, 0); // flag 0 = '&' // cambio a 1 per passaggio riferimento in c
                } else {
                    gc.setParamsDeclFunc(typePar, namePar, 0); // flag 1 = '*'
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
                gc.setExitFunction(indent);
            }

        }
    }

    //ifExpression
    public void enterIfExpression(janusParser.IfExpressionContext ctx){
        if(numfaj < 1) {
            if (ctx.condition() != null) {
                gc.openIfDec(indent);
                this.condition(ctx.condition());
                gc.closeIfDec();

                indent++;
            }
        }
    }

    public void exitIfExpression(janusParser.IfExpressionContext ctx){
        if(numfaj < 1) {
            gc.openAssertCondition(0, indent); // 0 = real condition
            this.getFiCondition((janusParser.IfConstructorContext) ctx.getParent());
            gc.closeAssertCondition(0);
            indent--;
        }
    }


    //elseExpression
    public void enterElseExpression(janusParser.ElseExpressionContext ctx){
        if(numfaj < 1) {
            gc.setElse(indent);
            indent++;
        }
    }

    public void exitElseExpression(janusParser.ElseExpressionContext ctx){
        if(numfaj < 1) {
            gc.openAssertCondition(1, indent); // 1 = neg
            this.getFiCondition((janusParser.IfConstructorContext) ctx.getParent());
            gc.closeAssertCondition(1);
            indent--;
            gc.setExitFunction(indent);
        }

    }

    public void getFiCondition(janusParser.IfConstructorContext ctx){
        if(numfaj < 1) {//fork and join
            //pass if condition context
            this.condition(ctx.fiExpression().condition());
        }
    }

    //block
    /*
    public void enterBlock(janusParser.BlockContext ctx){
        if(numfaj < 1) {//fork and join
                if (ctx.localParamDeclare() != null) {
                    if (ctx.localParamDeclare().value() != null) {
                        if (ctx.localParamDeclare().local().getText().compareTo("local") == 0) {
                            if (ctx.localParamDeclare().array() != null) {

                                gc.setParamDeclare(ctx.localParamDeclare().type().getText(), ctx.localParamDeclare().variableName().getText(), ctx.localParamDeclare().value().getText(), indent, 1);//set array
                            } else {
                                gc.setParamDeclare(ctx.localParamDeclare().type().getText(), ctx.localParamDeclare().variableName().getText(), ctx.localParamDeclare().value().getText(), indent, 0);

                            }
                        } else {//delocal => assert
                            gc.openAssertCondition(0, indent);
                            //gc.setGeneralCondition(ctx.localParamDeclare().variableName().getText(), ctx.localParamDeclare().assignmentOperator().getText(), ctx.localParamDeclare().value().getText());//on janus.g4 chang asssignmentoOperetator to opcondition
                            gc.setGeneralCondition(ctx.localParamDeclare().variableName().getText(), ctx.localParamDeclare().opcondition().getText(), ctx.localParamDeclare().value().getText());//for delocal, is a condition assert
                            gc.closeAssertCondition(0);
                        }
                    } else {
                        if (ctx.localParamDeclare().array() != null) {
                            gc.setParamDeclare(ctx.localParamDeclare().type().getText(), ctx.localParamDeclare().variableName().getText(), "0", indent, 1);//set array
                        } else {
                            if (ctx.localParamDeclare().local().getText().compareTo("local") == 0) {
                                gc.setParamDeclare(ctx.localParamDeclare().type().getText(), ctx.localParamDeclare().variableName().getText(), "0", indent, 0);
                            } else {
                                gc.openAssertCondition(0, indent);
                                gc.setGeneralCondition(ctx.localParamDeclare().variableName().getText(), " = ", "0");
                                gc.closeAssertCondition(0);
                            }

                        }
                    }
                }

                if (ctx.assignmentExpression() != null) {
                    gc.setAssignmentExpression(ctx.assignmentExpression().value(0).getText(), ctx.assignmentExpression().assignmentOperator().getText(), ctx.assignmentExpression().value(1).getText(), 0, indent); //0 = forward
                }
        }
    }
    */
    /* NEW TEST*/
    public void enterLocalParamDeclare(janusParser.LocalParamDeclareContext ctx){
        if(numfaj < 1) {//fork and join
            //if (ctx.localParamDeclare() != null) {
                if (ctx.value() != null) { // if rvalue not null
                    if (ctx.local().getText().compareTo("local") == 0) { // if local
                        if (ctx.array() != null) { // if is array

                            gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), ctx.value().getText(), indent, 1);//set array
                        }
                        else if(ctx.value().tagName() != null){ // if is struct value
                            if(threadArg && type_msg_memory == 0){ // message passing memory
                                gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(),ctx.value().tagName().getText()+"."+ctx.value().value(0).getText(), indent, 0);
                            }
                            else if(threadArg && type_msg_memory == 1){ // shared memory
                                gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(),"((struct " + ctx.value().tagName().getText()+"*)arg)->"+ctx.value().value(0).getText(), indent, 0);

                            }
                        }
                        else {

                            gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), ctx.value().getText(), indent, 0);

                        }
                    } else {//delocal => assert
                        gc.openAssertCondition(0, indent);
                        //gc.setGeneralCondition(ctx.localParamDeclare().variableName().getText(), ctx.localParamDeclare().assignmentOperator().getText(), ctx.localParamDeclare().value().getText());//on janus.g4 chang asssignmentoOperetator to opcondition
                        if(ctx.value().tagName() != null) { // if is struct value
                            if (threadArg && type_msg_memory == 0) {
                                gc.setGeneralCondition(ctx.variableName().getText(), ctx.opcondition().getText(), ctx.value().tagName().getText() + "." + ctx.value().value(0).getText());//for delocal, is a condition assert
                            } else if (threadArg && type_msg_memory == 1) {
                                gc.setGeneralCondition(ctx.variableName().getText(), ctx.opcondition().getText(), "((struct " + ctx.value().tagName().getText() + "*)arg)->" + ctx.value().value(0).getText());//for delocal, is a condition assert

                            }
                        }
                        else{
                            gc.setGeneralCondition(ctx.variableName().getText(), ctx.opcondition().getText(), ctx.value().getText());//for delocal, is a condition assert

                        }
                        //gc.setGeneralCondition(ctx.variableName().getText(), ctx.opcondition().getText(), ctx.value().getText());//for delocal, is a condition assert
                        gc.closeAssertCondition(0);
                    }
                } else {
                    if (ctx.array() != null) {
                        gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), "0", indent, 1);//set array
                    } else {
                        if (ctx.local().getText().compareTo("local") == 0) {
                            gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), "0", indent, 0);
                        } else {
                            gc.openAssertCondition(0, indent);
                            gc.setGeneralCondition(ctx.variableName().getText(), " = ", "0");
                            gc.closeAssertCondition(0);
                        }

                    }
                }
            //}


        }
    }

    public void enterAssignmentExpression(janusParser.AssignmentExpressionContext ctx){
        if (numfaj < 1) {
            /*
            if(ctx.tagName() != null){
                //for struct notation, namestruct->value
                if(threadArg){//arg to thread
                    if(type_msg_memory == 0) { // 0 = message passing local struct
                        gc.setAssignmentExpression(ctx.tagName().getText()+"." + ctx.value(0).getText(),ctx.assignmentOperator().getText(),ctx.value(1).getText(),0,indent);//0=forwar
                    }
                    else{//type_msg_memory = 1 = shared memory
                        gc.setAssignmentExpression("((struct "+ ctx.tagName().getText()+"*)arg)->" + ctx.value(0).getText(),ctx.assignmentOperator().getText(),ctx.value(1).getText(),0,indent);//0=forwar
                    }
                }
                else {//tag for function
                    gc.setAssignmentExpression(ctx.tagName().getText() + "->" + ctx.value(0).getText(), ctx.assignmentOperator().getText(), ctx.value(1).getText(), 0, indent);//0=forward

                }
            }
            else {
                gc.setAssignmentExpression(ctx.value(0).getText(), ctx.assignmentOperator().getText(), ctx.value(1).getText(), 0, indent); //0 = forward
            }
            */
        //new version
            if(ctx.value(0).tagName() != null || ctx.value(1).tagName() != null){
                String lvalue;
                String rvalue;
                if(threadArg && type_msg_memory == 0){//arg to thread, 0 = message passing local struct
                    if(ctx.value(0).tagName() != null){
                        lvalue = ctx.value(0).tagName().getText() + "." + ctx.value(0).value(0).getText();
                    }
                    else{
                        lvalue = ctx.value(0).getText();
                    }
                    if(ctx.value(1).tagName() != null){
                        rvalue = ctx.value(1).tagName().getText() + "." + ctx.value(1).value(0).getText();
                    }
                    else{
                        rvalue = ctx.value(1).getText();
                    }
                    gc.setAssignmentExpression(lvalue,ctx.assignmentOperator().getText(),rvalue,0,indent);//0=forward
                }
                else if(threadArg && type_msg_memory == 1){//arg to thread, 1 = message passing shared struct
                    if(ctx.value(0).tagName() != null){
                        lvalue = "((struct " + ctx.value(0).tagName().getText() + "*)arg)->"  + ctx.value(0).value(0).getText();
                    }
                    else{
                        lvalue = ctx.value(0).getText();
                    }
                    if(ctx.value(1).tagName() != null){
                        rvalue = "((struct " + ctx.value(1).tagName().getText() + "*)arg)->" + ctx.value(1).value(0).getText();
                    }
                    else{
                        rvalue = ctx.value(1).getText();
                    }
                    gc.setAssignmentExpression(lvalue,ctx.assignmentOperator().getText(),rvalue,0,indent);//0=forward
                }
                else {//tag for function
                    if(ctx.value(0).tagName() != null){
                        lvalue = ctx.value(0).tagName().getText() + "->" + ctx.value(0).value(0).getText();
                    }
                    else{
                        lvalue = ctx.value(0).getText();
                    }
                    if(ctx.value(1).tagName() != null){
                        rvalue = ctx.value(1).tagName().getText() + "->" + ctx.value(1).value(0).getText();
                    }
                    else{
                        rvalue = ctx.value(1).getText();
                    }
                    gc.setAssignmentExpression(lvalue,ctx.assignmentOperator().getText(),rvalue,0,indent);//0=forward

                }
            }
            else {
                gc.setAssignmentExpression(ctx.value(0).getText(), ctx.assignmentOperator().getText(), ctx.value(1).getText(), 0, indent); //0 = forward
            }

        }
    }


    /*END TEST*/

    public void enterParamDeclare(janusParser.ParamDeclareContext ctx){
        if(numfaj < 1) {//fork and join
            if (structPass) {
                if (ctx.value() != null) {
                    if (ctx.array() != null) {
                        gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), ctx.value().getText(), indent, 1);//1=set array{}
                    }
                    else if(ctx.value().tagName() != null) { // if is value of struct
                        if (threadArg && type_msg_memory == 0) {
                            gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(),ctx.value().tagName().getText()+"."+ctx.value().value(0).getText(),indent,0);
                        }
                        else if(threadArg &&type_msg_memory == 1){
                            gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(),"((struct " + ctx.value().tagName().getText()+"*)arg)->"+ctx.value().value(0).getText(), indent, 0);
                        }
                    }
                    else {
                        gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), ctx.value().getText(), indent, 0);//0 = no array
                    }
                } else {
                    if (ctx.array() != null) {
                        gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), "0", indent, 1);
                    } else {
                        gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), "0", indent, 0);
                    }
                }
            }
        }
    }

    //functionCall
    public void enterFunctionCall(janusParser.FunctionCallContext ctx){
        if(numfaj < 1) {//fork and join
            if (ctx.call().getText().compareTo("call") == 0) {
                gc.setFunctionCall(ctx.tagName().getText(), 0, indent); // 0 = call forward
            }
            else {
                gc.setFunctionCall(ctx.tagName().getText(), 1, indent); // 0 = uncall reverse
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
            gc.openAssertCondition(0, indent);
            condition(ctx.condition(0));
            gc.closeAssertCondition(0);
        }
    }



    public void exitLoopConstructor(janusParser.LoopConstructorContext ctx){
        if(numfaj < 1) {//fork and join
            if (ctx.loopExp() == null) { // not loop Expression set While
                gc.openWhileDec(indent);
                this.condition(ctx.condition(1));
                gc.closeWhileDec();
                indent++;
            }

            gc.openAssertCondition(1, indent);
            this.condition(ctx.condition(0));
            gc.closeAssertCondition(1);

            //for do exp
            if (ctx.doExp() != null) {
                ParseTree parseTree = ctx.doExp();
                ParseTreeWalker expWalk = new ParseTreeWalker();
                expWalk.walk(this, parseTree);
            }
            indent--;
            gc.setExitFunction(indent);
        }
    }

    //Loop expression
    public void enterLoopExp(janusParser.LoopExpContext ctx){
        if(numfaj < 1) {//fork and join
            gc.openWhileDec(indent);
            this.getLoopCondition((janusParser.LoopConstructorContext) ctx.getParent());
            gc.closeWhileDec();
            indent++;
        }
    }

    public void getLoopCondition(janusParser.LoopConstructorContext ctx){
        if(numfaj < 1) {//fork and join
            //pass loop condition context
            this.condition(ctx.condition(1));
        }
    }

    //print
    public void enterPrint(janusParser.PrintContext ctx){
        if(numfaj < 1) {//fork and join
            if(ctx.tagName()!=null){
                if(threadArg){//arg to thread
                    if(type_msg_memory == 0) { // 0 = message passing local struct
                        gc.setPrint(ctx.tagName().getText() + "." + ctx.value().getText(),indent);
                    }
                    else {//type_msg_memory = 1 = shared memory
                        gc.setPrint("((struct " + ctx.tagName().getText() + "*)arg)->" + ctx.value().getText(), indent);
                    }
                }
                else {
                    gc.setPrint(ctx.tagName().getText() + "->" + ctx.value().getText(), indent);
                }
            }
            else {
                gc.setPrint(ctx.value().getText(), indent);
            }
        }
    }

    public void enterMsgpass(janusParser.MsgpassContext ctx){
        if(numfaj < 1){//fork and join
            if(ctx.tagName() != null){
                if(threadArg){//arg to thread
                    //gc.setPrint("((struct "+ ctx.tagName().getText()+"*)arg)->" + ctx.value().getText(),indent);
                    if(type_msg_memory == 0){ // 0 = message passing local struct

                        gc.setMsgpass(ctx.typemsg().getText(), ctx.tagName().getText()+ "." + ctx.value().getText(), ctx.port().getText(), indent);
                    }
                    else{ //type_msg_memory = 1 = shared memory
                        gc.setMsgpass(ctx.typemsg().getText(), "((struct "+ ctx.tagName().getText()+"*)arg)->" + ctx.value().getText(), ctx.port().getText(), indent);
                    }

                }
                else{ // if not a thread
                    gc.setMsgpass(ctx.typemsg().getText(), ctx.tagName().getText() + "->" + ctx.value().getText(), ctx.port().getText(), indent);
                }
            }
            else {
                gc.setMsgpass(ctx.typemsg().getText(), ctx.variableName().getText(), ctx.port().getText(), indent);
            }
        }
    }



    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){

        countforkandjoin += 2;
        numfaj ++;
        //nidfork += 2;

        //System.out.println("countforkandjoin + nidfork: " + (countforkandjoin + nidfork));
        if(numfaj <= 1) {//fork and join
            if(ctx.tagName() != null) {
                if(nidfork > 1){//this for pass an struct address to thread
                    gc.setforkandjoin("&"+ctx.tagName().getText(),indent,countforkandjoin + nidfork, 0); // flag 0 = forward
                }
                else {
                    gc.setforkandjoin(ctx.tagName().getText(), indent, countforkandjoin + nidfork, 0); // flag 0 = forward
                }
            }
            else{
                gc.setforkandjoin("NULL",indent, countforkandjoin + nidfork, 0); // flag 0 = forward
            }
            // write pthread_join()
            if(join == 0){
                gc.setJoinThread(indent,countforkandjoin);
            }
        }
        /* old janusWriterTest
        if(depth == ctx.depth()) {
            gc.setforkandjoin(indent, countforkandjoin + nidfork);
        }
        */
    }

    public void exitForkandjoin(janusParser.ForkandjoinContext ctx){

        numfaj--;
        //countforkandjoin -= 2;
        //System.out.println("count fork and join: " + countforkandjoin);
        //if(numfaj <= 1) {
            //gc.setJoinThread(indent,countforkandjoin + nidfork);
        //}
    }



    public void enterPortDeclare(janusParser.PortDeclareContext ctx){
        gc.setInitPort(ctx.port().getText(),indent);
    }

    public void condition(janusParser.ConditionContext ctx) {
        if (numfaj < 1) {//fork and join
            if (ctx.logicalExpression() == null) {
                if(ctx.value(0).tagName() != null || ctx.value(1).tagName() != null){
                    String lvalue;
                    String rvalue;
                    if(threadArg && type_msg_memory == 0){//arg to thread, 0 = message passing local struct
                        if(ctx.value(0).tagName() != null){
                            lvalue = ctx.value(0).tagName().getText() + "." + ctx.value(0).value(0).getText();
                        }
                        else{
                            lvalue = ctx.value(0).getText();
                        }
                        if(ctx.value(1).tagName() != null){
                            rvalue = ctx.value(1).tagName().getText() + "." + ctx.value(1).value(0).getText();
                        }
                        else{
                            rvalue = ctx.value(1).getText();
                        }
                        gc.setGeneralCondition(lvalue, ctx.opcondition().getText(),rvalue);

                    }
                    else if(threadArg && type_msg_memory == 1){//arg to thread, 1 = message passing shared struct
                        if(ctx.value(0).tagName() != null){
                            lvalue = "((struct " + ctx.value(0).tagName().getText() + "*)arg)->"  + ctx.value(0).value(0).getText();
                        }
                        else{
                            lvalue = ctx.value(0).getText();
                        }
                        if(ctx.value(1).tagName() != null){
                            rvalue = "((struct " + ctx.value(1).tagName().getText() + "*)arg)->" + ctx.value(1).value(0).getText();
                        }
                        else{
                            rvalue = ctx.value(1).getText();
                        }
                        gc.setGeneralCondition(lvalue, ctx.opcondition().getText(),rvalue);
                    }
                    else {//tag for function
                        if(ctx.value(0).tagName() != null){
                            lvalue = ctx.value(0).tagName().getText() + "->" + ctx.value(0).value(0).getText();
                        }
                        else{
                            lvalue = ctx.value(0).getText();
                        }
                        if(ctx.value(1).tagName() != null){
                            rvalue = ctx.value(1).tagName().getText() + "->" + ctx.value(1).value(0).getText();
                        }
                        else{
                            rvalue = ctx.value(1).getText();
                        }
                        gc.setGeneralCondition(lvalue, ctx.opcondition().getText(),rvalue);

                    }
                }
                else{gc.setGeneralCondition(ctx.value(0).getText(), ctx.opcondition().getText(), ctx.value(1).getText());
                }
            } else {
                condition(ctx.condition(0));
                gc.appendStrToFile(" " + ctx.logicalExpression().getText() + " ");
                condition(ctx.condition(1));
            }
        }

    }

    public void enterStruct(janusParser.StructContext ctx){
        structPass = false;
        //init struct
        gc.initStruct(ctx.tagName().getText(),indent);
    }

    public void exitStruct(janusParser.StructContext ctx){
       structPass = true;
    }

}
