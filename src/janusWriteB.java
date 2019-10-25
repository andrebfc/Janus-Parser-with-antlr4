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
    public void enterStruct(janusParser.StructContext ctx){
        gc.initStruct(ctx.tagName().getText());

    }

}
