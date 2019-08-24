public class threadJoin extends janusBaseListener {

    int countfaj = 0;

    public void exitForkandjoin(janusParser.ForkandjoinContext ctx){
        countfaj += 2;
    }

    public int getForkCount(){
        return countfaj;
    }
}
