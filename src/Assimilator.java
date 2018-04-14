public class Assimilator extends Building {
    private int mineralCost=75;
    private int gasCost=0;
    private int buildTime=30;
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
        game.assimilator++;
    }

}
