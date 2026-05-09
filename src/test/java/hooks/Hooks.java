package hooks;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import manager.DriverManager;
import utils.BaseUtils;
import utils.WaitUtils;

public class Hooks {

	WebDriverWait wait;

	@Before
	public void init() throws IOException {
		System.out.println("Init: I am in before method");
		DriverManager.initDriver();
		DriverManager.getDriver();
		WaitUtils.initWait();
		DriverManager.goToUrl(BaseUtils.getConfigValue("url"));
	}

	@After
	public void end() {
		System.out.println("End: I am in after method");
		DriverManager.quitDriver();
		System.out.println("entered in closing browser method");
	}
}
