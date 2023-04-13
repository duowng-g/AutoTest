package Pages;

import Common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class longInPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public WebDriverWait wait;
    public longInPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        wait = new WebDriverWait(driver, 30);
    }
    //khai bao cac locators
    private By email_btn = By.xpath("/html/body/div[2]/div[1]/div/div[1]/div/div/div[2]/form/div[2]/div[1]/div[2]/input");
    private By longinPassword = By.id("login-password");
    private By longIn_btn = By.xpath("/html/body/div[2]/div[1]/div/div[1]/div/div/div[2]/form/div[2]/div[6]/div[2]");

    public mainPage longIn(String email, String password) throws InterruptedException {
        validateHelper.waitForPageLoad();
        validateHelper.verifyURL("longin");
        validateHelper.sendText(email_btn,email);
        validateHelper.sendText(longinPassword,password);
        validateHelper.clickElement(longIn_btn);
        Thread.sleep(20);
        return new mainPage(driver);
    }

}
