package tests.account_test;

import entities.Account;

public class AccountTestValues {
    public static final Account ACCOUNT = (new Account())
            .setAccountName("Gorin Gena")
            .setBillingCity("La Huerta")
            .setBillingCountry("US")
            .setBillingState("South Dakota")
            .setBillingStreet("Lazy Spring Park")
            .setBillingZip("7170")
            .setDescription("Earlier in the day, the president was suspended from Facebook and Instagram. That suspension will be reviewed after the transition of power to Joe Biden on 20 January.")
            .setEmployees(28)
            .setIndustry("Utilities")
            .setPhone("(579) 720-2367")
            .setShippingCity("La Huerta")
            .setShippingCountry("US")
            .setShippingState("South Dakota")
            .setShippingStreet("Lazy Spring Park")
            .setShippingZip("7170")
            .setType("Reseller")
            .setWebsite("https://twitter.com");
}
