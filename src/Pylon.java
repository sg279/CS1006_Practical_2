import java.util.ArrayList;
import java.util.Arrays;

public class Pylon extends Building {
    private int mineralCost=100;
    private int gasCost=0;
    private int buildTime=25;
    ArrayList<Building> dependentOn = new ArrayList<Building>();
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&!game.hasBeenBuilt(this)){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.pylon++;
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
