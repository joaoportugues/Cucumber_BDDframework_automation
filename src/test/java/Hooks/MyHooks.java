package Hooks;

import java.time.Duration;
import java.util.Properties;

import factory.ThreadLocalDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.configReader;


public class MyHooks {
	WebDriver driver;

	@Before
	public void setUp() {
		Properties prop = configReader.initializeProperties();
		driverFactory.initializeBrowser(prop.getProperty("browser"));
		driver = ThreadLocalDriver.getTLDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown() {
		ThreadLocalDriver.getTLDriver().quit();
	}
}
