package manager;

import java.util.List;

import utility.CSVFileIO;
import utility.CSVRow;

public class PriceManager {

	// Types of movies
    public static final int BLOCKBUSTER = 1;
    public static final int ROMANTIC = 2;
    public static final int COMEDY = 3;
    public static final int CRIME = 4;
    public static final int FANTASY = 5;
    public static final int HISTORY = 6;
    public static final int HORROR = 7;
    public static final int THREE_D = 8;

    
	private static final String Price_Path="src/price_csv.csv";
	public static void rewrite(String Path, List<CSVRow> table) {
		CSVFileIO.rewriteToCSV(Path,table);
	}
	
	public static int fetch(String Row)
	{	int ret;
		List<CSVRow> table = CSVFileIO.getParsedCSV(Price_Path);
		for(int i=0;i<table.size();i++)
		{
			if(table.get(i).getRow().get(0).compareTo(Row)==0)
			{
				ret = Integer.parseInt(table.get(i).getRow().get(1));
				return ret;
			}
		}
		
		return -1;
	}
	
	public static int fetch(int Row)
	{	int ret;
	String Row1;
		switch(Row) {
		case 1: Row1="Blockbuster";break;
		case 2: Row1 = "Romantic";break;
		case 3: Row1 = "Comedy";break;
		case 4: Row1 = "Crime";break;
		case 5: Row1 = "Fantasy";break;
		case 6: Row1 = "History";break;
		case 7: Row1=  "Horror";break;
		case 8: Row1= "3D";break;
		case 11: Row1 = "Platinum";break;
		default: Row1="";break;
			
		}
		List<CSVRow> table = CSVFileIO.getParsedCSV(Price_Path);
		for(int i=0;i<table.size();i++)
		{
			if(table.get(i).getRow().get(0).compareTo(Row1)==0)
			{
				ret = Integer.parseInt(table.get(i).getRow().get(1));
				return ret;
			}
		}
		
		return -1;
	}
	

}
