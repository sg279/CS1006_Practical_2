import java.lang.reflect.Array;
import java.util.ArrayList;

public class CS1006Practical3 {
    public static void main (String[] args){

        Game game = new Game();
        ArrayList<Game> games = new ArrayList<Game>();
        games.add(game);
        //game.getPossibleMoves();
        System.out.println("1");
        Boolean goalCompleted=false;
        while(!goalCompleted){
            ArrayList<Game> temp = new ArrayList<>();
            for (Game possibleGame: games
                 ) {
                if (possibleGame.pylon==2){
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
