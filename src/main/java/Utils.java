import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    private static WebDriver webDriver;
    private static WebDriverWait wait;
    private static final String chromeDriverPath = "C:\\WebDriver\\chromedriver.exe";

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            webDriver = new ChromeDriver();
            wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        }
        return webDriver;
    }

    private static void waitForElement(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void typeText(WebElement webElement, String text) {
        waitForElement(webElement);
        webElement.sendKeys(text);
    }
    public static void equalsCurrentPage() {
        getWebDriver().getCurrentUrl().equals(getDomain());
    }

    public static void close() {
        webDriver.close();
        webDriver = null;
    }

    public static String getDomain() {
        return "https://opensource-demo.orangehrmlive.com/";
    }
}