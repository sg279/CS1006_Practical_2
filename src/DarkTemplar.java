import java.util.ArrayList;
import java.util.Arrays;

public class DarkTemplar extends Unit{
    private int mineralCost=125;
    private int gasCost=125;
    private int buildTime=55;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new CyberneticsCore(), new Gateway(), new Pylon(), new TwilightCouncil(), new Assimilator(), new DarkShrine()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.availableGateway>=1&&game.darkShrine>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.darkTemplar++;
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