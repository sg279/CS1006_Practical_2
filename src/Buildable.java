import java.util.ArrayList;

public abstract class Buildable {
    private int mineralCost;
    private int gasCost;
    private int buildTime;
    private ArrayList<Building> dependentOn;
    abstract boolean canBeBuilt(Game game);
    abstract void build(Game game);

    public int getBuildTime() {
        return buildTime;
    }

    public int getGasCost() {
        return gasCost;
    }

    public int getMineralCost() {
        return mineralCost;
    }

    public ArrayList<Building> getDependentOn() {
        return dependentOn;
    }
}
