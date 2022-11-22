package letskodeit.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FramesUtility {
	public WebDriver driver;
	public WaitsUtility waitsUtility;
	public FramesUtility(WebDriver driver)
	{
		this.driver = driver;
		waitsUtility=new WaitsUtility(driver);
	}
	public static Logger log = LogManager.getLogger(FramesUtility.class);
	// 1.switch into frame by using frame name or id
	public void switchToFrameByusing( String FrameNameorId) {
		try {
			//first check frame is visible on page
			//waitsUtility.waitUntilFrameIsLoaded(driver, 50, FrameNameorId);
			driver.switchTo().frame(FrameNameorId);
			log.info("driver is switched to frame by using Name or Id");
		} catch (Exception e) {
			log.debug("Exception at driver is switched to frame by using Name or Id"+e);
		}
	}

	// 2.switch into frame by using frame index
	public void switchToFrameByusing( int Frameindex) {
		try {
			//first check frame is visible on page
			
			waitsUtility.waitUntilFrameIsLoaded(3, Frameindex);
			//then switch to frame
			driver.switchTo().frame(Frameindex);
			log.info("driver is switched to frame by usingFrameindex");
		} catch (Exception e) {
			log.debug("Exception at driver is switched to frame by usingFrameindex"+e);
		}
	}

	// 3.switch into frame by using frame element
	public void switchToFrameByusing( By locator) {
		WebElement FrameElement=driver.findElement(locator);
		try {
			//first check frame is visible on page
			waitsUtility.waitUntilFrameIsLoaded(3, locator);
			driver.switchTo().frame(FrameElement);
			log.info("driver is switched to frame by using frame element");
		} catch (Exception e) {
			log.debug("Exception at driver is switched to frame by using frame element"+e);
		}
	}

	// 4.switch to parent frame
	public void switchToFrameByusing() {
		try {
			driver.switchTo().parentFrame();
			log.info("driver is switched to frame by using pareentFrame");
		} catch (Exception e) {
			log.debug("Exception at driver is switched to frame by using pareentFrame"+e);
		}
	}

	// 5.count all iframes
	public void countAllIframesInPage() {
		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		int size = elements.size();
		System.out.println(size);
	}
	public void switchToDefault()
	{
		driver.switchTo().defaultContent();
		}
}
