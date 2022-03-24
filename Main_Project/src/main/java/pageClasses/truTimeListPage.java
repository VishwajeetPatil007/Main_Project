package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.basePageClass;

public class truTimeListPage extends basePageClass{

	public truTimeListPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//span[@ng-repeat='title in document.hitHighlights.appTitle']//span[@class='search-hit-highlight ng-scope'][normalize-space()='TruTime']")
	WebElement TruTime;
	
	public truTimeHomePage clickOnTruTime() {
		try {
		TruTime.click();
		waitForPageLoad(3);
		logger.log(Status.PASS, "'TruTime' option Clicked Successfully.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
		truTimeHomePage obj = new truTimeHomePage(driver, logger);
		PageFactory.initElements(driver, obj);
		return obj;
	}
	
}
