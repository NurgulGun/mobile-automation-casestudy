package util;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static AndroidDriver androidDriver;

    @BeforeScenario
    public void setCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "GM6");
        capabilities.setCapability("udid", "EUDMEIHQSGJR75EY");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("appPackage","com.getir.casestudy.dev");
        capabilities.setCapability("appActivity","com.getir.casestudy.modules.splash.ui.SplashActivity");

        androidDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("******** TEST BASLIYOR ********");
    }

    @AfterScenario
    public void tearDown() {
        androidDriver.quit();

    }

    public void elementSendkey(WebElement element, String text) {
        waitForElementVisible(element);
        element.sendKeys(text);
    }

    public void tapElement(WebElement element) {
        waitForElementClickable(element);
        element.click();
    }

    public void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean isExist(WebElement element) {
        waitForElementVisible(element);
        return element.isDisplayed();
    }

    public void scrollDown() {
        Dimension size = androidDriver.manage().window().getSize();
        PointOption pointStart, pointEnd;
        int startY = (int) (size.height * 0.7);
        int endY = (int) (size.height * 0.2);
        int startX = size.height / 2;
        pointStart = PointOption.point(startX,startY);
        pointEnd = PointOption.point(startX, endY);
        new TouchAction(androidDriver).press(pointStart).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(pointEnd).release().perform();
        System.out.println("-> Sayfa Scroll Edildi");
    }

}
