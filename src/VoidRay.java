public class VoidRay extends Unit{
    private int mineralCost=250;
    private int gasCost=150;
    private int buildTime=60;
    private Building[] dependentOn;
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

    public int getBuildTime() {
        return buildTime;
    }

    public int getGasCost() {
        return gasCost;
    }

    public int getMineralCost() {
        return mineralCost;
    }
}