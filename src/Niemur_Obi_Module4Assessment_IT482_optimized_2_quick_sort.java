import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class Niemur_Obi_Module4Assessment_IT482_optimized_2_quick_sort {

	public static void main(String[] args) throws IOException {
		String [] data = getData();
		String[] test = QuicsortData(data, 0, data.length-1);
		 
		
		
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
	
	
	public static String[] QuicsortData(String[] arr, int low, int high) throws IOException {
		
		 if (low < high) {
		        // Choose pivot element
		        String pivot = arr[high];

		        // Partition the array
		        int i = low - 1;
		        for (int j = low; j < high; j++) {
		            if (arr[j].compareTo(pivot) < 0) {
		                i++;
		                String temp = arr[i];
		                arr[i] = arr[j];
		                arr[j] = temp;
		            }
		        }

		        // Move pivot to correct position
		        String temp = arr[i+1];
		        arr[i+1] = arr[high];
		        arr[high] = temp;

		        // Recursively sort left and right partitions
		        int pi = i + 1;
		        QuicsortData(arr, low, pi - 1);
		        QuicsortData(arr, pi + 1, high);
		    }
	
		return arr;
	}

}
