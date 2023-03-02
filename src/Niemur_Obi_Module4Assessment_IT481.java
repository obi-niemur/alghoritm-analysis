import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class Niemur_Obi_Module4Assessment_IT481 {

	public static void main(String[] args) throws IOException {
		String[] test = BubblesortData();
		 
		
		
		long startTime = System.currentTimeMillis();
		 
		 for (String t : test) {
			 
				System.out.println(t); 
			} 
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
	      System.out.println("");
	      System.out.println("Sort took " + elapsedTime + " milliseconds");
	}

	public static String[] getData() throws IOException {
		FileInputStream fis = new FileInputStream(new File("large.xls"));
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		ArrayList<String> data = new ArrayList<String>();

		// Get reference of the worksheet
		HSSFSheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) // iteration over row using for each loop
		{
			for (Cell cell : row) // iteration over cell using for each loop
			{
				data.add(cell.getStringCellValue());
				break; 
			}
		}
		return data.toArray(new String[0]);
	}
	
	
	public static String[] BubblesortData() throws IOException {
		String[] test = getData();
		String temp; 
	     System.out.println("Sorted string...");
	     for (int j = 0; j < test.length; j++) {
	         for (int i = j + 1; i < test.length; i++) {
	            // comparing strings
	            if (test[i].compareTo(test[j]) < 0) {
	               temp = test[j];
	               test[j] = test[i];
	               test[i] = temp;
	            }
	         }
	         
		
	}
		return test;
	}

}
