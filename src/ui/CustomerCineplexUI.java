package ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.CinemaHall;
import entities.Cineplex;
import manager.CustomerCineplexManager;

/**
 * UI module for CUSTOMERS for accessing the Cineplex Database
 *
 * @author Gan Shyan
 */
public class CustomerCineplexUI {

    private int sel = -1;
    private Scanner scanner;

    /**
     * CustomerCineplexManager attribute
     */
    private CustomerCineplexManager customerCineplexDBManager;

    /**
     * Constructor
     */
    public CustomerCineplexUI() {
        scanner = new Scanner(System.in);
        customerCineplexDBManager = new CustomerCineplexManager();
    }

    /**
     * Start up sequence for this UI module
     */
    public void startUp() {
        System.out.println("****** Welcome Customer to Cineplex Locations Manager ******\n");

        while (sel != 0) {
            System.out.println("Choose Operation: ");
            System.out.println("(0) - Exit Cineplex Locations Manager");
            System.out.println("(1) - List out all Cineplex location");
            System.out.println("(2) - Search for cinema hall");

            while (true) {
                try {
                    sel = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!\n");
                    scanner.next();
                }
            }

            switch (sel) {
                case 1:
                    listOutCineplexLocations();
                    break;
                case 2:
                    searchForCinemaHall();
                    break;
            }
        }
    }

    /**
     * List out all the cineplex
     */
    private void listOutCineplexLocations() {
        List<Cineplex> cineplexList = customerCineplexDBManager.getAllCineplexes();
        if (cineplexList == null || cineplexList.size() == 0) {
            System.out.println("No Cineplex found");
        } else {
            System.out.println("We currently have " + cineplexList.size() + " locations\n");
            for (Cineplex cineplex : cineplexList) {
                printOutCineplexDetail(cineplex);
                System.out.print("\n\n");
            }
        }

    }

    /**
     * Search for a single cinema hall and print out the details
     */
    private void searchForCinemaHall() {
        System.out.print("\n");

        CinemaHall cinemaHall;

        System.out.print("Enter cinema hall number: ");

        int hallNumber;
        while (true) {
            try {
                hallNumber = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter a number!\n");
                scanner.next();
            }
        }

        cinemaHall = customerCineplexDBManager.searchCinemaHall(hallNumber);
        if (cinemaHall == null) {
            System.out.println("No cinema hall found");
        } else {
            printOutCinemaHallDetail(cinemaHall);
        }
    }

    /**
     * Print out the details of a single cineplex on the console
     */
    private void printOutCineplexDetail(Cineplex cineplex) {
        System.out.print("\n");
        System.out.println("Cineplex - " + cineplex.getName());
        System.out.println("Cineplex ID - " + cineplex.getCineplexCode());
        System.out.println("Address - " + cineplex.getAddress());
        System.out.println("Number of cinema halls - " + cineplex.getCinemaHallList().size());
        for (CinemaHall cinemaHall : cineplex.getCinemaHallList()) {
            System.out.print("*** Cinema hall " + cinemaHall.getHallNumber());
            System.out.print(", Seating capacity - " + cinemaHall.getNumberOfSeats());
            System.out.print(", Hall Type - ");
            if (cinemaHall.getCinemaType() == CinemaHall.NORMAL_HALL) {
                System.out.print("Normal hall");
            } else if (cinemaHall.getCinemaType() == CinemaHall.PLATINUM_MOVIE_SUITE) {
                System.out.print("Platinum Movie Suite");
            }
            System.out.print("\n");
        }
    }

    /**
     * Print out the details of a single cinemaHall on the console
     *
     * @param cinemaHall Cinema hall
     */
    private void printOutCinemaHallDetail(CinemaHall cinemaHall) {
        System.out.println("Cinema hall number - " + cinemaHall.getHallNumber());
        switch (cinemaHall.getCinemaType()) {
            case CinemaHall.NORMAL_HALL:
                System.out.println("Hall type - Normal Hall ");
                break;
            case CinemaHall.PLATINUM_MOVIE_SUITE:
                System.out.println("Hall type - Platinum Movie Suite");
                break;
        }
        System.out.println("Seating capacity - " + cinemaHall.getNumberOfSeats());
        System.out.println("****** Floor Plan ******\n");
        cinemaHall.getFloorPlan().printOutFloorPlan();
        System.out.println("\n");
    }
}
