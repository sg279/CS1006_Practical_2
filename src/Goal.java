import java.util.ArrayList;

/**
 * This class is represents the goal game state to be created
 */
public class Goal {
    //Defines the properties for Goal class which are the same as the properties for a game state. The properties also include values for the
    //Maximum amount of gateways, robotics facilities, stargates that should be built.
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
    int maxGateways;
    int maxRobotics;
    int maxStargate;

    /**
     * This method takes a game object as a parameter and checks if the game has started to build all of the items required by the goal and returns
     * true if it has
     *
     * @param game The game being checked
     * @return True if the game has started building all of the required units
     */
    public boolean goalCompleted(Game game){
        //Instantiate a boolean called completed as false, and instantiate integers for all of the game buildable properties as 0
        Boolean completed = false;
        int gameNexus=0;
        int gamePylon=0;
        int gameAssimilator=0;
        int gameGateway=0;
        int gameCyberneticsCore=0;
        int gameRoboticsFacility=0;
        int gameStargate=0;
        int gameTwilightCouncil=0;
        int gameTemplarArchives=0;
        int gameDarkShrine=0;
        int gameRoboticsBay=0;
        int gameFleetBeacon=0;
        int gameProbe=0;
        int gameZealot=0;
        int gameStalker=0;
        int gameSentry=0;
        int gameObserver=0;
        int gameImmortal=0;
        int gamePhoenix=0;
        int gameVoidRay=0;
        int gameColossus=0;
        int gameHighTemplar=0;
        int gameDarkTemplar=0;
        int gameCarrier=0;
        //For every item in the game's build order list, get the item's class and increment the appropriate value
        for (int i=0; i<game.buildOrder.size(); i++){
            Class itemClass = game.buildOrder.get(i).getClass();
            if (itemClass.equals(Assimilator.class)){gameAssimilator++;}
            if (itemClass.equals(CyberneticsCore.class)){gameCyberneticsCore++;}
            if (itemClass.equals(Gateway.class)){gameGateway++;}
            if (itemClass.equals(Immortal.class)){gameImmortal++;}
            if (itemClass.equals(Nexus.class)){gameNexus++;}
            if (itemClass.equals(Observer.class)){gameObserver++;}
            if (itemClass.equals(Phoenix.class)){gamePhoenix++;}
            if (itemClass.equals(Probe.class)){gameProbe++;}
            if (itemClass.equals(Pylon.class)){gamePylon++;}
            if (itemClass.equals(RoboticsFacility.class)){gameRoboticsFacility++;}
            if (itemClass.equals(Sentry.class)){gameSentry++;}
            if (itemClass.equals(Stalker.class)){gameStalker++;}
            if (itemClass.equals(Stargate.class)){gameStargate++;}
            if (itemClass.equals(VoidRay.class)){gameVoidRay++;}
            if (itemClass.equals(Zealot.class)){gameZealot++;}
            if (itemClass.equals(Carrier.class)){gameCarrier++;}
            if (itemClass.equals(Colossus.class)){gameColossus++;}
            if (itemClass.equals(DarkShrine.class)){gameDarkShrine++;}
            if (itemClass.equals(DarkTemplar.class)){gameDarkTemplar++;}
            if (itemClass.equals(FleetBeacon.class)){gameFleetBeacon++;}
            if (itemClass.equals(HighTemplar.class)){gameHighTemplar++;}
            if (itemClass.equals(RoboticsBay.class)){gameRoboticsBay++;}
            if (itemClass.equals(TemplarArchives.class)){gameTemplarArchives++;}
            if (itemClass.equals(TwilightCouncil.class)){gameTwilightCouncil++;}
        }
        //If the goal's buildable properties are less than or equal to the number of each buildable the game started set completed to true
        if(nexus<=gameNexus &&
        pylon<=gamePylon &&
        assimilator<=gameAssimilator &&
        gateway<=gameGateway &&
        cyberneticsCore<=gameCyberneticsCore &&
        roboticsFacility<=gameRoboticsFacility &&
        stargate<=gameStargate &&
        twilightCouncil<=gameTwilightCouncil &&
        templarArchives<=gameTemplarArchives &&
        darkShrine<=gameDarkShrine &&
        roboticsBay<=gameRoboticsBay &&
        fleetBeacon<=gameFleetBeacon &&
        probe<=gameProbe &&
        zealot<=gameZealot &&
        stalker<=gameStalker &&
        sentry<=gameSentry &&
        observer<=gameObserver &&
        immortal<=gameImmortal &&
        phoenix<=gamePhoenix &&
        voidRay<=gameVoidRay &&
        colossus<=gameColossus &&
        highTemplar<=gameHighTemplar &&
        darkTemplar<=gameDarkTemplar &&
        carrier<=gameCarrier){
            completed=true;
        }
        //Return completed
        return completed;
    }

