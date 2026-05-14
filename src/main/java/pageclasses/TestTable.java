package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import utils.WaitUtils;

public class TestTable {

	By table = By.xpath("//table[@id='courses_table']//tbody//tr");

	public List<WebElement> compareTableData() {
		return WaitUtils.visibilityOfAllElementsLocatedBy(table);

	}
}
