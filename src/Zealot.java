import java.util.ArrayList;
import java.util.Arrays;

public class Zealot extends Unit{
    private int mineralCost=50;
    private int gasCost=0;
    private int buildTime=17;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new Stargate()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.availableGateway>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.zealot++;
        game.availableGateway++;
    }
    public void startBuild(Game game){
        game.availableGateway--;
        int g;
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
