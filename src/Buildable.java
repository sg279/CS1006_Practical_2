import java.util.ArrayList;

/**
 * The abstract class that defines all buildables and their methods and properties. A buildable is anything a player can build and encompasses both units and buildings.
 */
public abstract class Buildable {
    //The mineral cost of the buildable
    private int mineralCost;
    //The gas cost of the buildable
    private int gasCost;
    //The in game seconds it takes to build the buildable
    private int buildTime;
    //A list of buildables that the buildables is dependent on in order to be created
    private ArrayList<Building> dependentOn;

    /**
     * A method to be implemented that returns true if a buildables can (and should) be built in a certain game state.
     * For buildings that produce units, the method checks if the game state has the required mineral, gas costs, and at least one of each building it is dependant on, and if the
     * number of that building that has started to be built is at a maximum number defined by how many different types of units built from the building the goal requires.
     * For buildings that don't produce units the same check is done but instead of checking if a certain number has started toi be built it is only checked if 1 has been built.
     * For units the same test is done but the amount that have started to be built is checked against how many are required by the goal (except probes, which have no limit), and
     * the game state is checked to see if the required buildings are available.
     *
     * @param game The game state that is trying to build the buildable.
     * @return If the buildable can and should be built
     */
    abstract boolean canBeBuilt(Game game);

    /**
     * This method is called when a unit is built in a game state. For buildings that don't produce units, the method increments the gamestates value for that building.
     * For buildings that produce units, the same is done but the game state's value for the number of that building that are available is also incremented.
     * For units the same is done except the value of available buildings of the type used to build the unit is also incremented.
     * For probes, the number of available probes is also incremented.
     * For assimilators, if the number of available probes is greater than or equal to 3, the number of available probes is reduced by three and the numbner of gas miners
     * is incremented by 3. If the number of available probes is less than three, the number of available probes is set to 0, the number of gas miners is
     * incremented by 3, and the number of mineral miners is reduced by 3-the number of available miners previously available.
     *
     * @param game The game state building the buildable
     */
    abstract void build(Game game);

    /**
     * @return The buildTime property
     */
    public int getBuildTime() {
        return buildTime;
    }

    /**
     * @return The gasCost property
     */
    public int getGasCost() {
        return gasCost;
    }

    /**
     * @return the mineralCost property
     */
    public int getMineralCost() {
        return mineralCost;
    }

    /**
     * @return The dependentOn property
     */
    public ArrayList<Building> getDependentOn() {
        return dependentOn;
    }
}
