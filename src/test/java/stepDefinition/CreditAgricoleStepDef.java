package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

import static stepDefinition.Hooks.actions;
import static stepDefinition.Hooks.driver;

public class CreditAgricoleStepDef {
    HomePage homePage = new HomePage();

    @When("l'utilisateur ferme popup")
    public void lUtilisateurFermePopup() {

        ReusableMethods.visibleWait(homePage.popUp, 10);
        ReusableMethods.wait(1);
        homePage.popUp.click();
    }


    @Then("L'utilisateur vérifie que les boutons concernés sont visibles et  fonctionnels")
    public void lUtilisateurVérifieQueLesChampsConcernésSontVisiblesEtFonctionnels() {
        List<WebElement> boutons = homePage.buttonsNavbarHomePage;
        for (WebElement w : boutons) {
            actions.moveToElement(w).perform();
            Assert.assertTrue(w.isDisplayed());
            Assert.assertTrue(w.isEnabled());
            ReusableMethods.wait(1);
        }
    }

    @Then("L'utilisateur vérifie que les liens concernés sont visibles et  fonctionnels")
    public void lUtilisateurVérifieQueLesLiensConcernésSontVisiblesEtFonctionnels(DataTable dataTable) {
        List<String> element = dataTable.column(0);

        for (String s : element) {
            WebElement w = driver.findElement(By.xpath("//a[contains(text(), '" + s + "')]"));
            actions.moveToElement(w).perform();
            Assert.assertTrue(w.isDisplayed());
            Assert.assertTrue(w.isEnabled());
            w.click();
            ReusableMethods.wait(1);
        }
    }

    @And("l'utilisateur clique sur icon de Contact")
    public void lUtilisateurCliqueSurIconDeContact() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.buttonContact));
        homePage.buttonContact.click();
        ReusableMethods.wait(1);
    }

    @And("l'utilisateur clique sur Être rappelé")
    public void lUtilisateurCliqueSurÊtreRappelé() {
        ReusableMethods.clickJS(homePage.lienÊtreRappelé);
        homePage.lienÊtreRappelé.click();

    }

    @And("l'utilisateur complète le formulaire {string},{string},{string}, {string},{string}")
    public void lUtilisateurComplèteLeFormulaire(String Nom, String Prénom, String Tel, String date, String horaire) {
        ReusableMethods.wait(1);
        ReusableMethods.clickJS(homePage.inputNom);
        homePage.inputNom.sendKeys(Nom);
        ReusableMethods.wait(1);
        ReusableMethods.clickJS(homePage.inputPrenom);
        homePage.inputPrenom.sendKeys(Prénom);
        ReusableMethods.wait(1);
        homePage.inputTel.sendKeys(Tel);
        ReusableMethods.wait(1);
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].removeAttribute('readonly')", homePage.inputDate);
        ReusableMethods.clickJS(homePage.inputDate);
        ReusableMethods.wait(3);
        System.out.println("date = " + date);
        homePage.inputDate.sendKeys(Keys.COMMAND,date);
//        homePage.inputDate.sendKeys(date);
//        actions.sendKeys(homePage.inputDate, date, Keys.BACK_SPACE).perform();

//        ReusableMethods.wait(1);
//        homePage.inputTime.sendKeys(horaire);


    }

    @And("l'utilisateur  clique sur le  checkbox")
    public void lUtilisateurCliqueSurLeCheckbox() {
        ReusableMethods.wait(1);
        homePage.checkboxAccept.click();
    }

    @And("l'utilisateur clique sur le bouton de valider")
    public void lUtilisateurCliqueSurLeBoutonDeValider() {
    }

    @Then("utilisateur vérifie que le message davertissement  rouge {string} saffiche")
    public void utilisateurVérifieQueLeMessageDavertissementRougeSaffiche(String arg0) {
    }
}
