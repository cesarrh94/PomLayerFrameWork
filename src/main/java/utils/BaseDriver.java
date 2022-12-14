package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseDriver {

    private WebDriver driver;

    // constructor
    public BaseDriver(WebDriver driver) {
        this.driver = driver;
    }
    // chromedriver for Windows OS.
    private String driverWindowsPath = "C:\\Optionals\\Webdriver\\chromedriver.exe";

    public WebDriver setUpDriver() {
        System.setProperty("webdriver.chrome.driver", driverWindowsPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void quitDriver() {
        driver.quit();
    }
}
