public class Immortal {
    static int mineralCost=250;
    static int gasCost=100;
    static int buildTime=55;
    static Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.availableRobotics>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.immortal++;
        game.availableRobotics++;
    }
    public void startBuild(Game game){
        game.availableRobotics--;
    }
}