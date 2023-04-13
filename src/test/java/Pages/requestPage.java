package Pages;

import Common.PropertiesFile;
import Common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class requestPage {
    private WebDriver driver;
    public WebDriverWait wait;
    private ValidateHelper validateHelper;
    public requestPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        validateHelper = new ValidateHelper(driver);
    }
    //khai bao cac doi tuong: Locators
    By newRequest = By.xpath("//*[@id=\"menu\"]/div[3]");
   // By searchRequest_btn = By.id("selection-filter-ip");
    By resultSearch = By.xpath("//*[@id=\"custom-selection\"]/div[3]/div/div[1]");
    By nameRequest_btn = By.xpath("/html/body/div[30]/div[2]/div/div/div/div/div[3]/div/div/form/div[1]/div[1]/div[2]/input");
    By detailRequest_btn = By.xpath("/html/body/div[30]/div[2]/div/div/div/div/div[3]/div/div/form/div[1]/div[3]/div[2]/textarea");
    By manager_btn = By.xpath("/html/body/div[30]/div[2]/div/div/div/div/div[3]/div/div/form/div[1]/div[5]/div[2]/input");
    By document_btn = By.xpath("/html/body/div[30]/div[2]/div/div/div/div/div[3]/div/div/form/div[1]/div[6]/div[2]/input");
    By sendRequest_btn = By.xpath("/html/body/div[30]/div[2]/div/div/div/div/div[3]/div/div/form/div[2]/div[1]");
    By saveDraft_btn = By.xpath("/html/body/div[30]/div[2]/div/div/div/div/div[3]/div/div/form/div[2]/div[2]");
    By sendForMe = By.xpath("/html/body/div[21]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div[1]/div[2]/div[1]");
    By isend = By.xpath("/html/body/div[21]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div[1]/div[2]/div[2]");
    By following = By.xpath("/html/body/div[21]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div[1]/div[2]/div[3]");
    By groups = By.xpath("/html/body/div[21]/div[1]/div/div[2]");
    By reports = By.xpath("/html/body/div[21]/div[1]/div/div[3]/div");
    By advanced = By.xpath("/html/body/div[21]/div[1]/div/div[4]/div");
    By searchAdvanced = By.id("js-search-query");
    By searchAdvancedEnter = By.xpath("/html/body/div[22]/div/div[1]/div/div[1]/div[3]");
    public void setNewRequest(){
        validateHelper.clickElement(newRequest);
    }
    public void searchRequest(){
        validateHelper.clickElement(resultSearch);
    }
    public void setRequest(String nameRequest, String detailRequest, String manager) throws AWTException, InterruptedException {
        validateHelper.sendText(nameRequest_btn, nameRequest);
        validateHelper.sendText(detailRequest_btn, detailRequest);
        validateHelper.sendText(manager_btn, manager);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(document_btn));
        js.executeScript("arguments[0].click();",driver.findElement(document_btn));
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.setAutoDelay(2000);
        StringSelection str = new StringSelection("F:\\hi\\hiii.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        robot.setAutoDelay(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.setAutoDelay(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void sendRequest() throws InterruptedException {
        validateHelper.clickElement(sendRequest_btn);
        Thread.sleep(2000);
    }
    public void saveDraft() throws InterruptedException {
        validateHelper.clickElement(saveDraft_btn);
        Thread.sleep(2000);
    }
    public void checkBox() throws InterruptedException {
        Thread.sleep(3000);
        validateHelper.clickElement(sendForMe);
        Thread.sleep(3000);
        validateHelper.clickElement(isend);
        Thread.sleep(3000);
        validateHelper.clickElement(following);
        Thread.sleep(2000);
    }
    public void checkGroups() throws InterruptedException {
        validateHelper.clickElement(groups);
        validateHelper.verifyURL("groups");
        Thread.sleep(2000);
    }
    public void checkReports() throws InterruptedException {
        validateHelper.clickElement(reports);
        validateHelper.verifyURL("reports");
        Thread.sleep(2000);
    }
    public void checkAdvanced(String search) throws AWTException, InterruptedException {
        validateHelper.clickElement(advanced);
        validateHelper.verifyURL("advanced");
        validateHelper.sendText(searchAdvanced, search);
        validateHelper.clickElement(searchAdvancedEnter);
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.mouseMove(814, 302);
        robot.setAutoDelay(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
    }
}
