package tests.account_test.residual;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static private_data.PrivateData.PASSWORD;
import static private_data.PrivateData.USERNAME;
import static tests.account_test.AccountTestValues.ACCOUNT;

public class AccountTest extends AbstractResidualTest {

    @Test(description = "Login and create an account on the home page")
    @Description(value = "Login and create an account on the home page")
    public void createAccountTest() {
        homePage = new LoginPage(getDriver())
                .openPage()
                .login(USERNAME, PASSWORD)
                .clickContextBarButton("Accounts")
                .clickNewAccountButton()
                .createAccount(ACCOUNT)
                .clickSaveButton()
                .clickCloseAccountCreatedButton()
                .clickContextBarButton("Accounts");
        Assert.assertEquals(homePage.getAccountsCount(), 1, "There is more than 1 account");
        Assert.assertEquals(homePage.getAccountNames().get(0), ACCOUNT.getAccountName(),
                "Account names aren't equal");
    }
}
