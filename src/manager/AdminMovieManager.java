package manager;

import java.util.List;

import database.MovieDB;
import entities.Movie;
import factory.MovieDAOFactory;
import moviedao.IAdminMovieDAO;

/**
 * Control class for accessing the movie database for admins
 *
 * @author Gan Shyan
 */
public class AdminMovieManager {

    /**
     * The movie database
     */
    private MovieDB movieDB;

    /**
     * The movie database data access object
     */
    private IAdminMovieDAO dbdao;

    /**
     * Constructor
     *
     * @param userType Caller type
     */
    public AdminMovieManager(String userType) {
        movieDB = MovieDB.getInstance();
        dbdao = (IAdminMovieDAO) MovieDAOFactory.getMovieDBDAO(userType);
    }

    /**
     * Save changes to the database
     */
    public void saveDatabase() {
        movieDB.saveDatabase();
    }

    /**
     * Insert new movie into database
     *
     * @param movie Movie object
     */
    public void insertMovie(Movie movie) {
        dbdao.insert(movie, movieDB.getMovieList());
    }

    /**
     * Search for a movie in the database
     *
     * @param name Title of movie
     * @return Movie object
     */
    public Movie searchMovie(String name) {
        return dbdao.getMovie(name, movieDB.getMovieList());
    }

    /**
     * Return all movies in database
     *
     * @return List of Movie objects
     */
    public List<Movie> getAllMovies() {
        return dbdao.getAllMovies(movieDB.getMovieList());
    }
}
