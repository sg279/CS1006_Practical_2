import java.util.ArrayList;
import java.util.Arrays;

public class Stargate extends Building {
    private int mineralCost=150;
    private int gasCost=150;
    private int buildTime=60;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new CyberneticsCore(), new Gateway()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.cyberneticsCore>=1&&game.pylon>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.stargate++;
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
