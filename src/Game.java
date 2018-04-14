import java.util.ArrayList;
import java.util.Calendar;

public class Game {
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
    int probe;
    int zealot;
    int stalker;
    int sentry;
    int observer;
    int immortal;
    int phoenix;
    int voidRay;
    int gasMiners;
    int mineralMiners;
    int availableNexus;
    int availableGateway;
    int availableRobotics;
    int availableStargate;
    int availabeProbe;

    private ArrayList<Event> calendar = new ArrayList<>();
    private ArrayList<Game> possibleMoves = new ArrayList<>();

    public void startBuilding(Buildable buildable){
        this.minerals-=buildable.getMineralCost();
        this.gas-=buildable.getGasCost();
        Event event = new Event(buildable, this.time+buildable.getBuildTime());
        if(buildable instanceof Unit){
            //Remove available building, add back on build
            ((Unit) buildable).startBuild(this);
        }
        this.calendar.add(event);
    }

    public void startMining(){
        this.availabeProbe--;
        this.mineralMiners++;
    }

    public void startGasMining(){
        if(this.gasMiners<this.assimilator*3&&this.availabeProbe>=1){
            this.gasMiners++;
            this.availabeProbe--;
        }
    }

    public void tick(){
        this.time++;
        this.minerals+=(this.mineralMiners*41.0/60.0)-(this.mineralMiners%2)*21.0/60.0;
        this.gas+=this.gasMiners*38/60;
        for (Event event: this.calendar
             ) {
            if(event.time==this.time){
                event.buildable.build(this);
                this.calendar.remove(event);
            }

        }
    }

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
        probe=game.probe;
        zealot=game.zealot;
        stalker=game.stalker;
        sentry=game.sentry;
        observer=game.observer;
        immortal=game.immortal;
        phoenix=game.phoenix;
        voidRay=game.voidRay;
        gasMiners=game.gasMiners;
        mineralMiners=game.mineralMiners;
        availableNexus=game.availableNexus;
        availableGateway=game.availableGateway;
        availableRobotics=game.availableRobotics;
        availableStargate=game.availableStargate;
        availabeProbe=game.availabeProbe;
        calendar = new ArrayList<Event>(game.calendar);
    }

    public Game(){
        time=0;
        minerals=300;
        gas=300;
        nexus=1;
        pylon=1;
        assimilator=1;
        gateway=1;
        cyberneticsCore=1;
        roboticsFacility=1;
        stargate=1;
        probe=6;
        zealot=0;
        stalker=0;
        sentry=0;
        observer=0;
        immortal=0;
        phoenix=0;
        voidRay=0;
        gasMiners=3;
        mineralMiners=3;
        availableNexus=1;
        availableGateway=1;
        availableRobotics=1;
        availableStargate=1;
        availabeProbe=1;
    }

    public void getPossibleMoves(){
        AllBuildables allBuildables = new AllBuildables();
        allBuildables.addBuildables();

        this.tick();
        for(int i=0; i<allBuildables.allBuildables.size();i++){
            if(allBuildables.allBuildables.get(i).canBeBuilt(this)){
                Game possibleGame = new Game(this);
                possibleGame.startBuilding(allBuildables.allBuildables.get(i));
                this.possibleMoves.add(possibleGame);
            }

        }
        if(this.availabeProbe>=1){
            Game possibleGame = new Game(this);
            possibleGame.startMining();
            Game possibleGame2 = new Game(this);
            possibleGame2.startGasMining();
            this.possibleMoves.add(possibleGame);
            this.possibleMoves.add(possibleGame2);
        }
        this.possibleMoves.add(new Game(this));
    }

}
