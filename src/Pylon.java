public class Pylon extends Building {
    private int mineralCost=100;
    private int gasCost=0;
    private int buildTime=25;
    private Building[] dependentOn;
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
