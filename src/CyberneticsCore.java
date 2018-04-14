public class CyberneticsCore extends Building {
    private int mineralCost=150;
    private int gasCost=0;
    private int buildTime=50;
    private Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gateway>=1&&game.pylon>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.cyberneticsCore++;
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
