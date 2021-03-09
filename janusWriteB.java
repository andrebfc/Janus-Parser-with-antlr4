// reverse walk
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

public class janusWriteB extends janusBaseListener{


    List<String> typePar = new ArrayList<String>();
    List<String> namePar = new ArrayList<String>();

    int nidfork = 0;
    int depth = 0;

    boolean structInForkAndJoin = false;

    //Parse for fork and join count
    ParseTreeWalker walker = new ParseTreeWalker();
    ParseTree parseTree;

    genereteCode gc;
    utility ut;
    janusRules r;

    //constructor
    janusWriteB(genereteCode genCode, utility u){
        this.gc = genCode;
        this.ut = u;

        r = new janusRules(gc,ut);
    }


    public void enterPortDeclare(janusParser.PortDeclareContext ctx){
            gc.setInitPort(ctx.port().getText());
    }

    public void enterLocalPortDeclare(janusParser.LocalPortDeclareContext ctx){
        if(ctx.local() != null && ctx.local().getText().compareTo("delocal") == 0) {
            gc.setInitPort(ctx.port().getText());
        }
    }

    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){
        structInForkAndJoin = true; // se sono all'interno di un fork and join non dichiaro la struttura

    }

    public void exitForkandjoin(janusParser.ForkandjoinContext ctx){
        structInForkAndJoin = false;
    }

    //function
    public void enterFunction(janusParser.FunctionContext ctx){
        gc.declareFunction(ctx.functionDeclaration().tagName().getText(),1);
        ut.incIndent();
    }

    public void exitFunction(janusParser.FunctionContext ctx){
        ParseTree parseTree;
        int childCount = ctx.getChildCount();
        childCount--;
        while (childCount >= 0) { // have child expression

            parseTree = ctx.getChild(childCount);
            r.getContext(parseTree);
            childCount--;
        }

        ut.decIndent();
        gc.setExitFunction();
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
                gc.setParamsDeclFunc(typePar, namePar, 1);// flag 1 = '*'
            }
        }
        gc.setExitFunctionDeclaration();

        //list reset
        typePar.clear();
        namePar.clear();
    }


    //struct init, before possible increment or assignment expression
    /*
    public void enterStructInit(janusParser.StructInitContext ctx){

        if(!structInForkAndJoin) {// se sono all'interno di un fork and join non dichiaro la struttura
            if (ctx.local() != null) {
                if ("delocal".compareTo(ctx.local().getText()) == 0) {
                    gc.initStruct(ctx.tagName().getText(), ctx.structName().getText());
                } else if ("local".compareTo(ctx.local().getText()) == 0) {
                    //TODO
                    //else if is local
                }
            } else {
                gc.initStruct(ctx.tagName().getText(), ctx.structName().getText());
            }
        }
    }
    */

}
