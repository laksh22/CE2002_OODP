package factory;

import moviedao.AdminMovieDAO;
import moviedao.CustomerMovieDAO;
import moviedao.IMovieDAO;

/**
 * Factory class that instantiates the correct MovieDBDAO according to the caller type and
 * returns it to the caller
 *
 * @author Gan Shyan
 */
public abstract class MovieDAOFactory {

    /**
     * Return DAO according to caller type
     *
     * @param type Caller type
     * @return IMovieDAO
     */
    public static IMovieDAO getMovieDBDAO(String type) {
        if (type.equals("ADMIN")) {
            return new AdminMovieDAO();
        } else if (type.equals("CUSTOMER")) {
            return new CustomerMovieDAO();
        }
        return null;
    }
}