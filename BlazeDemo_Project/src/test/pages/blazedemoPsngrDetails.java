package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class blazedemoPsngrDetails {

	WebDriver driver = null;

	public blazedemoPsngrDetails(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.NAME,using="inputName")
	public WebElement name;

	@FindBy(how=How.NAME,using="address")
	public WebElement address;

	@FindBy(how=How.ID,using="city")
	public WebElement city;

	@FindBy(how=How.ID,using="state")
	public WebElement state;

	@FindBy(how=How.NAME,using="zipCode")
	public WebElement zipCode;

	@FindBy(how=How.XPATH,using="//select[(@name='cardType') and (@class='form-inline')]")
	public WebElement cardType;

	@FindBy(how=How.NAME,using="creditCardNumber")
	public WebElement creditCardNumber;

	@FindBy(how=How.NAME,using="creditCardMonth")
	public WebElement creditCardMonth;

	@FindBy(how=How.NAME,using="creditCardYear")
	public WebElement creditCardYear;

	@FindBy(how=How.NAME,using="nameOnCard")
	public WebElement nameOnCard;

	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	public WebElement btnSubmit;

	@FindBy(how=How.XPATH,using="//p[contains(text(),\"Flight Number\")]")
	public WebElement flightNumText;

	public String getTitle() throws Exception
	{
		Thread.sleep(2000);
		return driver.getTitle();
	}

	public blazedemoPsngrDetails enterPsngrDetails(String flightNum, List<List<String>> listOL) throws InterruptedException {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(true, title.equals("BlazeDemo Purchase"));

		String flightNumber = flightNumText.getText();
		if(!flightNumber.contains(flightNum)) {
			System.out.println("This is actually a bug on the page - Need to populate appropriate flight number for testing purpose");
		}

		name.clear();
		name.click();
		name.sendKeys(listOL.get(1).get(0));

		address.click();
		address.sendKeys(listOL.get(1).get(1));

		city.click();
		city.sendKeys(listOL.get(1).get(2));

		state.click();
		state.sendKeys(listOL.get(1).get(3));

		zipCode.click();
		zipCode.sendKeys(listOL.get(1).get(4));

		creditCardNumber.click();
		creditCardNumber.sendKeys(listOL.get(1).get(6));

		creditCardMonth.clear();
		creditCardMonth.click();
		creditCardMonth.sendKeys(listOL.get(1).get(7));

		creditCardYear.clear();
		creditCardYear.click();
		creditCardYear.sendKeys(listOL.get(1).get(8));

		nameOnCard.click();
		nameOnCard.sendKeys(listOL.get(1).get(9));

		btnSubmit.click();
		Thread.sleep(3000);
		return null;


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