package movielistingdao;

import java.util.List;

import entities.MovieListing;

/**
 * DAO for Customers accessing the movie listing database
 *
 * @author Gan Shyan
 */
public interface ICustomerMovieListingDAO extends IMovieListingDAO {
    /**
     * Return all movie listings that show a film
     *
     * @param movieName        Name of movie
     * @param allMoviesListing List of movie listings in database
     * @return List of movie listings
     */
    List<MovieListing> searchMovieListingByFilmName(String movieName, List<MovieListing> allMoviesListing);

    /**
     * Return all movie listings in the cineplex according to the cineplex's name
     *
     * @param cineplexName     Name of cineplex
     * @param allMoviesListing List of movie listings in database
     * @return List of movie listings
     */
    List<MovieListing> searchMovieListingByCineplex(String cineplexName, List<MovieListing> allMoviesListing);

}
