import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

public class janusWriteB extends janusBaseListener{

    genereteCode gc;
    List<String> typePar = new ArrayList<String>();
    List<String> namePar = new ArrayList<String>();
    int indent = 0;

    //Parse for fork and join count
    ParseTreeWalker walker = new ParseTreeWalker();
    ParseTree parseTree;

    int nidfork = 0;
    int depth = 0;
    int type_msg_memory = 0;
    int join = 0; //  0 = no pthread_create

    //constructor
    janusWriteB(genereteCode genCode, int ind, int tmm,int j){
        this.gc = genCode;
        this.indent = ind;
        this.type_msg_memory = tmm;
        this.join = j;
    }

    //constructor
    /*
    janusWriteB(genereteCode genCode, int ind, int nf, int d){
        this.gc = genCode;
        this.indent = ind;
        this.nidfork = nf;
        this.depth = d;
    }
    */


    public void enterPortDeclare(janusParser.PortDeclareContext ctx){
        gc.setInitPort(ctx.port().getText(),indent);
    }

    //function
    public void enterFunction(janusParser.FunctionContext ctx){
        gc.declareFunction(ctx.functionDeclaration().tagName().getText(),1);
        indent++;
    }

    public void exitFunction(janusParser.FunctionContext ctx){
        ParseTree parseTree;
        int childCount = ctx.getChildCount();
        childCount--;
        while (childCount >= 0) { // have child expression

            parseTree = ctx.getChild(childCount);
            getContext(parseTree);
            childCount--;
        }
        //pthread join
        if(join == 1) {
            parseTree = ctx;
            threadJoin tj = new threadJoin();
            walker.walk(tj, parseTree);
            int count = tj.getForkCount();
            gc.setJoinThread(indent,count);
        }

        indent--;

        gc.setExitFunction(indent);
        gc.setBlankLine();


    }

    //parametersDeclaration function
    public void enterParametersDeclaration(janusParser.ParametersDeclarationContext ctx){

        if(ctx != null){
            // add type and variable name on string list
            typePar.add(ctx.paramDecFun().type().getText());
            namePar.add(ctx.paramDecFun().variableName().getText());

        }
    }

    //function declaration
    public void exitFunctionDeclaration(janusParser.FunctionDeclarationContext ctx){
        if(ctx.parametersDeclaration() != null) {
            if (ctx.parametersDeclaration().paramDecFun().array() == null) {
                gc.setParamsDeclFunc(typePar, namePar, 0);// flag 0 = '&' // cambio a 1 per passaggio riferimento in c
            } else {
                gc.setParamsDeclFunc(typePar, namePar, 0);// flag 1 = '*'
            }
        }
        gc.setExitFunctionDeclaration();

        //list reset
        typePar.clear();
        namePar.clear();
    }

    //struct init, before possible increment or assignment expression
    public void enterStruct(janusParser.StructContext ctx){
        gc.initStruct(ctx.tagName().getText(),indent);

    }

    public void getContext(ParseTree parseTree){
        if(parseTree != null) {
            if (parseTree.getClass().getCanonicalName().compareTo("janusParser.BlockContext") == 0) {

                getContext(parseTree.getChild(1));
                getContext(parseTree.getChild(0)); // HA DUE FIGLI
            }

            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.IfConstructorContext") == 0){ //if constructor case

                janusIfThenElseWalker jiw = new janusIfThenElseWalker(gc,indent,type_msg_memory);
                walker.walk(jiw,parseTree);
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.LoopConstructorContext") == 0){ // loop case

                janusLoopWalker jlW = new janusLoopWalker(gc,indent,type_msg_memory);
                walker.walk(jlW,parseTree);
            }
            else if (parseTree.getClass().getCanonicalName().compareTo("janusParser.ForkandjoinContext") == 0){ // fork and join
                janusForkandjoinWalker jFW = new janusForkandjoinWalker(gc,indent);
                walker.walk(jFW,parseTree);
            }
            else { // qualsiasi altra cosa quando non è Block Context

                janusExpWalker jew = new janusExpWalker(gc,indent,type_msg_memory);
                walker.walk(jew,parseTree);

            }

        }
    }


}
