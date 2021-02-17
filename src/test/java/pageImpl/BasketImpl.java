package pageImpl;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.BaseTest;

import java.util.List;

public class BasketImpl extends BaseTest {

    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_titleTextView")
    private WebElement BASKET_TITLE;
    @FindBy(id = "com.getir.casestudy.dev:id/tvTitle")
    private WebElement EMPTY_BASKET_TEXT;
    @FindBy(xpath = "//*[@resource-id='com.getir.casestudy.dev:id/btnAdd']")
    private List<WebElement> ADD_BUTTONS;
    @FindBy(xpath = "//*[@resource-id='com.getir.casestudy.dev:id/btnRemove']")
    private List<WebElement> REMOVE_BUTTONS;
    @FindBy(xpath = "//*[@resource-id='com.getir.casestudy.dev:id/tvCount']")
    private List<WebElement> PRODUCT_COUNTS;

    public BasketImpl() {
        PageFactory.initElements(androidDriver,this);
    }

    @Step("Sepetin boş olduğu kontrol edilir.")
    public void isBasketEmpty() {
        waitForElementVisible(EMPTY_BASKET_TEXT);
        Assert.assertTrue("******** Sepet Bos Degil ********", EMPTY_BASKET_TEXT.getText().contains("no result"));
        System.out.println("-> Sepettin Bos Oldugu Kontrol Edildi");
    }

    @Step("Sepetteki tüm ürünler silinir.")
    public void removeBasket() {
        while (!EMPTY_BASKET_TEXT.getText().contains("no result")) {
            tapElement(REMOVE_BUTTONS.get(0));
        }
        System.out.println("-> Sepetteki Tum Urunler Silindi");
    }

    @Step("Sepetteki tüm ürünler <count> arttırılır.")
    public void increaseProduct(int count) {
        int currentCount;
            scrollDown();

        for (int i=0; i<ADD_BUTTONS.size();i++) {
            currentCount = Integer.parseInt(PRODUCT_COUNTS.get(i).getText());

            for (int p=0; p<count;p++){
                tapElement(ADD_BUTTONS.get(i));
            }
            Assert.assertEquals("******** Urun attırılamadı ********", Integer.parseInt(PRODUCT_COUNTS.get(i).getText()), currentCount + count);
        }
        System.out.println("-> Sepetteki Tum Urunler arttirildi");
    }

}
