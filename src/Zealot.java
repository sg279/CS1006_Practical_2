public class Zealot extends Unit{
    private int mineralCost=50;
    private int gasCost=0;
    private int buildTime=17;
    private Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.availableGateway>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.zealot++;
        game.availableGateway++;
    }
    public void startBuild(Game game){
        game.availableGateway--;
    }
}
