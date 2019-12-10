package cineplexdao;

import java.util.List;

import entities.Cineplex;

/**
 * Data access object for admins to access the cineplex database
 *
 * @author Gan Shyan
 */
public interface IAdminCineplexDAO extends ICineplexDAO {

    /**
     * Add Cineplex to database
     *
     * @param cineplex Cineplex object
     * @param list     Original list in database
     */
    void addCineplex(Cineplex cineplex, List<Cineplex> list);

    /**
     * Delete Cineplex to database
     *
     * @param cineplex Cineplex object
     * @param list     Original list in database
     */
    void deleteCineplex(Cineplex cineplex, List<Cineplex> list);

}
