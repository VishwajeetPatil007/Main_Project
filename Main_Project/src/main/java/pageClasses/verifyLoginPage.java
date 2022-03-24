package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.basePageClass;



public class verifyLoginPage extends basePageClass{

	public verifyLoginPage(WebDriver driver, ExtentTest logger) {
		
		super(driver,logger);
	}
	
	@FindBy(xpath="//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//div[1]//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[2]")
	WebElement textField;
	
	@FindBy(xpath="//input[@id='idTxtBx_SAOTCC_OTC']")
	WebElement otpTextbox;
	
	@FindBy(xpath="//input[@id='idSubmit_SAOTCC_Continue']")
	WebElement verifyButton;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement yesButton;
	
	public void clickOntext() {
		try {
		textField.click();
		logger.log(Status.PASS, "'Send Text Message' Clicked Successfully.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
	}
	
	public void enterOTP(String otp) {
		try {
		otpTextbox.sendKeys(otp);
		logger.log(Status.PASS, "OTP Entered Successfully.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
	}
	
	public void clickOnVerify() {
		try {
		verifyButton.click();
		waitForPageLoad(3);
		logger.log(Status.PASS, "Verify button Clicked Successfully.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
	}
	
	public beCognizantHomePage clickOnYes() {
		try {
		yesButton.click();
		waitForPageLoad(3);
		logger.log(Status.PASS, "'Yes' Option Clicked Successfully.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
		beCognizantHomePage home = new beCognizantHomePage(driver, logger);
		PageFactory.initElements(driver, home);
		return home;
	}
	
	
	
	
	
}
