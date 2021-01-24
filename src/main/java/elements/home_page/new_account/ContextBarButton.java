package elements.home_page.new_account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextBarButton extends AbstractElement {
    private final String BUTTON_XPATH = "//*[@title='%s' and contains(@class, 'context-bar')]";
    private final By BUTTON_BY;

    public ContextBarButton(WebDriver driver, String buttonTitle) {
        super(driver);
        BUTTON_BY = By.xpath(String.format(BUTTON_XPATH, buttonTitle));
    }

    public void click() {
        waitForElementToBeClickable(BUTTON_BY);
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(BUTTON_BY)).build().perform();
    }
}
