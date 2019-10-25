// struct declaration
public class janusStructDeclare extends janusBaseListener{

    boolean pass = false;
    String nameStruct;

    genereteCode gc;
    utility ut;

    //constructor
    janusStructDeclare(genereteCode genCode, utility u){
        this.gc = genCode;
        this.ut = u;
    }

    public void enterStruct(janusParser.StructContext ctx){
        pass = true;
        nameStruct = ctx.tagName().getText();
        gc.setStruct(ctx.tagName().getText());
        ut.incIndent();


    }

    public void exitStruct(janusParser.StructContext ctx){
        ut.decIndent();
        gc.closeStruct();
        pass = false;
    }

    public void enterParamDeclare(janusParser.ParamDeclareContext ctx){
        if(pass) {
            if(ctx.array() != null){
                gc.setStructParam(ctx.type().getText(),ctx.variableName().getText(),1);//1 is array
            }
            else {
                gc.setStructParam(ctx.type().getText(), ctx.variableName().getText(),0);
            }
        }
    }

    public String getStructName(){
        return nameStruct;
    }

}
