package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHypnotes extends CommonPage {
    @FindBy(xpath ="//div[text()='Biofeedback/Emotion-Detection']")
    public WebElement biofeedback;

}
