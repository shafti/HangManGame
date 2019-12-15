package hangmangame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Initializes the hangManGame with the values to be used.
 * 
 * @author claude Lalanne
 * @author claude.r.lalanne@gmail.com
 */
public class GameInitializer {
    private int counter = 10;
    private int index;
    private ArrayList<String> movieTitleAndHints;
    private String[] movieAndHint = new String[2];
    private StringBuilder movieSelected = new StringBuilder();
    private ArrayList<Character> letters = new ArrayList<>();
    
    /**
     * Constructor will create the ArrayList with information from the loader.
     * @param movieList loader ArrayList
     */
    public GameInitializer(ArrayList<String> movieList){
        movieTitleAndHints = movieList;
    }
    
    /**
     * Calling method used to organize order of methods used to play game.
     */
    public void playGame(){
        welcomeMessage();
        setMovieAndHint();
        hideMovieSelected(movieAndHint);        
        System.out.println("HINT: " + movieAndHint[1]);
        System.out.println(movieSelected);
        
        for(int i = 9; i >=0; i--){
            char letter = promptForLetter();
            i+= evaluateAndSet(letter,movieAndHint, movieSelected);
            System.out.println(movieSelected);
            
            if(movieAndHint[0].equals(movieSelected.toString())) {
                System.out.println("Correct Guess!");
                break;
            }
            if(i == 0) {
                System.out.println("You ran out of guesses.");
            }
            System.out.println(i +" guesses left");
        }
        System.out.println("The name of the Movie: " + movieAndHint[0]);
        //resets the values for the next game
        movieSelected.setLength(0);
        letters.clear();
        System.out.println();        
    }
    
    /**
     * A description of how to play the game
     */
    public void welcomeMessage(){
        System.out.println("Welcome to - Guess The Movie!");
        System.out.println("Use the hint to Guess the movie");
        System.out.println("You have 10 incorrect guesses\n");        
    }
    
    /**
     * randomly selects the movie to use.  Movie name and hint are stored
     * in array.
     */
    private void setMovieAndHint(){
        Random random = new Random();
        index = random.nextInt(movieTitleAndHints.size());
        String movieNameInitial = movieTitleAndHints.get(index);
        movieAndHint = movieNameInitial.split(","); 
    }
    
    /**
     * creates the underscores that makes up name of movie.
     * @param movieAndHint name of random movie  
     */
     private void hideMovieSelected(String[] movieAndHint){
        for(int i = 0; i < movieAndHint[0].length(); i++){
            if(movieAndHint[0].charAt(i)== ' '){
                movieSelected.append(' ');
            }else{
                movieSelected.append('-');
            }
        }        
    }
     /**
      * Prompts user to enter a guess.  Only first character is used.
      * @return the character selected by the user
      */
     public char promptForLetter(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");        
        char charSelected = input.next().toUpperCase().charAt(0);
        System.out.println();
        return charSelected;
    }
     /**
      * stores the user selected char in a list, verifies that the guess is a 
      * character in the movie name
      * @param letter user guess
      * @param movieAndHint movie that was selected
      * @param movieSelected the underscore string that is being guessed
      * @return if a guess is correct does not decrement the number of guesses.
      */
     public int evaluateAndSet(char letter, String[] movieAndHint, StringBuilder movieSelected){
         int increment = 0;
        letters.add(letter);
        for(int i =0; i<movieAndHint[0].length(); i++){
            if(movieAndHint[0].charAt(i)==letter) {
                movieSelected.setCharAt(i, letter);
                increment = 1;
            }
        }  
        System.out.println("Letters selected: " + letters.toString());
        return increment;
    }

}
