public class Pylon extends Building {
    static int mineralCost=100;
    static int gasCost=0;
    static int buildTime=25;
    static Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.pylon++;
    }

}
