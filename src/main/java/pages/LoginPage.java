package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "input-email")
	private WebElement emailField;
	
	@FindBy (id = "input-password")
	private WebElement passwordField;
	
	@FindBy (xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement WarningMessage;
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	public void enterPassword (String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public String getWarningMessage() {
		return WarningMessage.getText();
	}

}
