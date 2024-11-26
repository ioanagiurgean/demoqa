package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonsPage extends PageBase{
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToButtonsPage(){
        WebElement webTablesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//li[.//span[text()='Buttons']]")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webTablesLink);
        wait.until(ExpectedConditions.urlContains("buttons"));
    }
}
