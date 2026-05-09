package utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import manager.DriverManager;

public class WaitUtils {
	private static WebDriverWait wait;

	public static void initWait() throws NumberFormatException, IOException {
		wait = new WebDriverWait(DriverManager.getDriver(),
				Duration.ofSeconds(Integer.parseInt(BaseUtils.getConfigValue("wait"))));
	}

	public static WebDriverWait getWait() {
		return wait;

	}

	public static WebElement elementToBeClickable(By element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement visibilityOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
