   package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class RegisterStepdef {
	
	WebDriver driver;
	HomePage homepage;
	RegisterPage registerPage;

	@Given ("User navigates to Account registration page")
	public void User_navigates_to_Account_registration_page () {
		driver = driverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		//driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		homepage.selectRegisterOption();
		//driver.findElement(By.linkText("Register")).click();
		}
	
	@When ("User enters below details in the fields")
	public void User_enters_below_details_in_the_fields (DataTable dataTable) {
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		
		registerPage = new RegisterPage(driver);
		
		registerPage.enterFirstName(map.get("firstName"));
		//driver.findElement(By.id("input-firstname")).sendKeys(map.get("firstName"));
		
		registerPage.enterLastName(map.get("lastName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(map.get("lastName"));
		
		registerPage.enterEmail(CommonUtils.EmailGeneratorByTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(CommonUtils.EmailGeneratorByTimeStamp());
		
		registerPage.enterTelephone(map.get("telephone"));
		//driver.findElement(By.id("input-telephone")).sendKeys(map.get("telephone"));
		
		registerPage.enterPassword(map.get("password"));
		//driver.findElement(By.id("input-password")).sendKeys(map.get("password"));
		
		registerPage.enterConfirmPassword(map.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(map.get("password"));
	}

	@And ("User selects yes for newsletter option")
	public void User_selects_yes_for_newsletter_option () {
		registerPage.selectYesNewsletterOption();
		//driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
	}
	@And ("User select private policy field")
	public void User_select_private_policy_field () {
		registerPage.selectPrivacyPolicy();
		//driver.findElement(By.name("agree")).click();
	}
	@And ("User clicks on Continue button")
	public void User_clicks_on_Continue_button () {
		registerPage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	@Then ("User account get created successfully")
	public void User_account_get_created_successfully () {
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
		//Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText().contains("Your Account Has Been Created!"));
	}
	@When ("User does not enter any fields")
	public void User_does_not_enter_any_fields () {
		registerPage = new RegisterPage(driver);
	}
	@Then ("Warning messages should be displayed under all the respective fields")
	public void Warning_messages_should_be_displayed_under_all_the_respectivev_fields () {
		
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstnameWarning());
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText().contains("First Name must be between 1 and 32 characters!"));
		
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastnameWarning());
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText().contains("Last Name must be between 1 and 32 characters!"));
		
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarning());
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText().contains("E-Mail Address does not appear to be valid!"));
		
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText().contains("Telephone must be between 3 and 32 characters!"));
		
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarning());
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText().contains("Password must be between 4 and 20 characters!"));;
	}
	@Then ("Warning message about email address already exists")
	public void Warning_message_about_email_address_already_exists () {
		//Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: E-Mail Address is already registered!")); 
	}
}
