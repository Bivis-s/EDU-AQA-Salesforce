package elements.home_page.new_account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends AbstractElement{
    private final String INPUT_XPATH = "//*[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInput')]//input";
    private final By INPUT_BY;

    public Input(WebDriver driver, String label) {
        super(driver);
        this.INPUT_BY = By.xpath(String.format(INPUT_XPATH, label));
    }

    public void write(String text) {
        waitForElementVisible(INPUT_BY);
        driver.findElement(INPUT_BY).sendKeys(text);
    }
}
