package letskodeit.domineobject.hooks;/*
package com.testinkbox.domineobject.hooks;
package inboxbdd.domineobject.hooks;

import inboxbdd.context.TestContetxt;
import inboxbdd.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Myhooks {
    private WebDriver driver;
    public final TestContetxt testContetxt;

    public Myhooks(TestContetxt testContetxt) {
        this.testContetxt = testContetxt;
    }

    @Before
    public void doSomethingBefore(Scenario scenario) {
        System.out.println("BEFORE THREAD ID---->" + Thread.currentThread().getId() + "," + "SCENARIO NAME--->" + scenario.getName());

        String nameofbrowser = System.getProperty("browser", "chrome");
        driver = DriverFactory.initializeDriver(nameofbrowser);
    }

    @After
    public void doSomethingAfter(Scenario scenario) {
        System.out.println("AFTER THREAD ID--->" + Thread.currentThread().getId() + "," + "SCENARIO NAME--->" + scenario.getName());
        driver.quit();

    }
}

*/
