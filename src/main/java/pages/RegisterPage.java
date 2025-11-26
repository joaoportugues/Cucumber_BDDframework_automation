package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy (id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy (id = "input-email")
	private WebElement emailField;
	
	@FindBy (id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy (id = "input-password")
	private WebElement passwordField;
	
	@FindBy (id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy (name = "agree")
	private WebElement privacyPolicyOption;
	
	@FindBy (xpath = "//label[normalize-space()='Yes']")
	private WebElement yesToNewsletterOption;
	
	@FindBy (xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	@FindBy (xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarning;
	
	@FindBy (xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarning;
	
	@FindBy (xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarning;
	
	@FindBy (xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarning;
	
	@FindBy (xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarning;
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	public void enterTelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public void enterConfirmPassword(String ConfirmPasswordText) {
		confirmPasswordField.sendKeys(ConfirmPasswordText);
	}
	public void selectPrivacyPolicy() {
		privacyPolicyOption.click();
	}
	public void selectYesNewsletterOption() {
		yesToNewsletterOption.click();
	}
	public void clickOnContinueButton() {
		continueButton.click();
	}
	public String getWarningMessageText() {
		return warningMessage.getText();
	}
	public String getFirstnameWarning() {
		return firstNameWarning.getText();
	}
	public String getLastnameWarning() {
		return lastNameWarning.getText();
	}
	public String getEmailWarning() {
		return emailWarning.getText();
	}
	public String getTelephoneWarning() {
		return telephoneWarning.getText();
	}
	public String getPasswordWarning() {
		return passwordWarning.getText();
	}
	
	
	
	

}
