package tests.account_test.not_residual;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.home_page.HomePage;
import tests.account_test.AbstractAccountTest;

import static private_data.PrivateData.PASSWORD;
import static private_data.PrivateData.USERNAME;
import static tests.account_test.AccountTestValues.ACCOUNT;

public class AddAndDeleteAccountTest extends AbstractAccountTest {

    @Test(description = "Login and create an account on the Home page then delete this account")
    @Description(value = "Login and create an account on the Home page then delete this account")
    public void createAndDeleteAccountTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.openPage();
        HomePage homePage = loginPage
                .login(USERNAME, PASSWORD)
                .clickContextBarButton("Accounts")
                .clickNewAccountButton()
                .createAccount(ACCOUNT)
                .clickSaveButton()
                .clickCloseAccountCreatedButton()
                .clickContextBarButton("Accounts")
                .deleteAllAccounts();
        Assert.assertTrue(homePage.isAccountListEmpty());
    }
}
