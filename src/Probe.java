public class Probe extends Unit{
    private int mineralCost=40;
    private int gasCost=0;
    private int buildTime=15;
    private Building[] dependentOn;
    Building builtFrom;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.availableNexus>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.probe++;
        game.availabeProbe++;
        game.availableNexus++;
    }
    public void startBuild(Game game){
        game.availableNexus--;
    }
}
