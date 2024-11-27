package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class CheckBoxPage extends PageBase{
    @FindBy(xpath = "//li[.//span[text()='Check Box']]")
    public WebElement checkBoxLink;

    @FindBy(xpath="//button[@class='rct-collapse rct-collapse-btn']")
    public WebElement treeNodeHome;
    @FindBy(xpath = "//span[@class='rct-checkbox']")
    public List<WebElement> rctCheckbox;
    @FindBy(xpath = "//button[@aria-label='Toggle']")
    public WebElement homeButton;
    @FindBy(xpath = "//label[input[@id='tree-node-desktop']]")
    public WebElement treeNodeDesktop;
    @FindBy(xpath = "//label[input[@id='tree-node-documents']]")
    public WebElement treeNodeDocuments;
    @FindBy(xpath = "//label[input[@id='tree-node-downloads']]")
    public WebElement treeNodeDownloads;


    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnCheckBoxPage(){
        checkBoxLink.click();
        wait.until(ExpectedConditions.urlContains("checkbox"));
    }
    public void clickOnTreeNodeHome(){
        //treeNodeHome.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", treeNodeHome);
        executor.executeScript("arguments[0].click();", rctCheckbox.get(0));
    }
    public List<String>  checkBoxItems() {
        WebElement resultDiv = driver.findElement(By.id("result"));
        List<WebElement> selectedItems= resultDiv.findElements(By.cssSelector(".text-success"));
        List<String> selectItemTexts= new ArrayList<>();
        for(WebElement item: selectedItems){
            selectItemTexts.add(item.getText());
        }
        return selectItemTexts;
    }
    public void clickElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public void clickTreeHomeCheckBox() {
        clickElement(homeButton);
    }

    public void clickTreeHomeDesktopBox() {
        clickElement(treeNodeDesktop);
    }

    public void clickTreeHomeDocumentsBox() {
        clickElement(treeNodeDocuments);
    }
    public void clickTreeHomeDownloadsBox() {
        clickElement(treeNodeDownloads);
    }


}
