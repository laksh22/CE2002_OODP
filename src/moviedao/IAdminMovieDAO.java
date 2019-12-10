package moviedao;

import java.util.List;

import entities.Movie;

/**
 * @author Gan Shyan
 */
public interface IAdminMovieDAO extends IMovieDAO {
    /**
     * Delete a movie in database
     *
     * @param movie     Movie object
     * @param movieList Original list in database
     */
    void delete(Movie movie, List<Movie> movieList);

    /**
     * Insert a movie in database
     *
     * @param movie     Movie object
     * @param movieList Original list in database
     */
    void insert(Movie movie, List<Movie> movieList);

    /**
     * Update a movie in database
     *
     * @param movie     Movie object
     * @param movieList Original list in database
     */
    void update(Movie movie, List<Movie> movieList);
}
