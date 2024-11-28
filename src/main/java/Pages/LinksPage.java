package Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
public class LinksPage extends PageBase{
    public LinksPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//li[.//span[text()='Links']]")
    public WebElement linksMenu;
    @FindBy(id="simpleLink")
    public WebElement simpleLink;
    @FindBy(id="dynamicLink")
    public WebElement dynamicLink;
    @FindBy(id="created")
    public WebElement createdLink;

    public void navigateToLinksPage(){
        WebElement webTablesLink = wait.until(ExpectedConditions.elementToBeClickable(linksMenu));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webTablesLink);
        wait.until(ExpectedConditions.urlContains("links"));
    }
    public void navigateToNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", simpleLink);
        simpleLink.click();
    }
    public void navigateToDynamicNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dynamicLink);
        dynamicLink.click();
    }
    public void handleWindow(){
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows= driver.getWindowHandles();
        for(String windowHandle: allWindows){
            if(!windowHandle.equals(originalWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    public void createdLink(){
        wait.until(ExpectedConditions.elementToBeClickable(createdLink));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", createdLink);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("API Response: " + alert.getText());
        alert.accept();
    }
}
