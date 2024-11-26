package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\ioana\\automation\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.nopcommerce.com/en");

        // Get the title of the page
        System.out.println("Title of the page: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
