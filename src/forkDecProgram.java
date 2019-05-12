public class forkDecProgram extends janusBaseListener{

    genereteCode gc;
    int countForkandjoin = 0;

    //constructor
    forkDecProgram(genereteCode genCode){
        this.gc = genCode;
    }

    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){
        countForkandjoin += 2;
        gc.setforkandjoinDeclare(countForkandjoin,0);
        gc.setforkandjoinDeclare(countForkandjoin,1);

    }
}
