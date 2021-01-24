package tests.account_test.residual;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pages.LoginPage;
import pages.home_page.HomePage;
import tests.account_test.AbstractAccountTest;

import static private_data.PrivateData.PASSWORD;
import static private_data.PrivateData.USERNAME;

/**
 * These test classes leave side entities that need to be deleted in {@code @AfterMethod}
 */
public abstract class AbstractResidualTest extends AbstractAccountTest {

    @AfterMethod
    public void clearAccountList() {
        endTest();
        initTest();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.openPage();
        HomePage homePage = loginPage
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .clickContextBarButton("Accounts")
                .deleteAllAccounts();
        Assert.assertTrue(homePage.isAccountListEmpty());
    }
}
