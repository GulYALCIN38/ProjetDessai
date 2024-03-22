package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinition.Hooks.driver;

public abstract class CommonPage {
    public CommonPage() {
        PageFactory.initElements(driver,this);
    }
    private OleaHomePage oleaHomePage;

    public OleaHomePage getOleaHomePage() {
        if(oleaHomePage==null){
            oleaHomePage=new OleaHomePage();
        }
        return oleaHomePage;
    }

}
