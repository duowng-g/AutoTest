package Testcase;

import Base.baseSetUp;
import Common.ValidateHelper;
import Pages.longInPage;
import Pages.mainPage;
import Pages.requestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class mainTest extends baseSetUp {
    private WebDriver driver;
    public longInPage longInPage;
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
        Thread.sleep(30);
        driver.navigate().to("https://account.base.vn/a/login?app=account&return=company");
        longInPage = new longInPage(driver);
        mainPage mainpage = longInPage.longIn("giangbaseinc@gmail.com","giang123");
    }
    @Test(priority = 2)
    public void BaseRequest() throws InterruptedException {
        Thread.sleep(30);
        mainPage = new mainPage(driver);
        requestPage requestpage = mainPage.baseRequest();
        Thread.sleep(20);
    }

}
