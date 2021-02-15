package pageImpl;

import com.thoughtworks.gauge.Step;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.BaseTest;


public class LoginImpl extends BaseTest {

    @FindBy(id = "com.getir.casestudy.dev:id/usernameEditText")
    private WebElement USERNAME;
    @FindBy(id = "com.getir.casestudy.dev:id/passwordEditText")
    private WebElement PASSWORD;
    @FindBy(id = "com.getir.casestudy.dev:id/loginButton")
    private WebElement LOGIN_BUTTON;
    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_leftIconImageView")
    private WebElement PROFILE_ICON;

    public LoginImpl() {
        PageFactory.initElements(androidDriver, this);
    }

    @Step("<username> kullanıcı adı ve <password> şifresi ile login olunur.")
    public void login(String username, String password) {
        elementSendkey(USERNAME,username);
        elementSendkey(PASSWORD,password);
        tapElement(LOGIN_BUTTON);

        Assert.assertTrue("******** Giris Yapilamadi ********", isExist(PROFILE_ICON));
        System.out.println("-> Login Tamamlandi ");

    }

}
