package tests.account_test.not_residual;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.home_page.HomePage;
import tests.account_test.AbstractAccountTest;

import static private_data.PrivateData.PASSWORD;
import static private_data.PrivateData.USERNAME;
import static tests.account_test.AccountTestValues.ACCOUNT;

public class AddAndDeleteAccountTest extends AbstractAccountTest {

    @Test
    public void createAndDeleteAccountTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.openPage();
        HomePage homePage = loginPage
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .clickContextBarButton("Accounts")
                .clickNewAccountButton()
                .createAccount(ACCOUNT)
                .clickSaveButton()
                .clickCloseAccountCreatedButton()
                .clickContextBarButton("Accounts")
//                .clickContextBarButton("Accounts")
                .deleteAllAccounts();
        Assert.assertTrue(homePage.isAccountListEmpty());
    }
}