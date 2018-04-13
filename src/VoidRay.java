public class VoidRay {
    static int mineralCost=250;
    static int gasCost=150;
    static int buildTime=60;
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
        game.voidRay++;
        game.availableStargate++;
    }
    public void startBuild(Game game){
        game.availableStargate--;
    }
}