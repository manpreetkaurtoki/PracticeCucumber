package pageclasses;

import org.openqa.selenium.By;

import utils.UiActionsUtils;

public class WelcomeToTheInternet {

	By loginLink = By.xpath("//a[text()='Form Authentication']");

	public void clickFormAuth() {
		UiActionsUtils.click(loginLink);
	}
}
