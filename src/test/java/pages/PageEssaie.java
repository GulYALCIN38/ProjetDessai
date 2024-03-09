package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class PageEssaie {

    public PageEssaie() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "POSTULER")
    public WebElement postuler;

    @FindBy(linkText = "CDI")
    public WebElement cdi;

    @FindBy(linkText = "Ingénierie")
    public WebElement ingénierie;

    @FindBy(linkText = "Accéder à nos offres d'emploi")

    public WebElement acces;

    @FindBy(xpath = "//input[@id='keywords']")
    public WebElement mot_cles;

    @FindBy(xpath = "//input[@class='btn-search btn btn-primary']")
    public WebElement search;

    @FindBy(xpath = "(//a[text()='Postuler '])[1]")
    public WebElement postulerUnPost;
    @FindBy(xpath = "//div[@aria-label='close-dialog']")
    public WebElement popup;
    @FindBy(xpath= "//input[@id='jobapp_Nom']")
    public WebElement nom;
    @FindBy(id= "jobapp_Prénom")
    public WebElement prenom;
    @FindBy(id= "applicant-resume")
    public WebElement joindreCv;

    @FindBy(xpath = "//button[text()='Refuser']")
    public WebElement refuser;

    @FindBy(xpath = "//div[@class='iti__flag iti__']")
    public WebElement dropdownFlag;

    @FindBy(id = "iti-0__item-us-preferred")
    public WebElement flagUs;

    @FindBy(id = "jobapp_Téléphone")
    public WebElement tel;
    @FindBy(xpath = "//input[@id='jobapp-tc']")
    public WebElement checkbox;
    @FindBy(xpath = "//button[text()='Soumettre']")
    public WebElement soumettre;
}
