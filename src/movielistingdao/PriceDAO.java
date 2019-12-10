package movielistingdao;

import java.util.List;

import utility.CSVFileIO;
import utility.CSVRow;

public class PriceDAO {
	public static void insertPrice(CSVRow priceData) {
    	CSVFileIO.writeToCSV("src/price_csv.csv", priceData);
    }

    /*
     * Get reviews data from the CSV file
     * @return List of CSVRows containing the data of all reviews
     */
    public static List<CSVRow> getPrice() {
    	List<CSVRow> table = CSVFileIO.getParsedCSV("src/reviews.csv");
    	return table;
    }

}
