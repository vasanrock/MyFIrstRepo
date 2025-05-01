package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilitis 
{
	/*
	 * rownCount = will count the entire row in excel
	 * cellCount = will count the entire column in excel
	 * allCellData = get all data from excel
	 * CellData = get specific set of value
	 * setCellData = create column and set value in existing excel file
	 * 
	 */

	public int rowCount(String filePath,String sheetName) throws IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workBook.close();
		return rowCount;
	}

	public int cellCount(String filePath,String sheetName) throws IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		int cellCount = sheet.getRow(0).getLastCellNum();
		workBook.close();
		return cellCount;
	}

	public void allData(String filePath,String sheetName) throws IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i <= rowCount; i++) 
		{
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cellCount; j++) 
			{
				String cell = row.getCell(j).toString();
				System.out.print(cell+"\t");
			}
			System.out.println();
		}
		workBook.close();
	}

	public  String CellData(String filePath,String sheetName,int row,int cell) throws IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		XSSFRow row2 = sheet.getRow(row);
		String cell2 = null ;
		try {
			cell2 = row2.getCell(cell).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		System.out.println("Cell is empty");
		}
		workBook.close();
		return cell2;
	}
	
	public  void setCellData(String filePath,String sheetName,int row,int col,String data) throws IOException
	{
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		XSSFRow row2 = sheet.getRow(row);
		row2.createCell(col).setCellValue(data);
		file.close();
		FileOutputStream file1 = new FileOutputStream(filePath);
		workBook.write(file1);
		workBook.close();
		file1.close();
		

		
		
	}
	




}
