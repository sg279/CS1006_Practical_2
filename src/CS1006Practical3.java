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
        while(!goalCompleted){
            Set<Game> temp = new HashSet<Game>();
            for (Game possibleGame: games
                 ) {
                if (possibleGame.zealot==1){
                    System.out.println("complete");
                    goalCompleted=true;
                }
                else{
                    temp.addAll(possibleGame.getPossibleMoves());
                }
            }
            games.clear();
            games.addAll(temp);

        }
    }
}
