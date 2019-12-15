package hangmangame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class allows you to play a game of hangman
 * 
 * @author Claude Lalanne
 * @author claude.r.lalanne@gmail.com
 */
public class HangManGame {
    
    public static void main(String[] args) {
        //filename to load movies and hints
        Loader load = new Loader("movies.txt");
        GameInitializer game = new GameInitializer(load.getMovieTitleAndHints());
        Scanner input = new Scanner(System.in);        
                
        char play = 'Y';
        
        while(play =='Y'){
            game.playGame();
            System.out.print("would you like to play again?: ");            
            play = input.nextLine().toUpperCase().charAt(0);
            System.out.println();
        }
    }    
}