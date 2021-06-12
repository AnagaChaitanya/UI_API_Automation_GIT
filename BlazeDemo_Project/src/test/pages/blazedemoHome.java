package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import utils.webUtils;

public class blazedemoHome {

	WebDriver driver = null;

	public blazedemoHome(WebDriver driver) {
		
		PageFactory.initElements(driver, blazedemoHome.this);
		this.driver = driver;
		
	}

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Travel The World')]")
	public WebElement travelTheWorld;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'home')]")
	public WebElement btnHome;

	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Welcome to the Simple Travel Agency!')]")
	public WebElement title;

	@FindBy(how=How.XPATH,using="//select[(@name='fromPort') and (@class='form-inline')]")
	public WebElement departureCity;

	@FindBy(how=How.XPATH,using="//select[(@name='toPort') and (@class='form-inline')]")
	public WebElement destinationCity;

	@FindBy(how=How.XPATH,using="//input[@value='Find Flights' and @type='submit']")
	public WebElement btnFindFlights;

	public void selectDeptDestCities(String dept, String dest) throws InterruptedException {
		selectFromDropDownWithVisibleText(departureCity, dept);
		Thread.sleep(100);
		selectFromDropDownWithVisibleText(destinationCity, dest);
		Thread.sleep(100);
		btnFindFlights.click();
		Thread.sleep(100);
	}

	public void selectFromDropDownWithVisibleText(final WebElement selectDropDown, final String visibleTextToSelect) {
		try {
			String strText = "";
			Select select = new Select(selectDropDown);
			select.selectByValue(visibleTextToSelect);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
