package Testcase;

import Base.baseSetUp;
import Pages.longInPage;
import Pages.mainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class longInTest extends baseSetUp {
    private WebDriver driver;
    public longInPage longInPage;
    @BeforeClass
    public void setUp(){
        driver = new baseSetUp().setDriver("chrome");
    }
    @Test(priority = 1)
    public void longInTest() throws InterruptedException {
        Thread.sleep(30);
        driver.navigate().to("https://account.base.vn/a/login?app=account&return=company");
        longInPage = new longInPage(driver);
        mainPage mainpage = longInPage.longIn("giangbaseinc@gmail.com","giang123");
    }
}
