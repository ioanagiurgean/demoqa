package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RadioButtonPage extends PageBase{
    @FindBy(xpath = "//li[.//span[text()='Radio Button']]")
    public WebElement textBoxLink;
    @FindBy(xpath = "//div[@class='mb-3']")
    public WebElement radioButtonText;
    @FindBy(xpath="//input[@id='yesRadio']")
    public WebElement yesRadioButton;
    @FindBy(xpath="//input[@id='impressiveRadio']")
    public WebElement impressiveRadioButton;
    @FindBy(xpath = "//input[@id='noRadio']")
    public WebElement noRadioButton;
    @FindBy(xpath = "//p[contains(text(), 'You have selected')]//span[@class='text-success']")
    public WebElement textSuccess;

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToRadioButtonPage(){
     textBoxLink.click();
     wait.until(ExpectedConditions.urlContains("radio-button"));
    }
    public String checkTextOfRadioButton(){
        return radioButtonText.getText();
    }
    public String clickOnRadioButton(WebElement radioButton) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", radioButton);
        return textSuccess.getText();
    }

    public String clickOnYesRadio() {
        return clickOnRadioButton(yesRadioButton);
    }

    public String clickOnImpressiveRadio() {
        return clickOnRadioButton(impressiveRadioButton);
    }
    public boolean checkNoButton(){
      return noRadioButton.isEnabled();
    }

}
