package baitap.test;

import baitap.model.IphonePage;
import driver.driverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestCase9 {
    @Test
    public void testAddMobileToCart() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");
        IphonePage iphonePage = new IphonePage(driver);
        iphonePage.clickMobileLink();
        iphonePage.clickAddCart();
        iphonePage.enterCouponCode("GURU50");
        iphonePage.clickApplyDiscount();
        boolean check1 = iphonePage.addShippingCost();
        boolean check = iphonePage.verifyDiscountGenerated();
        Assert.assertTrue(check);
        boolean check2 = iphonePage.addShippingCost();
        Assert.assertNotEquals(check1,check2);
    }
}
