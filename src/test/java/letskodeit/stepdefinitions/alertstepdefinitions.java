package letskodeit.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import letskodeit.constants.Myconstants;
import letskodeit.context.PicoContainer;
import letskodeit.context.pages.Homepage;
import letskodeit.context.pages.PageFactoryManager;
import org.testng.Assert;

import java.io.IOException;

public class alertstepdefinitions {
    String ref1="sdfvbjhs";
    private final Homepage homepage;

    public alertstepdefinitions(PicoContainer picoContainer) {
        homepage = PageFactoryManager.getHomepage(picoContainer.driver);
    }

    @Given("^i am on the letskodeit page$")
    public void i_am_on_the_letskodeit_page() throws IOException {
      homepage.load(Myconstants.Home);
    }

    @When("^user enters Name \"([^\"]*)\"$")
    public void user_enters_name_something(String strArg1) {
     //  ref1 = strArg1;
        homepage.input_to_alert(strArg1);
    }
    @When("^user click on confirm button$")
    public void user_click_on_confirm_button()  {
        homepage.confirm_button();
    }
    @When("user click on Alert button")
    public void user_click_on_alert_button() {
        homepage.alert_button();
    }

    @Then("^user name will be displayed on top of page$")
    public void user_name_will_be_displayed_on_top_of_page() {
        String actual = homepage.actualAlertMessage();
        String find =ref1;
        int i = actual.indexOf(find);
        if(i>0){
            System.out.println("Keyword matched the string");
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false, "Keyword not matched the string");
        }
      //homepage.Acceptalert();
    }
}
