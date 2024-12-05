package stepDefinition.essaie;

import com.github.javafaker.Faker;
import enums.COLOR;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.ReusableMethods;

import java.util.List;

import static stepDefinition.Hooks.actions;
import static stepDefinition.Hooks.driver;

public class EsiiStepDef {

    HomePage homePage = new HomePage();
    @When("l'utilisateur ferme Popup")
    public void lUtilisateurFermePopup() {
        try {
            ReusableMethods.visibleWait(homePage.refuserCookies, 10);
            ReusableMethods.wait(1);
            homePage.refuserCookies.click();
        } catch (Exception e) {
        }
    }

    @Then("L'utilisateur vérifie que les champs concernés sont visibles, fonctionnels")
    public void lUtilisateurVérifieQueLesChampsConcernésSontVisiblesFonctionnels(DataTable dataTable) {
        List<String> elements = dataTable.column(0);
        for (String element : elements) {
            WebElement w = driver.findElement(By.xpath("//a[@aria-label='" + element + "']"));
            actions.moveToElement(w).perform();
            Assert.assertTrue(w.isDisplayed());
            Assert.assertTrue( w.isEnabled());
            ReusableMethods.wait(1);
        }
    }

    @When("l'utilisateur clique sur le lien de Candidature spontané")
    public void lUtilisateurCliqueSurLeLienDeCandidatureSpontanée() {
        ReusableMethods.visibleWait(homePage.lienApropos, 10);
        actions.moveToElement(homePage.lienApropos).perform();
        ReusableMethods.visibleWait(homePage.candidatureSpontanée, 10);
        homePage.candidatureSpontanée.click();
    }

    @And("l'utilisateur remplit le formulaire {string},{string},{string}")
    public void lUtilisateurRemplitLeFormulaire(String nomPrenom, String email, String tel) {
        //ReusableMethods.scroll(homePage.nomPrenom);
        homePage.nomPrenom.sendKeys(nomPrenom);
        ReusableMethods.wait(1);
        homePage.e_mail.sendKeys(email);
        ReusableMethods.wait(1);
        homePage.tel.sendKeys(tel);
        ReusableMethods.wait(1);
    }

    @And("l'utilisateur télécharge un CV")
    public void lUtilisateurTéléchargeUnCV() {
        ReusableMethods.wait(1);
        String path = System.getProperty("user.home") + "/Desktop/Gul-YALCIN-FlowCV-Resume-20240620 (1).pdf";
        homePage.choisirUnCV.sendKeys(path);
    }

    @And("L'utilisateur télécharge une lettre de motivation")
    public void lUtilisateurTéléchargeUneLettreDeMotivation() {
        ReusableMethods.wait(1);
        String path = System.getProperty("user.home") + "/Desktop/Lettre Motivation -E.docx";
        homePage.choisirUneLetreMotivaton.sendKeys(path);

    }

    @And("L'utilisateur écrit un message")
    public void lUtilisateurÉcritUnMessage() {
        ReusableMethods.wait(1);
        Faker faker = new Faker();
        String message = faker.lorem().paragraph();
        homePage.inputMessage.sendKeys(message);
    }

    @And("l'utilisateur  clique sur le checkbox RGPD")
    public void lUtilisateurCliqueSurLeCheckboxRGPD() {
        ReusableMethods.wait(1);
        homePage.RGPD.click();
    }

    @And("l'utilisateur clique sur le bouton de Envoyer")
    public void lUtilisateurCliqueSurLeBoutonDeEnvoyer() {
        ReusableMethods.wait(1);
        homePage.buttonEnvoyer.click();
    }

    @Then("utilisateur vérifie que le message d'avertissement rouge {string} apparaît")
    public void utilisateurVérifieQueLeMessageDAvertissementRougeApparaît(String message) {
        ReusableMethods.wait(1);
        String actuelMessage = homePage.messageError.getText();
        String expectedMessage = message;
        Assert.assertEquals(expectedMessage, actuelMessage);
        ReusableMethods.wait(1);
        //On vérifie si le message est rouge
        COLOR.ROUGE_TEXT.assertTextColor(homePage.messageError);
    }


}
