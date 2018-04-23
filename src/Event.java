/**
 * This class defines an event object. An event object contains a buildable and an integer as properties, with the integer representing the time the object will be finished.
 * Objects of this type are made to be added to a game's calendar property.
 */
public class Event {
    Buildable buildable;
    int time;

    Event (Buildable buildable, int time){
        this.buildable=buildable;
        this.time=time;
    }
}
