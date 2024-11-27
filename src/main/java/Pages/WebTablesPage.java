package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WebTablesPage extends PageBase{
    public WebTablesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="delete-record-1")
    public WebElement deleteRecord1;
    @FindBy(xpath = "//input[@id='searchBox']")
    public WebElement searchBoxInput;
    @FindBy(xpath = "//div[@class='input-group-append']")
    public WebElement searchButton;
    @FindBy(xpath = "//span[@id='edit-record-1']")
    public WebElement editRecord;
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement fistName;
    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastName;
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@class='rt-tr-group'][1]")
    List<WebElement> firstRowCells;
    @FindBy(xpath = "//select[@aria-label='rows per page']")
    public WebElement rowPerPage;

    public void navigateToWebTablesPage(){
        WebElement webTablesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//li[.//span[text()='Web Tables']]")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webTablesLink);
        wait.until(ExpectedConditions.urlContains("webtables"));
    }
    public boolean checkDeleteRows(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", deleteRecord1);
        List<WebElement> remainingRows = driver.findElements(By.cssSelector(".rt-tr"));
        boolean rowDeleted = true;
        if(!remainingRows.isEmpty() && !remainingRows.get(0).findElements(By.cssSelector("rt-td")).isEmpty()){
            rowDeleted= false;
        }
        return rowDeleted;
    }
    public List<String> getHeaderTable(){
        List<WebElement>headers= driver.findElements(By.cssSelector(".rt-th"));
        List<String> newList= new ArrayList<>();
        for(int i=0;i<headers.size();i++){
            newList.add(headers.get(i).getText());
        }
        return newList;
    }
    public void searchInput(String inputValue){
        searchBoxInput.sendKeys(inputValue);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", searchButton);
    }
    public List<String> getRowData(){
        List<WebElement> rowCells = driver.findElements(By.cssSelector(".rt-tr.-odd .rt-td"));
        List<String> rowData= new ArrayList<>();
        for(WebElement cell: rowCells){
            rowData.add(cell.getText());
        }
        return rowData;
    }
    public void clickEditButton(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", editRecord);
    }
    public void changeFirstRowInformation(String _firstName,String _lastName){
        fistName.clear();
        fistName.sendKeys(_firstName);
        lastName.clear();
        lastName.sendKeys(_lastName);
        submitButton.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.cssSelector(".rt-tr:nth-child(1) .rt-td:nth-child(1)"), "ioana"));
    }
    public List<String> getFirstRowData(){
        List<String> rowData= new ArrayList<>();
        for(WebElement cell: firstRowCells){
            rowData.add(cell.getText());
        }
        return rowData;
    }
    public List<String> selectRows(){
        Select rowPerPageSelect= new Select(rowPerPage);
        List<WebElement> list = rowPerPageSelect.getOptions();
        List<String> newList = new ArrayList<>();
        for(WebElement option: list){
            newList.add(option.getText());
        }
        return newList;
    }
}
