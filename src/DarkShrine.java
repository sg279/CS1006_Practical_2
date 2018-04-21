import java.util.ArrayList;
import java.util.Arrays;

public class DarkShrine extends Building {
    private int mineralCost=100;
    private int gasCost=250;
    private int buildTime=100;
    ArrayList<Building> dependentOn = new ArrayList<Building>(Arrays.asList(new CyberneticsCore(), new Gateway(), new Pylon(), new TwilightCouncil(), new Assimilator()));
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.twilightCouncil>=1&&game.pylon>=1&&!game.hasBeenBuilt(this)){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.darkShrine++;
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
