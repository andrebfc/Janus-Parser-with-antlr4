public class janusStructDeclare extends janusBaseListener{

    genereteCode gc;
    int indent = 0;
    boolean pass = false;
    String nameStruct;

    //constructor
    janusStructDeclare(genereteCode genCode){
        this.gc = genCode;
    }

    public void enterStruct(janusParser.StructContext ctx){
            pass = true;
            nameStruct = ctx.tagName().getText();
            gc.setStruct(ctx.tagName().getText());
            indent++;


    }

    public void exitStruct(janusParser.StructContext ctx){
            indent--;
            gc.closeStruct();
            pass = false;
    }

    public void enterParamDeclare(janusParser.ParamDeclareContext ctx){
        if(pass) {
            if(ctx.array() != null){
                gc.setStructParam(ctx.type().getText(),ctx.variableName().getText(),indent,1);//1 is array
            }
            else {
                gc.setStructParam(ctx.type().getText(), ctx.variableName().getText(), indent,0);
            }
        }
    }

    public String getStructName(){

        return nameStruct;
    }

}
