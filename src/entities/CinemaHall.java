package entities;

import java.io.Serializable;

/**
 * @author Gan Shyan
 * Entity class which represents a single cinema hall
 */

public class CinemaHall implements Serializable {

    /**
     * UID of serializable class
     */
    static final long serialVersionUID = -7199465161254546296l;

    /**
     * Constant value of a normal cinema hall
     */
    public static final int NORMAL_HALL = 1;

    /**
     * Constant value of a platinum movie suite cinema hall
     */
    public static final int PLATINUM_MOVIE_SUITE = 2;

    /**
     * Floor plan of the cinema hall
     */
    private FloorPlan floorPlan;

    /**
     * Type of cinema hall
     */
    private int cinemaType;

    /**
     * Total Number of seats for the cinema hall
     */
    private int numberOfSeats;

    /**
     * Number of seats that have already been booked
     */
    private int numberOfBookedSeats;

    /**
     * Hall number that is unique for cinema halls in a {@link Cineplex}
     */
    private int hallNumber;

    /**
     * Constructor
     *
     * @param hallNumber Unique hall number
     */
    public CinemaHall(int hallType, FloorPlan floorPlan, int numberOfSeats, int hallNumber, int numberOfBookedSeats) {
        this.cinemaType = hallType;
        this.floorPlan = floorPlan;
        this.numberOfSeats = numberOfSeats;
        this.hallNumber = hallNumber;
        this.numberOfBookedSeats = numberOfBookedSeats;
    }

    /**
     * Getter method
     *
     * @param hallNumber Hall number
     */
    public CinemaHall(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    /**
     * Getter method
     *
     * @return FloorPlan
     */
    public FloorPlan getFloorPlan() {
        return floorPlan;
    }

    /**
     * Getter method
     *
     * @return Number of booked seats
     */
    public int getNumberOfBookedSeats() {
        return numberOfBookedSeats;
    }

    /**
     * Getter method
     *
     * @return Cinema Type
     */
    public int getCinemaType() {
        return cinemaType;
    }

    /**
     * Getter for hall number attribute
     *
     * @return hallNumber attribute
     */
    public int getHallNumber() {
        return hallNumber;
    }

    /**
     * Getter for the number of seats
     *
     * @return Number of seats
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * Make a copy of the object and return it
     *
     * @return Instance of cinema hall
     */
    public CinemaHall copy() {
        return new CinemaHall(cinemaType, this.floorPlan.copy(), numberOfSeats, hallNumber, numberOfBookedSeats);
    }

}
