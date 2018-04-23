import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class exists so that if other sections of the code need to iterate through each type of buildable a new list doesn't have to be created.
 * It also contains a method that is accessed to check if a buildable object is in a list of buildable objects
  */
public class AllBuildables {
    //An arraylist of buildables that will contain one of each type of buildable
    ArrayList<Buildable> allBuildables = new ArrayList<>();

    /**
     * This method returns nothing and takes no parameters, it simply adds one of each type of buildable to the allbuildables property
     */
    public void addBuildables(){
        this.allBuildables.add(new Nexus());
        this.allBuildables.add(new Pylon());
        this.allBuildables.add(new Assimilator());
        this.allBuildables.add(new Gateway());
        this.allBuildables.add(new CyberneticsCore());
        this.allBuildables.add(new RoboticsFacility());
        this.allBuildables.add(new Stargate());
        this.allBuildables.add(new TwilightCouncil());
        this.allBuildables.add(new TemplarArchives());
        this.allBuildables.add(new DarkShrine());
        this.allBuildables.add(new RoboticsBay());
        this.allBuildables.add(new FleetBeacon());
        this.allBuildables.add(new Probe());
        this.allBuildables.add(new Zealot());
        this.allBuildables.add(new Stalker());
        this.allBuildables.add(new Sentry());
        this.allBuildables.add(new Observer());
        this.allBuildables.add(new Immortal());
        this.allBuildables.add(new Phoenix());
        this.allBuildables.add(new VoidRay());
        this.allBuildables.add(new Colossus());
        this.allBuildables.add(new HighTemplar());
        this.allBuildables.add(new DarkTemplar());
        this.allBuildables.add(new Carrier());
    }

    /**
     *This method takes a buildable and a hashset of classes as parameters, and returns
     *true if the buildable item's class is the same as any of the classes in the hashset
     * @param buildable The buildable item being searched for
     * @param useful The hashset of classes
     * @return Returns true if the buildable exists in the set of buildables
     */
    public boolean isUseful(Buildable buildable,HashSet<Class> useful){
        Boolean isUseful = false;
        //Iterate through each class in the set, and if the class is the same as the buildable's class, set isUseful to true
        for (Class i: useful
             ) {
            if(i.equals(buildable.getClass())){
                isUseful=true;
            }
        }
        return isUseful;
    }
}
