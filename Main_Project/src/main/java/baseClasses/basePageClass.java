package baseClasses;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageClasses.landingPage;
import utilityClasses.dateUtils;

public class basePageClass extends baseTestClass{

	public ExtentTest logger;

	public basePageClass(WebDriver driver, ExtentTest logger) {
		this.logger = logger;
		this.driver = driver;
	}
	
	/*************Wait UntilElement is Clickable***************/
	public void isClickable(WebElement element) {
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**************Open Application***************/
	public landingPage openApplication() {
		logger.log(Status.INFO, "Openeing The Website");
		
		driver.get(getProperty("baseURL"));
		
		logger.log(Status.PASS, "Website Opened Successfully");
		landingPage landingpage = new landingPage(driver,logger);
		PageFactory.initElements(driver, landingpage);
		return landingpage;
		
	}
	
	
	
	/*********************Get Page Title*************************/

	public void getTitle(String ExpectedTitle) {
		try {
		Assert.assertEquals(driver.getTitle(), ExpectedTitle);
		reportPass("Actual title :"+ driver.getTitle()+" equals to Expected title:"+ExpectedTitle);
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	
	/************Reporting Functions**************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		Assert.fail(reportString);

	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);

	}

	public void takeScreenshot() {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(
				System.getProperty("user.dir") + "\\screenShots\\" + dateUtils.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\screenShots\\" + dateUtils.getTimeStamp() + ".png");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**********GEt All elements of DropDown**************/
	public List getAllElementsDropdown(WebElement element) {
		
		try {
			Select sel = new Select(element);
			List<WebElement> allElements = sel.getOptions();
			return allElements;
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		return null;
		
	}
	
	/**********Sends text in TextBox**************/
	public void EnterText(WebElement element, String text) {
		element.sendKeys(text);
	}
}
