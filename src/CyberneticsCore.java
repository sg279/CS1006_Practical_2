public class CyberneticsCore extends Building {
    static int mineralCost=150;
    static int gasCost=0;
    static int buildTime=50;
    static Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gateway>=1&&game.pylon>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.cyberneticsCore++;
    }

}
