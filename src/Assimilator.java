import java.util.ArrayList;
import java.util.Arrays;

public class Assimilator extends Building {
    private int mineralCost=75;
    private int gasCost=0;
    private int buildTime=30;
    ArrayList<Building> dependentOn = new ArrayList<>();
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        if(game.availabeProbe>=3){
            game.availabeProbe-=3;
            game.gasMiners+=3;
        }
        else if(game.mineralMiners>=3){
            int toTransfer= 3-game.availabeProbe;
            game.mineralMiners-=toTransfer;
            game.availabeProbe=0;
            game.gasMiners+=3;
        }
        game.assimilator++;
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
