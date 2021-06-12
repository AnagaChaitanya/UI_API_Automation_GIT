package stepDef;

import java.sql.Driver;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.blazedemoFlightDetails;
import pages.blazedemoHome;
import pages.blazedemoPsngrDetails;
import pages.blazedemoTicketConfirmation;
import utils.ConfigReader;
import utils.webUtils;

public class stepDefinitions {

	private WebDriver driver = null;
	private ConfigReader configReader;
	Properties prop;
	private blazedemoHome home;
	private blazedemoFlightDetails flightDet;
	private blazedemoPsngrDetails psgnrDet;
	private blazedemoTicketConfirmation ticketCnfrm;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() throws InterruptedException {
		String path = System.getProperty("user.dir");  
		String driverpath = path + "\\chrome\\chromedriver.exe"; 
		System.out.println(driverpath);
		String p2 = System.setProperty("webdriver.chrome.driver",driverpath);
		driver = new ChromeDriver();
		this.driver = driver;
		String browserName = prop.getProperty("browser");
		driver.navigate().to(prop.getProperty("appURL"));
		Thread.sleep(3000);
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

	@Given("verify travel agency home page")
	public void verify_travel_agency_home_page() throws InterruptedException {
		home = new blazedemoHome(driver);
		String title = driver.getTitle();
		Assert.assertEquals(true, title.contains("BlazeDemo"));
	}

	@When("select the departure and destination")
	public void select_the_departure_and_destination(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		home = new blazedemoHome(driver);
		List<List<String>> rows = dataTable.asLists(String.class);
		home.selectDeptDestCities(rows.get(1).get(0), rows.get(1).get(1));
	}

	@When("choose the flight from {string} to {string}")
	public void choose_the_flight_from_to(String dept, String dest, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		flightDet = new blazedemoFlightDetails(driver);
		List<List<String>> rows = dataTable.asLists(String.class);
		String flightNum = rows.get(1).get(0);
		String airLine = rows.get(1).get(1);
		flightDet.chooseFlight(dept, dest,flightNum , airLine );
	}


	@When("verify entering passenger details for flightNum {string}")
	public void verify_entering_passenger_details_for_flight_num(String flightNum, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		psgnrDet = new blazedemoPsngrDetails(driver);
		List<List<String>> rows = dataTable.asLists(String.class);
		psgnrDet.enterPsngrDetails(flightNum, rows);
	}

	@Then("verify the booking confirmation ID")
	public void verify_the_booking_confirmation_id() throws InterruptedException {
		ticketCnfrm = new blazedemoTicketConfirmation(driver);
		ticketCnfrm.confirmTicket();
	}

	@When("choose the {string} and {string}")
	public void choose_the_and(String dept, String dest) throws InterruptedException {
		home = new blazedemoHome(driver);
		home.selectDeptDestCities(dept, dest);
	}
	
	@Then("flights selection successful")
	public void flights_selection_successful() throws InterruptedException {
		home = new blazedemoHome(driver);
		driver.navigate().back();
		Thread.sleep(1000);
	}
	
	@When("choose below flights {string} and {string}")
	public void choose_below_flights_and(String flightNum, String airLine) throws InterruptedException {
		flightDet = new blazedemoFlightDetails(driver);
		flightDet.chooseFlight("San Diego", "London",flightNum , airLine );
		driver.navigate().back();
	}
}

