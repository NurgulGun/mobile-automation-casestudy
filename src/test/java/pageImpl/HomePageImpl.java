package pageImpl;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.BaseTest;

import java.util.List;

public class HomePageImpl extends BaseTest {

    @FindBy(xpath = "//*[@resource-id='com.getir.casestudy.dev:id/tvTitle']")
    private List<WebElement> CATEGORIES;

    public HomePageImpl() {
        PageFactory.initElements(androidDriver,this);
    }


    @Step("<category>. kategoriye tıklanır.")
    public void selectCategory(int categoryIndex) {
        tapElement(CATEGORIES.get(categoryIndex-1));
        System.out.println("-> " + categoryIndex + ". Kategoriye Tiklandi");
    }
}
