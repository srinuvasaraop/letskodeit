package letskodeit.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtility {

	   public  Select select;
	public WebDriver driver;

	public DropdownUtility(WebDriver driver) {
		this.driver = driver;
			}

	public static Logger log = LogManager.getLogger(DropdownUtility.class);
//********************* methods for single select && multiselect dropdown  ***************//
	// #1.select by visible text
	public void selectOptionByVisibleText(By locator, String optionText) {
		WebElement element=driver.findElement(locator);
		select = new Select(element);
		try {
			select.selectByVisibleText(optionText);
			log.info("The required option ia select by visible text ");
		} catch (Exception e) {
			log.debug("Exception at select by visible text ");
		}

	}

	// #2.select by index
	public void selectOptionByIndex(By locator, int index) {
		WebElement element=driver.findElement(locator);
		select = new Select(element);
		try {

			select.selectByIndex(index);
			log.info("The required option ia select by index ");
		} catch (Exception e) {
			log.debug("Exception at select by index");
		}

	}

	// 3.select by value
	public void selectOptionByValue(By locator,String value) {
		WebElement element=driver.findElement(locator);
		select = new Select(element);
		try {
			select.selectByValue(value);
			log.info("The required option ia select ByValue ");
		} catch (Exception e) {
			log.debug("Exception at select ByValue");
		}

	}
	//#4.is multiple
	public boolean isMultiSelctOrNot(By loactor) {
		boolean multiple=false;
		WebElement element=driver.findElement(loactor);
		select = new Select(element);
		try
		{
			 multiple = select.isMultiple();
			log.info("The required option is multiselect or not ");
		}catch (Exception e)
		{
			log.debug("Exception at option is multiselect or not");
		}
		  return multiple;
 	}
	
	//***********exclusive methods for multiselect******************//
	
	
	//#5.deselct option by visible text
		public void deselectOptionByVisibleText(By locator, String optionText) {
		WebElement element=driver.findElement(locator);
		select = new Select(element);
		boolean status =select.isMultiple();
		if(status)
		{
			try {

				select.deselectByVisibleText(optionText);
				log.info("The required option is de-select by visible text ");
			} catch (Exception e) {
				log.debug("Exception at option is de-select by visible text"+e);
			}
		}else
		{
			log.info("the select is not multi select");
		}
		

	}
   //#6.deselect option by value
	public void deselectOptionByValue(By locator, String value) {
		WebElement element=driver.findElement(locator);
		select = new Select(element);
		boolean status =select.isMultiple();
		if(status)
		{
			try {

				select.deselectByValue(value);
				log.info("The required option ia de-select by value");
			} catch (Exception e) {
				log.debug("Exception at  option ia de-select by value");
			}
		}else
		{
			log.info("the select is not multi select");
		}
		

	}
	//7.de-select by index
	public void deselectOptionByIndex( By locator, int index) {
		WebElement element=driver.findElement(locator);
		select = new Select(element);
		boolean status =select.isMultiple();
		if(status)
		{
			try {

				select.deselectByIndex(index);
				log.info("The required option ia de-select by indext ");
			} catch (Exception e) {
				log.debug("Exception at option ia de-select by indext ");
			}
		}else
		{
			log.info("the select is not multi select");
		}
		

	}
	
}
