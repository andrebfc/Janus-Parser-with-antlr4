import java.util.ArrayList;
import java.util.List;

public class janusExpWalker extends janusBaseListener {


    List<String> namePar = new ArrayList<String>();
    boolean structPass = true;

    genereteCode gc;
    utility ut;
    janusRules r;

    //constructor
    janusExpWalker(genereteCode genCode, utility u){
        this.gc = genCode;
        this.ut = u;

        r = new janusRules(gc,ut);
    }


    //Param Declare
    public void enterParamDeclare(janusParser.ParamDeclareContext ctx) {
        if (structPass) {
            r.ParamDeclare(ctx);
        }
    }

    //Local Param Declare
    public void enterLocalParamDeclare(janusParser.LocalParamDeclareContext ctx){
        r.LocalParamDeclare(ctx,1);
    }

    //Assignment Expression
    public void enterAssignmentExpression(janusParser.AssignmentExpressionContext ctx){

        r.AssignmentExpression(ctx,false); // false = reverse

    }



    //functionCall
    public void enterFunctionCall(janusParser.FunctionCallContext ctx){

        if(ctx != null){
            if(ctx.call().getText().compareTo("call") == 0) {
                gc.setFunctionCall(ctx.tagName().getText(), 1); // 0 = call reverse
            }
            else {
                gc.setFunctionCall(ctx.tagName().getText(), 0); // 0 = uncall forward
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
        r.janusPrint(ctx);
    }

    public void enterMsgpass(janusParser.MsgpassContext ctx){
        String type = "";

        if(ctx.typemsg().getText().compareTo("ssend") == 0){
            type = "srcv";
        }
        else if(ctx.typemsg().getText().compareTo("srcv") == 0){
            type = "ssend";
        }
        else if(ctx.typemsg().getText().compareTo("asend") == 0){
            type = "arcv";
        }
        else if(ctx.typemsg().getText().compareTo("arcv") == 0){
            type = "asend";
        }

        if(ctx.tagName() != null){
            if(ut.getThreadArg()){//arg to thread
                if(ut.getTypeMsg() == 0) { // 0 = message passing local struct
                    gc.setMsgpass(type, ctx.tagName().getText()+"." + ctx.value().getText(), ctx.port().getText());
                }
                else{// type_msg_memory = 1 => shared memory
                    gc.setMsgpass(type, "((struct "+ ctx.tagName().getText()+"*)arg)->" + ctx.value().getText(), ctx.port().getText());
                }
            }
            else{ // if not a thread
                gc.setMsgpass(type, ctx.tagName().getText() + "->" + ctx.value().getText(), ctx.port().getText());
            }
        }
        else {
            gc.setMsgpass(type, ctx.variableName().getText(), ctx.port().getText());
        }

    }

    public void enterStruct(janusParser.StructContext ctx){
        structPass = false;

    }

    public void exitStruct(janusParser.StructContext ctx){
        structPass = true;

    }

}
