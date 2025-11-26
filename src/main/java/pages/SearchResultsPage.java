package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;
	
	public SearchResultsPage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy (xpath = "//p[contains(text(),'There is no product that matches the search criteria')]")
	private WebElement messageText;
	
	public boolean displayStatusOfValidProduct() {
		return validHPProduct.isDisplayed();
	}
	public String getMessageText() {
		return messageText.getText();
	}

}
