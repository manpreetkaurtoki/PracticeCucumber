package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverManager;
import pageclasses.RegisterPage;

public class RegisterSteps {
	@Given("user is on register page")
	public void user_is_on_register_page() {
		DriverManager.goToUrl("https://with-bugs.practicesoftwaretesting.com/#/auth/register");
	}

	@When("user enter required fields {string} {string} {string} {string} {string} {string}")
	public void user_enter_required_fields(String firstname, String lastname, String city, String postalcode,
			String email, String phone) {

		RegisterPage regisObj = new RegisterPage();
		regisObj.enterfirstName(firstname);
		regisObj.enterLastName(lastname);
		regisObj.enterCity(city);
		regisObj.enterPostal(postalcode);
		regisObj.enterEmail(email);
		regisObj.enterPhone(phone + "");
	}

	@Then("print all entered fields")
	public void print_all_entered_fields() {
		System.out.println("Printed");

	}
}
