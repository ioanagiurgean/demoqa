package Tests;

import com.google.j2objc.annotations.Weak;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public WebDriver driver;

    @BeforeEach
    public void baseSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ioana\\automation\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();
    }
}
