package pageclasses;

import org.openqa.selenium.By;

import utils.UiActionsUtils;

public class LoginPageClass {

	By headingLogin = By.xpath("//h2[text() = 'Login Page']");

	By username = By.id("username");
	By password = By.id("password");
	By btnsubmit = By.xpath("//button[@type='submit']");

	public void enterUsername(String usernameText) {
		UiActionsUtils.enterText(username, usernameText);
	}

	public void enterPassword(String pass) {
		UiActionsUtils.enterPassword(password, pass);
	}

	public String getHeading() {
		return UiActionsUtils.getText(headingLogin);
	}

	public void clickLogin() {
		UiActionsUtils.click(btnsubmit);
	}
}
