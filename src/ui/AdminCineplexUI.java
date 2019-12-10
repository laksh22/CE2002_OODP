package ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.CinemaHall;
import entities.Cineplex;
import manager.AdminCineplexManager;

/**
 * UI module for ADMINS for accessing the Cineplex Database
 *
 * @author Gan Shyan
 */
public class AdminCineplexUI {

    private int sel = -1;
    private Scanner scanner;

    /**
     * AdminCineplexManager attribute
     */
    private AdminCineplexManager adminCineplexDBManager;

    /**
     * Constructor
     */
    public AdminCineplexUI() {
        scanner = new Scanner(System.in);
        adminCineplexDBManager = new AdminCineplexManager();
    }

    /**
     * Start up sequence for this UI module
     */
    public void startUp() {
        System.out.println("****** Welcome To Cineplex Locations Manager ******\n");

        while (sel != 0) {

            System.out.print("\n");
            System.out.println("Choose Operation: ");
            System.out.println("(0) - Exit Cineplex Locations Manager");
            System.out.println("(1) - List out all Cineplex location");
            System.out.println("(2) - Search for cineplex");
            System.out.println("(3) - Search for cinema hall");

            try {
                sel = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.print("Enter a number!\n");
                scanner.next();
            }

            switch (sel) {
                case 0:
                    adminCineplexDBManager.saveDatabase();
                    break;
                case 1:
                    listOutCineplexLocations();
                    break;
                case 2:
                    searchForCineplex();
                    break;
                case 3:
                    searchForCinemaHall();
                    break;
            }
        }
    }

    /**
     * List out all the cineplex
     */
    private void listOutCineplexLocations() {
        List<Cineplex> cineplexList = adminCineplexDBManager.getAllCineplexes();
        if (cineplexList.size() == 0) {
            System.out.println("No Cineplex found");
        } else {
            System.out.println("Number of Cineplex - " + cineplexList.size());
            for (Cineplex cineplex : cineplexList) {
                printOutCineplexDetail(cineplex);
                System.out.print("\n\n");
            }
        }
    }

    /**
     * Search for a single cineplex
     */
    private void searchForCineplex() {
        System.out.println("\n");
        int id;
        while (true) {
            System.out.println("Enter cineplex ID: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter a number!");
                scanner.next();
            }
        }

        Cineplex cineplex = adminCineplexDBManager.searchCineplex(id);

        if (cineplex == null) {
            System.out.println("No Cineplex found!");
        } else {
            printOutCineplexDetail(cineplex);
        }
    }

    /**
     * Search for a single cinema hall and print out the details
     */
    private void searchForCinemaHall() {
        System.out.print("\n");

        CinemaHall cinemaHall;
        int hallNumber;
        while (true) {
            try {
                System.out.print("Enter cinema hall number: ");
                hallNumber = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter a number!\n");
                scanner.next();
            }

        }

        cinemaHall = adminCineplexDBManager.searchCinemaHall(hallNumber);
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
        System.out.println("Cineplex code - " + cineplex.getCineplexCode());
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
     * Print out the details of a single cinema hall
     *
     * @param cinemaHall Cinema hall object
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
