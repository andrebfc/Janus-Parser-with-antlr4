import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class forkInitReverse extends janusBaseListener{

    genereteCode gc;
    static int countForkandjoin = 0;
    int indent;

    int fatherfork = 0;
    boolean pass = false;

    ParseTreeWalker walker = new ParseTreeWalker();
    ParseTree parseTree;

    //constructor
    forkInitReverse(genereteCode genCode, int ind){
        this.gc = genCode;
        this.indent = ind;
    }

    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){
        countForkandjoin += 1;


        if(fatherfork > 0){
            pass = true;
        }

        gc.setSingleFork(countForkandjoin,1);
        //block 0

        int childCount = ctx.block(0).getChildCount();
        childCount--;
        while (childCount >= 0) { // have child expression

            parseTree = ctx.block(0).getChild(childCount);
            getContext(parseTree);
            childCount--;
        }

        countForkandjoin += 1;

        if(pass){
            fatherfork -= 2;
            if(ctx.tagName() != null) {
                gc.setforkandjoin(ctx.tagName().getText(),indent, countForkandjoin - 2, 1); // -2 perchè è il padre
            }
            else{
                gc.setforkandjoin("NULL",indent, countForkandjoin - 2, 1); // -2 perchè è il padre
            }
        }


        gc.setExitFunction(0);


        gc.setSingleFork(countForkandjoin,1);

        //block 1
        childCount = ctx.block(1).getChildCount();
        childCount--;
        while (childCount >= 0) { // have child expression

            parseTree = ctx.block(1).getChild(childCount);
            getContext(parseTree);
            childCount--;
        }
        gc.setExitFunction(0);

    }


    public void getContext(ParseTree parseTree){
        if(parseTree != null) {

            if (parseTree.getClass().getCanonicalName().compareTo("janusParser.BlockContext") == 0) {
                getContext(parseTree.getChild(1));
                getContext(parseTree.getChild(0)); // HA DUE FIGLI
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
                fatherfork += 2;
                return;
            }
            else {
                janusExpWalker jew = new janusExpWalker(gc,indent,true); // true for argument thread
                walker.walk(jew,parseTree);
            }

        }
    }
}
