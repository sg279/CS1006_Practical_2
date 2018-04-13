public class Stalker {
    static int mineralCost=125;
    static int gasCost=50;
    static int buildTime=42;
    static Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.availableGateway>=1&&game.cyberneticsCore>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.stalker++;
        game.availableGateway++;
    }
    public void startBuild(Game game){
        game.availableGateway--;
    }
}