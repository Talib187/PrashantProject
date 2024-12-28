package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ErailXLUtils {

	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;

	String path;

	public ErailXLUtils(String path) {

		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() + 1; // It return index of last row how I am adding 1 here.
		wb.close();
		fis.close();

		return rowCount;
	}

	public int getCellCount(String sheetName, int rowNum) throws IOException {

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();

		return cellCount;
	}

	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell); // return the formatted value of String
		}

		catch (Exception e) {

			data = "";
		}
		wb.close();
		fis.close();
		return data;
	}

	// New method to write a list of values to an Excel file
	public void writeListToExcel(List<String> values, String sheetName) throws IOException {

		try (FileOutputStream fos = new FileOutputStream(path)) {
			wb = new XSSFWorkbook();
			sheet = wb.createSheet(sheetName);

			// Write each value into a new row
			for (int i = 0; i < values.size(); i++) {
				row = sheet.createRow(i); // Create a new row for each value
				cell = row.createCell(0); // Write to the first column (index 0)
				cell.setCellValue(values.get(i));
			}

			// Write the workbook to the file
			wb.write(fos);
			System.out.println("Excel file updated successfully with dropdown values!");
		} finally {
			if (wb != null) {
				wb.close();
			}
		}
	}
	
	
	
	
/*	public void writeListToExcel(List<String> values, String sheetName) throws IOException {
	    // Open the existing Excel file in read-write mode
	    FileInputStream fis = new FileInputStream(path);
	    wb = new XSSFWorkbook(fis);  // Open the existing workbook
	    sheet = wb.getSheet(sheetName);
	    
	    if (sheet == null) {
	        // If the sheet doesn't exist, create a new one
	        sheet = wb.createSheet(sheetName);
	    }
	    
	    // Get the last used row number in the sheet
	    int rowNum = sheet.getLastRowNum();
	    
	    // Write data starting from the next row after the last used row
	    for (int i = 1; i < values.size(); i++) {
	        row = sheet.createRow(rowNum + 1);  // Create a new row after the last row
	        cell = row.createCell(0);           // Write to the first column (index 0)
	        cell.setCellValue(values.get(i-1));  // Set the value for each cell
	        rowNum++;                          // Increment rowNum to move to the next row
	    }
	    
	    // Save the changes to the Excel file
	    try (FileOutputStream fos = new FileOutputStream(path)) {
	        wb.write(fos);  // Write the updated workbook to the file
	        System.out.println("Excel file updated successfully with new values.");
	    } finally {
	        // Close the workbook and input stream
	        fis.close();
	        wb.close();
		}

	}
	*/
}

