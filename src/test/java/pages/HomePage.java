package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.xml.xpath.XPath;
import java.util.List;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static stepDefinition.Hooks.driver;

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
    @FindBy(xpath = "//div[@class='group h-full']")
    public List<WebElement> boutonNawbar;
    @FindBy(xpath = "//button[@id='popin_tc_privacy_button_2']")
    public WebElement popup;
    @FindBy(xpath = "//a[@title='Accueil']")
    public WebElement title;

    @FindBy(xpath = "//a[@id='top-menu-create-account-button']")
    public WebElement creeUnCompte;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;
    @FindBy(xpath = "//input[@id='wup-password-input']")
    public WebElement password;
    @FindBy(xpath = "//input[@id='wup-mobilePhone-input']")
    public WebElement mobilePhone;
    @FindBy(xpath = "//div[@id='wup-password-error-message']")
    public WebElement errorMessage;
    @FindBy(xpath = "//img[@id='wup-password-opened-eye-icon']")
    public WebElement openPassword ;
    @FindBy(id = "wup-continue")
    public WebElement continuer ;
    @FindBy(id = "wup-step2-identity-title")
    public WebElement identityTitle ;

    //-------------DIAGDEV-----------------------------------------------------------------
    @FindBy(id = "enslashcontactslash")
    public WebElement contact ;
    @FindBy(name = "firstname")
    public WebElement firstName ;
    @FindBy(name = "lastname")
    public WebElement lastName ;
    @FindBy(name = "position")
    public WebElement position ;
    @FindBy(name = "company")
    public WebElement company ;
    @FindBy(name = "question")
    public WebElement request ;
    @FindBy(name = "city_state")
    public WebElement cityState ;
    @FindBy(name = "email")
    public WebElement mail ;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement send;
    @FindBy(xpath = "//div[@class='errorMessage']")
    public WebElement message;

   // ---------------------ESII----------------------------------------------------------------------
   @FindBy(id = "axeptio_btn_dismiss")
   public WebElement refuserCookies;

    @FindBy(xpath = "//*[text()='Candidature spontanée']")
    public WebElement candidatureSpontanée;
    @FindBy(xpath = "//a[@aria-label='À propos']")
    public WebElement lienApropos;
    @FindBy(id = "input_5_1")
    public WebElement nomPrenom;
    @FindBy(id = "input_5_3")
    public WebElement e_mail;
    @FindBy(id = "input_5_4")
    public WebElement tel;
    @FindBy(id = "input_5_5")
    public WebElement choisirUnCV;
    @FindBy(id = "input_5_6")
    public WebElement choisirUneLetreMotivaton;
    @FindBy(id = "input_5_7")
    public WebElement inputMessage;
    @FindBy(xpath = "//label[@class='gfield_consent_label']")
    public WebElement RGPD;
    @FindBy(xpath = "//button[@id='gform_submit_button_5']")
    public WebElement buttonEnvoyer;
    @FindBy(xpath = "//div[text()='Ce champ est nécessaire']")
    public WebElement messageError;

    // ---------------------SYNTANO----------------------------------------------------------------------
    @FindBy(xpath = "//*[@placeholder='Vos nom et prénom*']")
    public WebElement nomEtPrenom;
    @FindBy(xpath = "//*[@placeholder='Votre email*']")
    public WebElement votreEmail;
    @FindBy(xpath = "//*[@placeholder='Téléphone']")
    public WebElement telephon;
    @FindBy(xpath = "//*[@placeholder='Votre message*']")
    public WebElement votreMessage;
    @FindBy(name = "file-175")
    public WebElement choisirUnFichier;
    @FindBy(name = "acceptance-663")
    public WebElement checkbox;
    @FindBy(xpath = "//*[@class='wpcf7-form-control wpcf7-submit has-spinner']")
    public WebElement envoyer;
    @FindBy(xpath = "//span[text()='Ce champ est obligatoire.']")
    public WebElement messageDerror;



    //--------------------------Credit Agricole--------------------------------------------------

    @FindBy(xpath="//button[@data-trackingclass-npc='MMenu-niveau1-button']")
    public List<WebElement> buttonsNavbarHomePage;
    @FindBy(xpath="//div[@class='bouton-vert parbase']//button")
    public WebElement buttonContact;
    @FindBy(id="popin_tc_privacy_button_2")
    public WebElement popUp;
    @FindBy(xpath="//iframe[@src='https://www.googletagmanager.com/static/service_worker/4c30/sw_iframe.html?origin=https%3A%2F%2Fwww.credit-agricole.fr']")
    public WebElement iframe;
    @FindBy(xpath="//a[@aria-label='Être rappelé']")
    public WebElement lienÊtreRappelé;
    @FindBy(xpath="(//*[@id='WcbWidget-ContentHome-CallbackForm-LastName'])[2]")
    public WebElement inputNom;
    @FindBy(xpath="(//*[@id='WcbWidget-ContentHome-CallbackForm-FirstName'])[2]")
    public WebElement inputPrenom;
    @FindBy(xpath="(//*[@id='WcbWidget-ContentHome-CallbackForm-PhoneNumber'])[2]")
    public WebElement inputTel;
    @FindBy(xpath="(//div[@class='GreenBtn-callbackNeedCallbackFormContentWrapper radio-label js-radio-label'])[2]")
    public WebElement radioButton;
    @FindBy(xpath="(//*[@id='WcbWidget-ContentHome-CallbackForm-Date-Date'])[2]")
    public WebElement inputDate;
    @FindBy(xpath="(//button[@data-id='WcbWidget-ContentHome-CallbackForm-Date-Time'])[2]")
    public WebElement inputTime;
    @FindBy(id="(//*[@id='WcbWidget-ContentHome-CallbackFooter-NoticeDiv'])[2]")
    public WebElement checkboxAccept;


    /**
     * Cette méthode valide le title qui change lorsque vous cliquez sur un élément.
     * @param w webElement
     * @param expectedTitle String
     * @author gulyalcin
     * @date 08.06.2024
     */
    public void assertTitle(WebElement w,String expectedTitle){
        w.click();
        String actuelTitle= driver.getTitle();
        assertEquals(expectedTitle,actuelTitle);
    }

    /**
     * Cette méthode valide l'url qui change lorsque vous cliquez sur un élément.
     * @param w webElement
     * @param expectedUrl String
     * @author gulyalcin
     * @date 07.06.2024
     */
    public void assertUrl(WebElement w,String expectedUrl){
        ReusableMethods.visibleWait(w,10);
        w.click();
        String actuelUrl=driver.getCurrentUrl();
        assertEquals(expectedUrl,actuelUrl);
    }
    public void choisissezDropdown(WebElement w,String choix ){
        Select select=new Select(w);
        select.selectByVisibleText(choix);
    }
}
