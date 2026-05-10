package manager;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.BaseUtils;

public class DriverManager {
	private static WebDriver driver;

	public static void initDriver() throws IOException {
		String browser = BaseUtils.getConfigValue("browser");
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			ExtentTestManager.log.info("Chrome browser has launched");
			break;
		case "firefox":
			driver = new FirefoxDriver();
			ExtentTestManager.log.info("Firefox browser has launched");
			break;
		case "edge":
			driver = new EdgeDriver();
			ExtentTestManager.log.info("Edge browser has launched");
			break;
		default:
			System.out.println("Browser not supported!!");
			ExtentTestManager.log.info("No matching browser has found");
			break;

		}
		driver.manage().window().maximize();
		ExtentTestManager.log.info("Browser has been maximized");
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		driver.close();
		ExtentTestManager.log.info("All Browsers has been closed ");
	}

	public static void goToUrl(String url) {
		driver.get(url);
		ExtentTestManager.log.info(url+ " has opened");

	}
}
