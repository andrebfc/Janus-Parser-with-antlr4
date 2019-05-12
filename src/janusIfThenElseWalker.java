import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class janusIfThenElseWalker extends janusBaseListener {

    genereteCode gc;
    int indent;
    private int depth = 0;
    ParseTreeWalker walker = new ParseTreeWalker();


    janusIfThenElseWalker(genereteCode genCode, int ind){
        this.gc = genCode;
        this.indent = ind;
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
            gc.setGeneralCondition(ctx.value(0).getText(),ctx.opcondition().getText(),ctx.value(1).getText());
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
                janusIfThenElseWalker jiw = new janusIfThenElseWalker(gc,indent);
                walker.walk(jiw,parseTree);
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.LoopConstructorContext") == 0){ // loop case
                janusLoopWalker jlW = new janusLoopWalker(gc,indent);
                walker.walk(jlW,parseTree);
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.ForkandjoinContext") == 0){ // fork and join
                janusForkandjoinWalker jFW = new janusForkandjoinWalker(gc,indent);
                walker.walk(jFW,parseTree);
            }
            else {
                janusExpWalker jew = new janusExpWalker(gc,indent);
                walker.walk(jew,parseTree);
            }

        }
    }
}
