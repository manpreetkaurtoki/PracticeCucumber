package utils;

import org.openqa.selenium.By;

public class UiActionsUtils {

	public static String getText(By locator) {
		return WaitUtils.visibilityOfElementLocated(locator).getText();
	}

	public static void enterText(By locator, String text) {

		WaitUtils.visibilityOfElementLocated(locator).sendKeys(text);
	}

	public static void enterPassword(By locator, String text) {

		WaitUtils.visibilityOfElementLocated(locator).sendKeys(text);
	}

	public static void click(By locator) {
		WaitUtils.elementToBeClickable(locator).click();

	}
}
