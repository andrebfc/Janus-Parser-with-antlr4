public class janusDecPort extends janusBaseListener {

    genereteCode gc;
    int countForkandjoin = 0;

    //constructor
    janusDecPort(genereteCode genCode){
        this.gc = genCode;
    }

    //port
    public void enterPortDeclare(janusParser.PortDeclareContext ctx){

        gc.setPort(ctx.port().getText());

    }

    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){
        countForkandjoin += 2;
        gc.setPthreadDeclare(countForkandjoin);

    }
}
