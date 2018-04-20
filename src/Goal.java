import java.util.ArrayList;

public class Goal {
    int nexus;
    int pylon;
    int assimilator;
    int gateway;
    int cyberneticsCore;
    int roboticsFacility;
    int stargate;
    int probe;
    int zealot;
    int stalker;
    int sentry;
    int observer;
    int immortal;
    int phoenix;
    int voidRay;
    int maxGateways = zealot+stalker+sentry+cyberneticsCore+gateway;
    int maxRobotics = observer+immortal+roboticsFacility;
    int maxStargate = phoenix+voidRay+stargate;

    public boolean goalCompleted(Game game){
        Boolean completed = false;
        if(nexus==game.nexus &&
        pylon==game.pylon &&
        assimilator==game.assimilator &&
        gateway==game.gateway &&
        cyberneticsCore==game.cyberneticsCore &&
        roboticsFacility==game.roboticsFacility &&
        stargate==game.stargate &&
        probe>=game.probe &&
        zealot==game.zealot &&
        stalker==game.stalker &&
        sentry==game.sentry &&
        observer==game.observer &&
        immortal==game.immortal &&
        phoenix==game.phoenix &&
        voidRay==game.voidRay){
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
        probe=0;
        zealot=0;
        stalker=0;
        sentry=0;
        observer=0;
        immortal=0;
        phoenix=0;
        voidRay=0;

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
            this.maxGateways = zealot+stalker+sentry+cyberneticsCore+gateway;
            this.maxRobotics = observer+immortal+roboticsFacility;
            this.maxStargate = phoenix+voidRay+stargate;
        }
    }
}
