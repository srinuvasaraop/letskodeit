package letskodeit.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,glue={"letskodeit","letskodeit.domineobject.Utils.hookss"}
        ,tags = "@confirm"
        ,monochrome=true
        ,features = "src/test/resources/letskodeit"
)
public class TestngRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

