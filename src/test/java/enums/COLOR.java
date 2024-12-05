package enums;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public enum COLOR {

    NOIR_TEXT("#1b1b1d", "rgb(27, 27, 29)","rgba(27, 27, 29, 1)"),
    BLEU_TEXT("#005daa","rgb(0, 93, 170)", "rgba(0, 93, 170, 1)"),
    ORANGE_BORDER("#ff6b00","rgb(255, 107, 0)","rgba(255, 107, 0, 1)"),
    NOIR_BACKROUND("#24272a","rgb(0, 0, 0)","rgba(0, 0, 0, 0)"),
    ORANGE_BACKROUND("#ff6b00","rgb(255, 107, 0)","rgba(255, 107, 0, 1)"),
    ROUGE_TEXT("#f5222d","rgb(245, 34, 45)","rgba(245, 34, 45, 1)"),
    ROUGE_MESSAGE("#b20000","rgb(178, 0, 0)","rgba(178, 0, 0, 1)"),
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

    /**
     * Cette méthode valide la TextColor pour un WebElement
     * @param w WebElement
     * @author gulyalcin
     * @since 21/09/2024
     */
    public void assertTextColor(WebElement w){
        String actuelTextColor=w.getCssValue("color");
       // System.out.println("actuelTextColor = " + actuelTextColor);
        Assert.assertEquals(this.getRGBA(),actuelTextColor);
    }
    /**
     * Cette méthode valide la BorderColor pour un WebElement
     * @param w WebElement
     * @author gulyalcin
     * @since 09/09/2024
     */
    public void assertBorderColor(WebElement w){
        String actuelBorderColor=w.getCssValue("border-bottom-color");
        Assert.assertEquals(this.getRGBA(),actuelBorderColor);
    }
    /**
     * Cette méthode valide la BackroundColor pour un WebElement
     * @param w WebElement
     * @author gulyalcin
     * @since 09/09/2024
     */
    public void assertBackroundColor(WebElement w){
        String actuelBackroundColor=w.getCssValue("background-color");
        Assert.assertEquals(this.getRGBA(),actuelBackroundColor);
    }
}
