package Tests;

import Pages.WebTablesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebTablesTest extends TestBase{
    @Test
    public void checkWebTables(){
        String expectedUrl ="https://demoqa.com/webtables";
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.navigateToWebTablesPage();
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void checkDeleteRow(){
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.navigateToWebTablesPage();
        assertTrue(webTablesPage.checkDeleteRows(), "Row was not deleted");
    }
    @Test
    public void checkTableHeaders(){
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.navigateToWebTablesPage();
        List<String> expectedHeaders= new ArrayList<>(Arrays.asList("First Name","Last Name","Age","Email","Salary","Department", "Action"));
        Assertions.assertEquals(expectedHeaders, webTablesPage.getHeaderTable());
    }
    @Test
    public void searchAnItemInTable() {
        List<String> expectedList= new ArrayList<>(Arrays.asList("Cierra", "Vega", "39",
                "cierra@example.com", "10000", "Insurance"));
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.navigateToWebTablesPage();
        webTablesPage.searchInput("Cierra");
        assertEquals(expectedList,webTablesPage.getRowData());
    }
    @Test
    public void checkEditCell(){
        List<String> expectedList= new ArrayList<>(Arrays.asList("ioana", "giu", "39",
                "cierra@example.com", "10000", "Insurance"));
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.navigateToWebTablesPage();
        webTablesPage.clickEditButton();
        webTablesPage.changeFirstRowInformation("ioana","giu");
        assertEquals(expectedList,webTablesPage.getFirstRowData());
    }
    @Test
    public void checkRowsPerPageSelection(){
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.navigateToWebTablesPage();
        List<String> expectedList =new ArrayList<>(Arrays.asList("5 rows", "10 rows","20 rows","25 rows","50 rows","100 rows"));
        assertEquals(expectedList, webTablesPage.selectRows());
        }
    }
