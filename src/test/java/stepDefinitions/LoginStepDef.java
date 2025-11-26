package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.driverFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class LoginStepDef {

	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountPage;
	
	@Given("User navigates to Login page")
	public void user_navigates_to_login_page() {
		driver = driverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectLoginOption();
		}	

	@When("User enters the valid email address {string}")
	public void user_enters_the_valid_email_address(String email){
		loginpage = new LoginPage(driver);
		loginpage.enterEmail(email);
	}

	@And("Enters valid password {string}")
	public void enters_valid_password(String password) {
	loginpage.enterPassword(password);	   
	}	

	@And("Clicks on Login button")
	public void clicks_on_login_button() {
		loginpage.clickOnLoginButton();
	}

	@Then("User should Login successfully.")
	public void user_should_login_successfully() {
		accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInfoOption());
	}

	@When("User enters the invalid email address")
	public void user_enters_the_invalid_email_address() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmail(CommonUtils.EmailGeneratorByTimeStamp());
	}

	@And("Enters invalid password {string}")
	public void enters_invalid_password(String invalidPasswordText) {
		loginpage.enterPassword(invalidPasswordText);
	}

	@Then("User should not Login and get proper warning message.")
	public void user_should_not_login_and_get_proper_warning_message() {
		Assert.assertTrue(loginpage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User does not enters any credentials")
	public void User_does_not_enters_any_credentials() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmail("");
		loginpage.enterPassword("");
	}
	
}
