package manager;

import java.util.List;

import database.MovieDB;
import database.MovieListingDB;
import entities.Movie;
import entities.MovieListing;
import factory.MovieListingDAOFactory;
import movielistingdao.IAdminMovieListingDAO;

/**
 * Control class for accessing the movie listings database for admins
 *
 * @author Gan Shyan
 */
public class AdminMovieListingManager {

    /**
     * MovieDB attribute
     */
    private MovieDB movieDB;

    /**
     * MovieListingDB attribute
     */
    private MovieListingDB movieListingDB;

    /**
     * IAdminMovieListingDAO attribute
     */
    private IAdminMovieListingDAO dbdao;

    /**
     * Constructor
     *
     * @param type Caller type
     */
    public AdminMovieListingManager(String type) {
        movieListingDB = MovieListingDB.getInstance();
        movieDB = MovieDB.getInstance();
        dbdao = (IAdminMovieListingDAO) MovieListingDAOFactory.getMovieListingDBDAO(type);
    }

    /**
     * Search for a movie listing by id
     *
     * @param id Movie listing id
     * @return Movie Listing
     */
    public MovieListing searchMovieListing(int id) {
        return dbdao.getMovieListing(id, movieListingDB.getMovieList());
    }

    /**
     * Search for a movie by its title
     *
     * @param movieTitle Title of movie
     * @return Movie object
     */
    public Movie searchForMovie(String movieTitle) {
        for (Movie movie : movieDB.getMovieList()) {
            if (movie.getTitle().trim().toUpperCase().equals(movieTitle.trim().toUpperCase())) {
                return movie;
            }
        }
        return null;
    }

    /**
     * This function generates a unique ID for a movie listing, since each movie listing is meant to have a unique ID
     *
     * @return New id
     */
    public int getID() {
        return movieListingDB.getMovieList().size() + 1;
    }

    public List<MovieListing> getAllMovieListings() {
        return dbdao.getAllMovieListings(movieListingDB.getMovieList());
    }

    /**
     * Get a movie listing from the database using the id
     *
     * @param id Movie listing id
     * @return MovieListing object
     */
    public MovieListing getMovieListingByID(int id) {
        return dbdao.searchMovieListingByID(id, movieListingDB.getMovieList());
    }


    /**
     * Insert new movie listing into the database
     *
     * @param movieListing New movie listing object
     */
    public void insertMovieListing(MovieListing movieListing) {
        dbdao.addMovieListing(movieListing, movieListingDB.getMovieList());
    }

    /**
     * Delete movie listing from the database
     *
     * @param movieListing Movie listing object
     */
    public void deleteMovieListing(MovieListing movieListing) {
        dbdao.deleteMovieListing(movieListing, movieListingDB.getMovieList());
    }

    /**
     * Delete a movie listing from the database using the id
     *
     * @param movieListingID id of movie listing
     */
    public void deleteMovieListing(int movieListingID) {
        MovieListing movieListing = getMovieListingByID(movieListingID);
        dbdao.deleteMovieListing(movieListing, movieListingDB.getMovieList());
    }

    /**
     * Save the arraylist database into the text file
     */
    public void saveDatabase() {
        movieListingDB.saveDatabase();
    }

    /**
     * Get all movie listings that are yet to be shown
     *
     * @return List of movie listings
     */
    public List<MovieListing> getAllUpcomingMovieListings() {
        return dbdao.getAllUpcomingMovieListings(movieListingDB.getMovieList());
    }

    /**
     * Get all movie listings that are over
     *
     * @return List of movie listings
     */
    public List<MovieListing> getAllPreviousMovieListings() {
        return dbdao.getAllPreviousMovieListings(movieListingDB.getMovieList());
    }

    /**
     * Get all movie listings that are cancelled
     *
     * @return List of movie listings
     */
    public List<MovieListing> getAllCancelledMovieListings() {
        return dbdao.getAllCancelledMovieListings(movieListingDB.getMovieList());
    }

}
