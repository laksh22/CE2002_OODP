package entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity class which presents a movie showing at a {@link Cineplex}'s {@link CinemaHall} at a particular time
 *
 * @author Gan Shyan
 */
public class MovieListing implements Serializable {

    /**
     * UID of serializable class
     */
    static final long serialVersionUID = 4646206671745589693l;

    /**
     * ID Constant of value for a movie listings that has been cancelled.
     */
    public static final int CANCELLED = -1;

    /**
     * Unique ID of the movie listing
     */
    private int id;

    /**
     * ID of the {@link Cineplex} this movie is going to be shown
     */
    private String cineplexName;

    /**
     * Number of the {@link CinemaHall} this movie listing going to be shown
     */
    private CinemaHall cinemaHall;

    /**
     * {@link Date} object for when the movie is showing
     */
    private Date showTime;

    /**
     * {@link Movie} that is being shown
     */
    private Movie movie;

    /**
     * Constructor
     *
     * @param id           Id of the movie listing
     * @param cineplexName Name of cineplex
     * @param cinemaHall   Cinema Hall object for the movie listing
     * @param showTime     Starting time of movie showing
     * @param movie        Movie object
     */
    public MovieListing(int id, String cineplexName, CinemaHall cinemaHall, Date showTime, Movie movie) {
        this.id = id;
        this.cineplexName = cineplexName;
        this.cinemaHall = cinemaHall;
        this.showTime = showTime;
        this.movie = movie;
    }

    /**
     * Getter
     *
     * @return Id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter
     *
     * @return Cineplex name
     */
    public String getCineplexName() {
        return cineplexName;
    }

    /**
     * Getter
     *
     * @return Cinema Hall object
     */
    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    /**
     * Getter
     *
     * @return Date object of starting time
     */
    public Date getShowTime() {
        return showTime;
    }

    /**
     * Getter for {@link Movie} attribute
     *
     * @return entities.Movie attribute
     */
    public Movie getMovie() {
        return this.movie;
    }

    /**
     * Setter
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter
     *
     * @param cineplexName Name of cineplex
     */
    public void setCineplexID(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    /**
     * Setter
     *
     * @param cinemaHall Cinema hall object
     */
    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    /**
     * Setter
     *
     * @param showTime Data object
     */
    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    /**
     * Setter
     *
     * @param movie Movie object
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Book a seat
     *
     * @param row    Row index
     * @param column column index
     * @return True if booking was successful
     */
    public boolean bookSeat(int row, int column) {
        return cinemaHall.getFloorPlan().setSeatStatus(FloorPlan.BOOKED, row, column);
    }

    /**
     * Unbook a seat
     *
     * @param row    Row index
     * @param column Column index
     * @return True if unbooking was successful
     */
    public boolean unbookSeat(int row, int column) {
        return cinemaHall.getFloorPlan().setSeatStatus(FloorPlan.FREE, row, column);
    }

    /**
     * Print out the floor plan, showing available seats
     */
    public void showSeatAvailability() {
        cinemaHall.getFloorPlan().printOutFloorPlan();
    }

    /**
     * Check if a seat is empty
     *
     * @param row    Row index
     * @param column column index
     * @return Return true if a seat is true, false if else
     */
    public boolean checkIfSeatFree(int row, int column) {
        return cinemaHall.getFloorPlan().getSeatStatus(row, column);
    }

}
