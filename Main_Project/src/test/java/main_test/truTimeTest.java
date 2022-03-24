package main_test;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.basePageClass;
import baseClasses.baseTestClass;
import pageClasses.beCognizantHomePage;
import pageClasses.landingPage;
import pageClasses.truTimeHomePage;
import pageClasses.truTimeListPage;
import pageClasses.verifyLoginPage;

public class truTimeTest extends baseTestClass{
	
	landingPage landingpage;
	verifyLoginPage verifyloginpage;
	beCognizantHomePage homePage;
	truTimeListPage trutimelistpage;
	truTimeHomePage truetimehome;
	
	@BeforeMethod
	public void invokeBrowser() {
		try {
			invokeBrowser(getProperty("browsename"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getUrl() {
		logger = report.createTest("JustDial WebSite car wash");
		
		basePageClass base = new basePageClass(driver,logger);
		
		PageFactory.initElements(driver, base);
		
		landingpage = base.openApplication();
		
		landingpage.enterEmail(getProperty("Email"));
		
		landingpage.clickOnNext();
		
		landingpage.enterPassword(getProperty("Password"));
		
		verifyloginpage = landingpage.clickOnsignIn();
		
		verifyloginpage.clickOntext();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter OTP:");
		
		String otp = sc.next();
		
		verifyloginpage.enterOTP(otp);
		
		verifyloginpage.clickOnVerify();
		
		homePage = verifyloginpage.clickOnYes();
		
		homePage.getNameTag();
		
		trutimelistpage = homePage.sendKeysToSearch(getProperty("keys"));
		
		truetimehome = trutimelistpage.clickOnTruTime();
		
		truetimehome.switchWindow();
		
		truetimehome.switchtoIframe();
		
		truetimehome.getDaysOfWeek();
		
		truetimehome.getExpectedDates();
		
		truetimehome.checkArraysEqual();
		
		truetimehome.getExpectedDate();
		
		truetimehome.getSActualDate();
		
		truetimehome.checkActiveDate();
		
		
		
		
	}
	
	@AfterMethod
	public void flushReports() {
		report.flush();
		driver.quit();
	}

}
