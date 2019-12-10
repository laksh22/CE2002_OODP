package movielistingdao;

import java.util.List;

import entities.MovieListing;

/**
 * DAO for ADMINS to access the movie listing database
 *
 * @author Gan Shyan
 */
public interface IAdminMovieListingDAO extends IMovieListingDAO {

    /**
     * Search movie listing by its id
     *
     * @param id               movie listing id
     * @param movieListingList List of movie listings in database
     * @return Movie listing object
     */
    MovieListing searchMovieListingByID(int id, List<MovieListing> movieListingList);

    /**
     * Insert movie listing into database
     *
     * @param movieListing     Movie listing object
     * @param movieListingList List of movie listings in database
     */
    void addMovieListing(MovieListing movieListing, List<MovieListing> movieListingList);

    /**
     * Delete movie listing into database
     *
     * @param movieListing     Movie listing object
     * @param movieListingList List of movie listings in database
     */
    void deleteMovieListing(MovieListing movieListing, List<MovieListing> movieListingList);

    /**
     * Get all movie listings that have been cancelled
     *
     * @param movieListingList List of movie listings in database
     * @return List of movie listings
     */
    List<MovieListing> getAllCancelledMovieListings(List<MovieListing> movieListingList);
}
