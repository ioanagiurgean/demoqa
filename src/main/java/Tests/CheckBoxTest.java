package Tests;

import Pages.CheckBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CheckBoxTest extends TestBase{
    @Test
    public void checkHomeCheckBox(){
        CheckBoxPage checkBoxPage= new CheckBoxPage(driver);
        List<String> listOfHomeItems= Arrays.asList("home","desktop", "notes", "commands", "documents",
                "workspace","react","angular","veu","office","public","private","classified","general",
                "downloads","wordFile","excelFile");
        checkBoxPage.clickOnCheckBoxPage();
        checkBoxPage.clickOnTreeNodeHome();
        Assertions.assertEquals(listOfHomeItems, checkBoxPage.checkBoxItems());
    }
    @Test
    public void checkHomeDesktopBox(){
        CheckBoxPage checkBoxPage= new CheckBoxPage(driver);
        List<String> listOfHomeDesktopItems= Arrays.asList("desktop","notes","commands");
        checkBoxPage.clickOnCheckBoxPage();
        checkBoxPage.clickTreeHomeCheckBox();
        checkBoxPage.clickTreeHomeDesktopBox();
        Assertions.assertEquals(listOfHomeDesktopItems, checkBoxPage.checkBoxItems());
    }
    @Test
    public void checkHomeDocumentsBox() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        List<String> listOfHomeDocumentsItems = Arrays.asList("documents", "workspace", "react",
                "angular","veu","office","public","private","classified","general");
        checkBoxPage.clickOnCheckBoxPage();
        checkBoxPage.clickTreeHomeCheckBox();
        checkBoxPage.clickTreeHomeDocumentsBox();
        Assertions.assertEquals(listOfHomeDocumentsItems, checkBoxPage.checkBoxItems());
    }
    @Test
    public void checkHomeDownloadsBox() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        List<String> listOfHomeDownloadsItems = Arrays.asList("downloads","wordFile","excelFile");
        checkBoxPage.clickOnCheckBoxPage();
        checkBoxPage.clickTreeHomeCheckBox();
        checkBoxPage.clickTreeHomeDownloadsBox();
        Assertions.assertEquals(listOfHomeDownloadsItems, checkBoxPage.checkBoxItems());
    }

}
