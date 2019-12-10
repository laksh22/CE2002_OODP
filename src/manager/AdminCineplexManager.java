package manager;

import java.util.List;

import cineplexdao.IAdminCineplexDAO;
import database.CineplexDB;
import entities.CinemaHall;
import entities.Cineplex;
import factory.CineplexDAOFactory;

/**
 * Control class for accessing the cineplex database for admins
 *
 * @author Gan Shyan
 */
public class AdminCineplexManager {

    /**
     * CineplexDB attribute
     */
    private CineplexDB cineplexDB;

    /**
     * IAdminCineplexDAO attribute
     */
    private IAdminCineplexDAO iAdminCineplexDBDAO;

    /**
     * Constructor
     */
    public AdminCineplexManager() {
        cineplexDB = CineplexDB.getInstance();
        iAdminCineplexDBDAO = (IAdminCineplexDAO) CineplexDAOFactory.getDAO("ADMIN");
    }

    /**
     * Save changes to the database
     */
    public void saveDatabase() {
        cineplexDB.saveDatabase();
    }

    /**
     * Add a new cineplex object into the database
     *
     * @param cineplex Cineplex object
     */
    public void addCineplex(Cineplex cineplex) {
        iAdminCineplexDBDAO.addCineplex(cineplex, cineplexDB.getCineplexList());
    }

    /**
     * Delete a cineplex object from the database
     *
     * @param cineplex Cineplex object
     */
    public void deleteCineplex(Cineplex cineplex) {
        iAdminCineplexDBDAO.deleteCineplex(cineplex, cineplexDB.getCineplexList());
    }

    /**
     * Get all cineplex objects from the database
     *
     * @return All cineplex objects in database
     */
    public List<Cineplex> getAllCineplexes() {
        return iAdminCineplexDBDAO.getAllCineplexes(cineplexDB.getCineplexList());
    }

    /**
     * Search for a cineplex by its name.
     *
     * @param name Cineplex name
     * @return Cineplex object
     */
    public Cineplex searchCineplex(String name) {
        return iAdminCineplexDBDAO.searchCineplex(name, cineplexDB.getCineplexList());
    }

    /**
     * Search for a cineplex by its id.
     *
     * @param id Cineplex id
     * @return Cineplex object
     */
    public Cineplex searchCineplex(int id) {
        return iAdminCineplexDBDAO.searchCineplex(id, cineplexDB.getCineplexList());
    }

    /**
     * Search for a cinema hall by its number.
     *
     * @param cinemaHallNumber cinema hall number
     * @return Cinema hall object
     */
    public CinemaHall searchCinemaHall(int cinemaHallNumber) {
        return iAdminCineplexDBDAO.searchCinemaHall(cinemaHallNumber, cineplexDB.getCineplexList());
    }
}
