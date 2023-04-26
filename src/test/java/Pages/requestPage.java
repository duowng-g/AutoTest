package Pages;

import Common.PropertiesFile;
import Common.ValidateHelper;
import org.apache.poi.ss.formula.functions.T;
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
    By sendForMe = By.xpath("//div[@class='filter checked']");
    By isend = By.xpath("//div[@data-filter='sending']");
    By following = By.xpath("//div[@data-filter='following']");
    By groups = By.xpath("//span[@class='-ap icon-folder_open']");
    By reports = By.xpath("//span[@class='-ap icon-equalizer']");
    By advanced = By.xpath("//span[@class='-ap icon-uniF146']");
    By searchAdvanced = By.id("js-search-query");
    By searchAdvancedEnter = By.xpath("//div[@class='cta']");
    By searchEditRequest = By.id("js-filter-button");
    By nameSearchRequest_btn = By.xpath("//input[@placeholder='Tên đề xuất']");
    By updateSearchRequest_btn = By.xpath("//div[@class='update js-submit url']");
    By openUtilities = By.xpath("//div[@class='more']//span[@class='-ap icon-chevron-thin-down']");
    By choiceEdit = By.xpath("//body/div[@id='apdialogs']/div[@id='__apdialog_custom-selection']/div[@class='__dialogwrapperscroller scroll-y forced-scroll']/div[@class='__dialogwrapper']/div[@class='__dialogwrapper-inner']/div[@class='__dialogmain']/div[@class='__dialogcontent simple-form']/div[@id='custom-selection']/div[@class='list list-actions -border']/div[6]");
    By editnameRequest_btn = By.xpath("//div[@class='__dialogcontent']//form[@id='request-edit-fx']//div[@class='row -istext  ']//div[@class='input data']//input[1]");
    By editDetailRequest_btn = By.xpath("//div[@class='input data']//textarea");
    By removeOldFile = By.xpath("//span[@class='remove-old-file right']");
    By editDocument_btn = By.xpath("//div[@class='input data']//input[@name='file-1']");
    By editRequest = By.xpath("//div[@class='button ok -success -rounded bold']");
    By home = By.xpath("//div[@class='icon']//span[@class='-ap icon-home']");
    By zoomOutMess = By.xpath("//div[@class='icon js-channel-minus']");
    // locators for Request co custom file
    By searchCustomField_btn = By.xpath("//input[@id='selection-filter-ip']");
    By searchCustomResult = By.xpath("//div[@class='-name'][normalize-space()='Request có custom field']");
    By nameCustomField = By.xpath("//div[@id='apdialogs']//div[@id='__apdialog_request-create-fx-dx']//form[@id='request-create-fx']//div[1]//input[@name='name']");
    By customSoNguyen = By.xpath("//div[@id='apdialogs']//div[@id='__apdialog_request-create-fx-dx']//form[@id='request-create-fx']//div[1]//input[@name='custom_so_nguyen']");
    By customTruongText = By.xpath("//div[@id='apdialogs']//div[@id='__apdialog_request-create-fx-dx']//form[@id='request-create-fx']//div[1]//input[@name='custom_truong_text']");
    By longText = By.xpath("//div[@id='apdialogs']//div[@id='__apdialog_request-create-fx-dx']//form[@id='request-create-fx']//div[1]//textarea[@name='custom_long_text']");
    By customDate = By.xpath("//div[@id='apdialogs']//div[@id='__apdialog_request-create-fx-dx']//form[@id='request-create-fx']//div[1]//input[@name='custom_ngay']");
    By date22_04_2023 = By.xpath("//a[normalize-space()='22']");
    By customDate_Time = By.xpath("//div[@id='apdialogs']//div[@id='__apdialog_request-create-fx-dx']//form[@id='request-create-fx']//div[1]//input[@name='custom_ngay_gio-date']");
    By customFile = By.xpath("//div[@id='apdialogs']//div[@id='__apdialog_request-create-fx-dx']//form[@id='request-create-fx']//div[1]//input[@name='custom_file']");
    By customSoThapPhan = By.xpath("//div[@id='apdialogs']//div[@id='__apdialog_request-create-fx-dx']//form[@id='request-create-fx']//div[1]//input[@name='custom_so_thap_phan']");
    By choice1Option = By.xpath("(//div[@class='is-display url'])[2]");
    By useChoice1Option = By.xpath("(//div[@class='is-box'])[2]//child::input");
    By resultChoice1Option = By.xpath("//div[normalize-space()='Toán']");
    By choiceMultiOption = By.xpath("(//div[@class='is-display url'])[3]");
    By useChoiceMultiOption = By.xpath("(//div[@class='is-box'])[3]//child::input");
    By choiceRice = By.xpath("//div[contains(@data-value,'Cơm')]");
    By choiceNoodles = By.xpath("//div[normalize-space()='Bún']");
    By completeChoiceMultiOption = By.xpath("//div[@class='is-close']");
    By addRow = By.xpath("(//div[contains(@class,'-icon')])[5]//span[@class='-ficon ficon-plus-circle']");
    By typeOfMaterial = By.xpath("(//input[@type='text'])[23]");
    By Quantity = By.xpath("(//input[@type='text'])[24]");
    By Price = By.xpath("(//input[@type='text'])[25]");
    By Notion = By.xpath("(//input[@type='text'])[26]");
    By deleteRow = By.xpath("(//div[@class='-index'])[1]");
    By Followers = By.xpath("//input[@name='followers']");
    By attachmentFile = By.xpath("//input[@name='file-1']");
    By creatCustomFile = By.xpath("//div[@class='button ok -success -rounded bold url']");
    //By newCustomReuqest = By.xpath("(//a[@title='Request and Approve'])[1]");

    public void setNewRequest() throws InterruptedException {
        validateHelper.clickElement(zoomOutMess);
        validateHelper.clickElement(newRequest);
    }
    public void searchRequest() throws InterruptedException {
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
        StringSelection str = new StringSelection("F:\\hi\\hiii.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
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
    public void setEditRequest(String name, String detail) throws InterruptedException, AWTException {
        Thread.sleep(3000);
        validateHelper.clickElement(openUtilities);
        validateHelper.clickElement(choiceEdit);
        validateHelper.clearText(editnameRequest_btn);
        validateHelper.sendText(editnameRequest_btn, name);
        validateHelper.clearText(editDetailRequest_btn);
        validateHelper.sendText(editDetailRequest_btn,detail);
        validateHelper.clickElement(removeOldFile);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(editDocument_btn));
        js.executeScript("arguments[0].click();",driver.findElement(editDocument_btn));
        Thread.sleep(2000);
        Robot robot = new Robot();
        StringSelection str = new StringSelection("\"F:\\hi\\editHi.doc\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        validateHelper.clickElement(editRequest);
    }
    public void checkBox(String newName, String newDetail) throws InterruptedException, AWTException {
        validateHelper.clickElement(sendForMe);
        Thread.sleep(3000);
        setEditRequest(newName, newDetail);
    }
    public void checkGroups() throws InterruptedException {
        Thread.sleep(3000);
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
    }
    public void searchCustomField(String searchCustomField) throws InterruptedException {
        validateHelper.sendText(searchCustomField_btn,searchCustomField);
        validateHelper.clickElement(searchCustomResult);
    }
    public void setCustomField(String name,String value,String text,String longtext,String time,String sothapphan, String Material, String quantity, String price, String notion, String followers) throws InterruptedException, AWTException {
        validateHelper.sendText(nameCustomField,name);
        validateHelper.sendText(customSoNguyen, value);
        validateHelper.sendText(customTruongText,text);
        validateHelper.sendText(longText, longtext);
        validateHelper.clickElement(customDate);
        validateHelper.clickElement(date22_04_2023);
        validateHelper.clickElement(customDate_Time);
        validateHelper.clickElement(date22_04_2023);
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(customFile));
        js.executeScript("arguments[0].click();",driver.findElement(customFile));
        Thread.sleep(2000);
        Robot robot = new Robot();
        StringSelection str1 = new StringSelection("\"F:\\hi\\editHi.doc\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str1, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        validateHelper.sendText(customSoThapPhan,sothapphan);
        validateHelper.clickElement(choice1Option);
        validateHelper.sendText(useChoice1Option,"Toán");
        validateHelper.clickElement(resultChoice1Option);
        validateHelper.clickElement(choiceMultiOption);
        validateHelper.clickElement(useChoiceMultiOption);
        validateHelper.clickElement(choiceRice);
        validateHelper.clickElement(choiceNoodles);
        validateHelper.clickElement(completeChoiceMultiOption);
        validateHelper.clickElement(addRow);
        validateHelper.sendText(typeOfMaterial,Material);
        validateHelper.sendText(Quantity, quantity);
        validateHelper.sendText(Price, price);
        validateHelper.sendText(Notion,notion);
        validateHelper.sendText(Followers,followers);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(attachmentFile));
        js.executeScript("arguments[0].click();",driver.findElement(attachmentFile));
        Thread.sleep(2000);
        StringSelection str2 = new StringSelection("\"F:\\hi\\editHi.doc\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str2, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        validateHelper.clickElement(creatCustomFile);
    }
    public void clickToCustomRequest(){
        driver.findElement(By.xpath("(//div[@class='g-body'])[2]//child::a[2]")).click();
    }
    //response Reuqest
    By receiving_btn = By.xpath("//div[@data-filter='receiving']//div[@class='cb']");
    By sending_btn = By.xpath("//div[@data-filter='sending']//div[@class='cb']");
    By followings_btn = By.xpath("//div[@data-filter='following']//div[@class='cb']");
    By zoomOut = By.xpath("//div[@class='icon js-channel-minus']");
    By filters_btn = By.xpath("//div[@id='js-filter-button']");
    By requestName_btn = By.xpath("(//div[@class='input'])[2]//input");
    By groups_btn = By.xpath("//div[@class='is-display url']");
    By quickFilters_btn = By.xpath("//input[@placeholder='Lọc nhanh']");
    By resultGroups = By.xpath("//div[@class='is-item'][normalize-space()='Request có custom field']");
    By currentStatus = By.xpath("//select[@name='s']");
    By madeBy = By.xpath("(//div[@class='input'])[4]//input[@name='users']");
    By finishFrom_btn = By.xpath("(//div[@class='input'])[5]//input[@name='finish_from']");
    By resultFinishFrom = By.xpath("(//a[normalize-space()='27'])[1]");
    By updateFilters = By.xpath("(//div[@class='update js-submit url'])[1]");
    By resultSearch_response = By.xpath("(//span[@class='text-link rq-unchecked'])[1]");
    By success_btn = By.xpath("(//div[@class='button -success -rounded'])[1]");
    By detailSuccess = By.xpath("(//div[@class='input data'])[1]//textarea[@name='msg']");
    By acceptRequest = By.xpath("(//div[@class='button ok -success -rounded bold url'])[1]");
    By cta_btn = By.xpath("(//div[@class='button -cta -rounded'])[1]");
    By searchForwarder = By.xpath("//div[contains(@class,'box-search')]//input[@name='qsearch']");
    By resultForwarder = By.xpath("(//div[@class='body'])[2]//div[@class='select-users list-users  ']");
    By successForwarded = By.xpath("//div[@class='button ok -success -rounded bold']");
    By error_btn = By.xpath("(//div[@class='button -error -rounded'])[1]");
    By detailRefuse = By.xpath("(//div[@class='input data'])[1]//textarea[@name='msg']");
    By refuseForwarded = By.xpath("//div[@class='button ok -error -rounded bold url']");



    public void searchRequest(String requestName, String requestGroups) throws InterruptedException {
        validateHelper.clickElement(zoomOut);
        validateHelper.clickElement(receiving_btn);
        Thread.sleep(2000);
        validateHelper.clickElement(sending_btn);
        Thread.sleep(2000);
        validateHelper.clickElement(followings_btn);
        Thread.sleep(2000);
        validateHelper.clickElement(filters_btn);
        validateHelper.sendText(requestName_btn,requestName);
        validateHelper.clickElement(groups_btn);
        validateHelper.sendText(quickFilters_btn,requestGroups);
        validateHelper.clickElement(resultGroups);
        Select select = new Select(driver.findElement(currentStatus));
        select.selectByVisibleText("Đến lượt duyệt");
        Thread.sleep(2000);
        validateHelper.clickElement(resultSearch_response);
    }
    public void answerRequest(String result,String detailsuccess,String Forwarder1,String Forwarder2,String detailrefuse) throws InterruptedException {
        switch (result.trim().toLowerCase()) {
            case "accept":
                validateHelper.clickElement(success_btn);
                validateHelper.sendText(detailSuccess, detailsuccess);
                validateHelper.clickElement(acceptRequest);
                break;
            case "forwarded":
                validateHelper.clickElement(cta_btn);
                validateHelper.sendText(searchForwarder,Forwarder1);
                validateHelper.clickElement(resultForwarder);
                validateHelper.clearText(searchForwarder);
                validateHelper.sendText(searchForwarder,Forwarder2);
                validateHelper.clickElement(resultForwarder);
                validateHelper.clickElement(successForwarded);
                break;
            case "refuse":
                validateHelper.clickElement(error_btn);
                validateHelper.sendText(detailRefuse,detailrefuse);
                validateHelper.clickElement(refuseForwarded);
        }
    }


}
