import java.util.Scanner;
import java.util.Date;
import java.util.List;
import modules.CustomerCineplexDBModule;
import modules.CustomerMovieDBModule;
import modules.CustomerMovieListingsDBModule;
import utilities.CSVFileIO;
import managers.BookingDBManager;
import managers.CustomerMovieListingDBManager;
import entities.MovieListing;
import entities.Booking;
import entities.CinemaHall;
import entities.Movie;
import entities.CinemaHall;
import managers.BookingDBManager;
/**
 * The main UI module for Customers.
 *
 * @author Gan Shyan
 */
public class CustomerModule {
    private Scanner scanner;
    private int sel = -1;
    private static final String sales_path="";
    public CustomerModule() {
        scanner = new Scanner(System.in);
    }

    public void startUp() {
        System.out.println("****** Welcome Customer ******");

        while (sel != 0) {
            System.out.println("Customer Module Main Menu:");
            System.out.println("(0): Exit Customer Module");
            System.out.println("(1): Access Movie Database");
            System.out.println("(2): Access Movie Listings Database");
            System.out.println("(3): Access Cineplex Locations Database");
            System.out.println("(4): Book Tickets!");
            System.out.println("(5): Check History of Bookings");
            sel = scanner.nextInt();
            scanner.nextLine();

            switch (sel) {
                case 1:
                    new CustomerMovieDBModule().startUp();
                    break;
                case 2:
                    new CustomerMovieListingsDBModule().startUp();
                    break;
                case 3:
                    new CustomerCineplexDBModule().startUp();
                    break;
                case 4:
                	BookingDBManager book = new BookingDBManager();
                	System.out.println("Enter Customer Name:");
                	String customerName = scanner.nextLine().trim().toUpperCase();
                    System.out.println("Enter emailID:");
                    String emailID=scanner.nextLine().trim().toUpperCase();
                    System.out.println("Enter Mobile Number");
                    int mobileNumber = scanner.nextInt();
                    System.out.println("Enter Movie Name");
                    String movieName = scanner.nextLine().trim().toUpperCase();
                    Movie movie_temp = new Movie(movieName);
                    System.out.println("Enter Movie Date:");
                    System.out.println("Enter Movie Year(YYYY)");
                    int year= scanner.nextInt();
                    System.out.println("Enter Movie Month(MM)");
                    int month= scanner.nextInt();
                    System.out.println("Enter Movie Date(DD)");
                    int date= scanner.nextInt();
                    System.out.println("Enter Movie Hours(24Hr Format)");
                    int hours= scanner.nextInt();
                    System.out.println("Enter Movie Minutes");
                    int minutes= scanner.nextInt();
                    Date show = new Date(year,month,date,hours,minutes);
                    System.out.println("Enter Cinema Hall ID");
                    int cinemaHallID = scanner.nextInt();
                    CinemaHall temp_hall=new CinemaHall(cinemaHallID);
                    System.out.println("Enter Cineplex Name/ID");
                    String cineplexName = scanner.nextLine().trim().toUpperCase();
                    
                    CustomerMovieListingDBManager checker = new CustomerMovieListingDBManager();
                    
                    List<MovieListing> existing=checker.getAllUpcomingMovieListings();
                    MovieListing currentEntry =new MovieListing(0,cineplexName,temp_hall,show,movie_temp); 
                    int valid=0;
                    for (MovieListing m : existing)
                    {
                    	m.setId(0);
                    	if(!cineplexName.equals(m.getCineplexName()))
                    	{
                    		continue;
                    	}
                    	if(m.getCinemaHall().getHallNumber()!= cinemaHallID)
                    	{
                    		continue;
                    	}
                    	if(!show.equals(m.getShowTime()))
                    	{
                    		continue;
                    	}
                    	if(!m.getMovie().getTitle().equals(movieName))
                    	{
                    		continue;
                    	}
                    	currentEntry = m;
                    	valid=1;
                    }
                    if(valid==0)
                    {
                    	System.out.println("Invalid Entry!, No such show exists");
                    }
                    else
                    {
                    	currentEntry.showSeatAvailability();
                    	while(true) {
                    		
                    	System.out.println("Enter Row of Seat you wish to book(Enter -1 to exit)");
                        int row = scanner.nextInt();
                        if(row==-1) break;
                        System.out.println("Enter Collumn of Seat you wish to book(Enter -1 to exit)");
                        int collumn= scanner.nextInt();
                        boolean free=currentEntry.checkIfSeatFree(row, collumn);
                        if(free)
                        {
                        	currentEntry.bookSeat(row,collumn);
                        	System.out.println("Seat booked!");
                        	String trans_id =  cineplexName.substring(0,3) + String.valueOf(year).trim() + String.valueOf(month).trim() + String.valueOf(date).trim() + String.valueOf(hours).trim() + String.valueOf(minutes).trim();
                        	Booking book_new = new Booking(customerName,emailID,mobileNumber, movieName,String.valueOf(cinemaHallID),cineplexName,trans_id);
                        	BookingDBManager.insertBooking(book_new);

                        	
                           
                        }
                        else
                        {
                        	System.out.println("This Seat is full, try another seat number");
                        }
                        }
                        
                    }
                    ;
                    
                	break;
                case 5:
                	System.out.println("Enter email ID used for booking");
                	String email= scanner.nextLine().trim().toUpperCase();
                	List<Booking> history = BookingDBManager.getBookings(email);
                	if (history.size()==0)
                	{
                		System.out.println("No Prior Bookings!");
                	}
                	else
                	{
                		for(int i = 0; i<history.size();i++)
                		{
                			Booking old_booking= history.get(i);
                			String name = old_booking.getCustomerName();
                			String movie_name= old_booking.getMovieName();
                			String cineplex =old_booking.getCineplexName();
                			System.out.println("You have a previous booking to watch "+movie_name+", Under the name of "+name+", at "+cineplex+".");
                		}
                	}
            }
        }
    }
}
