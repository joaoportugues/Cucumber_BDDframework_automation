package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.configReader;

public class driverFactory {
	
	static WebDriver driver = null;
	
	public static void initializeBrowser(String browserName) {
		
		
		if (browserName.equals("chrome")) {
			
			driver = new ChromeDriver();
		
		}else if(browserName.equals("firefox")){
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("edge")){
			
			driver = new EdgeDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	public static WebDriver getDriver() {
		return driver;
	}

}
