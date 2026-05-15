package pageclasses;

import org.openqa.selenium.By;

import utils.UiActionsUtils;

public class RegisterPage {

	By firstName = By.id("first_name");
	By lastName = By.id("last_name");
	By city = By.id("city");
	By postal = By.id("postcode");
	By email = By.id("email");
	By phone = By.id("phone");

	public void enterfirstName(String fname) {
		UiActionsUtils.enterText(firstName, fname);

	}

	public void enterLastName(String lname) {
		UiActionsUtils.enterText(lastName, lname);

	}

	public void enterCity(String cityName) {
		UiActionsUtils.enterText(city, cityName);

	}

	public void enterPostal(String pcode) {
		UiActionsUtils.enterText(postal, pcode);

	}

	public void enterEmail(String emailVal) {
		UiActionsUtils.enterText(email, emailVal);

	}

	public void enterPhone(String phn) {
		UiActionsUtils.enterText(phone, phn);

	}
}
