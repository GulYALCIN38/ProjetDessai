





package stepDefinition;

import enums.COLOR;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.ReusableMethods;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static stepDefinition.Hooks.actions;
import static stepDefinition.Hooks.driver;


public class OleaHomepageCheckTitles extends CommonPage {
    List<WebElement> liens = getOleaHomePage().links;
    @Given("L'utilisateur visite le site de {string}")
    public void lUtilisateurVisiteLeSiteDe(String url) {
        driver.get(url);
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
            w.click();
            getOleaHomePage();
            getOleaHomePage();
            COLOR.NOIR_BACKROUND.assertBackroundColor(w);
            ReusableMethods.wait(1);
        }
        actions.moveToElement(getOleaHomePage().demandeUneDemo).perform();
        COLOR.ORANGE_BACKROUND.assertBackroundColor(getOleaHomePage().demandeUneDemo);
        getOleaHomePage().assertTitle(getOleaHomePage().demandeUneDemo,"Demande de démo – Olea Medical");
        getOleaHomePage().assertTitle(getOleaHomePage().linkConnection,"Connexion – Olea Medical");
        getOleaHomePage().FR.click();
        getOleaHomePage().assertUrl(getOleaHomePage().EN, "https://www.olea-medical.com/en/customer/connexion/");

    }

}
