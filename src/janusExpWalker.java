import java.util.ArrayList;
import java.util.List;

public class janusExpWalker extends janusBaseListener {

    genereteCode gc;
    List<String> namePar = new ArrayList<String>();
    int indent;
    boolean structPass = true;
    boolean threadArg = false;

    //constructor
    janusExpWalker(genereteCode genCode, int ind){
        this.gc = genCode;
        this.indent = ind;
    }

    //constructor for argument struct thread
    janusExpWalker(genereteCode genCode, int ind,boolean ta){
        this.gc = genCode;
        this.indent = ind;
        this.threadArg = ta;
    }

    //Param Declare
    public void enterParamDeclare(janusParser.ParamDeclareContext ctx) {
        if (structPass) {
            if (ctx.value() != null) {
                if (ctx.array() != null) {
                    gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), ctx.value().getText(), indent, 1);
                } else {
                    gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), ctx.value().getText(), indent, 0);
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

    //Local Param Declare
    public void enterLocalParamDeclare(janusParser.LocalParamDeclareContext ctx){
        if(ctx.value() != null) {
            if (ctx.local().getText().compareTo("delocal") == 0) {
                if(ctx.array() != null) {
                    gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), ctx.value().getText(), indent,1);
                }
                else{
                    gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), ctx.value().getText(), indent,0);
                }
            }
            else{//local => assert
                //gc.setAssertCondition(ctx.variableName().getText(),ctx.assignmentOperator().getText(),ctx.value().getText(),0,indent);//on janus.g4 chang asssignmentoOperetator to opcondition
                gc.setAssertCondition(ctx.variableName().getText(),ctx.opcondition().getText(),ctx.value().getText(),0,indent);//for delocal, is a condition assert
            }
        }
        else{
            if(ctx.array() != null) {
                gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), "0", indent, 1);
            }
            else{
                if (ctx.local().getText().compareTo("delocal") == 0) {
                    gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), "0", indent, 0);
                }
                else{
                    gc.setAssertCondition(ctx.variableName().getText(),"=","0",0,indent);
                }

            }
        }
    }

    //Assignment Expression
    public void enterAssignmentExpression(janusParser.AssignmentExpressionContext ctx){
        if(ctx.tagName() != null){
            //for struct notation, namestruct->value
            if(threadArg){//arg to thread
                gc.setAssignmentExpression("((struct "+ ctx.tagName().getText()+"*)arg)->" + ctx.value(0).getText(),ctx.assignmentOperator().getText(),ctx.value(1).getText(),1,indent);//1 = reverse
            }
            else{
                gc.setAssignmentExpression(ctx.tagName().getText() + "->" + ctx.value(0).getText(), ctx.assignmentOperator().getText(), ctx.value(1).getText(), 1, indent);//1 = reverse
            }
        }
        else {
            gc.setAssignmentExpression(ctx.value(0).getText(), ctx.assignmentOperator().getText(), ctx.value(1).getText(), 1, indent); // 1 = reverse
        }
    }


    //functionCall
    public void enterFunctionCall(janusParser.FunctionCallContext ctx){

        if(ctx != null){
            if(ctx.call().getText().compareTo("call") == 0) {
                gc.setFunctionCall(ctx.tagName().getText(), 1, indent); // 0 = call reverse
            }
            else {
                gc.setFunctionCall(ctx.tagName().getText(), 0, indent); // 0 = uncall forward
            }
        }
    }

    public void exitFunctionCall(janusParser.FunctionCallContext ctx){
        gc.setArgumentsFunction(namePar);
        namePar.clear();
    }

    //argumentsFunction
    public void enterArguments(janusParser.ArgumentsContext ctx){
        if(ctx != null){
            namePar.add(ctx.variableName().getText());
        }
    }

    public void enterPrint(janusParser.PrintContext ctx){
        if(ctx.tagName()!=null){
            if(threadArg){//arg to thread
                gc.setPrint("((struct "+ ctx.tagName().getText()+"*)arg)->" + ctx.value().getText(),indent);
            }
            else {
                gc.setPrint(ctx.tagName().getText() + "->" + ctx.value().getText(), indent);
            }
        }
        else {
            gc.setPrint(ctx.value().getText(), indent);
        }
    }

    public void enterMsgpass(janusParser.MsgpassContext ctx){
        String type = "";

        if(ctx.typemsg().getText().compareTo("ssend") == 0){
            //gc.setMsgpass("srcv",ctx.variableName().getText(),ctx.port().getText(),indent);
            type = "srcv";
        }
        else if(ctx.typemsg().getText().compareTo("srcv") == 0){
            //gc.setMsgpass("ssend",ctx.variableName().getText(),ctx.port().getText(),indent);
            type = "ssend";
        }
        else if(ctx.typemsg().getText().compareTo("asend") == 0){
            //gc.setMsgpass("arcv",ctx.variableName().getText(),ctx.port().getText(),indent);
            type = "asend";
        }
        else if(ctx.typemsg().getText().compareTo("arcv") == 0){
            //gc.setMsgpass("asend",ctx.variableName().getText(),ctx.port().getText(),indent);
            type = "arcv";
        }


        if(ctx.tagName() != null){
            if(threadArg){//arg to thread
                //gc.setPrint("((struct "+ ctx.tagName().getText()+"*)arg)->" + ctx.value().getText(),indent);
                gc.setMsgpass(type, "((struct "+ ctx.tagName().getText()+"*)arg)->" + ctx.value().getText(), ctx.port().getText(), indent);
            }
            else{ // if not a thread
                gc.setMsgpass(type, ctx.tagName().getText() + "->" + ctx.value().getText(), ctx.port().getText(), indent);
            }
        }
        else {
            gc.setMsgpass(type, ctx.variableName().getText(), ctx.port().getText(), indent);
        }

    }

    public void enterStruct(janusParser.StructContext ctx){
        structPass = false;

    }

    public void exitStruct(janusParser.StructContext ctx){
        structPass = true;

    }

}
