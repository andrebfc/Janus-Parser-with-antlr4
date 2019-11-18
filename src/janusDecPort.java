//set port for message passing
public class janusDecPort extends janusBaseListener {

    int countForkandjoin = 0;

    genereteCode gc;
    utility ut;

    //constructor
    janusDecPort(genereteCode genCode, utility u) {
        this.gc = genCode;
        this.ut = u;
    }

    //port
    public void enterPortDeclare(janusParser.PortDeclareContext ctx) {
        //load include file if find a port
        if(ut.getIncludeThread()){
            gc.setInclude4threads(ut.getLimit());
        }
        gc.setlibinclude(true);
        gc.setPort(ctx.port().getText());
    }


    //local port
    public void enterLocalPortDeclare(janusParser.LocalPortDeclareContext ctx){
        //load include file if find a port
        if(ut.getIncludeThread()){
            gc.setInclude4threads(ut.getLimit());
        }
        gc.setlibinclude(true);
        if(ctx.local().getText().compareTo("local") == 0) {
            gc.setPort(ctx.port().getText());
        }
    }

    //fork and join
    public void enterForkandjoin(janusParser.ForkandjoinContext ctx) {
        if(!gc.getlibinclude()){
            gc.setInclude4threads(ut.getLimit());
            gc.setlibinclude(true);
        }

        countForkandjoin += 2;
        gc.setPthreadDeclare(countForkandjoin);

    }



}
