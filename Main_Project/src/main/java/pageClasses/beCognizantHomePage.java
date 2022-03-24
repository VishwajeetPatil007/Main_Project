package pageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.basePageClass;

public class beCognizantHomePage extends basePageClass{

	public beCognizantHomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//p[@id='user-name']")
	WebElement nameTag;
	
	@FindBy(xpath="//input[@id='searchbox']")
	WebElement searchbox;
	
	public void getNameTag() {
		try {
		String name = nameTag.getText();
		System.out.println("Name:"+name);
		logger.log(Status.PASS, "Name of Employee is Displayed on console Successfully.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
	}

	public truTimeListPage sendKeysToSearch(String keys) {
		try {
		searchbox.sendKeys(keys);
		logger.log(Status.PASS, "'TruTime' keys Entered Successfully in Search Box.");
		searchbox.sendKeys(Keys.ENTER);
		logger.log(Status.PASS, "'ENTER' key Sent to searchBox Successfully.");
		waitForPageLoad(3);
		
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
		truTimeListPage obj = new truTimeListPage(driver, logger);
		PageFactory.initElements(driver, obj);
		return obj;
	}
	
}
