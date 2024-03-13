package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static stepDefinition.Hooks.driver;

public class OleaHomePage extends CommonPage{

    @FindBy(id = "ckStep1Button")
    public WebElement validePopup;
    @FindBy(xpath = "(//btn[text()='Accepter les cookies'])[1]")
    public WebElement cookies;
    @FindBy(xpath = "//div[@class='menu__item-wrapper']")
    public List<WebElement> links;
    @FindBy(xpath = "//div[@class='header__cta is--header-elmt']//a")
    public WebElement demandeUneDemo;
    @FindBy(xpath = "//a[@class='header-connect__btn']")
    public WebElement linkConnection;
    @FindBy(css = ".lang-switcher__btn-link")
    public WebElement FR;
    @FindBy(css = ".lang-switcher-item__link")
    public WebElement EN;
    @FindBy(xpath = "//input[@id='salutation2-0e1d22b1-d468-455f-a6a8-90d127854edb']")
    public WebElement civilite;
    @FindBy(id = "firstname-0e1d22b1-d468-455f-a6a8-90d127854edb")
    public WebElement prenom;
    @FindBy(id = "lastname-0e1d22b1-d468-455f-a6a8-90d127854edb")
    public WebElement nom;
    @FindBy(id = "hs-form-iframe-0")
    public WebElement iframe;
    @FindBy(id = "profession-0e1d22b1-d468-455f-a6a8-90d127854edb")
    public WebElement select;
    @FindBy(id = "countryname-0e1d22b1-d468-455f-a6a8-90d127854edb")
    public WebElement selectPays;
    @FindBy(id = "email-0e1d22b1-d468-455f-a6a8-90d127854edb")
    public WebElement email;
    @FindBy(id = "wished_appointment_date-0e1d22b1-d468-455f-a6a8-90d127854edb")
    public WebElement datePreferance;
    @FindBy(xpath = "(//button[@class='pika-button pika-day'])[20]")
    public WebElement date;
    @FindBy(id = "wished_time_slot-0e1d22b1-d468-455f-a6a8-90d127854edb")
    public WebElement creneau;
    @FindBy(xpath = "//label[text()='Veuillez remplir tous les champs requis.']")
    public WebElement message;
    /**
     * Cette méthode valide le title qui change lorsque vous cliquez sur un élément.
     * @param w webElement
     * @param expectedTitle
     * @author gulyalcin
     * @date 09.03.2024
     */
    public void assertTitle(WebElement w,String expectedTitle){
        w.click();
        String actuelTitle= driver.getTitle();
        assertEquals(expectedTitle,actuelTitle);
    }

    /**
     * Cette méthode valide l'url qui change lorsque vous cliquez sur un élément.
     * @param w webElement
     * @param expectedUrl
     * @author gulyalcin
     * @date 09.03.2024
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
