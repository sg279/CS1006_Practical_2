import java.util.ArrayList;
import java.util.Arrays;

public class Stalker extends Unit{
    private int mineralCost=125;
    private int gasCost=50;
    private int buildTime=42;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new Gateway(), new CyberneticsCore(), new Pylon(), new Assimilator()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.availableGateway>=1&&game.cyberneticsCore>=1){
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