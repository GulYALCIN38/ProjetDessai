package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.ReusableMethods;

import java.util.List;

import static stepDefinition.Hooks.actions;
import static stepDefinition.Hooks.driver;

public class JDFStepDefinition {
    List<WebElement> elements;
    HomePage homePage = new HomePage();

    @Given("l'utilisateur visite le site de {string}")
    public void l_utilisateur_visite_le_site_de(String siteDeJDF) {
        driver.get(siteDeJDF);
    }

    @When("l'utilisateur ferme Popup")
    public void lUtilisateurFermePopup() {

        try {
            ReusableMethods.visibleWait(homePage.popup, 30);
            ReusableMethods.wait(1);
            homePage.popup.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("L'utilisateur vérifie que les champs concernés sont visibles et fonctionnels")
    public void l_utilisateur_vérifie_que_les_champs_concernés_sont_visibles_et_fonctionnels() {
        elements = homePage.boutonNawbar;
        for (WebElement w : elements) {
            actions.moveToElement(w).perform();
            Assert.assertTrue(w.isDisplayed());
            assert w.isEnabled();
            ReusableMethods.wait(1);
        }

    }

    @And("l'utilisateur clique sur le link de Créer un compte")
    public void lUtilisateurCliqueSurLeLinkDeCréerUnCompte() {
        ReusableMethods.visibleWait(homePage.creeUnCompte,20);
        homePage.creeUnCompte.click();
    }

    @And("l'utilisateur remplit le formulaire avec des valeurs valides {string}, {string}")
    public void lUtilisateurRemplitLeFormulaireAvecDesValeursValides(String email, String tel) {
        ReusableMethods.visibleWait(homePage.email,10);
        ReusableMethods.wait(1);
        homePage.email.sendKeys(email);
        ReusableMethods.wait(1);
        homePage.mobilePhone.sendKeys(tel);
        ReusableMethods.wait(1);
    }

    @And("l'utilisateur remplit le champ de mot de passe avec de valeur invalid {string}")
    public void lUtilisateurRemplitLeChampDeMotDePasseAvecDeValeurInvalid(String motDePasse) {
        homePage.password.sendKeys(motDePasse);
        ReusableMethods.wait(1);
        homePage.openPassword.click();
        ReusableMethods.wait(1);
        homePage.continuer.click();
    }

    @Then("utilisateur vérifie que le message d'avertissement {string} apparaît")
    public void utilisateurVérifieQueLeMessageDAvertissementApparaît(String messageAttendu) {
        ReusableMethods.visibleWait(homePage.errorMessage,15);
       String messageActuel= homePage.errorMessage.getText();
       ReusableMethods.wait(1);
        Assert.assertEquals(messageAttendu,messageActuel);
    }

    @And("l'utilisateur remplit le champ de mot de passe avec de valeur valid {string}")
    public void lUtilisateurRemplitLeChampDeMotDePasseAvecDeValeurValid(String password) {
        homePage.password.sendKeys(password);
        ReusableMethods.wait(1);
        homePage.openPassword.click();
        ReusableMethods.wait(1);

    }

    @Then("l'utilisateur verifie quil passe à la deuxième étape de création de compte")
    public void lUtilisateurVerifieQuilPasseÀLaDeuxièmeÉtapeDeCréationDeCompte() {
        homePage.assertTitle(homePage.continuer,"Inscrivez-vous dès maintenant sur fdj.fr");
        ReusableMethods.wait(2);
        ReusableMethods.visibleWait(homePage.identityTitle,25);
        assert homePage.identityTitle.isDisplayed();

    }
}




