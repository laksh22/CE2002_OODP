package movielistingdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.MovieListing;

/**
 * Data Access Object for admins for accessing the movie listing database
 *
 * @author Gan Shyan
 */
public class AdminMovieListingDAO implements IAdminMovieListingDAO {

    /**
     * Get a movie listing by its id
     *
     * @param id Movie listing id
     * @return Movie listing object
     */
    @Override
    public MovieListing getMovieListing(int id, List<MovieListing> movieListingList) {
        for (MovieListing movieListing : movieListingList) {
            if (movieListing.getId() == id) {
                return movieListing;
            }
        }
        return null;
    }

    /**
     * Search for movie listing by its id
     *
     * @param id               movie listing id
     * @param movieListingList List of movie listings in database
     * @return Movie listing object
     */
    @Override
    public MovieListing searchMovieListingByID(int id, List<MovieListing> movieListingList) {
        for (MovieListing movieListing : movieListingList) {
            if (movieListing.getId() == id) {
                return movieListing;
            }
        }
        return null;
    }

    /**
     * Add movie listing in database
     *
     * @param movieListing     Movie listing object
     * @param movieListingList List of movie listings in database
     */
    @Override
    public void addMovieListing(MovieListing movieListing, List<MovieListing> movieListingList) {
        movieListingList.add(movieListing);
    }

    /**
     * Delete movie listing
     *
     * @param movieListing     Movie listing object
     * @param movieListingList List of movie listings in database
     */
    @Override
    public void deleteMovieListing(MovieListing movieListing, List<MovieListing> movieListingList) {
        for (MovieListing m : movieListingList) {
            if (m.getId() == movieListing.getId()) {
                m.setId(MovieListing.CANCELLED);
            }
        }
    }

    /**
     * Get all movie listings
     *
     * @param movieListingList List of movie listings in database
     * @return List of movie listings
     */
    @Override
    public List<MovieListing> getAllMovieListings(List<MovieListing> movieListingList) {
        return movieListingList;
    }

    /**
     * Search for all upcoming movie listings
     *
     * @param movieListingList List of movie listings in database
     * @return List of movie listings
     */
    @Override
    public List<MovieListing> getAllUpcomingMovieListings(List<MovieListing> movieListingList) {
        Date currentDate = new Date();
        ArrayList<MovieListing> filteredList = new ArrayList<>();
        for (MovieListing m : movieListingList) {
            if (m.getId() != MovieListing.CANCELLED && m.getShowTime().after(currentDate)) {      // Get only movie listings that are not over and not cancelled
                filteredList.add(m);
            }
        }
        return filteredList;
    }

    /**
     * Get all movie listings that are over
     *
     * @param movieListingList List of movie listings in database
     * @return List of movie listings
     */
    @Override
    public List<MovieListing> getAllPreviousMovieListings(List<MovieListing> movieListingList) {
        Date currentDate = new Date();
        ArrayList<MovieListing> filteredList = new ArrayList<>();
        for (MovieListing m : movieListingList) {
            if (m.getId() != MovieListing.CANCELLED && m.getShowTime().before(currentDate)) {      // Get only movie listings that are over and not cancelled
                filteredList.add(m);
            }
        }
        return filteredList;
    }

    /**
     * Get all movie listings that have been cancelled
     *
     * @param movieListingList List of movie listings in database
     * @return List of movie listings
     */
    @Override
    public List<MovieListing> getAllCancelledMovieListings(List<MovieListing> movieListingList) {
        ArrayList<MovieListing> filteredList = new ArrayList<>();
        for (MovieListing m : movieListingList) {
            if (m.getId() == MovieListing.CANCELLED) {      // Get only movie listings that have been cancelled
                filteredList.add(m);
            }
        }
        return filteredList;
    }


}
