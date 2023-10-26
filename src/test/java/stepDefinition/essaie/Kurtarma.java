package stepDefinition.essaie;

public class Kurtarma {
    /*
     @FindBy(css = "h5[style='font-size: 25px; font-weight: 600; padding: 10px;']")
    public List<WebElement> listTitles;

    @FindBy(xpath = "//a[@class='ant-btn css-15rg2km ant-btn-link features-btn']")
    public List<WebElement> listHeader;
    @FindBy(xpath = "//span[text()='Payment Service']")
    public WebElement secondHeader;

    -------------------------------------------

    package stepDefinitions.UI_StepDef.homePage;

import enums.COLOR;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigurationReader;
import utilities.JS_utilities;

import java.time.Duration;

import static stepDefinitions.Hooks.*;

public class Week1_us006_check_titles {

    @Given("user goes to home page")
    public void user_goes_to_home_page() {
        driver.get(ConfigurationReader.getProperty("url"));

    }

    @Then("assert first header color should be white")
    public void assert_first_header_color_should_be_white() {
        // for return type ==> ctrl-alt -v ()
        String actuelTextColor = commonPage.getHomePage().listHeader.get(0).getCssValue("color");
        String expectedTextColor = "rgba(255, 255, 255, 1)";
        Assert.assertEquals(expectedTextColor, actuelTextColor);
        //2nd Way enum
        COLOR.WHITE_TEXT.assertTextColor(commonPage.getHomePage().listHeader.get(0));
        //3. Way extention
        commonPage.getHomePage().listHeader.get(0).assertTextColor(COLOR.WHITE_TEXT.getRGBA());


    }

    @Then("assert first header background color is green")
    public void assert_first_header_backround_color_is_green() {
        // enum
        COLOR.TEXT_GREEN_BACKROUND.assertBackroundColor(commonPage.getHomePage().listHeader.get(0));
        //2. way ==> extention class
        commonPage.getHomePage().listHeader.get(0).assertBackroundColor(COLOR.TEXT_GREEN_BACKROUND.getRGBA());

    }

    @When("user scroll to second header")
    public void user_scroll_to_second_header() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", commonPage.getHomePage().listHeader.get(1));
        waitForVisibility(commonPage.getHomePage().listHeader.get(1));

        commonPage.getHomePage().listHeader.get(1).hoverWebElement();

        waitFor(2);


    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebElement waitForVisibility(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    @Then("assert first header color should be black")
    public void assert_first_header_color_should_be_black() {
        COLOR.BlACK_TEXT.assertTextColor(commonPage.getHomePage().listHeader.get(0));


    }

    @Then("assert first header background color should be grey")
    public void assert_first_header_backround_color_should_be_grey() {
        COLOR.TEXT_GRAY_BACKROUND.assertBackroundColor(commonPage.getHomePage().listHeader.get(0));

    }
}
------------------------------------------------------------
@UI @us06_UI
Feature: week1
  Scenario: US 006
    Given user goes to home page
    Then  assert first header color should be white
    And assert first header background color is green
    When user scroll to second header
    Then  assert first header color should be black
    And assert first header background color should be grey

     */
}
