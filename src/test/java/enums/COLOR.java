package enums;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public enum COLOR {

    NOIR_TEXT("#1b1b1d", "rgb(27, 27, 29)","rgba(27, 27, 29, 1)"),
    BLEU_TEXT("#005daa","rgb(0, 93, 170)", "rgba(0, 93, 170, 1)"),

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
}
