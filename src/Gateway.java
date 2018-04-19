import java.util.ArrayList;
import java.util.Arrays;

public class Gateway extends Building {
    private int mineralCost=150;
    private int gasCost=0;
    private int buildTime=65;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new Pylon()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.pylon>=1){
            int gateways = 0;
            for (Buildable buildable: game.buildOrder
                 ) {
                if(buildable.getClass()==this.getClass()){
                    gateways++;
                }
            }
            if(gateways==game.goal.maxGateways){
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
        game.gateway++;
        game.availableGateway++;
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
