/**
 * This class is extended by all unit objects. It adds the startBuild method that reduces the number of available buildings that the unit is built from
 * by 1 in the game state building the unit which is provided as a parameter
 */
public abstract class Unit extends Buildable {
    /**
     * Reduces the number of available buildings that the unit is built from by 1 in the game state that is building the unit
     *
     * @param game The game state that is building the unit
     */
    public abstract void startBuild(Game game);
}
