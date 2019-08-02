import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class forkInitForward extends janusBaseListener{

    genereteCode gc;
    static int countForkandjoin = 0;
    int indent;
    ParseTreeWalker walker = new ParseTreeWalker();
    ParseTree parseTree;
    int type_msg_memory = 0;

    //constructor
    forkInitForward(genereteCode genCode, int ind,int tmm){
        this.gc = genCode;
        this.indent = ind;
        this.type_msg_memory = tmm;
    }

    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){
        countForkandjoin += 1;
        gc.setSingleFork(countForkandjoin,0);

        //set and copy struct for local message passing
        if(ctx.tagName() != null && type_msg_memory == 0){ //tagName is struct argument
            gc.setLocalStruct(ctx.tagName().getText(),indent);
            gc.setCpyStruct(ctx.tagName().getText(),indent);
        }

        parseTree = ctx.block(0);
        janusWriteF jW = new janusWriteF(gc,indent,countForkandjoin+1,ctx.block(0).depth()+1,true,type_msg_memory);
        walker.walk(jW,parseTree);
        gc.setExitFunction(0);

        countForkandjoin += 1;

        gc.setSingleFork(countForkandjoin,0);

        //set and copy struct for local message passing
        if(ctx.tagName() != null && type_msg_memory == 0){ //tagName is struct argument
            gc.setLocalStruct(ctx.tagName().getText(),indent);
            gc.setCpyStruct(ctx.tagName().getText(),indent);
        }

        parseTree = ctx.block(1);
        janusWriteF jW2 = new janusWriteF(gc,indent,countForkandjoin+1,ctx.block(0).depth()+2,true,type_msg_memory);
        walker.walk(jW2,parseTree);
        gc.setExitFunction(0);

    }

}