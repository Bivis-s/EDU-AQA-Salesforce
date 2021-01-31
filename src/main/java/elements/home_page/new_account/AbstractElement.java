package elements.home_page.new_account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractElement {
    protected final WebDriver driver;

    public AbstractElement(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForElementVisible(By by) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .not(ExpectedConditions.invisibilityOfElementLocated(by)));
    }

    protected void waitForElementToBeClickable(By by) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .elementToBeClickable(by));
    }
}
