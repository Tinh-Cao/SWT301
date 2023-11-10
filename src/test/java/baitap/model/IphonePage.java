package baitap.model;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Data
public class IphonePage {

    WebDriver driver;

    By mobileLink = By.linkText("MOBILE");
    By AddCart = By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]");
    By couponCode = By.xpath("//input[@id='coupon_code']");
    By discount = By.xpath("//td[normalize-space()='Discount (GURU50)']");
    By discountCost = By.xpath("//span[normalize-space()='-$25.00']");
    By applyDiscount = By.xpath("//span[contains(text(),'Apply')]");
    By totalCost = By.cssSelector("strong span[class='price']");
    By subTotal = By.xpath("//td[@class='product-cart-total']//span[@class='price'][normalize-space()='$500.00']");
    public IphonePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobileLink() {
        driver.findElement(mobileLink).click();
    }

    public void clickAddCart() {
        driver.findElement(AddCart).click();
    }
    public void clickApplyDiscount() {
        driver.findElement(applyDiscount).click();
    }


    public void enterCouponCode(String cuponCode) {
        WebElement couponCodeElement = driver.findElement(this.couponCode);
        couponCodeElement.clear();
        driver.findElement(couponCode).sendKeys(cuponCode);
    }

    public boolean verifyDiscountGenerated() {
        String discountString = driver.findElement(discountCost).getText().replace(",", "").replace("-$", "");
        double discountAmount = Double.parseDouble(discountString);
        double expectedDiscount = 25.00;
        return Math.abs(discountAmount - expectedDiscount) < 0.01;
    }

    public boolean addShippingCost() {
        String subtotalString = driver.findElement(subTotal).getText().replace(",", "").replace("$", "");
        String totalString = driver.findElement(totalCost).getText().replace(",", "").replace("$", "");
        double subtotal = Double.parseDouble(subtotalString);
        double total = Double.parseDouble(totalString);
        return (total == subtotal);
    }
}