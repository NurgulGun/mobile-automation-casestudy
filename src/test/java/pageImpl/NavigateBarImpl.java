package pageImpl;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.BaseTest;

public class NavigateBarImpl extends BaseTest {

    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_getir10GABasketButton")
    private WebElement BASKET_ICON;
    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_leftIconImageView")
    private WebElement BACK_ICON;
    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_titleTextView")
    private WebElement BASKET_PAGE_TITLE;

    public NavigateBarImpl() {
        PageFactory.initElements(androidDriver,this);
    }

    @Step("Sepet ikonuna tıklanır.")
    public void tapBasket() {
        tapElement(BASKET_ICON);
        waitForElementVisible(BASKET_PAGE_TITLE);
        Assert.assertEquals("", BASKET_PAGE_TITLE.getText(),"Basket");
        System.out.println("-> Sepet Sayfasi Acildi ");
    }

    @Step("Geri butonuna basılır.")
    public void tapBackBtn() {
        tapElement(BACK_ICON);
        System.out.println("-> Geri Butonuna Basildi");
    }
}
