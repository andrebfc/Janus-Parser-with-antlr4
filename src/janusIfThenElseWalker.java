import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class janusIfThenElseWalker extends janusBaseListener {

    genereteCode gc;
    int indent;
    private int depth = 0;
    ParseTreeWalker walker = new ParseTreeWalker();
    int type_msg_memory = 0;
    boolean threadArg = false;


    janusIfThenElseWalker(genereteCode genCode, int ind, int tmm){
        this.gc = genCode;
        this.indent = ind;
        this.type_msg_memory = tmm;
    }

    janusIfThenElseWalker(genereteCode genCode, int ind, int tmm,boolean ta){
        this.gc = genCode;
        this.indent = ind;
        this.type_msg_memory = tmm;
        this.threadArg = ta;
    }

    public void enterIfConstructor(janusParser.IfConstructorContext ctx){
        if(depth == 0){
            depth = ctx.depth();
        }
    }

    public void exitIfConstructor(janusParser.IfConstructorContext ctx){
        if(ctx.elseExpression() == null && depth == ctx.depth()){
            gc.setExitFunction(indent);

        }
    }

    //ifExpression
    public void enterIfExpression(janusParser.IfExpressionContext ctx){

        if(depth == ctx.depth() - 1) {

            gc.openIfDec(indent);
            this.getFiCondition((janusParser.IfConstructorContext) ctx.getParent()); //IfConstructor.FiExpression.Condition
            gc.closeIfDec();
            indent++;
            ParseTree parseTree;
            int childCount = ctx.block().getChildCount();
            childCount--;

            while (childCount >= 0) { // have child expression

                parseTree = ctx.block().getChild(childCount);
                getContext(parseTree);
                childCount--;
            }

        }
    }

    public void exitIfExpression(janusParser.IfExpressionContext ctx){
       if(depth == ctx.depth() - 1) {
           gc.openAssertCondition(0, indent); // 0 = real condition
           this.condition(ctx.condition());//ifExpression.condition
           gc.closeAssertCondition(0);
           indent--;
       }
    }

    public void getFiCondition(janusParser.IfConstructorContext ctx){
        //pass if condition context
        this.condition(ctx.fiExpression().condition());
    }

    //elseExpression
    public void enterElseExpression(janusParser.ElseExpressionContext ctx){
        if(depth == ctx.depth() - 1){
            gc.setElse(indent);
            indent++;
            ParseTree parseTree;
            int childCount = ctx.block().getChildCount();
            childCount--;

            while (childCount >= 0) { // have child expression

                parseTree = ctx.block().getChild(childCount);
                getContext(parseTree);
                childCount--;
            }

        }
    }

    public void exitElseExpression(janusParser.ElseExpressionContext ctx){
          if(depth == ctx.depth() - 1) {
              gc.openAssertCondition(1, indent); // 1 = neg
              this.getIfCondition((janusParser.IfConstructorContext) ctx.getParent());
              gc.closeAssertCondition(1);
              indent--;
              gc.setExitFunction(indent);
          }
    }

    public void getIfCondition(janusParser.IfConstructorContext ctx){
        //pass if condition context
        this.condition(ctx.ifExpression().condition());
    }


    public void condition(janusParser.ConditionContext ctx){
        if(ctx.logicalExpression() == null){
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
            else{
                gc.setGeneralCondition(ctx.value(0).getText(),ctx.opcondition().getText(),ctx.value(1).getText());
            }
        }
        else{
            condition(ctx.condition(0));
            gc.appendStrToFile(" " + ctx.logicalExpression().getText() + " ");
            condition(ctx.condition(1));
        }
    }



    public void getContext(ParseTree parseTree){
        if(parseTree != null) {

            if (parseTree.getClass().getCanonicalName().compareTo("janusParser.BlockContext") == 0) {
                getContext(parseTree.getChild(1));
                getContext(parseTree.getChild(0));
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.IfConstructorContext") == 0){ //if constructor case
                janusIfThenElseWalker jiw;
                if(threadArg){
                    jiw = new janusIfThenElseWalker(gc,indent,type_msg_memory,true); // true for thread Arg
                }
                else {
                    jiw = new janusIfThenElseWalker(gc, indent, type_msg_memory);
                }
                walker.walk(jiw,parseTree);
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.LoopConstructorContext") == 0){ // loop case
                janusLoopWalker jlW;
                if(threadArg){
                    jlW = new janusLoopWalker(gc,indent,type_msg_memory,threadArg);
                }
                else{
                    jlW = new janusLoopWalker(gc,indent,type_msg_memory);
                }
                walker.walk(jlW,parseTree);
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.ForkandjoinContext") == 0){ // fork and join
                janusForkandjoinWalker jFW = new janusForkandjoinWalker(gc,indent);
                walker.walk(jFW,parseTree);
            }
            else {
                janusExpWalker jew;
                if(threadArg){
                    jew = new janusExpWalker(gc,indent,threadArg,type_msg_memory);
                }
                else {
                    jew = new janusExpWalker(gc, indent, type_msg_memory);
                }
                walker.walk(jew,parseTree);
            }

        }
    }
}
