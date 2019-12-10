package entities;

import java.io.Serializable;

/**
 * A entity that represents the floor plan for a single {@link CinemaHall}
 *
 * @author Gan Shyan
 */
public class FloorPlan implements Serializable {

    /**
     * Value of 1 indicates that a seat is booked
     */
    public static final int BOOKED = 1;

    /**
     * Value of 0 indicates that a seat is empty
     */
    public static final int FREE = 0;

    /**
     * Value of -1 indicates that a slot is not actually a seat
     */
    private static final int NOT_A_SEAT = -1;

    /**
     * UI printing element of a booked seat
     */
    private static final String bookedSeatElement = "[x]";

    /**
     * UI printing element of a empty seat
     */
    private static final String emptySeatElement = "[ ]";

    /**
     * UI printing element of a not seat element
     */
    private static final String notASeatElement = "   ";

    /**
     * A 2D array which represents the seating plan
     */
    private int[][] seatingPlan;

    /**
     * Number of rows of the floor plan
     */
    private int numberOfRows;

    /**
     * Number of columns of the floor plan
     */
    private int numberOfColumns;

    /**
     * Constructor
     *
     * @param seatingPlan     Seating plan
     * @param numberOfRows    Number of rows of the cinema hall
     * @param numberOfColumns Number of columns of the cinema hall
     */
    public FloorPlan(int[][] seatingPlan, int numberOfRows, int numberOfColumns) {
        this.seatingPlan = seatingPlan;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    /**
     * Change the status of a seat.
     *
     * @param status New seat status
     * @param row    Row index of seat
     * @param column Column index of seat
     * @return boolean value indicating if the change in the seat status is successive
     */
    public boolean setSeatStatus(int status, int row, int column) {
        if (seatingPlan[row][column] == NOT_A_SEAT) { // That empty 'seat' is not actually a seat, thus status cannot change
            return false;
        } else {
            if (status == BOOKED && seatingPlan[row][column] == BOOKED) // Trying to book a seat which is already booked
            {
                return false;
            } else if (status == FREE && seatingPlan[row][column] == FREE) { // Trying to unbook a seat which is not booked
                return false;
            } else {
                seatingPlan[row][column] = status;
                return true;
            }
        }
    }

    /**
     * Check if a seat is available
     *
     * @param row    Row index of seat
     * @param column Column index of seat
     * @return True if seat is free for booking, false if else
     */
    public boolean getSeatStatus(int row, int column) {
        if (seatingPlan[row][column] == FREE) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Print out the floor plan of the cinema hall.
     */
    public void printOutFloorPlan() {

        char rowIndex = 'A';

        // Print the first row (which is the column index)
        System.out.print("        ");
        for (int k = 0; k < numberOfColumns; k++) {
            if (k < 9) {
                System.out.print(k + 1 + "  ");
            } else {
                System.out.print(k + 1 + " ");
            }
            if (k == 8) {
                System.out.print("  ");
            }

        }
        System.out.print("\n");

        // Print the rows consecutively
        for (int i = 0; i < numberOfRows; i++) {
            System.out.print(rowIndex + "      ");
            for (int j = 0; j < numberOfColumns; j++) {
                if (j == 9) {
                    System.out.print("  ");
                }
                if (seatingPlan[i][j] == 0) { // Empty seat
                    System.out.print(emptySeatElement);
                } else if (seatingPlan[i][j] == 1) { // Booked seat
                    System.out.print(bookedSeatElement);
                } else if (seatingPlan[i][j] == -1) {    // Not a seat
                    System.out.print(notASeatElement);
                }

            }
            System.out.print("\n");
            rowIndex += 1;
        }
    }

    /**
     * Copy this object and returns it
     *
     * @return New instance of FloorPlan object
     */
    public FloorPlan copy() {
        return new FloorPlan(seatingPlan.clone(), numberOfRows, numberOfColumns);
    }

}
