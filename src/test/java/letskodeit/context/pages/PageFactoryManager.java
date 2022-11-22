package letskodeit.context.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private  static Homepage homepage;
    public static Homepage getHomepage(WebDriver driver)
    {
        return homepage==null ? new Homepage(driver) :homepage;
    }
}
