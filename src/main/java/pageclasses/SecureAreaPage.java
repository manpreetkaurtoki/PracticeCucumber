package pageclasses;

import org.openqa.selenium.By;

import utils.UiActionsUtils;

public class SecureAreaPage {
	By afterLoginHeading = By.xpath("//h2[text()=' Secure Area']");

	public String getText() {
		return UiActionsUtils.getText(afterLoginHeading);
	}
}
