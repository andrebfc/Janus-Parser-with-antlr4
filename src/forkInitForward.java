import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class forkInitForward extends janusBaseListener{

    genereteCode gc;
    static int countForkandjoin = 0;
    int indent;
    ParseTreeWalker walker = new ParseTreeWalker();
    ParseTree parseTree;

    //constructor
    forkInitForward(genereteCode genCode, int ind){
        this.gc = genCode;
        this.indent = ind;
    }

    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){
        countForkandjoin += 1;
        gc.setSingleFork(countForkandjoin,0);

        parseTree = ctx.block(0);
        janusWriteF jW = new janusWriteF(gc,indent,countForkandjoin+1,ctx.block(0).depth()+1,true);
        walker.walk(jW,parseTree);
        gc.setExitFunction(0);

        countForkandjoin += 1;

        gc.setSingleFork(countForkandjoin,0);

        parseTree = ctx.block(1);
        janusWriteF jW2 = new janusWriteF(gc,indent,countForkandjoin+1,ctx.block(0).depth()+2,true);
        walker.walk(jW2,parseTree);
        gc.setExitFunction(0);

    }

}