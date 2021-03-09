import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class forkInitReverse extends janusBaseListener{


    static int countForkandjoin = 0;
    int fatherfork = 0;
    boolean pass = false;

    ParseTreeWalker walker = new ParseTreeWalker();
    ParseTree parseTree;

    utility ut;
    genereteCode gc;


    //constructor
    forkInitReverse(genereteCode genCode, utility u){
        this.gc = genCode;
        this.ut = u;
    }

    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){
        countForkandjoin += 1;


        if(fatherfork > 0){
            pass = true;
        }

        gc.setSingleFork(countForkandjoin,1);
        //block 0
        //set and copy struct for local message passing
        if(ctx.tagName() != null && ut.getTypeMsg() == 0){ //tagName is struct argument
            gc.setLocalStruct(ctx.tagName().getText(),ctx.variableName().getText());
            gc.setCpyStruct(ctx.tagName().getText(),ctx.variableName().getText());
        }

        int childCount = ctx.block(0).getChildCount();
        childCount--;
        while (childCount >= 0) { // have child expression

            parseTree = ctx.block(0).getChild(childCount);
            getContext(parseTree);
            childCount--;
        }

        countForkandjoin += 1;

        gc.setExitFunction();


        gc.setSingleFork(countForkandjoin,1);

        //block 1
        //set and copy struct for local message passing
        if(ctx.tagName() != null && ut.getTypeMsg() == 0){ //tagName is struct argument
            gc.setLocalStruct(ctx.tagName().getText(),ctx.variableName().getText());
            gc.setCpyStruct(ctx.tagName().getText(),ctx.variableName().getText());
        }

        childCount = ctx.block(1).getChildCount();
        childCount--;
        while (childCount >= 0) { // have child expression

            parseTree = ctx.block(1).getChild(childCount);
            getContext(parseTree);
            childCount--;
        }
        gc.setExitFunction();

    }

    //private getContext function for set thread argument
    private void getContext(ParseTree parseTree){
        if(parseTree != null) {

            if (parseTree.getClass().getCanonicalName().compareTo("janusParser.BlockContext") == 0) {
                //two child
                getContext(parseTree.getChild(1));
                getContext(parseTree.getChild(0));
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.IfConstructorContext") == 0){ //if constructor case
                ut.setThreadArg(true);
                janusIfThenElseWalker jiw = new janusIfThenElseWalker(gc,ut); // true for argument thread
                walker.walk(jiw,parseTree);
                ut.setThreadArg(false);
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.LoopConstructorContext") == 0){ // loop case
                ut.setThreadArg(true);
                janusLoopWalker jlW = new janusLoopWalker(gc,ut); // true for argument thread
                walker.walk(jlW,parseTree);
                ut.setThreadArg(false);
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.ForkandjoinContext") == 0){ // fork and join case
                janusForkandjoinWalker jFW = new janusForkandjoinWalker(gc, ut);
                walker.walk(jFW,parseTree);
                fatherfork += 2;
                return;
            }
            else {
                ut.setThreadArg(true);
                janusExpWalker jew = new janusExpWalker(gc,ut); // true for argument thread
                walker.walk(jew,parseTree);
                ut.setThreadArg(false);
            }

        }
    }
}
