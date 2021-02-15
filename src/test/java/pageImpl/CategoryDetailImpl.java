package pageImpl;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.BaseTest;

import java.util.List;

public class CategoryDetailImpl extends BaseTest {

    @FindBy(xpath = "//*[@resource-id='com.getir.casestudy.dev:id/btnAdd']")
    private List<WebElement> ADD_BUTTONS;
    @FindBy(xpath = "//*[@resource-id='com.getir.casestudy.dev:id/btnRemove']")
    private List<WebElement> REMOVE_BUTTONS;
    @FindBy(xpath = "//*[@resource-id='com.getir.casestudy.dev:id/tvCount']")
    private List<WebElement> PRODUCT_COUNTS;

    public CategoryDetailImpl() {
        PageFactory.initElements(androidDriver,this);
    }

    @Step("Sepete <count> farklı üründen <piece> tane eklenir.")
    public void addProductToBasket(int count, int piece) {
        int p;
        for (int i=0; i<count; i++) {
            if (i>2 && i%2 == 0) {
                scrollDown();
            }
            for (p=0; p<piece;p++) {
                tapElement(ADD_BUTTONS.get(i));
            }
            Assert.assertEquals("******** Urun Sepete Eklenemedi ********", PRODUCT_COUNTS.get(i).getText(),Integer.toString(p));
            int currentProductCount = i+1;
            System.out.println("-> " + currentProductCount + ". Urunden " + p + " Tane Sepete Eklendi");
        }
    }
}
