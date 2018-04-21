import java.util.ArrayList;
import java.util.Arrays;

public class Immortal extends Unit{
    private int mineralCost=250;
    private int gasCost=100;
    private int buildTime=55;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new RoboticsFacility(), new CyberneticsCore(), new Pylon(), new Gateway(), new Assimilator()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.availableRobotics>=1){
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

    public ArrayList<Building> getDependentOn() {
        return dependentOn;
    }
}