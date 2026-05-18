package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtils;

public class ExcelDataProvider {
	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() {

		String path = "src/test/resources/testdata/LoginData.xlsx";

		ExcelUtils excel = new ExcelUtils(path, "Sheet1");

		int rows = excel.getRowCount();
		int cols = excel.getColCount();

		Object[][] data = new Object[rows - 1][cols];
		String rowData = "";
		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < cols; j++) {

				data[i - 1][j] = excel.getCellData(i, j);
				rowData += data[i - 1][j] + " ";
				System.out.println(data[i - 1][j]);
			}
			System.out.println("Row-wise data : " + rowData);
		}

		return data;
	}

	@DataProvider(name = "courseData")
	public static Object[][] getExcelCourseData() {

		Object[][] data = null;

		String path = "src/test/resources/testdata/CourseTableData.xlsx";

		ExcelUtils excel = new ExcelUtils(path, "Sheet1");

		int rows = excel.getRowCount();
		int cols = excel.getColCount();

		data = new Object[rows - 1][cols];
		String rowData = "";
		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < cols; j++) {

				data[i - 1][j] = excel.getCellData(i, j);
				rowData += data[i - 1][j] + " ";
				System.out.println(data[i - 1][j]);
			}
			System.out.println("Row-wise data : " + rowData);
		}

		return data;
	}

	@Test(dataProvider = "loginData")
	public void loginTest(String usrname, String password) {
		System.out.println(usrname);
		System.out.println(password);

	}

	
}
