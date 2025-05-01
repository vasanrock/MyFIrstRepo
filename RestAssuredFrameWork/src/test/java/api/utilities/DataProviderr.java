package api.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviderr 
{

	@DataProvider(name = "data")
	
	public String[][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//test-data//data.xlsx";
		ExcelUtilitis xl = new ExcelUtilitis();
		int rowCount = xl.rowCount(path, "Sheet1");
		int cellCount = xl.cellCount(path, "Sheet1");
		
		String data[][] = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) 
		{
			for (int j = 0; j < cellCount; j++) 
			{
				data[i-1][j] = xl.CellData(path, "Sheet1",i,j);
			}
		}
		
		return data;
	
	}
	
	@DataProvider(name = "username")
public String[] userName() throws IOException
	{
		String path = System.getProperty("user.dir")+"//test-data//data.xlsx";
		ExcelUtilitis xl = new ExcelUtilitis();
		int rowCount = xl.rowCount(path, "Sheet1");
		
		String user[]= new String[rowCount];
		for (int i = 1; i <=  rowCount; i++) 
		{
			user[i-1]= xl.CellData(path, "Sheet1",i,1);
		
		}
		
		return user;
	}
	
	
	

}
