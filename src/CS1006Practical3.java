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
        //game.getPossibleMoves();
        System.out.println("1");
        Boolean goalCompleted=false;
        ArrayList<Buildable> useful = new ArrayList<>();
        useful.add(new Gateway());
        useful.add(new Probe());
        useful.add(new Zealot());
        useful.add(new Pylon());
        while(!goalCompleted){
            Set<Game> temp = new HashSet<Game>();
            for (Game possibleGame: games
                 ) {
                if (possibleGame.zealot==1){
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
