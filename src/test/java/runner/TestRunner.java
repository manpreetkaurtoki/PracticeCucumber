package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features= "src/test/resources/features/Register.feature",
		glue = {"stepdefinitions","hooks"},
		plugin = {"pretty",
				"html:target/cucumber-report.html",
				"json:target/report.json"},
	
		dryRun = false
		
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
