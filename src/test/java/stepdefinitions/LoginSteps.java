package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("Chrome browser is opened")
	public void chrome_browser_is_opened() {
		System.out.println("Steps : Chrome browser is opened ");
	}

	@Given("user is on xyz site")
	public void user_is_on_xyz_site() {
		System.out.println("Steps: user is on xyz site");
	}

	@When("user clicks on Login link")
	public void user_clicks_on_login_link() {
		System.out.println("Steps: user clicks on Login link");
	}

	@Then("user should land on login page")
	public void user_should_land_on_login_page() {
		System.out.println("Steps: user should land on login page ");
	}

	@When("user enters username {string}")
	public void user_enters_username(String string) {
		System.out.println("Steps: user enters username {string} ");
	}

	@When("enter password {string}")
	public void enter_password(String string) {
		System.out.println("Steps: enter password {string}");
	}

	@When("user clicks on Sign In")
	public void user_clicks_on_sign_in() {
		System.out.println("Steps: user clicks on Sign In ");
	}

	@Then("user should be successfully logged in")
	public void user_should_be_successfully_logged_in() {
		System.out.println("Steps: user should be successfully logged in");
	}
}
