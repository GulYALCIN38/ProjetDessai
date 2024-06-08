
package stepDefinition.essaie;

import com.github.javafaker.Faker;
import enums.COLOR;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.*;
import static stepDefinition.Hooks.actions;
import static stepDefinition.Hooks.driver;


public class OleaHomepageCheckTitles extends CommonPage {
    List<WebElement> liens = getOleaHomePage().links;
    Faker faker=new Faker();

    @Given("L'utilisateur visite le site de {string}")
    public void lUtilisateurVisiteLeSiteDe(String url) {
        driver.get(ConfigReader.getProperty("urlOlea"));
    }

    @When("L'utilisateur ferme Popup")
    public void lUtilisateurValidePopup() {
        ReusableMethods.visibleWait(getOleaHomePage().validePopup, 10);
        getOleaHomePage().validePopup.click();
        ReusableMethods.wait(2);
        ReusableMethods.visibleWait(getOleaHomePage().cookies, 10);
        getOleaHomePage().cookies.click();
    }

    @Then("l'utilisateur vérifie que les champs concernés sont visibles")
    public void lUtilisateurVérifieQueLesChampsConcernésSontVisibles() {
        //première voie
        liens.forEach(t -> assertTrue(t.isDisplayed()));
        //deuxième voie
        for (WebElement w : liens) {
            assert w.isDisplayed();
        }
        assertTrue(getOleaHomePage().demandeUneDemo.isDisplayed());
        assertTrue(getOleaHomePage().linkConnection.isDisplayed());
        assertTrue(getOleaHomePage().FR.isDisplayed());
    }

    @Then("l'utilisateur vérifie que les champs concernés sont fonctionnels")
    public void lUtilisateurVérifieQueLesChampsConcernésSontFonctionnels() {
        for (WebElement w : liens) {
            ReusableMethods.wait(1);
            actions.moveToElement(w).perform();
            COLOR.ORANGE_BORDER.assertBorderColor(w);
            ReusableMethods.wait(1);
            w.click();
            ReusableMethods.wait(1);
            COLOR.NOIR_BACKROUND.assertBackroundColor(w);
            ReusableMethods.wait(1);
        }
        actions.moveToElement(getOleaHomePage().demandeUneDemo).perform();
        COLOR.ORANGE_BACKROUND.assertBackroundColor(getOleaHomePage().demandeUneDemo);
        getOleaHomePage().assertTitle(getOleaHomePage().demandeUneDemo, "Demande de démo – Olea Medical");
        getOleaHomePage().assertTitle(getOleaHomePage().linkConnection, "Connexion – Olea Medical");
        getOleaHomePage().FR.click();
        getOleaHomePage().assertUrl(getOleaHomePage().EN, "https://www.olea-medical.com/en/customer/connexion/");


    }

    @And("l'utilisateur clique sur la demande de démo")
    public void lUtilisateurCliqueSurLaDemandeDeDémo() {
        getOleaHomePage().demandeUneDemo.click();
    }

    @And("l'utilisateur remplit le formulaire avec des valeurs valides {string}, {string}, {string}")
    public void lUtilisateurRemplitLeFormulaireAvecDesValeursValides(String prénom, String nom, String institution) {
        driver.switchTo().frame(getOleaHomePage().iframe);
        ReusableMethods.click(getOleaHomePage().civilite);
        getOleaHomePage().prenom.sendKeys(prénom);
        ReusableMethods.wait(1);
        getOleaHomePage().nom.sendKeys(nom, Keys.TAB, institution);
        ReusableMethods.wait(1);
        getOleaHomePage().choisissezDropdown(getOleaHomePage().select, "Radiologue / Docteur / Chirurgien");
        getOleaHomePage().choisissezDropdown(getOleaHomePage().selectPays, "France");
        getOleaHomePage().email.sendKeys("gulyalcin@gmail.com", Keys.TAB, "0643542365");
        getOleaHomePage().datePreferance.click();
        ReusableMethods.wait(1);
        getOleaHomePage().date.click();
        String creneau=faker.lorem().word();
        getOleaHomePage().creneau.click();
        getOleaHomePage().creneau.sendKeys(creneau,Keys.TAB,Keys.ENTER);
        ReusableMethods.wait(1);

    }

    @Then("l'utilisateur vérifie que le message d'avertissement apparaît:{string}")
    public void lUtilisateurVérifieQuUnMessageDAvertissementApparaît(String expectedMessage) {
        ReusableMethods.visibleWait(getOleaHomePage().message,10);
        String actuelmessage=getOleaHomePage().message.getText();
        assertEquals(expectedMessage,actuelmessage);
        driver.switchTo().defaultContent();

        String str= "gul";
        String str2="gul";
        assert str.equals(str2);
        
    }



}


    





           