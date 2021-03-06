import java.util.ArrayList;
import java.util.Arrays;

public class Nexus extends Building {
    private int mineralCost=400;
    private int gasCost=0;
    private int buildTime=100;
    ArrayList<Building> dependentOn = new ArrayList<Building>();

    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost){
            return true;
        }
        else{
            return false;
        }
    }
    public void build (Game game){
        game.nexus++;
        game.availableNexus++;
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
