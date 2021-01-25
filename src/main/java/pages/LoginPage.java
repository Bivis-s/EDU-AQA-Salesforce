package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.home_page.HomePage;

public class LoginPage extends AbstractPage {
    protected static final String LOGIN_URL = URL + "login.salesforce.com/";
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step(value = "Open login page")
    public LoginPage openPage() {
        driver.get(LOGIN_URL);
        return this;
    }

    public LoginPage enterUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(driver);
    }

    @Step(value = "Logging in")
    public HomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new HomePage(driver);
    }
}
