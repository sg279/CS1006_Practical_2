import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

/**
 * This class represents a simulated game at any given second. It stores information about how many of each unit and building a class contains, the order they  were built,
 * the time, the number of minerals and gas the player has, the number of available buildings and probes, a goal, the number of probes mining minerals and gas and a calendar of items
 * that have started being built and the time at which they will finish. It also contains methods important to the running of a game, most importantly,
 * a method that gets all possible moves the play can make from a given game state.
 */
public class Game {

    //Define all of the properties of a game state
    public String buildOrderStr = "";
    int time;
    float minerals;
    float gas;
    int nexus;
    int pylon;
    int assimilator;
    int gateway;
    int cyberneticsCore;
    int roboticsFacility;
    int stargate;
    int twilightCouncil;
    int templarArchives;
    int darkShrine;
    int roboticsBay;
    int fleetBeacon;
    int probe;
    int zealot;
    int stalker;
    int sentry;
    int observer;
    int immortal;
    int phoenix;
    int voidRay;
    int colossus;
    int highTemplar;
    int darkTemplar;
    int carrier;
    int gasMiners;
    int mineralMiners;
    int availableNexus;
    int availableGateway;
    int availableRobotics;
    int availableStargate;
    int availabeProbe;
    ArrayList<Buildable> buildOrder = new ArrayList<>();
    ArrayList<Buildable> didntBuild = new ArrayList<>();
    Goal goal;
    private ArrayList<Event> calendar = new ArrayList<>();
    private ArrayList<Game> possibleMoves = new ArrayList<>();

    /**
     * This method takes a buildable as a parameter, subtracts the mineral and gas cost from the game's minerals and gas,
     * adds an event object of the buildable and the time it will be completed to the games calendar, and adds the appropriate
     * text to the buildOrder string. It also calls the startBuild method if the item is a unit. This method reduces the number
     * of available buildings used to build the unit by 1.
     *
     * @param buildable The item to be built
     */
    public void startBuilding(Buildable buildable){
        //Add the item to the build order, and take the mineral and gas costs away from the game
        this.buildOrder.add(buildable);
        this.minerals-=buildable.getMineralCost();
        this.gas-=buildable.getGasCost();
        //Create a new event object with the item to be built and the current game time + the item's build time as parameters
        Event event = new Event(buildable, this.time+buildable.getBuildTime());
        //If the item is a unit, call the startBuild method with this game as a parameter
        if(buildable instanceof Unit){
            //Remove available building, add back on build
            ((Unit) buildable).startBuild(this);
        }
        //Add the event to the game's calendar
        this.calendar.add(event);
        //Add the appropriate text to the buildOrder string
        buildOrderStr = buildOrderStr + buildable.getClass().getName() + "\t" + time + "\n";
    }

    /**
     * This method reduces the number of available probes by 1 and increments the number of mineralMiners by 1
     */
    public void startMining(){
        this.availabeProbe--;
        this.mineralMiners++;
    }

    /**
     * This method checks if the number of gas miners is less than the number of assimilators times 3 and if the number of
     * available probes is more than or equal to 1. If so, the number of gas miners is incremented by 1 and the number of
     * available probes is reduced by 1
     */
    public void startGasMining(){
        if(this.gasMiners<this.assimilator*3&&this.availabeProbe>=1){
            this.gasMiners++;
            this.availabeProbe--;
        }
    }

    /**
     * This method simulates the passing of 1 in game second
     */
    public void tick(){
        //The games time is incremented by 1
        this.time++;
        //The number of minerals is increased by the number of mineral miners times 41/60 and is then reduced by the modulus of 2 of the number of mineral miners
        //times 21 over sixy, to simulate the reduced yield of every third miner
        this.minerals+=(this.mineralMiners*41.0/60.0)-(this.mineralMiners%2)*21.0/60.0;
        //The gas value is increased by the number of gas miners times by 38/60
        this.gas+=this.gasMiners*38/60;
        //For each event in the calendar, if the even'ts time is the current time, call that event's buildable's build method
        //with this game as a parameter, and remove the item from the calendar, then reduce the index of the item being checked
        //by 1 to avoid skipping over any events
        for (int i=0; i<calendar.size(); i++) {
            if(calendar.get(i).time==this.time){
                calendar.get(i).buildable.build(this);
                this.calendar.remove(i);
                i--;
            }

        }
    }

    /**
     * This method is a constructor that takes a game object as a parameter, and sets all of the new games properties to the properties of the parameter game
     *
     * @param game The game that needs to be copied
     */
    public Game(Game game){
        time=game.time;
        minerals=game.minerals;
        gas=game.gas;
        nexus=game.nexus;
        pylon=game.pylon;
        assimilator=game.assimilator;
        gateway=game.gateway;
        cyberneticsCore=game.cyberneticsCore;
        roboticsFacility=game.roboticsFacility;
        stargate=game.stargate;
        twilightCouncil=game.twilightCouncil;
        templarArchives=game.templarArchives;
        darkShrine=game.darkShrine;
        roboticsBay=game.roboticsBay;
        fleetBeacon=game.fleetBeacon;
        probe=game.probe;
        zealot=game.zealot;
        stalker=game.stalker;
        sentry=game.sentry;
        observer=game.observer;
        immortal=game.immortal;
        phoenix=game.phoenix;
        voidRay=game.voidRay;
        colossus=game.colossus;
        highTemplar=game.highTemplar;
        darkTemplar=game.darkTemplar;
        carrier=game.carrier;
        gasMiners=game.gasMiners;
        mineralMiners=game.mineralMiners;
        availableNexus=game.availableNexus;
        availableGateway=game.availableGateway;
        availableRobotics=game.availableRobotics;
        availableStargate=game.availableStargate;
        availabeProbe=game.availabeProbe;
        calendar = new ArrayList<>(game.calendar);
        buildOrder=new ArrayList<>(game.buildOrder);
        didntBuild= new ArrayList<>(game.didntBuild);
        this.goal=game.goal;
        this.buildOrderStr = game.buildOrderStr;
    }

