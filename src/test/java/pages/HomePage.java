package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

import static java.lang.String.format;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "truste-consent-button")
    public WebElement accepteCookies;
    @FindBy(id = "hamburger-btn")
    public WebElement hamburgerBouton;
    @FindBy(xpath = "//span[@data-toggle='#nav-container,#full-bg']")
    public WebElement close;
    @FindBy(xpath = "(//*[@class='tf-logo-cls-1'])[2]")
    public WebElement logo;
    @FindBy(id = "chosenselector_chosen")
    public WebElement rechercher;
    @FindBy(id = "suggest1")
    public WebElement rechercherTextbox;
    @FindBy(linkText = "Statut des commandes")
    public WebElement statutDesCommandes;
    @FindBy(id = "quick-order")
    public WebElement CommandeRapide;
    @FindBy(id = "sign-in-toggle")
    public WebElement seConnecter;
    @FindBy(xpath = "//*[@data-toggle='#cart-sidebar,#full-bg']")
    public WebElement panier;

    @FindBy(id = "primary-link-1")
    public WebElement produits;

    @FindBy(xpath = "//ul[@id='primary-nav']/li")
    public List<WebElement> titresHamburgerBouton;

    // @FindBy(xpath = "(//a[@data-analytics-text='Anticorps'])[1]")
    public WebElement getFirstSecondaryLink(int number) {
        return Driver.getDriver().findElement(By.xpath(format("//li[@id='secondary-link-%s-1']/a", number)));
    }


    @FindBy(xpath = "//li[@id='secondary-link-1-1']/a")
    public WebElement secondarylink1_1;
    @FindBy(id = "secondary-link-2-1")
    public WebElement secondarylink2_1;
    @FindBy(id = "secondary-link-3-1")
    public WebElement secondarylink3_1;
    @FindBy(id = "secondary-link-4-1")
    public WebElement secondarylink4_1;
    @FindBy(id = "secondary-link-5-1")
    public WebElement secondarylink5_1;

    @FindBy(xpath = "//span[@data-test-id='loginScreen_features']")
    public WebElement feature;
    @FindBy(xpath = "//div[text()='Payment Service']")
    public WebElement paimentservices;

}
