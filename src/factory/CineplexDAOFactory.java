package factory;

import cineplexdao.AdminCineplexDAO;
import cineplexdao.CustomerCineplexDAO;
import cineplexdao.ICineplexDAO;

/**
 * Factory class that instantiates the correct CineplexDBDAO according to the caller type and
 * returns it to the caller
 *
 * @author Gan Shyan
 */
public abstract class CineplexDAOFactory {

    /**
     * Return DAO according to caller type
     *
     * @param type Caller type
     * @return ICineplexDAO
     */
    public static ICineplexDAO getDAO(String type) {
        if (type.equals("ADMIN")) {
            return new AdminCineplexDAO();
        } else if (type.equals("CUSTOMER")) {
            return new CustomerCineplexDAO();
        }
        return null;
    }
}
