/*This class use to count threads and set pthread_create/pthread_join */


public class janusForkandjoinWalker extends janusBaseListener  {

    genereteCode gc;
    int indent;
    static int countforkandjoin = 0;
    static int numfaj = 0;
    int join;

    //constructor
    janusForkandjoinWalker(genereteCode genCode, int ind, int j){
        this.gc = genCode;
        this.indent = ind;
        this.join = j;
    }

    public void enterForkandjoin(janusParser.ForkandjoinContext ctx){
        numfaj++; // count fork and join constructor
        countforkandjoin += 2; // count fork and join programs
        //gc.setForkandjoinvar(countforkandjoin);
    }

    public void exitForkandjoin(janusParser.ForkandjoinContext ctx){
        numfaj--;
        if (numfaj < 1){// only exit fork and join, if number fork and join >= 1 the function does nothing
            if(ctx.tagName() != null) {//there is struct argument fork and join
                if(gc.getForkandjoinvar() > 2){//this for pass an struct address to thread
                    gc.setforkandjoin("&"+ctx.tagName().getText(), indent, gc.getForkandjoinvar(), 1); // 1 = reverse
                }
                else {
                    gc.setforkandjoin(ctx.tagName().getText(), indent, gc.getForkandjoinvar(), 1); // 1 = reverse
                }
            }
            else{// no struct argument for fork and join
                gc.setforkandjoin("NULL",indent, gc.getForkandjoinvar(), 1); // 1 = reverse
            }
            // write pthread_join()
            if(join == 0){
                gc.setJoinThread(indent,gc.getForkandjoinvar());
            }
            gc.setForkandjoinvar(2);
            //reset number fork and join for subtree
            countforkandjoin = 0;
        }

    }
}
