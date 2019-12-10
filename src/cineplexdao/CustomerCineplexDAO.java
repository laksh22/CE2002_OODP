package cineplexdao;

import java.util.List;

import entities.CinemaHall;
import entities.Cineplex;

/**
 * Data access object for admins accessing the admin cineplex database
 *
 * @author Gan Shyan
 */
public class CustomerCineplexDAO implements ICustomerCineplexDAO {

    /**
     * Get all cineplex in database
     *
     * @param list Original list in database
     * @return Original list in database
     */
    @Override
    public List<Cineplex> getAllCineplexes(List<Cineplex> list) {
        return list;
    }

    /**
     * Search for a cineplex by its id. Returns null if no cineplex found.
     *
     * @param id   Cineplex id
     * @param list Original list in database
     * @return Cineplex object
     */
    @Override
    public Cineplex searchCineplex(int id, List<Cineplex> list) {
        for (Cineplex cineplex : list) {
            if (cineplex.getCineplexCode() == id) {
                return cineplex;
            }
        }
        return null;
    }

    /**
     * Search for a cineplex by its name. Returns null if no cineplex found.
     *
     * @param name Cineplex name
     * @param list Original list in database
     * @return Cineplex object
     */
    @Override
    public Cineplex searchCineplex(String name, List<Cineplex> list) {
        for (Cineplex cineplex : list) {
            if (cineplex.getName().equals(name)) {
                return cineplex;
            }
        }
        return null;
    }

    /**
     * Search for a cinema hall by its id. Returns null if no cinema hall found.
     *
     * @param cinemaHallId cinema hall id
     * @param list         Original list in database
     * @return Cinema Hall object
     */
    @Override
    public CinemaHall searchCinemaHall(int cinemaHallId, List<Cineplex> list) {
        for (Cineplex cineplex : list) {
            for (CinemaHall cinemaHall : cineplex.getCinemaHallList()) {
                if (cinemaHall.getHallNumber() == cinemaHallId) {
                    return cinemaHall;
                }
            }
        }
        return null;
    }
}
