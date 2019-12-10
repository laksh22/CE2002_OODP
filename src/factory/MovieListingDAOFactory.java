package factory;

import movielistingdao.AdminMovieListingDAO;
import movielistingdao.CustomerMovieListingDAO;
import movielistingdao.IMovieListingDAO;

/**
 * Factory class that instantiates the correct MovieListingDBDAO according to the caller type and
 * returns it to the caller
 *
 * @author Gan Shyan
 */
public abstract class MovieListingDAOFactory {

    /**
     * Return DAO according to caller type
     *
     * @param type Caller type
     * @return IMovieListingDAO
     */
    public static IMovieListingDAO getMovieListingDBDAO(String type) {
        if (type.trim().toUpperCase().equals("ADMIN")) {
            return new AdminMovieListingDAO();
        } else if (type.trim().toUpperCase().equals("CUSTOMER")) {
            return new CustomerMovieListingDAO();
        }
        return null;
    }

}
