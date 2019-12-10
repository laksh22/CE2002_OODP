package manager;

import java.util.List;

import database.MovieDB;
import database.MovieListingDB;
import entities.Movie;
import entities.MovieListing;
import factory.MovieListingDAOFactory;
import movielistingdao.ICustomerMovieListingDAO;

/**
 * Control class for accessing the movie listings database for CUSTOMERS
 *
 * @author Gan Shyan
 */
public class CustomerMovieListingManager {

    /**
     * MovieDB attribute
     */
    private MovieDB movieDB;
    /**
     * MovieListingDB attribute
     */
    private MovieListingDB movieListingDB;
    /**
     * ICustomerMovieListingDAO attribute
     */
    private ICustomerMovieListingDAO dbdao;

    /**
     * Constructor
     */
    public CustomerMovieListingManager() {
        movieListingDB = MovieListingDB.getInstance();
        movieDB = MovieDB.getInstance();
        dbdao = (ICustomerMovieListingDAO) MovieListingDAOFactory.getMovieListingDBDAO("CUSTOMER");
    }

    /**
     * Search for a movie by its title
     *
     * @param movieTitle Movie title
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
     * Get all movies in the database
     *
     * @return List of movie listings
     */
    public List<MovieListing> getAllMovieListings() {
        return dbdao.getAllMovieListings(movieListingDB.getMovieList());
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
     * Search for movie listings by the movie title
     *
     * @param filmName Title of movie
     * @return List of movie listings
     */
    public List<MovieListing> searchMovieListingByFilmName(String filmName) {
        return dbdao.searchMovieListingByFilmName(filmName, movieListingDB.getMovieList());
    }

    /**
     * Search for movie listings by cineplex name
     *
     * @param cineplexName Cineplex name
     * @return List of movie listings
     */
    public List<MovieListing> searchMovieListingByCineplex(String cineplexName) {
        return dbdao.searchMovieListingByCineplex(cineplexName, movieListingDB.getMovieList());
    }

}
