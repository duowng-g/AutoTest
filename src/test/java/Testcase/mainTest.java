package Testcase;

import Base.baseSetUp;
import Common.PropertiesFile;
import Common.ValidateHelper;
import Pages.logInPage;
import Pages.mainPage;
import Pages.requestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class mainTest extends baseSetUp {
    private WebDriver driver;
    public logInPage logInPage;
    public mainPage mainPage;
    public ValidateHelper validateHelper;
    public WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        driver = new baseSetUp().setDriver("chrome");
        validateHelper = new ValidateHelper(driver);
        wait = new WebDriverWait(driver, 30);
    }
    @Test(priority = 1)
    public void longInTest() throws InterruptedException {
        PropertiesFile.setPropertiesFile();
        Thread.sleep(30);
        driver.navigate().to("https://account.base.vn/a/login?app=account&return=company");
        logInPage = new logInPage(driver);
        mainPage mainpage = logInPage.logIn(PropertiesFile.getPropValue("email"),PropertiesFile.getPropValue("password"));
    }
    @Test(priority = 2)
    public void BaseRequest() throws InterruptedException {
        Thread.sleep(30);
        mainPage = new mainPage(driver);
        requestPage requestpage = mainPage.baseRequest();
        Thread.sleep(20);
    }

}
