package tests.account_test.residual;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pages.home_page.HomePage;
import tests.abstract_tests.AbstractTest;

/**
 * These test classes leave side entities that need to be deleted in {@code @AfterMethod}
 */
public abstract class AbstractResidualTest extends AbstractTest {
    protected HomePage homePage;

    @AfterMethod(description = "Open site and clear account list")
    public void clearAccountList() {
        homePage
                .openPage()
                .clickContextBarButton("Accounts")
                .deleteAllAccounts();
        Assert.assertTrue(homePage.isAccountListEmpty());
    }
}
