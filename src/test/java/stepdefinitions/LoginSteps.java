package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	WebDriverWait wait;
	By formAuth = By.xpath("//a[text()='Form Authentication']");
	By headingLogin = By.xpath("//h2[text() = 'Login Page']");
	By afterLoginHeading = By.xpath("//h2[text()=' Secure Area']");
	By username = By.id("username");
	By password = By.id("password");
	By btnsubmit = By.xpath("//button[@type='submit']");

	@Given("Chrome browser is opened")
	public void chrome_browser_is_opened() {
		driver = new ChromeDriver();

		System.out.println("Steps : Chrome browser is opened ");
	}

	@Given("user is on xyz site")
	public void user_is_on_xyz_site() {
		driver.get("https://the-internet.herokuapp.com");
		System.out.println("Steps: user is on xyz site");
	}

	@When("user clicks on Login link")
	public void user_clicks_on_login_link() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginlink = wait.until(ExpectedConditions.elementToBeClickable(formAuth));
		loginlink.click();

		System.out.println("Steps: user clicks on Login link");
	}

	@Then("user should land on login page")
	public void user_should_land_on_login_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(headingLogin));
		Assert.assertEquals(heading.getText(), "Login Page");
		System.out.println("Steps: user should land on login page ");
	}

	@When("user enters username {string}")
	public void user_enters_username(String string) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement usernameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		usernameEle.sendKeys("tomsmith");
		System.out.println("Steps: user enters username {string} ");
	}

	@When("enter password {string}")
	public void enter_password(String string) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement passwordEle = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		passwordEle.sendKeys("SuperSecretPassword!");
		System.out.println("Steps: enter password {string}");
	}

	@When("user clicks on Sign In")
	public void user_clicks_on_sign_in() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginClick = wait.until(ExpectedConditions.elementToBeClickable(btnsubmit));
		loginClick.click();
		System.out.println("Steps: user clicks on Sign In ");
	}

	@Then("user should be successfully logged in")
	public void user_should_be_successfully_logged_in() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement afterHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(afterLoginHeading));
		Assert.assertEquals(afterHeading.getText(), "Secure Area");
		System.out.println("Steps: user should be successfully logged in");
	}
}
