public class janusForkandjoinWalker extends janusBaseListener  {

    genereteCode gc;
    int indent;
    static int countforkandjoin = 0;
    static int numfaj = 0;

    //constructor
    janusForkandjoinWalker(genereteCode genCode, int ind){
        this.gc = genCode;
        this.indent = ind;
    }

    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){
        numfaj++; // count fork and join constructor
        countforkandjoin += 2; // count fork and join programs
    }

    public void exitForkandjoin(janusParser.ForkandjoinContext ctx){
        numfaj--;

        if (numfaj < 1){
            if(ctx.tagName() != null) {//struct argument fork and join
                gc.setforkandjoin(ctx.tagName().getText(),indent, gc.getForkandjoinvar(), 1); // 1 = reverse
            }
            else{
                gc.setforkandjoin("NULL",indent, gc.getForkandjoinvar(), 1); // 1 = reverse

            }
            gc.setForkandjoinvar(countforkandjoin);
            //reset number fork and join for subtree
            countforkandjoin = 0;
        }

    }
}
