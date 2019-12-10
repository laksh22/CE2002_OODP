package manager;

import java.util.List;

import cineplexdao.ICustomerCineplexDAO;
import database.CineplexDB;
import entities.CinemaHall;
import entities.Cineplex;
import factory.CineplexDAOFactory;

/**
 * Control class for accessing the cineplex database for Customer
 *
 * @author Gan Shyan
 */
public class CustomerCineplexManager {

    /**
     * CineplexDB attribute
     */
    private CineplexDB cineplexDB;

    /**
     * ICustomerCineplexDAO attribute
     */
    private ICustomerCineplexDAO customerCineplexDBDAO;

    /**
     * Constructor
     */
    public CustomerCineplexManager() {
        cineplexDB = CineplexDB.getInstance();
        customerCineplexDBDAO = (ICustomerCineplexDAO) CineplexDAOFactory.getDAO("CUSTOMER");
    }

    /**
     * Get all cineplex in the database
     *
     * @return List of Cineplex
     */
    public List<Cineplex> getAllCineplexes() {
        return customerCineplexDBDAO.getAllCineplexes(cineplexDB.getCineplexList());
    }

    /**
     * Saerch for a cinema hall by its number
     *
     * @param cinemaHallNumber Cinema hall number
     * @return CinemaHall
     */
    public CinemaHall searchCinemaHall(int cinemaHallNumber) {
        return customerCineplexDBDAO.searchCinemaHall(cinemaHallNumber, cineplexDB.getCineplexList());
    }
}
