package cineplexdao;

import java.util.List;

import entities.CinemaHall;
import entities.Cineplex;

/**
 * Base data access object for cineplex database
 *
 * @author Gan Shyan
 */
public interface ICineplexDAO {

    /**
     * Get all cineplex in database
     *
     * @param list Original list in database
     * @return Original list in database
     */
    List<Cineplex> getAllCineplexes(List<Cineplex> list);

    /**
     * Search for a cineplex by its id. Returns null if no cineplex found.
     *
     * @param id   Cineplex id
     * @param list Original list in database
     * @return Cineplex object
     */
    Cineplex searchCineplex(int id, List<Cineplex> list);

    /**
     * Search for a cineplex by its name. Returns null if no cineplex found.
     *
     * @param name Cineplex name
     * @param list Original list in database
     * @return Cineplex object
     */
    Cineplex searchCineplex(String name, List<Cineplex> list);

    /**
     * Search for a cinema hall by its id. Returns null if no cinema hall found.
     *
     * @param cinemaHallId cinema hall id
     * @param list         Original list in database
     * @return Cinema Hall object
     */
    CinemaHall searchCinemaHall(int cinemaHallId, List<Cineplex> list);

}
