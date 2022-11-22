package letskodeit.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility {
    Actions actions;
    public WebDriver driver;

    public ActionsUtility(WebDriver driver) {
        this.driver = driver;
    }

    public static Logger log = LogManager.getLogger(ActionsUtility.class);

    // 1.Right click operation on Webelement
    public void rightClickOperations(By locator) {
        try {
            actions = new Actions(driver);
            WebElement element=driver.findElement(locator);
            actions.contextClick(element).build().perform();
            log.info("Right click operation on Webelement...done");
        } catch (Exception e) {
            log.debug("Exception raised at Right click operation on Webelement");
        }
    }

    // 2.Right click operations on Where mouse point is present.
    public void rightClickOperations() {
        try {
            actions = new Actions(driver);
                       actions.contextClick().build().perform();
            log.info("Right click operations on Where mouse point is present...");
        } catch (Exception e) {
            log.debug("Exception raised at Where mouse point is presen");
        }
    }

    // 3.MouseOver Actions
    public void MouseOver(By locator) {
        try {
            actions = new Actions(driver);
            WebElement element=driver.findElement(locator);
            actions.moveToElement(element).build().perform();

            log.info("mouse over action is doing now");
        } catch (Exception e) {
            log.debug("Exception raised at Where mouse over action is doing now");
        }
        }


    // 4.Drag and Drop
    public void dragNdrop( By locator1,By locator2) {
        try {
            actions = new Actions(driver);
            WebElement src=driver.findElement(locator1);
            WebElement dest=driver.findElement(locator2);
           actions.dragAndDrop(src, dest).build().perform();
            log.info("drag and drop actions is going ");
        } catch (Exception e) {
            log.debug("Exception raised at Where drag and drop actions is going");
        }
    }
    // 5.Drag and Drop in iframes

    public void dragNdrop( By locator1, By locator2, By locator3) {
        actions = new Actions(driver);
        // scroll into view
        WebElement src=driver.findElement(locator1);
        WebElement dest=driver.findElement(locator2);
        WebElement iframeelement=driver.findElement(locator3);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", iframeelement);
        // switch to iframe

        try {
            driver.switchTo().frame(0);
            System.out.println("drag and drop actions is going ");
            actions.dragAndDrop(src, dest).build().perform();
            log.info("drag and drop  in iframes is going ");
        } catch (Exception e) {
            log.debug("Exception raised at drag and drop  in iframes is going ");
        }
    }
}
