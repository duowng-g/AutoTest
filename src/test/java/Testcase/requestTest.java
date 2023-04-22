package Testcase;

import Base.baseSetUp;
import Common.PropertiesFile;
import Common.RecordVideo;
import Common.ValidateHelper;
import Pages.logInPage;
import Pages.mainPage;
import Pages.requestPage;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Set;

public class requestTest extends baseSetUp {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public WebDriverWait wait;
    public logInPage logInPage;
    public mainPage mainPage;
    public requestPage requestpage;
    public static RecordVideo RecordVideo;

    @BeforeClass
    public void setUp() throws ATUTestRecorderException {
        driver = new baseSetUp().setDriver("chrome");
        wait = new WebDriverWait(driver, 50);
        validateHelper = new ValidateHelper(driver);
        PropertiesFile.setPropertiesFile();
        RecordVideo.startRecord("Base");
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
        mainPage = new mainPage(driver);
        requestPage requestpage = mainPage.baseRequest();
    }

   @Test(priority = 3)
    public void setRequest() throws InterruptedException, AWTException {
        PropertiesFile.setPropertiesFile();
        requestpage = new requestPage(driver);
        String MainWindown = driver.getWindowHandle();
        System.out.println(MainWindown);
        Set<String> windowns = driver.getWindowHandles();
        for (String windown : windowns) {
            if (!MainWindown.equals(windown)) {
                driver.switchTo().window(windown);
                Thread.sleep(2000);
                requestpage.setNewRequest();
                requestpage.searchRequest();
                requestpage.setRequest(PropertiesFile.getPropValue("nameRequest"), PropertiesFile.getPropValue("detailRequest"), PropertiesFile.getPropValue("manager"));
                requestpage.sendRequest();
                Thread.sleep(3000);
                requestpage.checkBox(PropertiesFile.getPropValue("newNameRequest"),PropertiesFile.getPropValue("newDetailRequest"));
                Thread.sleep(3000);
                requestpage.checkGroups();
                Thread.sleep(3000);
                requestpage.checkReports();
                Thread.sleep(3000);
                requestpage.checkAdvanced(PropertiesFile.getPropValue("searchAdvanced"));
                //Close the Child Windown
                Thread.sleep(5000);
                driver.close();
            }
        }
        //Switch to Parent window (Main Windown)
          driver.switchTo().window(MainWindown);
          Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void requestCustomField() throws InterruptedException, AWTException {
        PropertiesFile.setPropertiesFile();
        requestpage.clickToCustomRequest();
        String MainWindown = driver.getWindowHandle();
        System.out.println(MainWindown);
        Set<String> windowns = driver.getWindowHandles();
        for (String windown : windowns) {
            if (!MainWindown.equals(windown)) {
                driver.switchTo().window(windown);
                Thread.sleep(2000);
                requestpage.setNewRequest();
                requestpage.searchCustomField(PropertiesFile.getPropValue("searchCustomField"));
                requestpage.setCustomField(PropertiesFile.getPropValue("nameCustomField"), PropertiesFile.getPropValue("customSoNguyen"), PropertiesFile.getPropValue("customTruongText"), PropertiesFile.getPropValue("longText"), PropertiesFile.getPropValue("customTime"), PropertiesFile.getPropValue("customSoThapPhan"), PropertiesFile.getPropValue("Material"), PropertiesFile.getPropValue("quantity"), PropertiesFile.getPropValue("price"), PropertiesFile.getPropValue("notion"), PropertiesFile.getPropValue("followers"));
            }
        }
    }
    @AfterClass
    public void tearDown() throws ATUTestRecorderException {
        RecordVideo.stopRecord();
        driver.quit();
    }
}