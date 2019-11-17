package movielistingdao;

import java.util.List;

import utility.CSVFileIO;
import utility.CSVRow;

/*
 * Class accesses the Auth database
 * @author Lakshyajeet Dwivedee
 */
public class AuthDAO {

	/*
	 * Get the data from the CSV file
     * @return List of CSVRows containing the data of alluser's credentials 
	 */
    public static List<CSVRow> getUserCredentials() {
    	List<CSVRow> table = CSVFileIO.getParsedCSV("src/auth.csv");
    	return table;
    }
}