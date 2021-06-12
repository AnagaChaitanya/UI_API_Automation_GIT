package driverRunner;

import org.junit.runner.RunWith;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions( monochrome = true,features = {"src/resources/BD_FlightBooking.feature"} , plugin = {"pretty", "html:target/cucumber-reports"}, glue = "stepDef")
public class testRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider
	//@DataProvider (parallel = true) -- For parallel execution support 
	public Object[][] scenarios() {
		return super.scenarios();
	}
	

}