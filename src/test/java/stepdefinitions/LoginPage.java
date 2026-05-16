package stepdefinitions;

import org.testng.Assert;

import dataprovider.ExcelDataProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageclasses.LoginPageClass;
import pageclasses.SecureAreaPage;
import pageclasses.WelcomeToTheInternet;

public class LoginPage {
	WelcomeToTheInternet wlObj;
	LoginPageClass loginObj;
	SecureAreaPage secureObj;

	@Given("user is on xyz site")
	public void user_is_on_xyz_site() {

	}

	@When("user clicks on form auth")
	public void user_clicks_on_form_auth() {
		wlObj = new WelcomeToTheInternet();
		wlObj.clickFormAuth();
	}

	@Then("user should land on login page")
	public void user_should_land_on_login_page() {
		loginObj = new LoginPageClass();
		String heading = loginObj.getHeading();
		Assert.assertEquals(heading, "Login Page");
	}

	@When("user enters username {string}")
	public void user_enters_username(String string) {
		loginObj.enterUsername(string);
	}

	@When("enter password {string}")
	public void enter_password(String string) {
		loginObj.enterPassword(string);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginObj.clickLogin();
	}

	@Then("user should see {string}")
	public void user_should_see(String result) {

		switch (result.toLowerCase()) {
		case "failure":
			System.out.println("Fail");
			System.out.println(ExcelDataProvider.getLoginData());
			break;

		case "success":
			secureObj = new SecureAreaPage();
			Assert.assertEquals(secureObj.getText(), "Secure Area");
			ExcelDataProvider.getLoginData();
			break;

		}
	}
}
