// this class inizialize threads for fork and join
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class forkInitForward extends janusBaseListener{

    static int countForkandjoin = 0;

    ParseTreeWalker walker = new ParseTreeWalker();
    ParseTree parseTree;

    utility ut;
    genereteCode gc;

    //constructor
    forkInitForward(genereteCode genCode, utility u){
        this.gc = genCode;
        this.ut = u;
    }

    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){
        countForkandjoin += 2;
        gc.setSingleFork(countForkandjoin-1,0);


        //set and copy struct for local message passing
        if(ctx.tagName() != null && ut.getTypeMsg() == 0){ //tagName is struct argument
            gc.setLocalStruct(ctx.tagName().getText());
            gc.setCpyStruct(ctx.tagName().getText());
        }

        parseTree = ctx.block(0);

        ut.setThreadArg(true); // set thread Argument true
        //first thread fork and join walk
        janusWriteF jW = new janusWriteF(gc,countForkandjoin,ut);
        walker.walk(jW,parseTree);

        gc.setExitFunction();

        ut.setThreadArg(false); // set thread Argument false after walk

        gc.setSingleFork(countForkandjoin,0);

        //set and copy struct for local message passing
        if(ctx.tagName() != null && ut.getTypeMsg() == 0){ //tagName is struct argument
            gc.setLocalStruct(ctx.tagName().getText());
            gc.setCpyStruct(ctx.tagName().getText());
        }

        parseTree = ctx.block(1);
        ut.setThreadArg(true);// set thread Argument true
        //second thread fork and join walk
        janusWriteF jW2 = new janusWriteF(gc,countForkandjoin,ut);
        walker.walk(jW2,parseTree);

        gc.setExitFunction();

        ut.setThreadArg(false);// set thread Argument false after walk
    }


}