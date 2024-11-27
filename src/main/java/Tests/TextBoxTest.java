package Tests;

import Pages.TextBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TextBoxTest extends TestBase{
    @Test
    public void goToFirstPage(){
        TextBoxPage textBoxPage= new TextBoxPage(driver);
        String expectedUrl= "https://demoqa.com/text-box";
        textBoxPage.goToTextBox();
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void goToElementsPage(){
        TextBoxPage textBoxPage= new TextBoxPage(driver);
        driver.get("https://demoqa.com/elements");
        String expectedString ="Please select an item from left to start practice.";
        Assertions.assertEquals(expectedString, textBoxPage.getTextFromElementsLink());
    }
    @Test
    public void goTextBoxPage() {
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        driver.get("https://demoqa.com/elements");
        textBoxPage.goToTextBox();
        Assertions.assertEquals("Text Box", textBoxPage.getTextBox());
        }
    @Test
    public void setTextBoxForm() {
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        driver.get("https://demoqa.com/elements");
        textBoxPage.goToTextBox();
        textBoxPage.inputTextBoxForm("ioana giu","ioana.giurgean13@gmail.com","todorn","basarab");
        textBoxPage.clickOnSubmitButton();
        Assertions.assertEquals("ioana.giurgean13@gmail.com", textBoxPage.getEmailAfterSubmit());
        }

    }
