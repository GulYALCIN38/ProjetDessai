package stepDefinition.essaie;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.PageEssaie;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class PostulerUnPosteChezAstek {
    PageEssaie pageAstek = new PageEssaie();

    @Given("utilisateur visite {string}")
    public void utilisateur_visite(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @When("utilisateur  clicque sur le bouton de POSTULER")
    public void utilisateur_clicque_sur_le_bouton_de_postuler() {
        ReusableMethods.visibleWait(pageAstek.postuler,25);
        pageAstek.postuler.click();

    }

    @When("utilisateur clicque sur le bouton de CDI")
    public void utilisateur_clicque_sur_le_bouton_de_cdi() {
        Set<String> Windows = Driver.getDriver().getWindowHandles();
        List<String> windowslist = new ArrayList<>(Windows);
        Driver.getDriver().switchTo().window(windowslist.get(1));
        ReusableMethods.wait(1);
        ReusableMethods.clickJS(pageAstek.cdi);
    }

    @When("utilisateur clicque sur le bouton de Ingenierie")
    public void utilisateur_clicque_sur_le_bouton_de_ingenierie() {
        //ReusableMethods.scroll(pageAstek.ingénierie);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", pageAstek.ingénierie);
        ReusableMethods.wait(1);
        pageAstek.ingénierie.click();

    }

    @When("utilisateur clicque sur le bouton de Acceder a nos offres d'emploi")
    public void utilisateur_clicque_sur_le_bouton_de_acceder_a_nos_offres_d_emploi() {
        ReusableMethods.wait(5);
        pageAstek.acces.click();

    }


    @And("utilisateur envoye un mot-cles a le textbox de mot-cles")
    public void utilisateur_Envoye_Un_Mot_Cles_A_Le_Textbox_De_MotCles() {
        ReusableMethods.switchToWindow(2);
        ReusableMethods.wait(1);
        pageAstek.mot_cles.sendKeys("ingenieur testeur");
        pageAstek.search.click();
        ReusableMethods.wait(1);
        pageAstek.postulerUnPost.click();


    }

    @Then("utilisateur rempli ses informations pour soumettre")
    public void utilisateur_Rempli_Ses_Informations_Pour_Soumettre() {
        //pageAstek.refuser.click();
        ReusableMethods.wait(2);
        pageAstek.popup.click();

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.visibleWait(pageAstek.nom,10);
        actions.moveToElement(pageAstek.nom);
        actions.sendKeys(pageAstek.nom,"Yalcin").build().perform();
        ReusableMethods.wait(1);
        pageAstek.prenom.sendKeys("Gul",Keys.TAB, "gulyalcin@gmail.com");
        ReusableMethods.wait(1);
        String path = System.getProperty("user.home") + "/Desktop/Hacer-Gul-Yalcin-FlowCV-Resume-20240209 (2).pdf";
        // pageAstek.joindreCv.click();
        ReusableMethods.wait(1);
        pageAstek.joindreCv.sendKeys(path);


        ReusableMethods.wait(1);

        //pageAstek.dropdownFlag.click();

        //ReusableMethods.click(pageAstek.flagUs);

        pageAstek.tel.sendKeys("0658194363");

        pageAstek.checkbox.click();
        assertTrue(pageAstek.checkbox.isSelected());

        //pageAstek.soumettre.click();


    }

    public static class ESIIStepDefs {
    }
}
