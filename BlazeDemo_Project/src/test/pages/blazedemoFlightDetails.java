package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.internal.junit.ArrayAsserts;

import base.BasePage;
import utils.webUtils;

public class blazedemoFlightDetails {

	WebDriver driver = null;

	public blazedemoFlightDetails(WebDriver driver) {

		PageFactory.initElements(driver, blazedemoFlightDetails.this);
		this.driver = driver;

	}

	@FindBy(how=How.XPATH,using="//table[contains(@class,'table')]/thead")
	public WebElement flightTableHeader;

	public WebElement chooseThisFlight(String flightNum, String airLine) {
		String xpath = "//tr[contains(.,'" + flightNum +  "') and contains(.,'" + airLine + "')]/td/input[@class='btn btn-small']";
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public blazedemoFlightDetails chooseFlight(String dept, String dest, String flightNum, String airLine) throws InterruptedException {
		String title = driver.getTitle();
		Assert.assertEquals(true, title.equals("BlazeDemo - reserve"));
		System.out.println(title);
		String flightDet = flightTableHeader.getText();
		if(flightDet.contains("Departs: " + dept) &&  flightDet.contains("Arrives: " + dest)) {
			WebElement chooseFlight=chooseThisFlight(flightNum, airLine);
			chooseFlight.click();
			Thread.sleep(10000);
		} else {
			return new blazedemoFlightDetails(driver);
		}
		return null;
	}

}
