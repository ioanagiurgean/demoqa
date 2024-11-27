package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonsPage extends PageBase{
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//button[@id='doubleClickBtn']")
    public WebElement doubleClickBtn;
    @FindBy(xpath = "//p[@id='doubleClickMessage']")
    public WebElement doubleClickMessage;
    @FindBy(xpath="//button[@id='rightClickBtn']")
    public WebElement rightClickBtn;
    @FindBy(xpath = "//p[@id='rightClickMessage']")
    public WebElement rightClickMessage;
    @FindBy(xpath = "//button[text()='Click Me']")
    public WebElement clickMeButton;
    @FindBy(xpath = "//p[@id='dynamicClickMessage']")
    public WebElement dynamicClickMessage;

    public void navigateToButtonsPage(){
        WebElement webTablesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//li[.//span[text()='Buttons']]")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webTablesLink);
        wait.until(ExpectedConditions.urlContains("buttons"));
    }
    public void clickDoubleClickMe(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",doubleClickBtn);
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();

    }
    public String getMessageDoubleClickButton(){
        wait.until(ExpectedConditions.visibilityOf(doubleClickMessage));
        return doubleClickMessage.getText();
    }
    public void clickRightMe(){
        wait.until(ExpectedConditions.urlContains("buttons"));
        wait.until(ExpectedConditions.elementToBeClickable(rightClickBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",rightClickBtn);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", rightClickBtn);
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn).perform();

    }
    public String getMessageRightClickMeButton(){
        wait.until(ExpectedConditions.visibilityOf(rightClickMessage));
        return rightClickMessage.getText();
    }
    public void clickOnClickMeButton(){
        wait.until(ExpectedConditions.urlContains("buttons"));
        wait.until(ExpectedConditions.elementToBeClickable(clickMeButton));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", clickMeButton);

    }
    public String getMessageFromClickMeButton(){
        wait.until(ExpectedConditions.visibilityOf(dynamicClickMessage));
        return dynamicClickMessage.getText();
    }
}
