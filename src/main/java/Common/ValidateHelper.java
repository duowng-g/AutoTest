package Common;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;

public class ValidateHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    public ValidateHelper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }
    public boolean verifyURL(String URL){
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl().contains(URL);
    }
    public boolean verifyElementText(By element, String elementText){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText().contains(elementText);
    }

    public void sendText(By element, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(value);
    }
    public void clickElement(By element) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
    public void waitForPageLoad() {
        ExpectedCondition<Boolean> jsload = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("document.readyPage").toString().equals("complete");
            }
        };
        try {
            wait.until(jsload);
        } catch (Throwable e) {
            System.out.println("Khong load duoc trang");
        }
    }

    //Handle checkbox
    public void clearText(By element){
        driver.findElement(element).clear();
    }
}

