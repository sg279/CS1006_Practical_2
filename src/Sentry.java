public class Sentry {
    static int mineralCost=50;
    static int gasCost=100;
    static int buildTime=37;
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
        game.sentry++;
        game.availableGateway++;
    }
    public void startBuild(Game game){
        game.availableGateway--;
    }
}