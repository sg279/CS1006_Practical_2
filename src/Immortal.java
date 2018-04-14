public class Immortal extends Unit{
    private int mineralCost=250;
    private int gasCost=100;
    private int buildTime=55;
    private Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.availableRobotics>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.immortal++;
        game.availableRobotics++;
    }
    public void startBuild(Game game){
        game.availableRobotics--;
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