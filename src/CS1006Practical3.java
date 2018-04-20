import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CS1006Practical3 {
    public static void main (String[] args){

        ArrayList<Buildable> goalBuildables = new ArrayList<Buildable>(Arrays.asList(new Zealot()));
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
            Set<Game> temp = new HashSet<Game>();
            for (Game possibleGame: games
                 ) {
                if (goal.goalCompleted(possibleGame)){
                    System.out.println("complete");
                    goalCompleted=true;
                }
                else{
                    temp.addAll(possibleGame.getPossibleMoves(useful));
                }
            }
            games.clear();
            games.addAll(temp);

        }
    }
}
