package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pageclasses.TestTable;

public class TestTableSteps {
	@Then("user should be see table data")
	public void user_should_be_see_table_data(DataTable dataTable) {
		TestTable tableoj = new TestTable();

		// Printing UI table Data row-wise
		List<WebElement> allrows = tableoj.compareTableData();
		for (WebElement element : allrows) {
			System.out.println(element.getText());

		}

		// Printing DataTable data
		List<Map<String, String>> dataTableFeature = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : dataTableFeature) {


			System.out.println("ID: " + row.get("ID"));
			System.out.println("Course Name: " + row.get("Course Name"));
			System.out.println("Language: " + row.get("Language"));
			System.out.println("Level: " + row.get("Level"));
			System.out.println("Enrollments: " + row.get("Enrollments"));
		}
		
		//Comparing UI and DataTable
		for (int i = 0; i < dataTableFeature.size(); i++) {
		
			List<WebElement> actualCol = allrows.get(i).findElements(By.tagName("td"));

			Map<String, String> expected = dataTableFeature.get(i);

			Assert.assertEquals(actualCol.get(0).getText(), expected.get("ID"));
			Assert.assertEquals(actualCol.get(1).getText(), expected.get("Course Name"));
			Assert.assertEquals(actualCol.get(2).getText(), expected.get("Language"));
			Assert.assertEquals(actualCol.get(3).getText(), expected.get("Level"));
			Assert.assertEquals(actualCol.get(4).getText(), expected.get("Enrollments"));
		}
		System.out.println("Size of Testcase : " + allrows.size());
		System.out.println("Size of Data Table : " + dataTableFeature.size());
		Assert.assertEquals(allrows.size(), dataTableFeature.size());
	}
}
