import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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


        Goal goal = new Goal(goalBuildables);
        Boolean goalCompleted=false;
        HashSet<Buildable> useful = new HashSet<>(goalBuildables);
        useful.add(new Probe());
        for (Buildable goalBuildable: goalBuildables
             ) {
            useful.addAll(goalBuildable.getDependentOn());
        }
        Game game = new Game(goal);
        Set<Game> games = new HashSet<Game>() {};
        games.add(game);
        while(!goalCompleted){
            ArrayList<Game> temp = new ArrayList<>();
            for (Game possibleGame: games
                 ) {
                if (goal.goalCompleted(possibleGame)&&!goalCompleted){
                    System.out.println("complete");
                    goalCompleted=true;
                }
                else{
                    temp.addAll(possibleGame.getPossibleMoves(useful));
                    while(temp.size()>1000){
                        temp.remove((int) Math.floor(Math.random() * 1001));
                    }
                }
            }
            games.clear();
            games.addAll(temp);

        }
    }
}
