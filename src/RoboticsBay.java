import java.util.ArrayList;
import java.util.Arrays;

public class RoboticsBay extends Building {
    private int mineralCost=200;
    private int gasCost=200;
    private int buildTime=65;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new CyberneticsCore(), new RoboticsFacility(), new Pylon(), new Assimilator(), new Gateway()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.roboticsFacility>=1&&game.pylon>=1&&!game.hasBeenBuilt(this)){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.roboticsBay++;
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
