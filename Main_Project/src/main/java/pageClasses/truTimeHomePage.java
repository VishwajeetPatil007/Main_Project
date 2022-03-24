package pageClasses;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.basePageClass;
import utilityClasses.weekDatesUtil;

public class truTimeHomePage extends basePageClass{
	String actualDate;
	String expectedDate;
	String[] datesActual = new String[7];
	String[] datesExpected = new String[7];
	

	public truTimeHomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);	
	}
	
	@FindBy(xpath="//div[@class='dayHeadr active ng-binding ng-scope']")
	WebElement actualDate1;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div/div[1]")
	List<WebElement> datesOfWeek;
	
	public void switchWindow() {
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		
		String cogHome = itr.next();
		String truTime = itr.next();
		
		driver.switchTo().window(truTime);
		
		waitForPageLoad(3);
	}
	
	public void switchtoIframe() {
		driver.switchTo().frame(driver.findElement(By.id("appFrame")));
		waitForPageLoad(3);
	}
	
	public void getDaysOfWeek() {
		System.out.println("Actual dates of week are:");
		int i = 0;
		for(WebElement element:datesOfWeek) {
			System.out.println(element.getText());
			datesActual[i] = element.getText();
			i++;
		}
	}
	
	public void getExpectedDates() {
		datesExpected = weekDatesUtil.getDaysOfWeek();
		System.out.println("Expected dates of week are:");
		for(int i = 0; i<datesExpected.length ; i++) {
			System.out.println(datesExpected[i]);
		}
	}
	
	public boolean checkArraysEqual() {
		
		if(Arrays.equals(datesActual, datesExpected)) {
			try {
			System.out.println("Actual and Expected dates of Week are Equal.");
			logger.log(Status.PASS, "Actual and Expected dates of Week are Equal.");
			}catch (Exception e) {
				takeScreenshot();
				reportFail(e.getMessage());
			}
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void getExpectedDate() {
		expectedDate = weekDatesUtil.getActiveDate();
		System.out.println("Expected active date is:"+expectedDate);
	}
	
	public void getSActualDate() {
		actualDate = actualDate1.getText();
		System.out.println("Actual active date is:"+actualDate);
	}
	
	public void checkActiveDate() {
		try {
		Assert.assertEquals(actualDate, expectedDate);
		System.out.println("Expected and Actual dates are Equal.");
		logger.log(Status.PASS, "Expected and Actual dates are Equal.");
		}catch (Exception e) {
			takeScreenshot();
			reportFail(e.getMessage());
		}
	}

}
