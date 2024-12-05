package stepDefinition.essaie;

import enums.COLOR;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class homepageStepDef {
    List<WebElement> elements;
    HomePage homePage = new HomePage();

    @Given("L'utilisateur visite le site de Thermo Fisher Scientific")
    public void utilisateur_visite_le_site_de_thermo_fisher_scientific() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.wait(1);
        try {
            homePage.accepteCookies.click();
        } catch (Exception e) {
            System.out.println("pas de probleme");
        }

    }

    @Then("Vérifier que les éléments de navbar sont visibles")
    public void vérifierQueLesÉlémentsDeNavbarSontVisibles() {
        elements = new ArrayList<>();
        elements.add(homePage.hamburgerBouton);
        elements.add(homePage.rechercher);
        elements.add(homePage.rechercherTextbox);
        elements.add(homePage.statutDesCommandes);
        elements.add(homePage.CommandeRapide);
        elements.add(homePage.seConnecter);
        elements.add(homePage.panier);

        for (WebElement w : elements) {
            w.isDisplayed();

        }

    }


    @Then("Vérifier que les éléments de navbar sont cliquable")
    public void vérifierQueLesÉlémentsDeNavbarSontCliquable() {
        elements = new ArrayList<>();
        for (WebElement w : elements) {
            w.isEnabled();

        }
    }

    @When("l'utilisateur clique sur le hamburger bouton")
    public void lUtilisateurCliqueSurLeBoutonDeHamburger() {
        homePage.hamburgerBouton.click();
    }

    @Then("vérifier que les éléments de hamburger bouton sont visibles")
    public void vérifierQueLesÉlémentsDeHamburgerBoutonSontVisibles() {
       List<WebElement>titles= homePage.titresHamburgerBouton;
        for (int i = 0; i < titles.size(); i++) {
            Assert.assertTrue(titles.get(i).isDisplayed());

        }


    }
    @Then("Vérifier que la couleur du titre{int} est noire")
    public void vérifierQueLaCouleurDuPremierTitreEstNoire(int no) {
        //solution 1
        String actualTextColor = homePage.titresHamburgerBouton.get(no-1).getCssValue("color");
        System.out.println("actualTextColor = " + actualTextColor);
        String expectedTextColor = "rgba(27, 27, 29, 1)";
        Assert.assertEquals(expectedTextColor, actualTextColor);

        // solution 2 ==>ENUMS
        COLOR.NOIR_TEXT.assertTextColor(homePage.titresHamburgerBouton.get(no-1));
    }
    @When("l'utilisateur scroll le titre {int}")
    public void lUtilisateurScrollLeTitre(int no) {

     ReusableMethods.wait(3);
       Actions actions=new Actions(Driver.getDriver());
       actions.moveToElement(homePage.titresHamburgerBouton.get(no-1)).build().perform();


    }

    @Then("Vérifier que la couleur du titre{int} est bleu")
    public void vérifierQueLaCouleurDuTitreEstBleu(int no) {
        COLOR.BLEU_TEXT.assertTextColor(homePage.titresHamburgerBouton.get(no-1));
    }



    @When("l'utilisateur clique sur le titre{int}")
    public void lUtilisateurCliqueSurLeTitre(int no) {
        homePage.titresHamburgerBouton.get(no-1).click();

    }



    @Then("vérifier que ce titre{int} {string} est visible")
    public void vérifierQueCeTitreEstVisible(int number, String title) {
        ReusableMethods.visibleWait(homePage.getFirstSecondaryLink(number),10);
        homePage.getFirstSecondaryLink(number).isDisplayed();
        String actual=homePage.getFirstSecondaryLink(number).getText();
        System.out.println("actual = " + actual);
        Assert.assertTrue(actual.contains(title));


    }

    @And("l'utilisateur ferme la page")
    public void lUtilisateurFermeLaPage() {
        Driver.closeDriver();
    }


}
