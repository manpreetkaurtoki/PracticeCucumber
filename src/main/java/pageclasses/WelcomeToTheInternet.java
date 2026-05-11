package pageclasses;

import org.openqa.selenium.By;

import utils.UiActionsUtils;

public class WelcomeToTheInternet {

	By loginLink = By.xpath("//a[text()='Form Authentication']");
	By dragdroplink = By.xpath("//a[text()='Drag and Drop']");

	public void clickFormAuth() {
		UiActionsUtils.click(loginLink);
	}

	public void clickDragDrop() {
		UiActionsUtils.click(dragdroplink);
	}

}
