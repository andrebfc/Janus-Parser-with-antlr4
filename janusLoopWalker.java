// walk on while constructor
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class janusLoopWalker extends janusBaseListener  {

    private int depth = 0;

    ParseTreeWalker walker = new ParseTreeWalker();

    genereteCode gc;
    utility ut;
    janusRules r;

    //constructor
    janusLoopWalker(genereteCode genCode, utility u){
        this.gc = genCode;
        this.ut = u;

        r = new janusRules(gc,ut);

    }

    //loop constructor
    public void enterLoopConstructor(janusParser.LoopConstructorContext ctx){

        if(depth == 0){
            depth = ctx.depth();
        }

        if(depth == ctx.depth()){
            gc.openAssertCondition(0);
            r.condition(ctx.condition(1));
            gc.closeAssertCondition(0);

            if(ctx.doExp() != null){
                ParseTree parseTree;
                int childCount = ctx.doExp().block().getChildCount();
                childCount--;

                while (childCount >= 0) { // have child expression
                    parseTree = ctx.doExp().block().getChild(childCount);
                    r.getContext(parseTree);
                    childCount--;
                }
            }

        }
    }

    public void exitLoopConstructor(janusParser.LoopConstructorContext ctx){
        if(depth == ctx.depth()) {
            if (ctx.loopExp() == null) { // not loop Expression set While

                gc.openWhileDec();
                r.condition(ctx.condition(0));
                gc.closeWhileDec();
                ut.incIndent();
            }

            gc.openAssertCondition(1);
            r.condition(ctx.condition(1));
            gc.closeAssertCondition(1);
            //for do exp
            if (ctx.doExp() != null) {
                ParseTree parseTree;
                int childCount = ctx.doExp().block().getChildCount();
                childCount--;

                while (childCount >= 0) { // have child expression
                    parseTree = ctx.doExp().block().getChild(childCount);
                    r.getContext(parseTree);
                    childCount--;
                }
            }
            ut.decIndent();
            gc.setExitFunction();
        }
    }

    //Loop expression
    public void enterLoopExp(janusParser.LoopExpContext ctx){
        if(depth == ctx.depth() - 1) {

            gc.openWhileDec();
            this.getWhileCondition((janusParser.LoopConstructorContext) ctx.getParent());
            gc.closeWhileDec();
            ut.incIndent();

            if (ctx != null) {
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
    }

    public void getWhileCondition(janusParser.LoopConstructorContext ctx){
        //pass if condition context
        r.condition(ctx.condition(0));

    }

}
