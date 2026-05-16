package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static Workbook workbook;
	static Sheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {

		try {
			FileInputStream fis = new FileInputStream(excelPath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public int getColCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}

	public String getCellData(int row, int col) {

		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(sheet.getRow(row).getCell(col));
	}
}
