package pages.home_page;

import elements.home_page.new_account.ContextBarButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractPage;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractPage {
    protected static final String HOME_URL = URL + "epamsystemsinc-e.lightning.force.com/lightning/page/home";
    private final By NEW_ACCOUNT_BUTTON_BY = By.xpath("//*[contains(@class,'slds-grid')]//a[contains(@title,'New')]");
    private final By CLOSE_ACCOUNT_CREATED_NOTIFICATION_BUTTON_BY =
            By.xpath("//button[contains(@class,'toastClose') and @title='Close']");
    private final By ACCOUNTS_MANAGE_DROPDOWN_BY =
            By.xpath("//*[contains(@class,'slds-grid')]//*[contains(@class,'rowActionsPlaceHolder')]");
    private final By ACCOUNT_MANAGE_DROPDOWN_SELECT_DELETE_BY =
            By.xpath("//*[@title='Delete' and @class='forceActionLink']/..");
    private final By ACCOUNT_MANAGE_CONFIRM_DELETION_BY =
            By.xpath("//*[contains(text(),'Delete')]//ancestor::*[contains(@class,'uiButton')]");
    private final String ACCOUNT_TABLE_ROW_XPATH = "//table[contains(@class,'slds-table')]//tbody//tr";
    private final By ACCOUNT_TABLE_ROW_BY = By.xpath(ACCOUNT_TABLE_ROW_XPATH);
    private final String ACCOUNT_TABLE_ROW_NAME_XPATH = ACCOUNT_TABLE_ROW_XPATH + "//th";
    private final By ACCOUNT_TABLE_ROW_NAME_BY = By.xpath(ACCOUNT_TABLE_ROW_NAME_XPATH);
    private final By EMPTY_ACCOUNT_LIST_MESSAGE =
            By.xpath("//*[contains(@class,'listViewContent')]//*[contains(@class,'emptyContent')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOME_URL);
        return this;
    }

    public HomePage clickContextBarButton(String title) {
        new ContextBarButton(driver, title).click();
        return this;
    }

    public NewAccountModal clickNewAccountButton() {
        waitForElementToBeClickable(NEW_ACCOUNT_BUTTON_BY);
        driver.findElement(NEW_ACCOUNT_BUTTON_BY).click();
        return new NewAccountModal(driver).waitForPageLoaded();
    }

    public HomePage clickCloseAccountCreatedButton() {
        waitForElementToBeClickable(CLOSE_ACCOUNT_CREATED_NOTIFICATION_BUTTON_BY);
        driver.findElement(CLOSE_ACCOUNT_CREATED_NOTIFICATION_BUTTON_BY).click();
        return this;
    }

    public HomePage clickAccountManageDropdown() {
        waitForElementToBeClickable(ACCOUNTS_MANAGE_DROPDOWN_BY);
        driver.findElement(ACCOUNTS_MANAGE_DROPDOWN_BY).click();
        return this;
    }

    public HomePage clickAccountManageDropdownDelete() {
        waitForElementToBeClickable(ACCOUNT_MANAGE_DROPDOWN_SELECT_DELETE_BY);
        driver.findElement(ACCOUNT_MANAGE_DROPDOWN_SELECT_DELETE_BY).click();
        return this;
    }

    public HomePage clickConfirmAccountDeletion() {
        waitForElementToBeClickable(ACCOUNT_MANAGE_CONFIRM_DELETION_BY);
        driver.findElement(ACCOUNT_MANAGE_CONFIRM_DELETION_BY).click();
        return this;
    }

    public int getAccountsCount() {
        waitForElementVisible(ACCOUNT_TABLE_ROW_BY);
        return driver.findElements(ACCOUNT_TABLE_ROW_BY).size();
    }

    public boolean isAccountListEmpty() {
        waitForElementVisible(EMPTY_ACCOUNT_LIST_MESSAGE);
        return driver.findElement(EMPTY_ACCOUNT_LIST_MESSAGE).isDisplayed();
    }

    public List<String> getAccountNames() {
        List<String> accountNames = new ArrayList<>();
        waitForElementVisible(ACCOUNT_TABLE_ROW_NAME_BY);
        for (WebElement row : driver.findElements(ACCOUNT_TABLE_ROW_NAME_BY)) {
            accountNames.add(row.getText());
        }
        return accountNames;
    }

    public HomePage deleteAllAccounts() {
        if (getAccountsCount() >= 1) {
            int dropdownCount = driver.findElements(ACCOUNTS_MANAGE_DROPDOWN_BY).size();
            for (int i = 0; i < dropdownCount; i++) {
                waitForElementToBeClickable(ACCOUNTS_MANAGE_DROPDOWN_BY);
                driver.findElement(ACCOUNTS_MANAGE_DROPDOWN_BY).click();
                clickAccountManageDropdownDelete();
                clickConfirmAccountDeletion();
                clickCloseAccountCreatedButton();
            }
        }
        return this;
    }
}
