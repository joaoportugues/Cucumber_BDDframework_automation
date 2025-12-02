package stepDefinitions;

import factory.ThreadLocalDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import factory.driverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;

import static factory.ThreadLocalDriver.getTLDriver;

public class searchStepDef {

	WebDriver driver = ThreadLocalDriver.getTLDriver();;
	HomePage homepage;
	SearchResultsPage searchResultsPage; 
	
	@Given ("User open the Application")
	public void User_open_the_Application () {
		System.out.println("Application is open");
	}
	@When ("User enters the existing product into search field {string}")
	public void User_enters_the_existing_product_into_search_field (String ProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductIntoSearchBox(ProductText);
		//driver.findElement(By.name("search")).sendKeys(existingProductText);
	}
	@And ("click on search button")
	public void click_on_search_button () {
		homepage.clickOnSearchButton();
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}
	@Then("the product should be displayed in search results")
	public void the_product_should_be_displayed_in_search_results () {
		searchResultsPage = new SearchResultsPage(driver);
		Assert.assertTrue(searchResultsPage.displayStatusOfValidProduct());
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	@When ("User enters the non existing product into search field {string}")
	public void User_enters_the_non_existing_product_into_search_field (String ProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductIntoSearchBox(ProductText);
		//driver.findElement(By.name("search")).sendKeys(nonExistingProductText);	
	}
	@Then("Proper information message should be displayed")
	public void Proper_information_message_should_be_displayed () {
		
		searchResultsPage = new SearchResultsPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.", searchResultsPage.getMessageText());
		//Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]")).getText());
	}
	@When ("User does not enters anything into search field")
	public void User_does_not_enters_anything_into_search_field () {
		homepage = new HomePage(driver);
	}
	
}
