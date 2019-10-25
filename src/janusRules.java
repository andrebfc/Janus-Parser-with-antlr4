// common rules for forward and reverse
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class janusRules extends janusBaseListener{
    genereteCode gc;
    utility ut;

    janusRules(genereteCode g, utility u){
        this.gc = g;
        this.ut = u;
    }

    public void LocalParamDeclare(janusParser.LocalParamDeclareContext ctx, int flag){ // flag = forward/reverse
        String locdeloc;
        //set string local or delocal
        if(flag == 0){//forward
            locdeloc = "local";
        }
        else{
            locdeloc = "delocal";
        }

        if (ctx.value() != null) { // if rvalue not null
            if (ctx.local().getText().compareTo(locdeloc) == 0) { // if local

                if (ctx.array() != null) { // if is array
                    gc.setArray(ctx.type().getText(), ctx.variableName().getText(), ctx.array().value().getText(), ctx.value().getText());
                }
                else if(ctx.value().tagName() != null){ // if is struct value
                    if(ut.getThreadArg() && ut.getTypeMsg() == 0){ // message passing memory
                        gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(),ctx.value().tagName().getText()+"."+ctx.value().value(0).getText(),0);
                    }
                    else if(ut.getThreadArg() && ut.getTypeMsg() == 1){ // shared memory
                        gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(),"((struct " + ctx.value().tagName().getText()+"*)arg)->"+ctx.value().value(0).getText(), 0);
                    }
                }
                else {
                    gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), ctx.value().getText(), 0);
                }
            } else {//delocal => assert
                gc.openAssertCondition(0);
                if(ctx.value().tagName() != null) { // if is struct value
                    if (ut.getThreadArg() && ut.getTypeMsg() == 0) {
                        gc.setGeneralCondition(ctx.variableName().getText(), ctx.opcondition().getText(), ctx.value().tagName().getText() + "." + ctx.value().value(0).getText());//for delocal, is a condition assert
                    } else if (ut.getThreadArg() && ut.getTypeMsg() == 1) {
                        gc.setGeneralCondition(ctx.variableName().getText(), ctx.opcondition().getText(), "((struct " + ctx.value().tagName().getText() + "*)arg)->" + ctx.value().value(0).getText());//for delocal, is a condition assert

                    }
                }
                else{
                    gc.setGeneralCondition(ctx.variableName().getText(), ctx.opcondition().getText(), ctx.value().getText());//for delocal, is a condition assert

                }
                gc.closeAssertCondition(0);
            }
        } else {
            if (ctx.array() != null) {
                gc.setArray(ctx.type().getText(), ctx.variableName().getText(), ctx.array().value().getText(), "0");
            } else {
                if (ctx.local().getText().compareTo(locdeloc) == 0) {
                    gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), "0", 0);
                } else {
                    gc.openAssertCondition(0);
                    gc.setGeneralCondition(ctx.variableName().getText(), " = ", "0");
                    gc.closeAssertCondition(0);
                }

            }
        }

    }


    public void ParamDeclare(janusParser.ParamDeclareContext ctx){
        if (ctx.value() != null) {
            if (ctx.array() != null) { //if is array
                gc.setArray(ctx.type().getText(), ctx.variableName().getText(), ctx.array().value().getText(), ctx.value().getText());
            }
            else if(ctx.value().tagName() != null) { // if is value of struct
                if (ut.getThreadArg() && ut.getTypeMsg() == 0) {
                    gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(),ctx.value().tagName().getText()+"."+ctx.value().value(0).getText(), 0);
                }
                else if(ut.getThreadArg() && ut.getTypeMsg() == 1){
                    gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(),"((struct " + ctx.value().tagName().getText()+"*)arg)->"+ctx.value().value(0).getText(), 0);
                }
            }
            else {
                gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), ctx.value().getText(), 0);//0 = no array
            }
        } else {
            if (ctx.array() != null) {//if is array

                gc.setArray(ctx.type().getText(), ctx.variableName().getText(), ctx.array().value().getText(), "0");
            } else {
                gc.setParamDeclare(ctx.type().getText(), ctx.variableName().getText(), "0", 0);
            }
        }
    }


    public void AssignmentExpression(janusParser.AssignmentExpressionContext ctx, boolean fr){ // fr is forward/revers, forward = true, reverse = false
        if(ctx.value(0).tagName() != null || ctx.value(1).tagName() != null){
            String lvalue;
            String rvalue;
            if(ut.getThreadArg() && ut.getTypeMsg() == 0){//arg to thread, 0 = message passing local struct
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

                if(fr) { // if forward
                    gc.setAssignmentExpression(lvalue, ctx.assignmentOperator().getText(), rvalue, 0);// 0 = forward
                }
                else{ // if reverse
                    gc.setAssignmentExpression(lvalue, ctx.assignmentOperator().getText(), rvalue, 1);// 1 = reverse
                }
            }
            else if(ut.getThreadArg() && ut.getTypeMsg() == 1){//arg to thread, 1 = message passing shared struct
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
                if(fr){ // if forward
                    gc.setAssignmentExpression(lvalue,ctx.assignmentOperator().getText(),rvalue,0);// 0 = forward
                }
                else{ // if reverse
                    gc.setAssignmentExpression(lvalue, ctx.assignmentOperator().getText(), rvalue, 1);// 1 = reverse
                }

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
                if(fr) {// if forward
                    gc.setAssignmentExpression(lvalue, ctx.assignmentOperator().getText(), rvalue, 0);// 0 = forward
                }
                else{// if reverse
                    gc.setAssignmentExpression(lvalue,ctx.assignmentOperator().getText(),rvalue,1);// 1 = reverse
                }
            }
        }
        else {
            if(fr) {// if forward
                gc.setAssignmentExpression(ctx.value(0).getText(), ctx.assignmentOperator().getText(), ctx.value(1).getText(), 0); // 0 = forward
            }
            else{// if reverse
                gc.setAssignmentExpression(ctx.value(0).getText(), ctx.assignmentOperator().getText(), ctx.value(1).getText(), 1); // 1 = reverse
            }
        }
    }



    public void janusPrint(janusParser.PrintContext ctx){
        if(ctx.tagName()!=null){
            if(ut.getThreadArg()){//arg to thread
                if(ut.getTypeMsg() == 0) { // 0 = message passing local struct
                    gc.setPrint(ctx.tagName().getText() + "." + ctx.value().getText());
                }
                else {//type_msg_memory = 1 = shared memory
                    gc.setPrint("((struct " + ctx.tagName().getText() + "*)arg)->" + ctx.value().getText());
                }
            }
            else {
                gc.setPrint(ctx.tagName().getText() + "->" + ctx.value().getText());
            }
        }
        else {
            gc.setPrint(ctx.value().getText());
        }
    }

    public void condition(janusParser.ConditionContext ctx){
        if(ctx.logicalExpression() == null){
            if(ctx.value(0).tagName() != null || ctx.value(1).tagName() != null){
                String lvalue;
                String rvalue;
                if(ut.getThreadArg() && ut.getTypeMsg() == 0){//arg to thread, 0 = message passing local struct
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
                else if(ut.getThreadArg() && ut.getTypeMsg() == 1){//arg to thread, 1 = message passing shared struct
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
            else {
                gc.setGeneralCondition(ctx.value(0).getText(), ctx.opcondition().getText(), ctx.value(1).getText());
            }
        }
        else{
            condition(ctx.condition(0));
            gc.appendStrToFile(" " + ctx.logicalExpression().getText() + " ");
            condition(ctx.condition(1));
        }
    }


    public void getContext(ParseTree parseTree){

        ParseTreeWalker walker = new ParseTreeWalker();

        if(parseTree != null) {

            if (parseTree.getClass().getCanonicalName().compareTo("janusParser.BlockContext") == 0) {
                //two child
                getContext(parseTree.getChild(1));
                getContext(parseTree.getChild(0));
            }

            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.IfConstructorContext") == 0){ //if constructor case
                janusIfThenElseWalker jiw;
                jiw = new janusIfThenElseWalker(gc, ut);
                walker.walk(jiw,parseTree);
            }

            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.LoopConstructorContext") == 0){ // loop case
                janusLoopWalker jlW;
                jlW = new janusLoopWalker(gc, ut);
                walker.walk(jlW,parseTree);
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.ForkandjoinContext") == 0){ // fork and join
                janusForkandjoinWalker jFW = new janusForkandjoinWalker(gc, ut);
                walker.walk(jFW,parseTree);
            }

            else{
                janusExpWalker jew;
                jew = new janusExpWalker(gc, ut);
                walker.walk(jew,parseTree);
            }
        }
    }

}