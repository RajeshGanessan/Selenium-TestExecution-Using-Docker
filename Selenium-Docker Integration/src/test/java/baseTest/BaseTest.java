package baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.xml.XmlTest;

public class BaseTest {

	protected WebDriver driver;
	public static Properties prop;

	@BeforeTest
	public void setup(ITestContext context) throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		String host = "localhost";


		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}
		String TestName = context.getCurrentXmlTest().getName();
		String completeUrl = "http://" + host + ":4444/wd/hub";

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {

			FirefoxOptions Fireoptions = new FirefoxOptions();
			this.driver = new RemoteWebDriver(new URL(completeUrl), Fireoptions);

		}else {
			options.setCapability("name", TestName );
//			this.driver = new RemoteWebDriver(new URL(completeUrl), options);

			WebDriverManager.chromedriver().setup();

			this.driver = new ChromeDriver();
		}

	}


	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
