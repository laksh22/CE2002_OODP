package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entities.Movie;

/**
 * This class represents the database which stores all the Movies
 *
 * @author Gan Shyan
 */
public class MovieDB {

    /**
     * File path to text file
     */
    private static final String FILE_PATH = "./movie_db.txt";

    /**
     * List of all movies in the database
     */
    private static List<Movie> movieList = new ArrayList<>();

    /**
     * Static instance of this database
     */
    private static MovieDB instance;

    /**
     * Private constructor to prevent user to instantiate this class directly
     */
    private MovieDB() {
        openDatabase();
        //createDatabase();
    }

    /**
     * Singleton pattern to get the instance of the Movie Database
     *
     * @return Static instance of this database
     */
    public static MovieDB getInstance() {
        if (instance == null) {
            instance = new MovieDB();
        }
        return instance;
    }

    /**
     * Getter method
     *
     * @return Current list of movies in the database
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Write ArrayList to the txt file
     */
    public void saveDatabase() {
        try {
            FileOutputStream fos =
                    new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);
            oos.writeObject(movieList); // Save arraylist to txt file
            oos.close();
        } catch (IOException ioe) {
            System.out.println("Exception");
            ioe.printStackTrace();
        }
    }

    /**
     * Open the database by reading the text file
     */
    private void openDatabase() {
        try {
            FileInputStream fos =
                    new FileInputStream(FILE_PATH);
            ObjectInputStream oos =
                    new ObjectInputStream(fos);
            try {
                movieList = ((ArrayList<Movie>) oos.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            oos.close();
        } catch (IOException ioe) {
            System.out.println("Exception");
            ioe.printStackTrace();
        }
    }

    /**
     * Create the movie database for the first time only
     */
    private void createDatabase() {
        ArrayList<String> casts1 = new ArrayList<>();
        casts1.add("Scarlett Johansson");
        casts1.add("Robert Downey, Jr.");
        casts1.add("Chris Hemsworth");
        casts1.add("Mark Ruffalo");
        casts1.add("Jeremy Renner");
        movieList.add(new Movie("Avengers: Endgame", 182, Movie.BLOCKBUSTER, Movie.END_OF_SHOWING, "After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance",
                " Anthony Russo", casts1, Movie.PG, 0));

        ArrayList<String> casts2 = new ArrayList<>();
        casts2.add("Linda Hamilton");
        casts2.add("Arnold Schwarzenegger");
        casts2.add("Mackenzie Davis");
        casts2.add("Gabriel Luna");
        casts2.add("Natalia Reyes");
        movieList.add(new Movie("Terminator: Dark Fate", 134, Movie.BLOCKBUSTER, Movie.NOW_SHOWING, "In Mexico City, a newly modified liquid Terminator -- the Rev-9 model -- arrives from the future to kill a young factory worker named Dani Ramos. Also sent back in time is Grace, a hybrid cyborg human who must protect Ramos from the seemingly indestructible robotic assassin. But the two women soon find some much-needed help from a pair of unexpected allies -- seasoned warrior Sarah Connor and the T-800 Terminator.",
                "Tim Miller", casts2, Movie.NC16, 0));

        ArrayList<String> cast3 = new ArrayList<>();
        cast3.add("Jesse Eisenberg");
        cast3.add("Woody Harrelson");
        cast3.add("Zoey Deutch");
        cast3.add("Rosario Dawson");
        cast3.add("Luke Wilson");

        movieList.add(new Movie("Zombieland: Double Tap", 99, Movie.HORROR, Movie.NOW_SHOWING, "Zombie slayers Tallahassee, Columbus, Wichita and Little Rock leave the confines of the White House to travel to Graceland in Memphis, Tenn. Along the way, they encounter other post-apocalyptic warriors and a group of survivors who find refuge in a commune. The scrappy fighters must now rely on their wits and weapons more than ever as they soon find themselves in a relentless battle against smarter, faster and seemingly indestructible zombies.",
                "Ruben Fleischer", cast3, Movie.M18, 0));

        ArrayList<String> cast4 = new ArrayList<>();
        cast4.add("Kristen Stewart");
        cast4.add("Naomi Scott");
        cast4.add("Elizabeth Banks");
        cast4.add("Ella Balinska");

        movieList.add(new Movie("Charlie's Angels", 138, Movie.BLOCKBUSTER, Movie.NOW_SHOWING, "When a systems engineer blows the whistle on a dangerous technology, Charlie's Angels from across the globe are called into action, putting their lives on the line to protect society.",
                "Elizabeth Banks", cast4, Movie.PG, 0));

        ArrayList<String> cast5 = new ArrayList<>();
        cast5.add("Angelina Jolie");
        cast5.add("Michelle Pfeiffer");
        cast5.add("Harris Dickinson");
        cast5.add("Chiwetel Ejiofor");
        movieList.add(new Movie("Maleficent: Mistress of Evil", Movie.FANTASY, 118, Movie.NOW_SHOWING, "Maleficent travels to a grand old castle to celebrate young Aurora's upcoming wedding to Prince Phillip. While there, she meets Aurora's future mother-in-law -- a conniving queen who hatches a devious plot to destroy the land's fairies. Hoping to stop her, Maleficent joins forces with a seasoned warrior and a group of outcasts to battle the queen and her powerful army.",
                "Joachim Rønning", cast5, Movie.PG, 0));

        ArrayList<String> cast6 = new ArrayList<>();
        cast6.add("Christian Bale");
        cast6.add("Matt Damon");
        cast6.add("Jon Bernthal");
        cast6.add("Caitriona Balfe");
        movieList.add(new Movie("Ford v Ferrari", 152, Movie.HISTORY, Movie.PREVIEW, "American automotive designer Carroll Shelby and fearless British race car driver Ken Miles battle corporate interference, the laws of physics and their own personal demons to build a revolutionary vehicle for the Ford Motor Co. Together, they plan to compete against the race cars of Enzo Ferrari at the 24 Hours of Le Mans in France in 1966.",
                "James Mangold", cast6, Movie.PG, 0));

        ArrayList<String> cast7 = new ArrayList<>();
        cast7.add("Adam Sandler");
        cast7.add("Idina Menzel");
        cast7.add("Lakeith Stanfield");
        cast7.add("Kevin Garnett");
        movieList.add(new Movie("Uncut Gems", 134, Movie.CRIME, Movie.PREVIEW, "A charismatic jeweler makes a high-stakes bet that could lead to the windfall of a lifetime. In a precarious high-wire act, he must balance business, family and adversaries on all sides in pursuit of the ultimate win.",
                " Josh Safdie", cast7, Movie.NC16, 0));

        ArrayList<String> cast8 = new ArrayList<>();
        cast8.add("Daisy Ridley");
        cast8.add("John Boyega");
        cast8.add("Carrie Fisher");
        cast8.add("Oscar Isaac");
        movieList.add(new Movie("Star Wars: Episode IX: The Rise Of Skywalker (2019)", 155, Movie.BLOCKBUSTER, Movie.COMING_SOON, "The surviving Resistance faces the First Order once more as Rey, Finn and Poe Dameron's journey continues. With the power and knowledge of generations behind them, the final battle commences.",
                "J.J. Abrams", cast8, Movie.PG, 0));

        saveDatabase();
    }
}