    /**
     * This method is a constructor that takes an arrayList of buildables as a parameter
     *
     * @param goals The list of buildables required by the user
     */
    public Goal(ArrayList<Buildable> goals){
        //Set all of the goal's buildable properties to 0
        nexus=0;
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
        probe=0;
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

        //For each item in the goals buildable arraylist, get the item's class and increment the appropriate property
        for (int i=0; i<goals.size(); i++){
            Class itemClass = goals.get(i).getClass();
            if (itemClass.equals(Assimilator.class)){this.assimilator++;}
            if (itemClass.equals(CyberneticsCore.class)){this.cyberneticsCore++;}
            if (itemClass.equals(Gateway.class)){this.gateway++;}
            if (itemClass.equals(Immortal.class)){this.immortal++;}
            if (itemClass.equals(Nexus.class)){this.nexus++;}
            if (itemClass.equals(Observer.class)){this.observer++;}
            if (itemClass.equals(Phoenix.class)){this.phoenix++;}
            if (itemClass.equals(Probe.class)){this.probe++;}
            if (itemClass.equals(Pylon.class)){this.pylon++;}
            if (itemClass.equals(RoboticsFacility.class)){this.roboticsFacility++;}
            if (itemClass.equals(Sentry.class)){this.sentry++;}
            if (itemClass.equals(Stalker.class)){this.stalker++;}
            if (itemClass.equals(Stargate.class)){this.stargate++;}
            if (itemClass.equals(VoidRay.class)){this.voidRay++;}
            if (itemClass.equals(Zealot.class)){this.zealot++;}
            if (itemClass.equals(Carrier.class)){this.carrier++;}
            if (itemClass.equals(Colossus.class)){this.colossus++;}
            if (itemClass.equals(DarkShrine.class)){this.darkShrine++;}
            if (itemClass.equals(DarkTemplar.class)){this.darkTemplar++;}
            if (itemClass.equals(FleetBeacon.class)){this.fleetBeacon++;}
            if (itemClass.equals(HighTemplar.class)){this.highTemplar++;}
            if (itemClass.equals(RoboticsBay.class)){this.roboticsBay++;}
            if (itemClass.equals(TemplarArchives.class)){this.templarArchives++;}
            if (itemClass.equals(TwilightCouncil.class)){this.twilightCouncil++;}
        }
        //Set all of the maximum properties to 0, and increment them by the number of different types of units the goal
        //requires that require them. Doing this to set the maximum number was done by experimentation, as setting the maximum
        //to the total number of units that require that building resulted in a lot unecessary buildings being built, so the
        //number of different types of units was used instead.
        this.maxGateways=0;
        if(zealot>0){this.maxGateways++;}
        if(stalker>0){this.maxGateways++;}
        if(sentry>0){this.maxGateways++;}
        if(cyberneticsCore>0){this.maxGateways++;}
        if(gateway>0){this.maxGateways++;}
        if(darkTemplar>0){this.maxGateways++;}
        if(highTemplar>0){this.maxGateways++;}
        if(colossus>0){this.maxGateways++;}
        if(carrier>0){this.maxGateways++;}
        this.maxRobotics = 0;
        if(observer>0){this.maxRobotics++;}
        if(immortal>0){this.maxRobotics++;}
        if(roboticsFacility>0){this.maxRobotics++;}
        if(colossus>0){this.maxRobotics++;}
        this.maxStargate = 0;
        if(phoenix>0){this.maxStargate++;}
        if(voidRay>0){this.maxStargate++;}
        if(stargate>0){this.maxStargate++;}
    }
}
