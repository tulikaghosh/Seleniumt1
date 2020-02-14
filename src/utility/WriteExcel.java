package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class WriteExcel {

	public void writeExcel(String fileName, String sheetName, String dataToWrite) throws IOException {

		try (FileInputStream fileIn = new FileInputStream(".\\TestExcel.xls")) {
			POIFSFileSystem fs = new POIFSFileSystem(fileIn);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row = sheet.getRow(2);
			if (row == null)
				row = sheet.createRow(4);
			HSSFCell cell = row.getCell(5);
			if (cell == null)
				cell = row.createCell(4);
			cell.setCellValue("a test");

			// Write the output to a file
			try (FileOutputStream fileOut = new FileOutputStream(".\\TestExcel.xls")) {
				wb.write(fileOut);
			}
		}
	}
}
