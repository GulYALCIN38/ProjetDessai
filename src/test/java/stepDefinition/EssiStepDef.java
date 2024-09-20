package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.ReusableMethods;

import java.util.List;

import static stepDefinition.Hooks.actions;
import static stepDefinition.Hooks.driver;

public class EssiStepDef {
    List<String> elements;
    HomePage homePage = new HomePage();

    @When("l'utilisateur ferme Popup")
    public void lUtilisateurFermePopup() {
        ReusableMethods.visibleWait(homePage.refuserCookies, 10);
        ReusableMethods.wait(1);
        homePage.refuserCookies.click();
    }

    @Then("L'utilisateur vérifie que les champs concernés sont visibles, fonctionnels")
    public void lUtilisateurVérifieQueLesChampsConcernésSontVisiblesFonctionnels(DataTable dataTable) {
        elements = dataTable.column(0);
        for (String element : elements) {
            WebElement w = driver.findElement(By.xpath("//a[@aria-label='" + element + "']"));
            actions.moveToElement(w).perform();
            assert w.isDisplayed();
            assert w.isEnabled();
            ReusableMethods.wait(1);
        }
    }


    @When("l'utilisateur clique sur le lien de Candidature spontanée")
    public void lUtilisateurCliqueSurLeLienDeCandidatureSpontanée() {
        actions.moveToElement(homePage.lienApropos).perform();
        ReusableMethods.visibleWait(homePage.candidatureSpontanée, 10);
        homePage.candidatureSpontanée.click();
    }
}
