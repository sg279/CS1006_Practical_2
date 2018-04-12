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
    int gasMiners;
    int mineralMiners;
    int availableNexus;
    int availableGateway;
    int availableRobotics;
    int availableStargate;

    ArrayList<Event> calendar = new ArrayList<>();

    public void startBuilding(Buildable buildable){
        this.minerals-=buildable.mineralCost;
        this.gas-=buildable.gasCost;
        Event event = new Event(buildable, this.time+buildable.buildTime);
        if(buildable instanceof Unit){
            //Remove available building, add back on build
            ((Unit) buildable).startBuild(this);
        }
        this.calendar.add(event);
    }

    public void tick(){
        this.time++;
        this.minerals+=(this.mineralMiners*41/60)-(this.mineralMiners%2)*21/60;
        this.gas+=this.gasMiners*38/60;
        for (Event event: this.calendar
             ) {
            if(event.time==this.time){
                event.buildable.build(this);
                this.calendar.remove(event);
            }

        }
    }
}
