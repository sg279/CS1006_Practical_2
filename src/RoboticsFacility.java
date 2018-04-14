public class RoboticsFacility extends Building {
    private int mineralCost=200;
    private int gasCost=100;
    private int buildTime=65;
    private Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.gas>=this.gasCost&&game.cyberneticsCore>=1&&game.pylon>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.roboticsFacility++;
    }

}
