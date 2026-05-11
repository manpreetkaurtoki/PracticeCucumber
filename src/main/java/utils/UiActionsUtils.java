package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import manager.ExtentTestManager;

public class UiActionsUtils {

	public static String getText(By locator) {
		return WaitUtils.visibilityOfElementLocated(locator).getText();
	}

	public static void enterText(By locator, String text) {

		WaitUtils.visibilityOfElementLocated(locator).sendKeys(text);
		ExtentTestManager.log.info("Entered Text : " + text);
	}

	public static void enterPassword(By locator, String text) {

		WaitUtils.visibilityOfElementLocated(locator).sendKeys(text);
		ExtentTestManager.log.info("Entered Password : " + "*******");
		
	}

	public static void click(By locator) {
		WaitUtils.elementToBeClickable(locator).click();
		ExtentTestManager.log.info(locator + " has been clicked");
	}

	public static void dragAndDrop(By source, By target) {
		WebElement sourceA = WaitUtils.find(source);
		WebElement sourceB = WaitUtils.find(target);
		WaitUtils.find(target);
		WaitUtils.actions().dragAndDrop(sourceA, sourceB).perform();
		ExtentTestManager.log.info("Source A is dragged to B");
	}
}
