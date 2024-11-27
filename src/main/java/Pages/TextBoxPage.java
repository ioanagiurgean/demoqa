package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxPage extends PageBase {
    @FindBy(xpath = "//div[@class='avatar mx-auto white']")
    public WebElement elementsLink;

    @FindBy(xpath = "//*[text()='Please select an item from left to start practice.']")
    public WebElement elementsText;

    @FindBy(xpath = "//li[.//span[text()='Text Box']]")
    public WebElement textBoxLink;

    @FindBy(xpath = "//span[text()='Text Box']")
    public WebElement getTextBox;

    @FindBy(id="userName")
    public WebElement userName;

    @FindBy(id="userEmail")
    public WebElement userEmail;
    @FindBy(id="currentAddress")
    public WebElement currentAddress;
    @FindBy(id="permanentAddress")
    public WebElement permanentAddress;
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitButton1;
    @FindBy(xpath = "//p[@id='email']")
    public WebElement emailTextAfterSubmit;

    public TextBoxPage(WebDriver driver){
        super(driver);

    }
    public String getTextFromElementsLink(){
        return elementsText.getText();
    }
    public void goToTextBox(){
        textBoxLink.click();
        wait.until(ExpectedConditions.urlContains("text-box"));
    }
    public String getTextBox(){
        return getTextBox.getText();
    }
    public void inputTextBoxForm(String _fullName, String _userEmail, String _currentAddress, String _permanentAddress){
        userName.sendKeys(_fullName);
        userEmail.sendKeys(_userEmail);
        currentAddress.sendKeys(_currentAddress);
        permanentAddress.sendKeys(_permanentAddress);

    }
    public void clickOnSubmitButton(){
        WebElement submitButton = driver.findElement(By.id("submit"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", submitButton);
       }
    public String getEmailAfterSubmit(){
        String fullText = emailTextAfterSubmit.getText();
        return fullText.split(":")[1].trim();
    }
}
