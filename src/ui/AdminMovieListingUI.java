package ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.CinemaHall;
import entities.Cineplex;
import entities.Movie;
import entities.MovieListing;
import manager.AdminCineplexManager;
import manager.AdminMovieListingManager;

/**
 * The UI class for the admin movie listing database module
 *
 * @author Gan Shyan
 */
public class AdminMovieListingUI {

    private int sel = -1;
    private Scanner scanner;
    /**
     * AdminMovieListingManager attribute
     */
    private AdminMovieListingManager listingDBManager;
    /**
     * AdminCineplexManager attribute
     */
    private AdminCineplexManager cineplexDBManager;

    /**
     * Constructor
     *
     * @param type Caller type
     */
    public AdminMovieListingUI(String type) {
        scanner = new Scanner(System.in);
        listingDBManager = new AdminMovieListingManager(type);
        cineplexDBManager = new AdminCineplexManager();
    }

    /**
     * Start up sequence for this UI module
     */
    public void startUp() {
        System.out.println("****** Welcome to Movie Listing Manager ******");

        while (sel != 0) {
            System.out.println("Choose Operation: ");
            System.out.println("(0) - Exit Admin Movie Listing Database Module");
            System.out.println("(1) - Enter New Movie Listing");
            System.out.println("(2) - Remove Movie Listing");
            System.out.println("(3) - Update MovieListing time");
            System.out.println("(4) - List out all upcoming movie listings");
            System.out.println("(5) - List out all previous listings");
            System.out.println("(6) - List out all cancelled listings");

            try {
                sel = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.print("Enter a number!\n");
                scanner.next();
            }

            switch (sel) {
                case 0:
                    listingDBManager.saveDatabase();
                    break;
                case 1:
                    enterNewMovieListing();
                    break;
                case 2:
                    removeMovieListing();
                    break;
                case 3:
                    updateMovieListingTime();
                    break;
                case 4:
                    listOutAllUpcomingMovieListings();
                    break;
                case 5:
                    listOutAllPreviousMovieListings();
                    break;
                case 6:
                    listOutAllCancelledMovieListings();
                    break;
            }
        }
    }

    /**
     * List out all the movie listings in the database that have yet to happen
     */
    private void listOutAllUpcomingMovieListings() {
        List<MovieListing> movieListingList = listingDBManager.getAllUpcomingMovieListings();
        if (movieListingList.size() == 0) {
            System.out.println("No movie listings found");
        } else {
            System.out.println(movieListingList.size() + " movie listings found\n\n");
            for (MovieListing movieListing : movieListingList) {
                if (movieListing.getId() != -1) {
                    listMovieListing(movieListing);
                    System.out.println("\n");
                }
            }
        }
    }

    /**
     * List out all the movie listings in the database that are already over
     */
    private void listOutAllPreviousMovieListings() {
        List<MovieListing> movieListingList = listingDBManager.getAllPreviousMovieListings();
        if (movieListingList.size() == 0) {
            System.out.println("No previous movie listings found");
        } else {
            System.out.println(movieListingList.size() + " previous movie listings found\n\n");
            for (MovieListing movieListing : movieListingList) {
                listMovieListing(movieListing);
                System.out.println("\n");
            }
        }
    }

    /**
     * List out all movie listings that have been cancelled
     */
    private void listOutAllCancelledMovieListings() {
        List<MovieListing> movieListingList = listingDBManager.getAllCancelledMovieListings();
        if (movieListingList.size() == 0) {
            System.out.println("No cancelled movie listings found");
        } else {
            System.out.println(movieListingList.size() + " cancelled movie listings found\n\n");
            for (MovieListing movieListing : movieListingList) {
                listMovieListing(movieListing);
                System.out.println("\n");

            }
        }
    }


