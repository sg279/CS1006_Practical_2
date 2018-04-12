public class RoboticsFacility extends Building {
    static int mineralCost=200;
    static int gasCost=100;
    static int buildTime=65;
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
        game.roboticsFacility++;
    }

}
