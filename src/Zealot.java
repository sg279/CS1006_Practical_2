public class Zealot {
    static int mineralCost=50;
    static int gasCost=0;
    static int buildTime=17;
    static Building[] dependentOn;
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
