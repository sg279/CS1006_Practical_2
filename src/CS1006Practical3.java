import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CS1006Practical3 {
    public static void main (String[] args){

        Game game = new Game();
        Set<Game> games = new HashSet<Game>() {
        };
        games.add(game);
        Boolean goalCompleted=false;
        ArrayList<Buildable> useful = new ArrayList<>();
        useful.add(new Gateway());
        useful.add(new Probe());
        useful.add(new Stalker());
        useful.add(new Pylon());
        useful.add(new CyberneticsCore());
        useful.add(new Assimilator());
        while(!goalCompleted){
            Set<Game> temp = new HashSet<Game>();
            for (Game possibleGame: games
                 ) {
                if (possibleGame.stalker==1){
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
