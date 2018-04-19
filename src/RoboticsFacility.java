import java.util.ArrayList;
import java.util.Arrays;

public class RoboticsFacility extends Building {
    private int mineralCost=200;
    private int gasCost=100;
    private int buildTime=65;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new CyberneticsCore(), new Pylon()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.cyberneticsCore>=1&&game.pylon>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.roboticsFacility++;
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
