package stepDefinition.essaie;

import enums.COLOR;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static stepDefinition.Hooks.actions;
import static stepDefinition.Hooks.driver;

public class SynantoStepDef {
    HomePage homePage = new HomePage();

    @Then("L'utilisateur vérifie que les champs concernés sont visibles fonctionnels")
    public void lUtilisateurVérifieQueLesChampsConcernésSontVisiblesFonctionnels(DataTable dataTable) {
        List<String> elements = dataTable.column(0);
        for (String element : elements) {
            WebElement w = driver.findElement(By.xpath("//*[text()='" + element + "']"));
            actions.moveToElement(w).perform();
            Assert.assertTrue(w.isDisplayed());
            Assert.assertTrue(w.isEnabled());
            ReusableMethods.wait(1);
        }
    }

    @When("l'utilisateur clique sur le lien de Candidature spontanée")
    public void lUtilisateurCliqueSurLeLienDeCandidatureSpontanée() {
        ReusableMethods.visibleWait(homePage.candidatureSpontanée, 10);
        homePage.candidatureSpontanée.click();
        ReusableMethods.wait(1);
    }

    @And("L'utilisateur complète le formulaire {string},{string},{string}, {string}")
    public void lUtilisateurComplèteLeFormulaire(String nomPrenom, String email, String tel, String message) {
        homePage.nomEtPrenom.sendKeys(nomPrenom);
        ReusableMethods.wait(1);
        homePage.votreEmail.sendKeys(email);
        ReusableMethods.wait(1);
        homePage.telephon.sendKeys(tel);
        ReusableMethods.wait(1);
        homePage.votreMessage.sendKeys(message);
        ReusableMethods.wait(1);
    }

    @And("l'utilisateur télécharge son CV")
    public void lUtilisateurTéléchargeSonCV() {
        ReusableMethods.wait(1);
        String path = System.getProperty("user.home") + "/Desktop/image (1).png";
        homePage.choisirUnFichier.sendKeys(path);
    }

    @And("l'utilisateur  clique sur le checkbox")
    public void lUtilisateurCliqueSurLeCheckbox() {
        ReusableMethods.wait(2);
        homePage.checkbox.click();
    }

    @And("l'utilisateur clique sur le bouton de envoyer")
    public void lUtilisateurCliqueSurLeBoutonDeEnvoyer() {
        ReusableMethods.wait(2);
        homePage.envoyer.click();

    }

    @Then("utilisateur vérifie que le message davertissement rouge {string} saffiche")
    public void utilisateurVérifieQueLeMessageDavertissementRougeSaffiche(String expectedMessage) {
        ReusableMethods.wait(1);
        String actuelMessage = homePage.messageDerror.getText();
        Assert.assertEquals(expectedMessage, actuelMessage);
        ReusableMethods.wait(1);
        //On vérifie si le message est rouge
        COLOR.ROUGE_MESSAGE.assertTextColor(homePage.messageDerror);
    }

//    JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
//        js.executeScript("arguments[0].removeAttribute('readonly')", homePage.inputDate);
//        ReusableMethods.clickJS(homePage.inputDate);
//        ReusableMethods.wait(3);
//        System.out.println("date = " + date);
//        homePage.inputDate.sendKeys(Keys.COMMAND,date);
//        homePage.inputDate.sendKeys(date);
//        actions.sendKeys(homePage.inputDate, date, Keys.BACK_SPACE).perform();
//
//        ReusableMethods.wait(1);
//        homePage.inputTime.sendKeys(horaire);


}
