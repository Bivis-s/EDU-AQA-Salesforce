package pages.home_page;

import elements.home_page.new_account.DropDown;
import elements.home_page.new_account.Input;
import elements.home_page.new_account.Textarea;
import entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

public class NewAccountModal extends AbstractPage {
    private final By CLOSE_BUTTON = By.xpath("//button[contains(@class, 'closeIcon')]");
    private final By SAVE_BUTTON = By.xpath("//button[@title='Save']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }

    public NewAccountModal waitForPageLoaded() {
        getWebDriverWait().until(ExpectedConditions.not(ExpectedConditions.invisibilityOfElementLocated(CLOSE_BUTTON)));
        return this;
    }

    private void writeToInput(String label, String text) {
        new Input(driver, label).write(text);
    }

    private void selectDropdown(String label, String option) {
        new DropDown(driver, label).select(option);
    }

    private void writeToTextarea(String label, String text) {
        new Textarea(driver, label).write(text);
    }

    public NewAccountModal createAccount(Account account) {
        writeToInput("Account Name", account.getAccountName());
        selectDropdown("Type", account.getType());
        writeToInput("Website", account.getWebsite());
        writeToInput("Phone", account.getPhone());
        selectDropdown("Industry", account.getIndustry());
        writeToInput("Employees", String.valueOf(account.getEmployees()));
        writeToTextarea("Description", account.getDescription());
        writeToTextarea("Billing Street", account.getBillingStreet());
        writeToInput("Billing City", account.getBillingCity());
        writeToInput("Billing Zip", account.getBillingZip());
        writeToInput("Billing State", account.getBillingState());
        writeToInput("Billing Country", account.getBillingCountry());
        writeToTextarea("Shipping Street", account.getShippingStreet());
        writeToInput("Shipping City", account.getShippingCity());
        writeToInput("Shipping Zip", account.getShippingZip());
        writeToInput("Shipping State", account.getShippingState());
        writeToInput("Shipping Country", account.getShippingCountry());
        return this;
    }

    public HomePage clickCloseButton() {
        driver.findElement(CLOSE_BUTTON).click();
        return new HomePage(driver);
    }

    public HomePage clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        return new HomePage(driver);
    }
}
