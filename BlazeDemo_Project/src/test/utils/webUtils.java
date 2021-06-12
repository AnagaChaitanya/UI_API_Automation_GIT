package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class webUtils {
	
	public WebDriver driver;

	/**
	 * 
	 * Constructor with the {@link WebDriver} object
	 * 
	 */
	public webUtils(WebDriver driver) {
		this.driver = driver;
		
	}

	public void selectFromDropDownWithVisibleText(WebElement selectDropDown, String visibleTextToSelect) {
		try {
			String strText = "";
			Select select = new Select(selectDropDown);
			select.selectByValue(visibleTextToSelect);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void doClick(final WebElement userEdit) {

		try {
			userEdit.toString();
			userEdit.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
