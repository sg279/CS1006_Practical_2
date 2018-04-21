import java.util.ArrayList;
import java.util.Arrays;

public class VoidRay extends Unit{
    private int mineralCost=250;
    private int gasCost=150;
    private int buildTime=60;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new Stargate(), new CyberneticsCore(), new Gateway(), new Pylon(), new Assimilator()));
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

    public ArrayList<Building> getDependentOn() {
        return dependentOn;
    }
}