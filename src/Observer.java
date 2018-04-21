import java.util.ArrayList;
import java.util.Arrays;

public class Observer extends Unit{
    private int mineralCost=25;
    private int gasCost=75;
    private int buildTime=40;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new RoboticsFacility(), new CyberneticsCore(), new Gateway(), new Pylon(), new Assimilator()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.availableRobotics>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.observer++;
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

    public ArrayList<Building> getDependentOn() {
        return dependentOn;
    }
}