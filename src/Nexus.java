public class Nexus extends Building {
    private int mineralCost=400;
    private int gasCost=0;
    private int buildTime=100;

    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost){
            return true;
        }
        else{
            return false;
        }
    }
    public void build (Game game){
        game.nexus++;
    }

}
