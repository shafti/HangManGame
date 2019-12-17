package hangmangame;

import java.util.Scanner;

/**
 * This class allows you to play a game of hangman using movies.  The movies.txt
 * file is used to upload information into the loader class.  The txt file is in
 * the same folder as this class.
 * 
 * @author Claude Lalanne
 * @author claude.r.lalanne@gmail.com
 */
public class HangManGame {
    
    public static void main(String[] args) {
        //filename to load movies and hints
        Loader load = new Loader("movies.txt");
        Scanner input = new Scanner(System.in);
        GameEngine game = new GameEngine(load.getMovieTitleAndHints());
        game.welcomeMessage();
        
        String play = "Y";        
        while(play.equals("Y")){
            game.playGame();
            while(true){
                System.out.print("Would you like to play again? Enter Y or N ");            
                play = input.nextLine().toUpperCase();
                if(play.equals("Y")|| play.equals("N")) {
                    game.reset();
                    break;
                }else{
                    System.out.println("The value entered is incorrect");
                }
            }            
            System.out.println();
        }
    }    
}