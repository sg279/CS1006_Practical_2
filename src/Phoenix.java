import java.util.ArrayList;
import java.util.Arrays;

public class Phoenix extends Unit{
    private int mineralCost=150;
    private int gasCost=100;
    private int buildTime=35;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new Stargate()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.availableStargate>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.phoenix++;
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