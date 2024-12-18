package stepDefinition.essaie;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static stepDefinition.Hooks.driver;

public class DiagdevStepDef {
    HomePage homePage = new HomePage();

    @When("l'utilisateur clique sur le lien de Contact")
    public void lUtilisateurCliqueSurLeLinkDeContact() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.contact));
        homePage.contact.click();
        ReusableMethods.wait(1);
    }

    @And("l'utilisateur remplit le formulaire {string},{string},{string},{string},{string},{string},{string}")
    public void lUtilisateurRemplitLeFormulaire(String firstname, String lastname, String position, String company, String request, String city, String mail) {
        homePage.firstName.sendKeys(firstname);
        homePage.lastName.sendKeys(lastname);
        ReusableMethods.wait(1);
        homePage.position.sendKeys(position);
        homePage.company.sendKeys(company);
        ReusableMethods.wait(1);
        homePage.request.sendKeys(request);
        homePage.cityState.sendKeys(city);
        ReusableMethods.wait(1);
        homePage.mail.sendKeys(mail);
        ReusableMethods.wait(1);

    }

    @And("l'utilisateur  clique sur le Send button")
    public void lUtilisateurCliqueSendButton() {
        homePage.send.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.wait(1);

    }

    @Then("utilisateur vérifie que le message d'avertissement {string} apparaît sur la surface rouge")
    public void utilisateurVérifieQueLeMessageDAvertissementApparaîtSurLaSurfaceRouge(String expectedMessage) {
        ReusableMethods.visibleWait(homePage.message, 20);
        String actualMessage = homePage.message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


}
