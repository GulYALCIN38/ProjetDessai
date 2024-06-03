package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinition.Hooks.driver;

public abstract class CommonPage {
    public CommonPage() {
        PageFactory.initElements(driver,this);
    }
    private OleaHomePage oleaHomePage;
    private PageHypnotes pageHypnotes;

    public OleaHomePage getOleaHomePage() {
        if(oleaHomePage==null){
            oleaHomePage=new OleaHomePage();
        }
        return oleaHomePage;
    }
    public PageHypnotes getPageHypnotes() {
        if(pageHypnotes==null){
            pageHypnotes=new PageHypnotes();
        }
        return pageHypnotes;
    }

}