    /**
     * This method is a constructor that takes a goal object as a parameter. It creates a new game with all of its properties in their default states, and sets
     * the games's goal property to the goal parameter
     *
     * @param goal The game's goal
     */
    public Game(Goal goal){
        time=0;
        minerals=50;
        gas=0;
        nexus=1;
        pylon=0;
        assimilator=0;
        gateway=0;
        cyberneticsCore=0;
        roboticsFacility=0;
        stargate=0;
        twilightCouncil=0;
        templarArchives=0;
        darkShrine=0;
        roboticsBay=0;
        fleetBeacon=0;
        probe=6;
        zealot=0;
        stalker=0;
        sentry=0;
        observer=0;
        immortal=0;
        phoenix=0;
        voidRay=0;
        colossus=0;
        highTemplar=0;
        darkTemplar=0;
        carrier=0;
        gasMiners=0;
        mineralMiners=6;
        availableNexus=1;
        availableGateway=0;
        availableRobotics=0;
        availableStargate=0;
        availabeProbe=0;
        this.goal = goal;
    }

    /**
     * This method returns an arrayList of all possible, vaguely sensible game states that can be created in the next in game second assuming the player can build only
     * one item each second, or assign a probe to start mining.
     *
     * @param useful A hashset of classes that the game should build
     * @return A list of all possible/sensible game states
     */
    public ArrayList<Game> getPossibleMoves(HashSet<Class> useful){
        //Create a new instance of the AllBuildables class and call the addBuildables method on it
        AllBuildables allBuildables = new AllBuildables();
        allBuildables.addBuildables();

        //Call the tick method on this game state
        this.tick();
        //For each item in the list of all buildable items do the following
        for(int i=0; i<allBuildables.allBuildables.size();i++){
            //Create a new buildable object from the i item in the allBuildables list
            Buildable buildable = allBuildables.allBuildables.get(i);
            //If the item couldn't have been built since the last item was built, is one of the useful items, and can be built in this game state do the following
            if((!didntBuild(buildable)&&allBuildables.isUseful(buildable,useful)&&buildable.canBeBuilt(this))){
                //Create a new game called possibleGame with this game as a parameter
                Game possibleGame = new Game(this);
                //Call the startBuilding method on the i buildable
                possibleGame.startBuilding(allBuildables.allBuildables.get(i));
                //Add the possibleGame to the list of possibleMoves
                this.possibleMoves.add(possibleGame);
            }

        }
        //If there are one or more available probes do the following
        if(this.availabeProbe>=1){
            //Create a new game object called possibleGame with this game as a parameter
            Game possibleGame = new Game(this);
            //Call the startMining method on the possibleGame
            possibleGame.startMining();
            //Add the possibleGame to the possibleMoves list
            this.possibleMoves.add(possibleGame);
            //If the number of gasMiners is less than 3 times the number of assimilators do the following
            if(this.gasMiners<this.assimilator*3){
                //Create a new game called possibleGame2 with this game as a parameter
                Game possibleGame2 = new Game(this);
                //Call the startGasMining on the possibleGame2
                possibleGame2.startGasMining();
                //Add possibleGame2 to this game's list of possible games
                this.possibleMoves.add(possibleGame2);
            }
        }
        //If there are no available miners do the following to simulate a player not building anything in order to wait to build something else
        else{
            //Clear this games didn'tBuild list
            this.didntBuild.clear();
            //Add every buildable that can be built to the didn'tBuild list to simulate all of the items the player could have built and didn't
            for(int i=0; i<allBuildables.allBuildables.size();i++){
                if(allBuildables.allBuildables.get(i).canBeBuilt(this)){
                    didntBuild.add(allBuildables.allBuildables.get(i));
                }
            }
            //Add this game to the possibleMoves list
            this.possibleMoves.add(new Game(this));
        }
        //Return this game's list of possible moves
        return this.possibleMoves;
    }

    /**
     * This method takes a buildable as a parameter and returns true if the game could have built the buildable could have been built
     * since the last item was built but wasn't. This simulates a player not building something when they can in order to wait to build something else,
     * and prevents game states from being a created that waited to build something when it wasn't needed.
     *
     * @param buildable The item being checked
     * @return True if the item could have been built since the last item was built but wasn't
     */
    public Boolean didntBuild(Buildable buildable){
        //Instantiate a boolean called didntBuild as false
        Boolean didntBuild=false;
        //For each item in the game's didntBuild list, if the item's class is the same as the buildable parameter's class, set didntBuild to true
        for (Buildable item: this.didntBuild
             ) {
            if(item.getClass().equals(buildable.getClass())){
                didntBuild=true;
            }
        }
        //Return didntBuild
        return didntBuild;
    }

    /**
     * This method checks if a buildable has started to be built by the game, and returns true if it has
     *
     * @param buildable The item to be checked
     * @return True if the game has started to build the item
     */
    public Boolean hasBeenBuilt(Buildable buildable){
        //Instantiate a boolean called hasBeenBuilt as false
        Boolean beenBuilt=false;
        //For each buildable in the buildOrder list, if the buildable's class is the same as the class of the item being checked, set beenBuilt to true
        for (Buildable item: this.buildOrder
                ) {
            if(item.getClass().equals(buildable.getClass())){
                beenBuilt=true;
            }
        }
        //Return beenBuilt
        return beenBuilt;
    }

}
