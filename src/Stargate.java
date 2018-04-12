public class Stargate extends Building {
    static int mineralCost=150;
    static int gasCost=150;
    static int buildTime=60;
    static Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.cyberneticsCore>=1&&game.pylon>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.stargate++;
    }

}
