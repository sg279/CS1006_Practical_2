import java.util.ArrayList;
import java.util.Arrays;

public class HighTemplar extends Unit{
    private int mineralCost=50;
    private int gasCost=150;
    private int buildTime=55;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new CyberneticsCore(), new Gateway(), new Pylon(), new TwilightCouncil(), new Assimilator(), new TemplarArchives()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.availableGateway>=1&&game.templarArchives>=1){
            int highTemplars = 0;
            for (Buildable buildable: game.buildOrder
                    ) {
                if(buildable.getClass()==this.getClass()){
                    highTemplars++;
                }
            }
            if(highTemplars==game.goal.highTemplar){
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
        game.highTemplar++;
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