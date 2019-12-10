package bookingdao;

import java.util.List;

import utility.CSVFileIO;
import utility.CSVRow;

/*
 * Class accesses the Booking database
 * @author Lakshyajeet Dwivedee
 */
public class BookingDAO {

    /*
     * Insert a new booking into BookingDB CSV file
     * @param bookingData CSVRow containing the data of the booking
     */
    public static void insertBooking(CSVRow bookingData) {
        CSVFileIO.writeToCSV("src/bookings.csv", bookingData);
    }

    /*
     * Get booking data from the CSV file
     * @return List of CSVRows containing the data of all bookings
     */
    public static List<CSVRow> getBookings() {
        List<CSVRow> table = CSVFileIO.getParsedCSV("src/bookings.csv");
        return table;
    }
}
