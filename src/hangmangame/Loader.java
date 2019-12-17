package hangmangame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class loads the information from a file and creates an ArrayList
 * of the lines in the file
 * 
 * @author Claude Lalanne
 * @author claude.r.lalanne@gmail.com
 */
public class Loader {
    private File file;
    private ArrayList<String> movieTitleAndHints;
    
    /**
     * Constructor loads the file information into the ArrayList
     * @param loadFile file to be loaded
     */
    public Loader(String loadFile) {
        file = new File(loadFile);
        try {
            Scanner sc = new Scanner(file);
            movieTitleAndHints = new ArrayList<>();
            while (sc.hasNext()) {
                movieTitleAndHints.add(sc.nextLine());
            }            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HangManGame.class.getName()).log(Level.SEVERE, loadFile + " Not Found");
            System.exit(0);
        }
    }

    /**
     * Gets the movie title and hint
     * @return the movieTitleAndHints
     */
    public ArrayList<String> getMovieTitleAndHints() {
        return movieTitleAndHints;
    }    
}