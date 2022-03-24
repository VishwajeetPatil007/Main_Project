package baseClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilityClasses.extentReportManager;

public class baseTestClass{
	public WebDriver driver = null;
	public ExtentReports report = extentReportManager.getReportInstance();
	public ExtentTest logger;
	public static Properties prop;
	
	/*****************Reading properties file**********/
	public String getProperty(String key) {

		prop = new Properties();

		try {
			prop.load(new FileInputStream(System.getProperty("user.dir")+"\\testData\\config.properties"));
			String s = prop.getProperty(key);
			return s;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	
	/**************** Invoke Browser *****************/
	public void invokeBrowser(String browsername) throws IOException {

		try {
			if (browsername.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				//WebDriverManager.chromedriver().setup();
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--disable-blink-features=AutomationControlled");
				driver = new ChromeDriver(co);
			} else if (browsername.equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
				
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setProfile(new FirefoxProfile());
				firefoxOptions.addPreference("dom.webnotifications.enabled", false);
				driver = new FirefoxDriver(firefoxOptions);
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

	}

	public void waitForPageLoad(double i) {
		try {
			Thread.sleep((long) (i * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
