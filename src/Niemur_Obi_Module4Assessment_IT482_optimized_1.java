import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class Niemur_Obi_Module4Assessment_IT482_optimized_1 {

	public static void main(String[] args) throws IOException {
		String[] test = SelectionsortData();
		 
		
		
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
	
	
	public static String[] SelectionsortData() throws IOException {
		String[] arr = getData();
		int n = arr.length;
		for(int i = 0; i < n - 1; i++)
	    {
	     
	        // Find the minimum element in unsorted array
	        int min_index = i;
	        String minStr = arr[i];
	        for(int j = i + 1; j < n; j++)
	        {
	             
	         
	            if(arr[j].compareTo(minStr) < 0)
	            {
	                
	                minStr = arr[j];
	                min_index = j;
	            }
	        }
	 
	    // Swapping the minimum element
	    // found with the first element.
	    if(min_index != i)
	    {
	        String temp = arr[min_index];
	        arr[min_index] = arr[i];
	        arr[i] = temp;
	    }
	    }
		
		
	
		return arr;
	}

}
