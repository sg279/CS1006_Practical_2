public class Observer {
    static int mineralCost=25;
    static int gasCost=75;
    static int buildTime=40;
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
        game.observer++;
        game.availableRobotics++;
    }
    public void startBuild(Game game){
        game.availableRobotics--;
    }
}