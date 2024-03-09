package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
}
