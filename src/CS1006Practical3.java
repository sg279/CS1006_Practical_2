import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The main class. This class contains code to parse the commandLine arguments and get possible game states until one of them ahs meth the goals required.
 */
public class CS1006Practical3 {
    public static void main (String[] args){
        if (args.length != 1) {
            System.out.println("Usage: CS1006Practical3 goalNumber");
            return;
        }
        ArrayList<Buildable> goalBuildables = new ArrayList<Buildable>();

        //depending on what basic option the user wants initialize goalBuildables differently.
        switch (args[0]) {
            case "1":
                goalBuildables.add(new Zealot());
                goalBuildables.addAll(Arrays.asList(new Stalker(), new Stalker(), new Stalker(), new Stalker()));
                goalBuildables.addAll(Arrays.asList(new Immortal(), new Immortal()));
                goalBuildables.addAll(Arrays.asList(new Colossus(), new Colossus()));
                break;
            case "2":
                goalBuildables.addAll(Arrays.asList(new Zealot(), new Zealot(), new Zealot(), new Zealot(), new Zealot(), new Zealot()));
                goalBuildables.addAll(Arrays.asList(new Stalker(), new Stalker()));
                goalBuildables.addAll(Arrays.asList(new Sentry(), new Sentry(), new Sentry()));
                goalBuildables.addAll((Arrays.asList(new VoidRay(), new VoidRay(), new VoidRay(), new VoidRay())));
                break;
            case "3":
                goalBuildables.addAll(Arrays.asList(new Zealot(), new Zealot()));
                goalBuildables.addAll(Arrays.asList(new Stalker(), new Stalker()));
                goalBuildables.add(new Sentry());
                goalBuildables.addAll(Arrays.asList(new Colossus(), new Colossus(), new Phoenix(), new Phoenix(), new Phoenix(), new Phoenix(), new Phoenix()));

                break;
            case "4":
                for (int i = 0; i<10; i++)
                    goalBuildables.add(new Zealot());
                for (int i = 0; i<7; i++)
                    goalBuildables.add(new Stalker());
                goalBuildables.addAll(Arrays.asList(new Sentry(), new Sentry(), new HighTemplar(), new HighTemplar(), new HighTemplar()));
                break;
            case "5":
                for (int i = 0; i<8; i++)
                    goalBuildables.add(new Zealot());
                for (int i = 0; i<10; i++)
                    goalBuildables.add(new Stalker());
                goalBuildables.addAll(Arrays.asList(new Sentry(), new Sentry(), new Immortal(), new Observer(), new Carrier(), new Carrier(), new Carrier(), new DarkTemplar(), new DarkTemplar()));
                break;
        }


        //Create a new goal object with the goalBuildables arraylist as a parameter
        Goal goal = new Goal(goalBuildables);
        //Instantiate a boolean called goalCompleted as false
        Boolean goalCompleted=false;
        //Created a new hashset of Class objects called useful
        HashSet<Class> useful = new HashSet<Class>();
        //For each item in the goalBuildables arrayList, add the item's class and the class of all buildables the item is dependent on to the hashset.
        //This removes duplicates in the list of useful objects. The dependentOn list could be changed to a list of classes and be slightly more efficient,
        //but for now this works
        for (Buildable i: goalBuildables
             ) {
            useful.add(i.getClass());
            for (Buildable j: i.getDependentOn()
                 ) {
                useful.add(j.getClass());
            }
        }
        //Add a probe class to the useful hashset
        useful.add(Probe.class);
        //Create a new game object with the goal object as a parameter
        Game game = new Game(goal);
        //Create a new hashset of game objects called games
        Set<Game> games = new HashSet<Game>() {};
        //Add game to the hashset
        games.add(game);
        //While the goalCompleted boolean is false
        while(!goalCompleted){
            //Create a new arraylist of games called temp
            ArrayList<Game> temp = new ArrayList<>();
            //For each game in the games hashset do the following
            for (Game possibleGame: games
                 ) {
                //If the goalCompleted method with the game as a parameter returns true, and the goalCompleted method is false (preventing this from happening for
                //any other games that may complete the goal at the same time) Print the buildOrder string and set goalCompleted to true
                if (goal.goalCompleted(possibleGame)&&!goalCompleted){
                    System.out.println("-----------------------------");
                    System.out.println(possibleGame.buildOrderStr);
                    goalCompleted=true;
                }
                //Otherwise, add all games returned by the getPossibleMoves method called with the useful set as a parameter to the temp list,
                //and while the temp list has more than 1000 objects, delete a random object
                else{
                    temp.addAll(possibleGame.getPossibleMoves(useful));
                    while(temp.size()>1000){
                        temp.remove((int) Math.floor(Math.random() * 1001));
                    }
                }
            }
            //Clear the games set and all of the items in the temp list
            games.clear();
            games.addAll(temp);

        }
    }
}
