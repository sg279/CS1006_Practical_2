public class Nexus extends Building {
    static int mineralCost=400;
    static int gasCost=0;
    static int buildTime=100;

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
