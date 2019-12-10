package movielistingdao;

import java.util.List;

import entities.MovieListing;

/**
 * Base DAO for the movie listing database
 *
 * @author Gan Shyan
 */
public interface IMovieListingDAO {

    /**
     * Get a single movie listing by its id
     *
     * @param id               Movie listing id
     * @param movieListingList Movie listing id
     * @return Movie listing object
     */
    MovieListing getMovieListing(int id, List<MovieListing> movieListingList);

    /**
     * Return all movie listings
     *
     * @param movieListingList List of movie listings in database
     * @return List of movie listings
     */
    List<MovieListing> getAllMovieListings(List<MovieListing> movieListingList);

    /**
     * Return all movie listings that are yet to occur
     *
     * @param movieListingList List of movie listings in database
     * @return List of movie listings
     */
    List<MovieListing> getAllUpcomingMovieListings(List<MovieListing> movieListingList);

    /**
     * Return all movie listings that are over
     *
     * @param movieListingList List of movie listings in database
     * @return List of movie listings
     */
    List<MovieListing> getAllPreviousMovieListings(List<MovieListing> movieListingList);
}
