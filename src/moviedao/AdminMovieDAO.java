package moviedao;

import java.util.List;

import entities.Movie;

/**
 * DAO for admins for accessing the movie database
 *
 * @author Gan Shyan
 */
public class AdminMovieDAO implements IAdminMovieDAO {

    /**
     * Delete a movie from the database
     *
     * @param movie     Movie object
     * @param movieList Original list of movie in the database
     */
    @Override
    public void delete(Movie movie, List<Movie> movieList) {
        movieList.remove(movie);
    }

    /**
     * Insert a new movie into the database
     *
     * @param movie     Movie object
     * @param movieList Original list in database
     */
    @Override
    public void insert(Movie movie, List<Movie> movieList) {
        movieList.add(movie);
    }

    /**
     * Update a movie in the database
     *
     * @param movie     Movie object
     * @param movieList Original list in database
     */
    @Override
    public void update(Movie movie, List<Movie> movieList) {
        for (Movie oldMovie : movieList) {
            if (oldMovie.getTitle().trim().toUpperCase().equals(movie.getTitle().trim().toUpperCase())) {
                oldMovie = movie;
            }
        }
    }

    /**
     * Get all movies in database
     *
     * @param movieList Original list in database
     * @return List of movie
     */
    @Override
    public List<Movie> getAllMovies(List<Movie> movieList) {
        return movieList;
    }

    /**
     * Get movie by name
     *
     * @param name      Name of movie
     * @param movieList List of movies in database
     * @return Movie object
     */
    @Override
    public Movie getMovie(String name, List<Movie> movieList) {
        String queryStr = name.toUpperCase().trim();
        for (Movie movie : movieList) {
            if (movie.getTitle().trim().toUpperCase().contains(queryStr)) {
                return movie;
            }
        }
        return null;
    }

}
