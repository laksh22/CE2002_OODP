package movielistingdao;

/**
 * Class to Manage Holidays database
 *
 * @author Vivek Adrakatti
 */
public class HolidaysManager {

    public static final String Date_Path = "holidays.csv"; //File Path

    /**
     * Function to write a date to CSV
     *
     * @param date
     */
    public static void addHolidayDates(String date) {
        HolidaysDAO.addHolidays(date);
    }
}
