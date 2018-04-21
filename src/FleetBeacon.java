import java.util.ArrayList;
import java.util.Arrays;

public class FleetBeacon extends Building {
    private int mineralCost=300;
    private int gasCost=200;
    private int buildTime=60;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new CyberneticsCore(), new Gateway(), new Pylon(), new Assimilator(), new Stargate()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.pylon>=1&&game.stargate>=1&&!game.hasBeenBuilt(this)){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.fleetBeacon++;
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

}
