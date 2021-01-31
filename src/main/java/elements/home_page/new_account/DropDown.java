package elements.home_page.new_account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown extends AbstractElement{
    private final String DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::div[contains(@class,'uiInputSelect ')]//a";
    private final String OPTION_XPATH = "//*[contains(@class, 'select-options')]/descendant::a[contains(text(),'%s')]";
    private final By DROPDOWN_BY;

    public DropDown(WebDriver driver, String label) {
        super(driver);
        DROPDOWN_BY = By.xpath(String.format(DROPDOWN_XPATH, label));
    }

    public DropDown select(String option) {
        waitForElementVisible(DROPDOWN_BY);
        driver.findElement(DROPDOWN_BY).click();
        By OPTION_BY = By.xpath(String.format(OPTION_XPATH, option));
        waitForElementVisible(OPTION_BY);
        driver.findElement(OPTION_BY).click();
        return this;
    }
}
