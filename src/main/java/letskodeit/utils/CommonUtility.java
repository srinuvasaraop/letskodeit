package letskodeit.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CommonUtility {
    public WebDriver driver;
    public letskodeit.utils.WaitsUtility waitsUtility;

    public CommonUtility(WebDriver driver) {
        this.driver = driver;
        waitsUtility = new WaitsUtility(driver);
    }

    public static Logger log = LogManager.getLogger(CommonUtility.class);


    //****************Reusable methods for navigation******************
    // public WebDriver driver;
    // #1.Re-usable method for Browser back operations
    public void browserBack() {
        try {
            driver.navigate().back();
            log.info("browser back button is pressed");
        } catch (Exception e) {
            log.debug("Exception at browser back button is pressed"+e);
        }

    }

    // #2.Re-usable method for Browser forward operations
    public void browserForword() {

        try {
            driver.navigate().forward();
            System.out.println("browser forword button is pressed");
        } catch (Exception e) {
            log.debug("Exception at browser forword button is pressed" + e);
        }

    }
        // #3.Re-usable method for Browser refreshPage operations
        public void refreshPage()
        {
            try {
                driver.navigate().refresh();
                log.info("browser page is refreshed....");
            } catch (Exception e) {
                log.debug("Exception at browser page is refreshed"+e);
            }
        }


        // #4.Re-usable method for Url navigation operations
        public void navigateTo(String ValidUrl)
        {
            try {
                driver.navigate().to(ValidUrl);
                log.info("navigation operations done");
            } catch (Exception e) {
                log.debug("Exception at navigation operations"+e);
            }

        }

        // 5.Re-usable method for send keys operation.
        public void setDataToElement(By locator, String data){

            try {
                //wait until the elemenet is available
                WebElement element=driver.findElement(locator);
                 waitsUtility.waitUntilElementLocated(20, locator);
                //first clear the data
                element.clear();
                //send the data
                element.sendKeys(data);
                log.info("data entered successfully..............");
            } catch (Exception e) {
                log.debug("Exception at data entered successfully" + e);
            }
        }

        //#6.Re-usable method for click operation.
        public void clickOnElemengt(By locator){
            try {
                WebElement element = driver.findElement(locator);
                element.click();
                log.info("Element clicked successfully.............");
            } catch (Exception e)
            {
                log.debug("Exception at Element  "+e);
                try {
                    throw new IOException(e.getMessage()+" locator "+locator);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }



