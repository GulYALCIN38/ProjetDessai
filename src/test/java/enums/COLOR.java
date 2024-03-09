package enums;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public enum COLOR {

    NOIR_TEXT("#1b1b1d", "rgb(27, 27, 29)","rgba(27, 27, 29, 1)"),
    BLEU_TEXT("#005daa","rgb(0, 93, 170)", "rgba(0, 93, 170, 1)"),
    ORANGE_BORDER("#ff6b00","rgb(255, 107, 0)","rgba(255, 107, 0, 1)"),
    NOIR_BACKROUND("#24272a","rgb(0, 0, 0)","rgba(0, 0, 0, 0)"),
    ORANGE_BACKROUND("#ff6b00","rgb(255, 107, 0)","rgba(255, 107, 0, 1)"),
    //rgb(255, 107, 0) ,#ff6b00 ,border-bottom-color
    //background-color ,#24272a  rgb(36, 39, 42)   siyah backround  rgba([36, 39, 42, 1])

    ;

    private String HEX;
    private String RBG;
    private String RGBA;

    COLOR(String HEX, String RBG, String RGBA) {
        this.HEX = HEX;
        this.RBG = RBG;
        this.RGBA = RGBA;
    }

    public String getHEX() {
        return HEX;
    }

    public String getRBG() {
        return RBG;
    }

    public String getRGBA() {
        return RGBA;
    }
    public void assertTextColor(WebElement w){
        String actuelTextColor=w.getCssValue("color");
        Assert.assertEquals(this.getRGBA(),actuelTextColor);
    }
    public void assertBorderColor(WebElement w){
        String actuelBorderColor=w.getCssValue("border-bottom-color");
        Assert.assertEquals(this.getRGBA(),actuelBorderColor);

    }
    public void assertBackroundColor(WebElement w){
        String actuelBackroundColor=w.getCssValue("background-color");
        Assert.assertEquals(this.getRGBA(),actuelBackroundColor);
    }
}
