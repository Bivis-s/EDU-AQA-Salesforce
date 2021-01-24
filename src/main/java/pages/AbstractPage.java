package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected static final String URL = "https://";
    private final WebDriverWait webDriverWait;

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    public abstract AbstractPage openPage();

    protected void waitForElementVisible(By by) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions
                .not(ExpectedConditions.invisibilityOfElementLocated(by)));
    }

    protected void waitForElementToBeClickable(By by) {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions
                .elementToBeClickable(by));
    }
}
