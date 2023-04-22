package Testcase;

import Base.baseSetUp;
import Common.PropertiesFile;
import Pages.logInPage;
import Pages.mainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class logInTest extends baseSetUp {
    private WebDriver driver;
    public logInPage logInPage;
    @BeforeClass
    public void setUp(){
        driver = new baseSetUp().setDriver("chrome");
    }
    @Test(priority = 1)
    public void longInTest() throws InterruptedException {
        PropertiesFile.setPropertiesFile();
        Thread.sleep(30);
        driver.navigate().to("https://account.base.vn/a/login?app=account&return=company");
        logInPage = new logInPage(driver);
        mainPage mainpage = logInPage.logIn(PropertiesFile.getPropValue("email"),PropertiesFile.getPropValue("password"));
    }
}
