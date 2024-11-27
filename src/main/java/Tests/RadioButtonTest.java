package Tests;

import Pages.RadioButtonPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RadioButtonTest extends TestBase{
    @Test
    public void checkRadioButtonTitle(){
        String expectedURL ="https://demoqa.com/radio-button";
        RadioButtonPage radioButtonPage= new RadioButtonPage(driver);
        radioButtonPage.navigateToRadioButtonPage();
        Assertions.assertEquals(expectedURL,driver.getCurrentUrl(), "URL mismatch - The Radio Button page should be loaded.");
    }
    @Test
    public void checkRadioButtonWelcomeText(){
        RadioButtonPage radioButtonPage= new RadioButtonPage(driver);
        radioButtonPage.navigateToRadioButtonPage();
        Assertions.assertEquals(radioButtonPage.checkTextOfRadioButton(), "Do you like the site?");
    }
    @Test
    public void checkYesRadioButton() {
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.navigateToRadioButtonPage();
        radioButtonPage.clickOnYesRadio();
        Assertions.assertEquals("Yes",radioButtonPage.clickOnYesRadio());
    }
    @Test
    public void checkImpressiveRadioButton() {
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.navigateToRadioButtonPage();
        radioButtonPage.clickOnImpressiveRadio();
        Assertions.assertEquals("Impressive",radioButtonPage.clickOnImpressiveRadio());
    }
    @Test
    public void checkNoButtonIsDisabled(){
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.navigateToRadioButtonPage();
        assertTrue(!radioButtonPage.checkNoButton(), "'No' radio button should be disabled.");
    }
}
