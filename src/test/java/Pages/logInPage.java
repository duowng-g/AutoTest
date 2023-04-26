package Pages;

import Common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class logInPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public WebDriverWait wait;
    public logInPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        wait = new WebDriverWait(driver, 30);
    }
    //khai bao cac locators
    private By email_btn = By.xpath("/html/body/div[2]/div[1]/div/div[1]/div/div/div[2]/form/div[2]/div[1]/div[2]/input");
    private By loginPassword = By.id("login-password");
    private By logIn_btn = By.xpath("/html/body/div[2]/div[1]/div/div[1]/div/div/div[2]/form/div[2]/div[6]/div[2]");

    public mainPage logIn(String email, String password) throws InterruptedException {
        validateHelper.waitForPageLoad();
        validateHelper.verifyURL("login");
        validateHelper.sendText(email_btn,email);
        validateHelper.sendText(loginPassword,password);
        validateHelper.clickElement(logIn_btn);
        Thread.sleep(20);
        return new mainPage(driver);
    }
}
