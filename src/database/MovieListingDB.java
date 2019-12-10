package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entities.MovieListing;

/**
 * Class that represents the movie listing database
 *
 * @author Gan Shyan
 */
public class MovieListingDB {

    /**
     * File path to text file
     */
    private static final String FILE_PATH = "./movie_listings_db.txt";

    /**
     * List of all movies in the database
     */
    private static List<MovieListing> movieListingsList = new ArrayList<>();

    /**
     * Static instance of this database
     */
    private static MovieListingDB instance;

    /**
     * Private constructor
     */
    private MovieListingDB() {
        openDatabase();
    }

    /**
     * Singleton pattern to get the instance of the Movie Database
     *
     * @return Static instance of this database
     */
    public static MovieListingDB getInstance() {
        if (instance == null) {
            instance = new MovieListingDB();
        }
        return instance;
    }

    /**
     * Getter method
     *
     * @return Current list of movielistings in the database
     */
    public List<MovieListing> getMovieList() {

        return movieListingsList;
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
            oos.writeObject(movieListingsList); // Save arraylist to txt file
            oos.close();
        } catch (IOException ioe) {
            System.out.println("Exception");
            ioe.printStackTrace();
        }
    }

    /**
     * Open the database by reading the text file
     */
    public void openDatabase() {
        try {
            FileInputStream fos =
                    new FileInputStream(FILE_PATH);
            ObjectInputStream oos =
                    new ObjectInputStream(fos);
            try {
                movieListingsList = ((ArrayList<MovieListing>) oos.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            oos.close();
        } catch (IOException ioe) {
            System.out.println("Exception");
            ioe.printStackTrace();
        }
    }

}
