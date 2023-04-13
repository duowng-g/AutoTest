package Pages;

import Common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.internal.invokers.ExpectedExceptionsHolder;

public class mainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public ValidateHelper validateHelper;
    public mainPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        validateHelper = new ValidateHelper(driver);
    }
    //khai bao cac doi tuong : Locators
    By baseRequest = By.xpath("/html/body/div[20]/div[3]/div[2]/div[1]/div/div/div[2]/div[2]/a[2]");
    By User = By.xpath("//*[@id=\"base-panel\"]/div[1]/div[1]/div");
     public requestPage baseRequest() throws InterruptedException {
         validateHelper.clickElement(User);
         JavascriptExecutor js = (JavascriptExecutor) driver;
         WebElement element = driver.findElement(baseRequest);
         js.executeScript("arguments[0].scrollIntoView();",element);
         Thread.sleep(3000);
         js.executeScript("arguments[0].click();",element);
         return new requestPage(driver);
     }
}
