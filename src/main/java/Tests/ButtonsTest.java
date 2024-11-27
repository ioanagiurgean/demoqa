package Tests;

import Pages.ButtonsPage;
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
    @Test
    public void checkDoubleClick(){
        String expectedMessageForDoubleClick="You have done a double click";
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.navigateToButtonsPage();
        buttonsPage.clickDoubleClickMe();
        Assertions.assertEquals(expectedMessageForDoubleClick, buttonsPage.getMessageDoubleClickButton());
    }
    @Test
    public void checkRightClick(){
        String expectedMessageForRightClick="You have done a right click";
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.navigateToButtonsPage();
        buttonsPage.clickRightMe();
        Assertions.assertEquals(expectedMessageForRightClick, buttonsPage.getMessageRightClickMeButton());
    }
    @Test
    public void checkClickOnMe(){
        String expectedMessageForClickMe="You have done a dynamic click";
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.navigateToButtonsPage();
        buttonsPage.clickOnClickMeButton();
        Assertions.assertEquals(expectedMessageForClickMe, buttonsPage.getMessageFromClickMeButton());
    }
}
