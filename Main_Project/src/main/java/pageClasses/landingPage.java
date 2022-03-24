package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.basePageClass;

public class landingPage extends basePageClass{

	public landingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	
	@FindBy(xpath="//input[@id='i0116']")
	WebElement signInTextbox;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement nextButton;
	
	@FindBy(xpath="//input[@id='i0118']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement signInButton;
	
	public void enterEmail(String Email) {
		try {
		signInTextbox.sendKeys(Email);
		logger.log(Status.PASS, "Email Id is Entered Successfully.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
	}
	
	public void clickOnNext() {
		try {
		nextButton.click();
		waitForPageLoad(3);
		logger.log(Status.PASS, "Next Button is clicked successfully.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
	}
	
	public void enterPassword(String Password) {
		
		try {
		passwordTextBox.sendKeys(Password);
		logger.log(Status.PASS, "Password is Entered Successfully.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
	}
	
	public verifyLoginPage clickOnsignIn() {
		try {
		signInButton.click();
		waitForPageLoad(3);
		logger.log(Status.PASS, "SignIn button Clicked Successfully.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
		verifyLoginPage verify = new verifyLoginPage(driver, logger);
		PageFactory.initElements(driver, verify);
		return verify;
	}

}
