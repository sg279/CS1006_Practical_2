import java.util.ArrayList;
import java.util.Arrays;

public class Carrier extends Unit{
    private int mineralCost=350;
    private int gasCost=250;
    private int buildTime=120;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new CyberneticsCore(), new Gateway(), new Pylon(), new Assimilator(), new Stargate(), new FleetBeacon()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.getGasCost()&&game.availableStargate>=1&&game.fleetBeacon>=1){
            int carriers = 0;
            for (Buildable buildable: game.buildOrder
                    ) {
                if(buildable.getClass()==this.getClass()){
                    carriers++;
                }
            }
            if(carriers==game.goal.carrier){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.carrier++;
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