    /**
     * Enter a new movie listing into the database
     */
    private void enterNewMovieListing() {

        // Admin choices the movie to create a new movie listing for
        System.out.println("Enter name of movie: ");
        String movieTitle = scanner.nextLine();

        Movie movie = listingDBManager.searchForMovie(movieTitle);
        if (movie == null) {
            System.out.println("No such movie found!");
            return;
        } else {
            System.out.println("Movie " + movie.getTitle() + " found");
            System.out.println("Run time: " + movie.getRunTime());
        }

        // Search for cineplex
        Cineplex cineplex;
        while (true) {
            // Find the cineplex for the new movie listing
            int cineplexId;
            while (true) {
                try {
                    System.out.println("Enter cineplex id: ");
                    cineplexId = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!\n");
                    scanner.next();
                }
            }

            cineplex = cineplexDBManager.searchCineplex(cineplexId);
            if (cineplex != null) {
                break;
            } else {
                System.out.println("Cineplex not found!");
            }
        }

        CinemaHall cinemaHall = null;
        int cinemaHallNumber;
        while (true) {
            while (true) {
                try {
                    System.out.println("Enter cinema hall number: ");
                    cinemaHallNumber = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!\n");
                    scanner.next();
                }
            }

            for (CinemaHall c : cineplex.getCinemaHallList()) {
                if (c.getHallNumber() == cinemaHallNumber) {
                    cinemaHall = c.copy();
                    break;
                }
            }

            if (cinemaHall != null) {
                break;
            } else {
                System.out.println("Cinema hall not found!");
            }
        }


        int date;
        while (true) {

            while (true) {
                try {
                    System.out.println("Enter date: ");
                    date = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!\n");
                    scanner.next();
                }
            }

            if (date >= 1 && date <= 31) {
                break;
            }
            System.out.println("Invalid date entered");
        }

        int month;
        while (true) {

            while (true) {
                try {
                    System.out.println("Enter month(JAN - 1, Dec - 12):");
                    month = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!\n");
                    scanner.next();
                }
            }

            if (month <= 12 && month >= 1) {
                break;
            }
            System.out.println("Invalid month entered");
        }

        int year;
        while (true) {
            try {
                System.out.println("Enter year: ");
                year = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter a number!\n");
                scanner.next();
            }
        }


        int hour;
        while (true) {
            while (true) {
                try {
                    System.out.println("Enter hour (24h format): ");
                    hour = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!\n");
                    scanner.next();
                }
            }
            if (hour <= 23 && hour >= 0) {
                break;
            }
            System.out.println("Invalid hour entered");
        }


        int minute;
        while (true) {
            while (true) {
                try {
                    System.out.println("Enter minute: ");
                    minute = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!\n");
                    scanner.next();
                }
            }

            if (minute <= 59 && minute >= 0) {
                break;
            }
            System.out.println("Invalid minute entered");
        }

        Date startTime = new Date(year - 1900, month - 1, date, hour, minute, 0);

        int id = listingDBManager.getID();
        listingDBManager.insertMovieListing(new MovieListing(id, cineplex.getName(), cinemaHall, startTime, movie));
        System.out.println("Movie listing entered");
    }

    /**
     * Remove a movie listing from the database
     */
    private void removeMovieListing() {
        int movieListingID;
        while (true) {
            while (true) {

                while (true) {
                    try {
                        System.out.println("\n");
                        System.out.println("Enter movie listing ID: ");
                        movieListingID = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Enter a number!\n");
                        scanner.next();
                    }
                }

                if (movieListingID >= 0) {
                    break;
                }
                System.out.println("Invalid movie listing ID!");
            }
            MovieListing movieListing = listingDBManager.getMovieListingByID(movieListingID);
            if (movieListing == null) {
                System.out.println("No Movie Listing Found!\n");
            } else {
                System.out.println("Movie Listing found!");
                listMovieListing(movieListing);
                System.out.println("\n Confirm cancellation of movie listing? Y(Yes)/N(No) : ");
                char c = scanner.nextLine().charAt(0);
                if (c == 'y' || c == 'Y') {
                    listingDBManager.deleteMovieListing(movieListing);
                }
                break;
            }
        }
    }

    /**
     *
     */
    private void updateMovieListingTime() {
        int id;
        while (true) {
            try {
                System.out.println("\nEnter Id of movie listing:");
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter a number!");
                scanner.next();
            }
        }

        MovieListing movieListing = listingDBManager.getMovieListingByID(id);

        if (movieListing == null) {
            System.out.println("No movie listing found!");
        } else {
            System.out.println("Movie listing found, current details:\n");
            listMovieListing(movieListing);

            int mDate;
            while (true) {
                try {
                    System.out.println("Enter date: ");
                    mDate = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!\n");
                    scanner.next();
                }
            }


            int month;
            while (true) {

                while (true) {
                    try {
                        System.out.println("Enter month(JAN - 1, Dec - 12):");
                        month = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Enter a number!\n");
                        scanner.next();
                    }
                }

                if (month <= 12 && month >= 1) {
                    break;
                }
                System.out.println("Invalid month entered");
            }

            int year;
            while (true) {
                try {
                    System.out.println("Enter year: ");
                    year = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number!\n");
                    scanner.next();
                }
            }


            int hour;
            while (true) {
                while (true) {
                    try {
                        System.out.println("Enter hour (24h format): ");
                        hour = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Enter a number!\n");
                        scanner.next();
                    }
                }
                if (hour <= 23 && hour >= 0) {
                    break;
                }
                System.out.println("Invalid hour entered");
            }


            int minute;
            while (true) {
                while (true) {
                    try {
                        System.out.println("Enter minute: ");
                        minute = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Enter a number!\n");
                        scanner.next();
                    }
                }

                if (minute <= 59 && minute >= 0) {
                    break;
                }
                System.out.println("Invalid minute entered");
            }

            movieListing.getShowTime().setDate(mDate);
            movieListing.getShowTime().setMonth(month - 1);
            movieListing.getShowTime().setYear(year - 1900);
            movieListing.getShowTime().setHours(hour);
            movieListing.getShowTime().setMinutes(minute);

            System.out.println("Movie listing update!\n");

            listMovieListing(movieListing);
        }
    }

    /**
     * Display a single movie listing in the UI
     *
     * @param movieListing Movie listing object
     */
    private void listMovieListing(MovieListing movieListing) {
        System.out.println("ID: " + movieListing.getId());
        System.out.println("Movie Title: " + movieListing.getMovie().getTitle());
        System.out.println("Cineplex Name: " + movieListing.getCineplexName());
        System.out.println("Cinema Hall: " + movieListing.getCinemaHall().getHallNumber());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("Show time: " + dateFormat.format(movieListing.getShowTime()));
        System.out.println("Run time: " + movieListing.getMovie().getRunTime());
    }
}
