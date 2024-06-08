package stepDefinition.essaie;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import static stepDefinition.Hooks.actions;
import static stepDefinition.Hooks.driver;


public class HypnotesDeneme extends CommonPage {
    @Given("user goes to homepage")
    public void user_goes_to_homepage() {
        driver.get(ConfigReader.getProperty("urlhypnotes"));

    }

    @When("user click at the BiofeedbackEmotion-Detection")
    public void user_click_at_the_biofeedback_emotion_detection() {
        ReusableMethods.scrollEnd();
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.END).perform();

        getPageHypnotes().biofeedback.click();


    }

    @Then("user should be see Level up with Emotion-Recognition")
    public void user_should_be_see_level_up_with_emotion_recognition() {

    }


}
