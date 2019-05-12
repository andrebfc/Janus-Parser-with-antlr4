import java.util.ArrayList;
import java.util.List;

public class janusDecFun extends janusBaseListener {

    genereteCode gc;
    List<String> typePar = new ArrayList<String>();
    List<String> namePar = new ArrayList<String>();
    int flag;


    //constructor
    janusDecFun(genereteCode genCode, int f){
        this.gc = genCode;
        this.flag = f;
    }


    //function
    public void enterFunction(janusParser.FunctionContext ctx){

        gc.declareFunction(ctx.functionDeclaration().tagName().getText(), 0);//this.flag);

    }

    public void exitFunction(janusParser.FunctionContext ctx){
        //reverse declaration
        gc.declareFunction(ctx.functionDeclaration().tagName().getText(), 1);

        if(ctx.functionDeclaration().parametersDeclaration() != null) {
            if (ctx.functionDeclaration().parametersDeclaration().paramDecFun().array() == null) {
                gc.setParamsDeclFunc(typePar, namePar, 0);// flag 0 = '&' // cambio a 1 per passaggio riferimento in c
            } else {
                gc.setParamsDeclFunc(typePar, namePar, 0);// flag 1 = '*'
            }
        }
        gc.appendStrToFile(");\n");

        //clear parameteres declaration
        typePar.clear();
        namePar.clear();
    }


    //parametersDeclaration function
    public void enterParametersDeclaration(janusParser.ParametersDeclarationContext ctx){
        if(ctx != null){
            typePar.add(ctx.paramDecFun().type().getText());
            namePar.add(ctx.paramDecFun().variableName().getText());
        }
    }


    //functionDeclariation
    public void exitFunctionDeclaration(janusParser.FunctionDeclarationContext ctx){
        if(ctx.parametersDeclaration() != null) {
            if (ctx.parametersDeclaration().paramDecFun().array() == null) {
                gc.setParamsDeclFunc(typePar, namePar, 0);// flag 0 = '&' // cambio a 1 per passaggio riferimento in c
            } else {
                gc.setParamsDeclFunc(typePar, namePar, 0);// flag 1 = '*'
            }
        }
        if(ctx.tagName().getText().compareTo("main") != 0) {
            gc.appendStrToFile(");\n");
        }

    }

}
