package manager;

import java.util.List;

import database.MovieDB;
import entities.Movie;
import factory.MovieDAOFactory;
import moviedao.ICustomerMovieDAO;

/**
 * Control class for accessing the movie database for CUSTOMERS
 *
 * @author Gan Shyan
 */
public class CustomerMovieManager {
    /**
     * The movie database
     */
    private MovieDB movieDB;

    /**
     * The movie database data access object
     */
    private ICustomerMovieDAO dbdao;

    /**
     * Constructor
     */
    public CustomerMovieManager() {
        movieDB = MovieDB.getInstance();
        dbdao = (ICustomerMovieDAO) MovieDAOFactory.getMovieDBDAO("CUSTOMER");
    }

    /**
     * Save changes to the database
     */
    public void saveDatabase() {
        movieDB.saveDatabase();
    }

    /**
     * Get all movies in database
     *
     * @return List of movies
     */
    public List<Movie> getAllMovies() {
        return dbdao.getAllMovies(movieDB.getMovieList());
    }

    /**
     * Search for movie by its name
     *
     * @param name Title of movie
     * @return Movie object
     */
    public Movie searchMovie(String name) {
        return dbdao.getMovie(name, movieDB.getMovieList());
    }

    /**
     * Get all movies that are upcoming
     *
     * @return List of movie
     */
    public List<Movie> getAllUpComingMovies() {
        return dbdao.getUpcomingMovies(movieDB.getMovieList());
    }

    /**
     * Get all movies that are in preview
     *
     * @return List of movie
     */
    public List<Movie> getAllPreviewMovies() {
        return dbdao.getPreviewMovies(movieDB.getMovieList());
    }

    /**
     * Get all movies that are now showing
     *
     * @return List of movie
     */
    public List<Movie> getAllNowShowingMovies() {
        return dbdao.getShowingNowMovies(movieDB.getMovieList());
    }

    /**
     * Get all movies that are over
     *
     * @return List of movie
     */
    public List<Movie> getEndOfShowingMovies() {
        return dbdao.getEndOfShowingMovies(movieDB.getMovieList());
    }
}
