package hooks;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import manager.DriverManager;
import manager.ExtentManager;
import manager.ExtentTestManager;
import utils.BaseUtils;
import utils.WaitUtils;

public class Hooks {

	WebDriverWait wait;

	@BeforeAll
	public static void initialise() throws IOException {
		ExtentManager.initReport();
	}

	@Before
	public void init(Scenario scenario) throws IOException {
		System.out.println("Init: I am in before method");
		ExtentTestManager.createTest(scenario.getStatus().name());
		DriverManager.initDriver();
		DriverManager.getDriver();
		WaitUtils.initWait();
		DriverManager.goToUrl(BaseUtils.getConfigValue("url"));
	}

	@After
	public void end(Scenario scenario) {
		if (scenario.isFailed()) {

			String errorMessage = scenario.getStatus().toString();

			Throwable error = getError(scenario);
			ExtentTestManager.log.fail("1 "+errorMessage); //print fail
			ExtentTestManager.log.fail("2 "+error); //print null
			ExtentTestManager.log.fail("3 "+error.getClass().getName()); // doesnt add
		} else {
			ExtentTestManager.log.pass("Test Passed");
		}

		System.out.println("End: I am in after method");
		DriverManager.quitDriver();
		System.out.println("entered in closing browser method");

	}

	private Throwable getError(Scenario scenario) {

		try {

			java.lang.reflect.Field field = scenario.getClass().getDeclaredField("delegate");

			field.setAccessible(true);

			Object delegate = field.get(scenario);

			java.lang.reflect.Method method = delegate.getClass().getMethod("getError");

			return (Throwable) method.invoke(delegate);

		} catch (Exception e) {

			return null;
		}
	}

	@AfterAll
	public static void tearDown() {
		ExtentManager.flushReport();
	}
}
