package factory;

import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.configReader;

public class driverFactory {
	
	static WebDriver driver;

	public static void initializeBrowser(String browserName) {
        switch (browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                ThreadLocalDriver.setTLDriver(driver);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                ThreadLocalDriver.setTLDriver(driver);
            }
            case "edge" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new EdgeDriver();
                ThreadLocalDriver.setTLDriver(driver);
            }
        }
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
