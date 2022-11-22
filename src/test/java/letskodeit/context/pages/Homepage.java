package letskodeit.context.pages;

import letskodeit.utils.CommonUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage {
   public  WebDriver driver;
    CommonUtility commonUtility;
    By alert_input_text = By.xpath("//div[@id='page']/descendant::input[@placeholder='Enter Your Name']");
    By alert_button = By.xpath(" //div[@id='page']/descendant::input[@id='alertbtn']");

    By confirm_button = By.xpath(" //div[@id='page']/descendant::input[@id='confirmbtn']");

    public Homepage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        commonUtility = new CommonUtility(driver);
    }

    public void input_to_alert(String enteryourname) {
        commonUtility.setDataToElement(alert_input_text, enteryourname);

    }

    public void alert_button() {
        commonUtility.clickOnElemengt(alert_button);
    }

    public void confirm_button() {
        commonUtility.clickOnElemengt(confirm_button);
    }
    public String actualAlertMessage()
    {
      String actu_msg=driver.switchTo().alert().getText();
      return  actu_msg;
    }
    public void Acceptalert()
    {
        driver.switchTo().alert().accept();
    }
}
