package pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class blazedemoTicketConfirmation {

	WebDriver driver = null;

	public blazedemoTicketConfirmation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//td[text()=\"Id\"]/following-sibling::td")
	public WebElement ticketID;

	@FindBy(how=How.XPATH,using="//td[text()=\"Id\"]/following-sibling::td")
	public WebElement ticketStat;

	@FindBy(how=How.XPATH,using="//td[text()=\"Card Number\"]/following-sibling::td")
	public WebElement creditCard;

	public void confirmTicket() throws InterruptedException {
		try {
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(true, title.equals("BlazeDemo Confirmation"));

			String ticketNumber = ticketID.getText();
			String ticketStatus = ticketStat.getText();
			String creditCardNum = creditCard.getText();


			if(ticketNumber.contains("^[0-9]{13}$") && ticketStatus.equals("PendingCapture")) {
				String ccRegex="^[x]{12}[0-9]{4}$";
				Pattern pat = Pattern.compile(ccRegex);
				Matcher m = pat.matcher(creditCardNum);
				System.out.println("The Flight ticket is successfully booked with ticket number :" + ticketNumber);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}