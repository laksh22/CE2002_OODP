package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entities.CinemaHall;
import entities.Cineplex;
import entities.FloorPlan;

/**
 * This class represents the database which stores all the Cineplex details
 *
 * @author Gan Shyan
 */
public class CineplexDB {

    /**
     * File path to the text file
     */
    private static final String FILE_PATH = ".\\cineplex_db.txt";

    /**
     * Array of the cineplex representing the database data
     */
    private static List<Cineplex> cineplexList = new ArrayList<>();

    /**
     * Single instance of the DB
     */
    private static CineplexDB instance;

    /**
     * Constructor
     */
    private CineplexDB() {
        // Read the text file to create the database
         openDatabase();
        // setupDatabaseFirstTime();
    }

    /**
     * Singleton pattern
     *
     * @return Static instance of the database
     */
    public static CineplexDB getInstance() {
        if (instance == null) {
            instance = new CineplexDB();
        }

        return instance;
    }

    /**
     * Getter for the data in this DB
     *
     * @return Original list of data
     */
    public List<Cineplex> getCineplexList() {
        return cineplexList;
    }

    /**
     * Write ArrayList to the txt file
     */
    public void saveDatabase() {
        try {
            FileOutputStream fos =
                    new FileOutputStream(".\\cineplex_db.txt");
            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);
            oos.writeObject(cineplexList); // Save arraylist to txt file
            oos.close();
        } catch (IOException ioe) {
            System.out.println("Exception");
            ioe.printStackTrace();
        }
    }

    /**
     * Open the database by reading the text file
     */
    private void openDatabase() {
        try {
            FileInputStream fos =
                    new FileInputStream("cineplex_db.txt");
            ObjectInputStream oos =
                    new ObjectInputStream(fos);
            try {
                cineplexList = ((ArrayList<Cineplex>) oos.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            oos.close();
        } catch (IOException ioe) {
            System.out.println("Exception");
            ioe.printStackTrace();
        }
    }

    /**
     * Used to write the database for the first time.
     */
    private void setupDatabaseFirstTime() {
        System.out.println("Writing to text file!!!");
        List<CinemaHall> cinemaHalls = new ArrayList<>();
        FloorPlan floorPlan = new FloorPlan(new int[9][18], 9, 18);
        FloorPlan floorPlan1 = new FloorPlan(new int[12][18], 12, 18);

        cinemaHalls.add(new CinemaHall(CinemaHall.PLATINUM_MOVIE_SUITE, floorPlan1.copy(), 12 * 18, 1, 0));
        cinemaHalls.add(new CinemaHall(CinemaHall.PLATINUM_MOVIE_SUITE, floorPlan1.copy(), 12 * 18, 2, 0));
        cinemaHalls.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan1.copy(), 12 * 18, 3, 0));
        cinemaHalls.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan1.copy(), 12 * 18, 4, 0));

        List<CinemaHall> cinemaHalls1 = new ArrayList<>();

        cinemaHalls1.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 5, 0));
        cinemaHalls1.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 6, 0));
        cinemaHalls1.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 7, 0));
        cinemaHalls1.add(new CinemaHall(CinemaHall.PLATINUM_MOVIE_SUITE, floorPlan.copy(), 9 * 18, 8, 0));

        List<CinemaHall> cinemaHalls2 = new ArrayList<>();

        cinemaHalls2.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 9, 0));
        cinemaHalls2.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 10, 0));
        cinemaHalls2.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 11, 0));
        cinemaHalls2.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 12, 0));

        List<CinemaHall> cinemaHalls3 = new ArrayList<>();

        cinemaHalls3.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 13, 0));
        cinemaHalls3.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 14, 0));
        cinemaHalls3.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 15, 0));
        cinemaHalls3.add(new CinemaHall(CinemaHall.NORMAL_HALL, floorPlan.copy(), 9 * 18, 16, 0));

        cineplexList.add(new Cineplex(1, "2 Handy Road Levels 5 & 6, The Cathay, Singapore 229233",
                "THE CATHAY CINEPLEX", cinemaHalls));
        cineplexList.add(new Cineplex(2, "8 Grange Road, Levels 4, 5 & 6, Cathay Cineleisure, Orchard Singapore 239695",
                "CATHAY CINEPLEX CINELEISURE ORCHARD", cinemaHalls1));
        cineplexList.add(new Cineplex(3, "80 Marine Parade Road, Level 7, Parkway Parade, Singapore 449269",
                "CATHAY CINEPLEX PARKWAY PARADE", cinemaHalls2));
        cineplexList.add(new Cineplex(4, "50 Jurong Gateway Road, Level 5, Jem, Singapore 608549",
                "CATHAY CINEPLEX JEM", cinemaHalls3));
        try {
            FileOutputStream fos =
                    new FileOutputStream(".\\cineplex_db.txt");
            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);
            oos.writeObject(cineplexList);
            oos.close();
        } catch (IOException ioe) {
            System.out.println("Exception");
            ioe.printStackTrace();
        }
    }
}
