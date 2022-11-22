package letskodeit.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitsUtility {
		public WebDriver driver;
	public WaitsUtility(WebDriver driver) {
		this.driver = driver;
	}
	public static Logger log = LogManager.getLogger(WaitsUtility.class);
	// #1.Re-usable methods for implicit wait
	public void setImplicitWaitForMethod() {
		try {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			log.info("implicit wait is implemented ");
		} catch (Exception e) {
			log.debug("Exceptiona at implicit wait is implemented"+e);
		}

	}

	// 2.RE-USABLE METHOD FOR PAGE LOADING
	public void setPageLoadForAUT() {
		try {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			log.info("page loading time is implemented ");
		} catch (Exception e) {
			log.debug("Exception at page loading time is implemented ");
		}
	}

	// 3.Re-usable method for script loading
	public void setLoadScriptForAjax() {
		try {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			log.info("script loading time is implemented ");
		} catch (Exception e) {
			log.debug("Exceptiona at script loading time is implemented"+e);
		}
	}
	// **********Re-usable methods for WebDriver waits/Explicit waits***********//

	// #4.Re-usable methods for frames visibility.
	public void waitUntilFrameIsLoaded(int timeouts, int frameIndex) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
			log.info("wait until frame is visible is loaded");
		} catch (Exception e) {
			log.debug("Exceptiona at wait until frame is visible"+e);
		}
	}

	// 5.re-usable method for frame visibility using frame name or ID
	public void waitUntilFrameIsLoaded(int timeouts, String FrameNameorID) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameNameorID));
			log.info("wait until frame is visible is loaded using StringOrId");

		} catch (Exception e) {
			log.debug("Exceptiona at wait until frame is visible is loaded using StringOrId"+e);
		}
	}



	// 6.re-usable method for frame using webelemt
	public void waitUntilFrameIsLoaded(int timeouts, By locator) {
		WebElement FrameElement=driver.findElement(locator);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameElement));
			log.info("wait until frame is visible is loaded using WebElement");
		} catch (Exception e) {
			log.debug("Exception at wait until frame is visible is loaded using WebElement"+e);
		}
	}
	//7.Re-usable methods for invisibilty of element located.
	public void waitUntilLocatedElementIsInvisible(int timeout,By locator)
	{
		WebElement element= driver.findElement(locator);
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOf(element));
			log.info("wait until frame invisibilty is loaded ");
		} catch (Exception e) {
			log.debug("Exception at wait until frame invisibilty is loaded "+e);
		}
	}
	//8.Re-usable methods for checking the text in page title.
	public void waitUntilPageTitlePartiallyMatched(int timeouts,String PartialText)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleContains(PartialText));
			log.info("wait until partial title macthed loading  ");
		} catch (Exception e) {
			log.debug("Exception at wait until partial title macthed loading"+e);
		}
	}
	//9.re-usable method for checking page title matched fully
	
	public void waitUntilPageTitleFullyMatched(int timeouts,String PartialText)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleIs(PartialText));
			log.info("wait until fully matched  title  loading  ");
		} catch (Exception e) {
			log.debug("Exceptiona at wait until fully matched  title  loading"+e);
		}
	}
	//10.re-usable method for checking the element presence
	public void waitUntilElementLocated(int timeouts,By locator)
	{
		WebElement element= driver.findElement(locator);
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("wait until element is present   loading  ");
		} catch (Exception e) {
			log.debug("Exception at wait until element is present loading"+e);
		}
	}
	//1.re-usable method for checking the element visible
	public void waitElementLocated(int timeouts,By visibleelement)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(visibleelement));
			log.info("elemenyt is visible");
		} catch (Exception e) {
			log.debug("Exception at elemenyt is visible"+e);
		}
	}
	public void waitElementTobeClickble(By visibleelement)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(visibleelement));
			log.info("elemenyt is clickable");
		} catch (Exception e) {
			log.debug("Exception at element is visible"+e.getMessage()+""+visibleelement);
		}
	}
}
