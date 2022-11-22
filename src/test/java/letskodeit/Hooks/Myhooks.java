//package letskodeit.Hooks;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import letskodeit.context.PicoContainer;
//import letskodeit.factory.DriverFactory;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//public class Myhooks { private WebDriver driver;
//    public PicoContainer picoContainer;
//
//    public Myhooks(PicoContainer picoContainer) {
//        this.picoContainer = picoContainer;
//    }
//    @Before(order=0)
//    public static void beforeScenarioStart(){
//        System.out.println("-----------------Start of Scenario-----------------");
//    }
//    @Before(order=1)
//
//    public void doSomethingBefore(Scenario scenario) {
//        System.out.println("BEFORE THREAD ID---->" + Thread.currentThread().getId() + "," + "SCENARIO NAME--->" + scenario.getName());
//
//        String nameofbrowser = System.getProperty("browser", "chrome");
//        driver = DriverFactory.initializeDriver(nameofbrowser);
//        picoContainer.driver=driver;
//    }
//    @AfterStep
//    public void addScreenshot(Scenario scenario) {
//        if (scenario.isFailed()) {
//            final byte[] failedscreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(failedscreenshot, "image/png", "image");
//        }
////        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
////        scenario.attach(screenshot, "image/png", "image");
//    }
//    @After(order=0)
//    public static void afterScenarioFinish(){
//        System.out.println("-----------------End of Scenario-----------------");
//    }
//    @After(order=1)
//    public void doSomethingAfter(Scenario scenario) {
//        System.out.println("AFTER THREAD ID--->" + Thread.currentThread().getId() + "," + "SCENARIO NAME--->" + scenario.getName());
//        driver.quit();
//    }
//}
//
//
