import java.util.ArrayList;
import java.util.Arrays;

public class RoboticsFacility extends Building {
    private int mineralCost=200;
    private int gasCost=100;
    private int buildTime=65;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new CyberneticsCore(), new Pylon(), new Gateway(), new Assimilator()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.cyberneticsCore>=1&&game.pylon>=1){
            int robotics = 0;
            for (Buildable buildable: game.buildOrder
                    ) {
                if(buildable.getClass()==this.getClass()){
                    robotics++;
                }
            }
            if(robotics==game.goal.maxRobotics){
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
        game.roboticsFacility++;
        game.availableRobotics++;
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
