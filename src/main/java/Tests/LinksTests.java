package Tests;

import Pages.LinksPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinksTests extends TestBase{
    @Test
    public void checkLinksTitle(){
        String expectedUrl ="https://demoqa.com/links";
        LinksPage linksPage = new LinksPage(driver);
        linksPage.navigateToLinksPage();
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void openLinkInNewTab(){
        LinksPage linksPage = new LinksPage(driver);
        linksPage.navigateToLinksPage();
        linksPage.navigateToNewTab();
        linksPage.handleWindow();
        Assertions.assertEquals("https://demoqa.com/",driver.getCurrentUrl());
    }
    @Test
    public void openDynamicLinkInNewTab(){
        LinksPage linksPage = new LinksPage(driver);
        linksPage.navigateToLinksPage();
        linksPage.navigateToDynamicNewTab();
        linksPage.handleWindow();
        Assertions.assertEquals("https://demoqa.com/",driver.getCurrentUrl());
    }
    @Test
    public void checkCreateLinkAPI() {
        LinksPage linksPage = new LinksPage(driver);
        linksPage.navigateToLinksPage();
        linksPage.createdLink();
    }
}
