package Hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.*;
import utils.configReader;

public class MyHooks {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		
		Properties prop = configReader.initializeProperties();
		driverFactory.initializeBrowser(prop.getProperty("browser"));
		driver = driverFactory.getDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
