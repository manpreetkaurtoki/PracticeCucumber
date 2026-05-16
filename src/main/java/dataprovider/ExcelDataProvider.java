package dataprovider;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class ExcelDataProvider {
	@DataProvider(name = "loginData")
    public static Object[][] getLoginData() {

        String path = "src/test/resources/testdata/LoginData.xlsx";

        ExcelUtils excel = new ExcelUtils(path, "Sheet1");

        int rows = excel.getRowCount();
        int cols = excel.getColCount();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] = excel.getCellData(i, j);
               System.out.println( data[i - 1][j]);
            }
        }

        return data;
    }
}
