package stepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utilities.Driver;


public class Hooks {
    public static WebDriver driver;
    public static CommonPage commonPage;
    public static Actions actions;

    @Before
    public void setUp() {

        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);


    }


    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/jpeg", "scenario_" + scenario.getName());
        }

        Driver.closeDriver();
    }

}
