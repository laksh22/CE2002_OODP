package moviedao;

import java.util.ArrayList;
import java.util.List;

import entities.Movie;

/**
 * Movie Database data access object for customers
 *
 * @author Gan Shyan
 */
public class CustomerMovieDAO implements ICustomerMovieDAO {

    /**
     * Constructor
     */
    public CustomerMovieDAO() {

    }

    /**
     * Get all movies in the database
     *
     * @param movieList Original list in database
     * @return List of movie
     */
    @Override
    public List<Movie> getAllMovies(List<Movie> movieList) {
        return movieList;
    }

    /**
     * Get movie by name in the database
     *
     * @param name      Name of movie
     * @param movieList List of movies in database
     * @return Movie object
     */
    @Override
    public Movie getMovie(String name, List<Movie> movieList) {
        name = name.trim().toUpperCase();
        for (Movie movie : movieList) {
            if (movie.getTitle().trim().toUpperCase().contains(name)) {
                return movie;
            }
        }
        return null;
    }


    /**
     * Get all movies whose status are "UPCOMING"
     *
     * @param movieList Original list in database
     * @return Movie object
     */
    @Override
    public List<Movie> getUpcomingMovies(List<Movie> movieList) {
        List<Movie> filteredList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == Movie.COMING_SOON) {
                filteredList.add(movie);
            }
        }
        return filteredList;
    }

    /**
     * Get all movies whose status are "PREVIEW"
     *
     * @param movieList Original list in database
     * @return Movie object
     */
    @Override
    public List<Movie> getPreviewMovies(List<Movie> movieList) {
        List<Movie> filteredList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == Movie.PREVIEW) {
                filteredList.add(movie);
            }
        }
        return filteredList;
    }

    /**
     * Get all movies whose status are "NOW SHOWING"
     *
     * @param movieList Original list in database
     * @return List of movies
     */
    @Override
    public List<Movie> getShowingNowMovies(List<Movie> movieList) {
        List<Movie> filteredList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == Movie.NOW_SHOWING) {
                filteredList.add(movie);
            }
        }
        return filteredList;
    }

    /**
     * Get all movies whose status are "END OF SHOWING"
     *
     * @param movieList Original list in database
     * @return List of movie
     */
    @Override
    public List<Movie> getEndOfShowingMovies(List<Movie> movieList) {
        List<Movie> filteredList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getStatus() == Movie.END_OF_SHOWING) {
                filteredList.add(movie);
            }
        }
        return filteredList;
    }
}
