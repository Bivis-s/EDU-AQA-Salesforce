package elements.home_page.new_account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Textarea extends AbstractElement {
    private final String TEXTAREA_XPATH =
            "//*[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInput')]//textarea";
    private final By TEXTAREA_BY;

    public Textarea(WebDriver driver, String label) {
        super(driver);
        TEXTAREA_BY = By.xpath(String.format(TEXTAREA_XPATH, label));
    }

    public void write(String text) {
        waitForElementVisible(TEXTAREA_BY);
        driver.findElement(TEXTAREA_BY).sendKeys(text);
    }
}
