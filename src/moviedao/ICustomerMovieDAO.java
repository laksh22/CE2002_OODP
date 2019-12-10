package moviedao;

import java.util.List;

import entities.Movie;

/**
 * Customer DAO for the movie database
 *
 * @author Gan Shyan
 */
public interface ICustomerMovieDAO extends IMovieDAO {

    /**
     * Get all movies whose status are "UPCOMING"
     *
     * @param movieList Original list in database
     */
    List<Movie> getUpcomingMovies(List<Movie> movieList);

    /**
     * Get all movies whose status are "PREVIEW"
     *
     * @param movieList Original list in database
     */
    List<Movie> getPreviewMovies(List<Movie> movieList);

    /**
     * Get all movies whose status are "NOW SHOWING"
     *
     * @param movieList Original list in database
     */
    List<Movie> getShowingNowMovies(List<Movie> movieList);

    /**
     * Get all movies whose status are "END OF SHOWING"
     *
     * @param movieList Original list in database
     */
    List<Movie> getEndOfShowingMovies(List<Movie> movieList);
}
