public abstract class Buildable {
    static int mineralCost;
    static int gasCost;
    static int buildTime;
    static Building[] dependentOn;
    abstract boolean canBeBuilt(Game game);
    abstract void build(Game game);
}
