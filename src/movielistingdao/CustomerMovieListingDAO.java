package movielistingdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.MovieListing;

/**
 * Movies Listing Database data access object for customers
 *
 * @author Gan Shyan
 */
public class CustomerMovieListingDAO implements ICustomerMovieListingDAO {

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
     * Get all movie listings in database
     *
     * @param movieListingList List of movie listings in database
     * @return List of movie listings
     */
    @Override
    public List<MovieListing> getAllMovieListings(List<MovieListing> movieListingList) {
        return movieListingList;
    }

    /**
     * Search for movie listing by name
     *
     * @param movieName        Name of movie
     * @param allMoviesListing List of movie listings in database
     * @return List of movie listings
     */
    @Override
    public List<MovieListing> searchMovieListingByFilmName(String movieName, List<MovieListing> allMoviesListing) {
        List<MovieListing> filteredList = new ArrayList<>();
        Date currentDate = new Date();
        for (MovieListing movieListing : allMoviesListing) {
            if (movieListing.getId() != MovieListing.CANCELLED && movieListing.getShowTime().after(currentDate) &&
                    movieListing.getMovie().getTitle().trim().toUpperCase().equals(movieName.toUpperCase().trim())) {  // Only return movie listings in the future and not cancelled
                filteredList.add(movieListing);
            }
        }
        return filteredList;
    }

    /**
     * Search movie listing shown in cineplex
     *
     * @param cineplexName     Name of cineplex
     * @param allMoviesListing List of movie listings in database
     * @return List of movie listing
     */
    @Override
    public List<MovieListing> searchMovieListingByCineplex(String cineplexName, List<MovieListing> allMoviesListing) {
        List<MovieListing> filteredList = new ArrayList<>();
        Date currentDate = new Date();
        for (MovieListing movieListing : allMoviesListing) {
            if (movieListing.getId() != MovieListing.CANCELLED && movieListing.getShowTime().after(currentDate) &&
                    movieListing.getCineplexName().trim().toUpperCase().contains(cineplexName.trim().toUpperCase())) { // Only return movie listings in the future and not cancelled
                filteredList.add(movieListing);
            }
        }
        return filteredList;
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
}
