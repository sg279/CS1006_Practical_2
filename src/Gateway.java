public class Gateway extends Building {
    static int mineralCost=75;
    static int gasCost=0;
    static int buildTime=30;
    static Building[] dependentOn;
    public boolean canBeBuilt(Game game){
        if (game.minerals>=this.mineralCost&&game.pylon>=1){
            return true;
        }
        else{
            return false;
        }
    }
    public void build(Game game){
        game.gateway++;
        game.availableGateway++;
    }

}
