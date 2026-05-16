package hooks;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
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
	public void end(Scenario scenario)
			throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException {
		if (scenario.isFailed()) {
			String errorMessage = scenario.getStatus().toString();
			ExtentTestManager.log.fail("1 " + errorMessage);
			Field delegate = scenario.getClass().getDeclaredField("delegate");
			delegate.setAccessible(true);
			Object testCaseState = delegate.get(scenario);

			Field errorField = testCaseState.getClass().getDeclaredField("error");
			errorField.setAccessible(true);
			Throwable error = (Throwable) errorField.get(testCaseState);

			ExtentTestManager.log.fail(error.getMessage(),
					MediaEntityBuilder
							.createScreenCaptureFromPath(BaseUtils.getScreenShotPath(DriverManager.getDriver(),
									scenario.getClass().getName() + "." + scenario.getName()))
							.build());

		} else if (scenario.getStatus().equals(Status.SKIPPED)) {
			ExtentTestManager.log.skip("Test Skipped");
		}

		else

		{
			ExtentTestManager.log.pass("Test Passed");
		}

		System.out.println("End: I am in after method");
		DriverManager.quitDriver();
		System.out.println("entered in closing browser method");

	}

	@AfterAll
	public static void tearDown() {
		ExtentManager.flushReport();
	}
}
