package letskodeit.context.pages;
import letskodeit.domineobject.Utils.ConfilLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BasePage
{
    protected WebDriver driver;
    protected WebDriverWait wait;
    final  static Logger log = LogManager.getLogger(BasePage.class);
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     PageFactory.initElements(driver, this);
    }
    public void load(String endpoint) throws IOException {
        driver.get(ConfilLoader.getInstance().getBaseUrl()+endpoint);
    }
}
