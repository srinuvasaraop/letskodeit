package letskodeit.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class AlertsUtility {
	// Re-usable methods for Alert interface
		public WebDriver driver;

	public AlertsUtility(WebDriver driver) {
		this.driver = driver;
	}
	public static Logger log = LogManager.getLogger(AlertsUtility.class);

	// #1.Verify alert is present or not
	public boolean verifyPresenceOfAlert() {
		boolean status = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.alertIsPresent());
			status = true;
			log.info(" alert is present complted");
		} catch (Exception e) {
			log.debug("Exception at alert is present completed "+e);
		}
		return status;
	}

	// #2.accept method

	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			log.info("alert is successfully accepted");
		} catch (Exception e) {
			log.debug("Exception at alert accepted"+e);
		}
	}

	// #3.dismiss method
	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		log.info("alert is successfully dismissed");
		} catch (Exception e) {
		log.debug("Exception at alert dismissed"+e);
		}
	}

//	#4.get the text from Alert
	public String getTextAlert() {
		String text = null;
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			log.info("alert is successfully get the text...." + text);
		} catch (Exception e) {
			log.debug("Exception at get the text"+e);
		}
		return text;
	}

	// #5.Verify the alert text
	public boolean verifyAlertText(String expAlertText) {
		boolean status = false;
		try {

			String textAlert = getTextAlert();
			Assert.assertEquals(expAlertText, textAlert);
			log.info("Verify the alert text successfull");
			status = true;

		} catch (Exception e) {
			log.debug("Exception at Verify the alert text"+e);
		}

		return status;
	}
	//#6.Send text to alert
	public void sendText(String alertInputText)
	{
		try
		{
			letskodeit.utils.StaticWaitUtility staticwaitutility=new letskodeit.utils.StaticWaitUtility(driver);
			Alert alert = driver.switchTo().alert();
			staticwaitutility.staticMediumWait();
			alert.sendKeys(alertInputText);
			log.info("send  text is  successfull");

			//*************wait for 1 sec  time*********************//

			staticwaitutility.staticSecWait();
			alert.accept();

			//*******again check any aleret is present
			boolean againAlet=verifyPresenceOfAlert();
			Assert.assertTrue(againAlet);
			log.info("again alert is present ");
			alert.accept();
			log.info("again alert is accepted ");
		}catch (Exception e) {
      log.debug("Exception at Send text to alert"+e);
		}
			}
	//#7.verify alert confirmation message***********
	public void verifyAlertConfirmationMessage(String alertInputText,String expalertConfirmation)
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(alertInputText);
			log.info("send  text is  successfull");

			//*************wait for 1 sec  time*********************//
			letskodeit.utils.StaticWaitUtility staticwaitutility=new letskodeit.utils.StaticWaitUtility(driver);
			staticwaitutility.staticSecWait();
			alert.accept();

			//*******again check any aleret is present
			boolean againAlet=verifyPresenceOfAlert();
			Assert.assertTrue(againAlet);
			System.out.println("again alert is prsent ");
		    String actualconfirmation = alert.getText();
		    Assert.assertEquals(actualconfirmation, expalertConfirmation);
		   log.info("confirmation message validated");
			alert.accept();
			log.info("again alert is accepted ");
		}
		catch(Exception e)
		{
			log.debug("Exception at verify alert confirmation message"+e);
		}
	}
	//********some times unexpected  alets will come for that 8 and 9 methods are writen*************//
	//#8.Press ok if alert is presented
	public void pressOkIfAlertIsPresented(WebDriver driver)
	{
		try
	{
		boolean verifyPresenceOfAlert = verifyPresenceOfAlert();
		Assert.assertTrue(verifyPresenceOfAlert);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		log.info("alert is available and pressed ok");
	}
		catch (Exception ex)
		{
			log.debug("Exception at Press ok if alert is presented"+ex);
		}

	}
	//#9.press cancel if alert present
	public void pressCancelIfAlertIsPresented(WebDriver driver)
	{
		boolean verifyPresenceOfAlert = verifyPresenceOfAlert();
		Assert.assertTrue(verifyPresenceOfAlert);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		System.out.println("alert is available and pressed cancel");

	}
	//#10.Validating Alert box message
	public void ValidateAlertBoxMessage(String alertInput,String alertMessage,String alertCondition)
	{

     try
     {

    	// ((AlertsUtility) driver.switchTo().alert()).sendText(driver,alertInput);
    	 //send email id to alter
    	 driver.switchTo().alert().sendKeys(alertInput);
		 letskodeit.utils.StaticWaitUtility staticWaitUtility=new letskodeit.utils.StaticWaitUtility(driver);
    	 staticWaitUtility.staticSmallWait();
    	 //press ok button
    	 driver.switchTo().alert().accept();
    	 staticWaitUtility.staticSmallWait();
    	 //again alert displayed
    	 driver.switchTo().alert();
    	 staticWaitUtility.staticSmallWait();
    	 //getting the text message of alert
    	 String actualText = driver.switchTo().alert().getText();
    	 driver.switchTo().alert();
    	 if(actualText.equals(alertMessage))
    	 {
    		 if(alertCondition.contains("Valid User Condition"))
    		 {
    			 System.out.println("Forgot password valid Email Verification Scenario passed");
    		 }
    		 else if(alertCondition.contains("Invalid User Condition"))
    		 {
    			 System.out.println("Forgot password Invali user data is passed");
    		 }
    		 else if(alertCondition.contains("Invalid Email Condition"))
    		 {
    			 System.out.println("Forgot password Invalid Email Verification Scenario passed");
    		 }
    		 else
    		 {
    			 System.out.println("forgot password alert box message scenario verification is failed...");
    		 }
    	 }
    	 else
    	 {
    		 System.out.println("forgot password validation is failed.....");
    	 }
    }catch (Exception e) {
       e.printStackTrace();
    }

	}

}
