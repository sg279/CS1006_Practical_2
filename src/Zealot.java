import java.util.ArrayList;
import java.util.Arrays;

public class Zealot extends Unit{
    private int mineralCost=100;
    private int gasCost=0;
    private int buildTime=38;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new Gateway(), new Pylon()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.availableGateway>=1){
            int zealots = 0;
            for (Buildable buildable: game.buildOrder
                    ) {
                if(buildable.getClass()==this.getClass()){
                    zealots++;
                }
            }
            if(zealots==game.goal.zealot){
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
        game.zealot++;
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
