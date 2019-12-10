package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Booking;
import entities.CinemaHall;
import entities.Movie;
import entities.MovieListing;
import manager.BookingManager;
import manager.CustomerMovieListingManager;
import manager.CustomerMovieManager;
import manager.PriceManager;
import movielistingdao.HolidaysDAO;
import utility.CSVRow;

/**
 * The main UI module for Customers.
 *
 * @author Gan Shyan
 */
public class CustomerUI {
    private Scanner scanner;
    private int sel = -1;
    private static final String sales_path = "";

    /**
     * Constructor
     */
    public CustomerUI() {
        scanner = new Scanner(System.in);
    }

    /**
     * Start up sequence for this UI module
     */
    public void startUp() {
        System.out.println("** Welcome Customer **");

        CustomerMovieManager manager = new CustomerMovieManager();
        Movie movie;

        while (sel != 0) {
            System.out.println("Customer Module Main Menu:");
            System.out.println("(0): Exit Customer Module");
            System.out.println("(1): Access Movie Database");
            System.out.println("(2): Access Movie Listings Database");
            System.out.println("(3): Access Cineplex Locations Database");
            System.out.println("(4): Book Tickets!");
            System.out.println("(5): Check History of Bookings");
            System.out.println("(6): Add Rating and Review");
            System.out.println("(7): View Rating and Review");
            System.out.println("(8): Show top 5 movies! ");

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
                    new CustomerMovieUI().startUp();
                    break;
                case 2:
                    new CustomerMovieListingUI().startUp();
                    break;
                case 3:
                    new CustomerCineplexUI().startUp();
                    break;
                case 4:
                    bookingCall();
                    break;
                case 5:
                    System.out.println("Enter Email ID Used:");
                    String emailID = scanner.nextLine();
                    BookingUI.printReviews(emailID.trim().toUpperCase());
                    break;
                case 6:
                    System.out.println("Enter Name of Movie to Review and Rate:");
                    //scanner.nextLine();
                    String tempMovie = scanner.nextLine();

                    movie = manager.searchMovie(tempMovie);
                    if (movie != null) {
                        ReviewUI.addReview(movie.getTitle(), movie);
                        manager.saveDatabase();
                    }
                    break;
                case 7:
                    System.out.println("Enter Name of Movie to view Reviews and Rating");
                    String tempMovie1 = scanner.nextLine();
                    movie = manager.searchMovie(tempMovie1);
                    ReviewUI.printReviews(movie.getTitle());
                    ReviewUI.printAverageRating(movie.getTitle());
                    break;
                case 8:
                    topByRating();
                    break;

            }

        }
    }

    /**
     * Function that facilitates booking System
     *
     * @author Vivek Adrakatti
     */
    public void bookingCall() {
        int total=0;
        BookingManager book = new BookingManager();
        System.out.println("Enter Customer Name:");
        String customerName = scanner.nextLine().trim().toUpperCase();
        System.out.println("Enter emailID:");
        String emailID = scanner.nextLine().trim().toUpperCase();
        System.out.println("Enter Mobile Number");
        int mobileNumber = scanner.nextInt();
        System.out.println("Enter Movie Name");
        scanner.nextLine();
        String movieName = scanner.nextLine();
        movieName.trim();
        CustomerMovieManager Movie= new CustomerMovieManager();

        if(Movie.searchMovie(movieName).getStatus()==-1)
        {
            System.out.println("No such movie!Exiting!");
            System.out.println("----------------------");
            return;
        }
        CustomerMovieListingManager manager_listing = new CustomerMovieListingManager();
        List<MovieListing> relevantListings = manager_listing.searchMovieListingByFilmName(movieName);
        CustomerMovieListingUI db_module = new CustomerMovieListingUI();

        if (relevantListings.size() == 0)
        {
            System.out.println("No such movie");
            return;
        }

        for (int i = 0; i < relevantListings.size(); i++)
        {

            System.out.println("Enter " + (i + 1) + " To choose this listing");
            System.out.println("--------------------------------------------");

            db_module.listMovieListing(relevantListings.get(i));
        }

        int a = scanner.nextInt();
        if (a> relevantListings.size())
        {
            System.out.println("Wrong Entry!Exiting!");
            return;

        }

        MovieListing to_book = relevantListings.get(a - 1);
        to_book.showSeatAvailability();
        Date yourDate=to_book.getShowTime();
        Calendar c = Calendar.getInstance();
        c.setTime(yourDate);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);

        int row = 0;
        char row_char = 0;
        while (true)
        {
            System.out.println("Enter Row(Enter $ to stop booking)");
            row_char = scanner.next().charAt(0);
            row = (int) (row_char - 64);
            if (row_char == '$')
            {System.out.println("Total Cost:"+total);
                System.out.println("------------------");
                break;
            }

            row--;
            System.out.println("Enter Collumn");
            int col = scanner.nextInt();
            col--;
            if (!to_book.checkIfSeatFree(row, col))
            {
                System.out.println("Seat Not Free, Aborting!");
                break;
            }
            to_book.bookSeat(row, col);
            System.out.println("What Category do you fall Under?");
            System.out.println("Press 1 for Adult");
            System.out.println("Press 2 for Child");
            System.out.println("Press 3 for Senior");
            int b = scanner.nextInt();
            int price1 = 0;
            if (b == 1)
            {
                price1 = PriceManager.fetch("Adult");
            }
            if (b == 2)
            {
                price1 = PriceManager.fetch("Child");
            }
            if (b == 3)
            {
                price1 = PriceManager.fetch("Senior");
            }
            Movie movie = to_book.getMovie();
            int type = movie.getTypeOfMovie();
            int price2 = 0;
            price2 = PriceManager.fetch(type);
            CinemaHall cinemahall = to_book.getCinemaHall();
            int type2 = cinemahall.getCinemaType();
            type2 += 10;
            int price3 = 0;
            price3 = PriceManager.fetch(type2);
            ArrayList<CSVRow> holidays = HolidaysDAO.returnHolidays();
            int price4 = 0;
            for (int i = 0; i < holidays.size(); i++)
            {
                String sDate1 = holidays.get(i).getRow().get(0);

                String date = "";
                String month = "";
                String year = "";
                String full = "";
                Date date1 = null;

                date1 = to_book.getShowTime();
                date = String.valueOf(date1.getDate());
                month = String.valueOf(date1.getMonth()+1);
                int mont= Integer.parseInt(month);
                if(mont%10==0)
                {
                    month= "0"+month;
                }
                year = String.valueOf(date1.getYear()+1900);
                full = year+"-"+month+"-"+date;
                //System.out.println(full);
                //System.out.println(date1.toString());

                if (sDate1.compareTo(full)==0) {
                    System.out.println("Holiday Surcharge Applicable!");
                    price4=10;}



            }
            if(dayOfWeek==7 || dayOfWeek==1)
            {
                System.out.println("Weekend Surcharge Applicable!");
                price4+=10;
            }

            System.out.println("The Price for your ticket is: " + (price1 + price2 + price3 + price4) + " .Pay on collection of Tickets");
            total=total+price1+price2+price3+price4;
            Booking book_new = new Booking(customerName, emailID, mobileNumber, movieName, String.valueOf(to_book.getCinemaHall().getHallNumber()), to_book.getCineplexName());
            BookingManager.insertBooking(book_new);
        }

    }

    /**
     * List out the top 5 Movies by rating
     *
     * @author Vivek Adrakatti
     */
    public void topByRating() {
        CustomerMovieManager allMovies = new CustomerMovieManager();
        List<Movie> movies = allMovies.getAllMovies();

        ReviewUI.printTop5(movies);
    }
}