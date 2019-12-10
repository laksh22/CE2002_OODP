package moviedao;

import java.util.List;

import entities.Movie;

/**
 * Base data access object (interface) for accessing Movie database
 *
 * @author Gan Shyan
 */
public interface IMovieDAO {

    /**
     * Get all movies
     *
     * @param movieList Original list in database
     * @return Original list in database
     */
    List<Movie> getAllMovies(List<Movie> movieList);

    /**
     * Search for move in database by its name
     *
     * @param name      Name of movie
     * @param movieList List of movies in database
     * @return Movie object
     */
    Movie getMovie(String name, List<Movie> movieList);
}
