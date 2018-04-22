import java.util.ArrayList;
import java.util.Arrays;

public class Colossus extends Unit{
    private int mineralCost=300;
    private int gasCost=200;
    private int buildTime=75;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new RoboticsBay(), new CyberneticsCore(), new RoboticsFacility(), new Pylon(), new Assimilator(), new Gateway()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.availableRobotics>=1&&game.roboticsBay>=1){
            int collossi = 0;
            for (Buildable buildable: game.buildOrder
                    ) {
                if(buildable.getClass()==this.getClass()){
                    collossi++;
                }
            }
            if(collossi==game.goal.colossus){
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
        game.colossus++;
        game.availableRobotics++;
    }
    public void startBuild(Game game){
        game.availableRobotics--;
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