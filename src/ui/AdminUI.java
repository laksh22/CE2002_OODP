package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main UI module for Admin.
 *
 * @author Gan Shyan
 */
public class AdminUI {

    private Scanner scanner;
    private int choice = -1;

    /**
     * Constructor
     */
    public AdminUI() {
        scanner = new Scanner(System.in);
    }

    /**
     * Start up sequence for this UI module
     */
    public void startUp() {
        System.out.println("****** Welcome Admin ******");

        while (choice != 0) {
            System.out.println("Admin Module Main Menu:");
            System.out.println("(0): Exit Admin Module");
            System.out.println("(1): Access Movie Database");
            System.out.println("(2): Access Movie Listings Database");
            System.out.println("(3): Access Cineplex Locations Database");

            while (true) {
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!\n");
                    scanner.next();
                }
            }


            switch (choice) {
                case 1:
                    AdminMovieUI adminMovieDBModule = new AdminMovieUI("ADMIN");
                    adminMovieDBModule.startUp();
                    break;
                case 2:
                    AdminMovieListingUI adminMovieListingDBModule = new AdminMovieListingUI("ADMIN");
                    adminMovieListingDBModule.startUp();
                    break;
                case 3:
                    AdminCineplexUI adminCineplexDBModule = new AdminCineplexUI();
                    adminCineplexDBModule.startUp();
                    break;
            }
        }
    }
}
