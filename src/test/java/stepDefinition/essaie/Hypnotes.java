package stepDefinition.essaie;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import utilities.Driver;



public class Hypnotes {
    HomePage homePage=new HomePage();
    @Given("user goes to homepage")
    public void user_goes_to_homepage() {
        Driver.getDriver().get("https://test.hypnotes.net/");

    }
    @When("user hoverover  at tke Feature button")
    public void user_hoverover_at_tke_feature_button() {
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(homePage.feature).perform();
       // ReusableMethods.scroll(homePage.feature);

    }
    @Then("user should be see paiment services")
    public void user_should_be_see_paiment_services() {

        Assert.assertTrue(homePage.paimentservices.isDisplayed());
        System.out.println("homePage.paimentservices.getText() = " + homePage.paimentservices.getText());

    }
}
