// walk on if then else constructor
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class janusIfThenElseWalker extends janusBaseListener {

    private int depth = 0;

    ParseTreeWalker walker = new ParseTreeWalker();

    genereteCode gc;
    utility ut;
    janusRules r;


    janusIfThenElseWalker(genereteCode genCode, utility u){
        this.gc = genCode;
        this.ut = u;

        r = new janusRules(gc,ut);
    }

    public void enterIfConstructor(janusParser.IfConstructorContext ctx){
        if(depth == 0){
            depth = ctx.depth();
        }
    }

    public void exitIfConstructor(janusParser.IfConstructorContext ctx){
        if(ctx.elseExpression() == null && depth == ctx.depth()){
            gc.setExitFunction();

        }
    }

    //ifExpression
    public void enterIfExpression(janusParser.IfExpressionContext ctx){

        if(depth == ctx.depth() - 1) {

            gc.openIfDec();
            this.getFiCondition((janusParser.IfConstructorContext) ctx.getParent()); //IfConstructor.FiExpression.Condition
            gc.closeIfDec();

            ut.incIndent();
            ParseTree parseTree;
            int childCount = ctx.block().getChildCount();
            childCount--;

            while (childCount >= 0) { // have child expression
                parseTree = ctx.block().getChild(childCount);
                r.getContext(parseTree);
                childCount--;
            }

        }
    }

    public void exitIfExpression(janusParser.IfExpressionContext ctx){
       if(depth == ctx.depth() - 1) {
           gc.openAssertCondition(0); // 0 = real condition
           r.condition(ctx.condition());
           gc.closeAssertCondition(0);
           ut.decIndent();
       }
    }

    public void getFiCondition(janusParser.IfConstructorContext ctx){
        //pass if condition context
        r.condition(ctx.fiExpression().condition());
    }

    //elseExpression
    public void enterElseExpression(janusParser.ElseExpressionContext ctx){
        if(depth == ctx.depth() - 1){
            gc.setElse();

            ut.incIndent();
            ParseTree parseTree;
            int childCount = ctx.block().getChildCount();
            childCount--;

            while (childCount >= 0) { // have child expression
                parseTree = ctx.block().getChild(childCount);
                r.getContext(parseTree);
                childCount--;
            }

        }
    }

    public void exitElseExpression(janusParser.ElseExpressionContext ctx){
          if(depth == ctx.depth() - 1) {
              gc.openAssertCondition(1); // 1 = neg
              this.getIfCondition((janusParser.IfConstructorContext) ctx.getParent());
              gc.closeAssertCondition(1);
              //indent--;
              ut.decIndent();
              gc.setExitFunction();
          }
    }

    public void getIfCondition(janusParser.IfConstructorContext ctx){
        //pass if condition context
        r.condition(ctx.ifExpression().condition());

    }

}
