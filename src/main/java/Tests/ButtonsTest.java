package Tests;

import Pages.ButtonsPage;
import Pages.WebTablesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ButtonsTest extends TestBase{
    @Test
    public void checkButtonsTitle(){
        String expectedUrl ="https://demoqa.com/buttons";
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.navigateToButtonsPage();
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
