public class Phoenix {
    static int mineralCost=150;
    static int gasCost=100;
    static int buildTime=35;
    static Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.availableStargate>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.phoenix++;
        game.availableStargate++;
    }
    public void startBuild(Game game){
        game.availableStargate--;
    }
}