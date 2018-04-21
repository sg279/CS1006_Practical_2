import java.util.ArrayList;

public class Goal {
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
    int maxGateways = zealot+stalker+sentry+cyberneticsCore+gateway+highTemplar+darkTemplar;
    int maxRobotics = observer+immortal+roboticsFacility+colossus;
    int maxStargate = phoenix+voidRay+stargate+carrier;

    public boolean goalCompleted(Game game){
        Boolean completed = false;
        if(nexus<=game.nexus &&
        pylon<=game.pylon &&
        assimilator<=game.assimilator &&
        gateway<=game.gateway &&
        cyberneticsCore<=game.cyberneticsCore &&
        roboticsFacility<=game.roboticsFacility &&
        stargate<=game.stargate &&
        twilightCouncil<=game.twilightCouncil &&
        templarArchives<=game.templarArchives &&
        darkShrine<=game.darkShrine &&
        roboticsBay<=game.roboticsBay &&
        fleetBeacon<=game.fleetBeacon &&
        probe<=game.probe &&
        zealot<=game.zealot &&
        stalker<=game.stalker &&
        sentry<=game.sentry &&
        observer<=game.observer &&
        immortal<=game.immortal &&
        phoenix<=game.phoenix &&
        voidRay<=game.voidRay &&
        colossus<=game.colossus &&
        highTemplar<=game.highTemplar &&
        darkTemplar<=game.darkTemplar &&
        carrier<=game.carrier){
            completed=true;
        }
        return completed;
    }

    public Goal(ArrayList<Buildable> goals){
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
            this.maxGateways = zealot+stalker+sentry+cyberneticsCore+gateway+darkTemplar+highTemplar+colossus+carrier;
            this.maxRobotics = observer+immortal+roboticsFacility+colossus;
            this.maxStargate = phoenix+voidRay+stargate;
        }
    }
}
