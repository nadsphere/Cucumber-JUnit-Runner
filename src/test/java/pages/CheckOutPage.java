package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By cartIcon = By.xpath("//img[@alt='Cart']");
    By checkoutBtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoBtn = By.cssSelector(".promoBtn");
    By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
    By prodName = By.xpath("//p[@class='product-name']");

    public void checkOutItem(){
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }

    public Boolean verifyPromoBtn(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(promoBtn)).isDisplayed();
    }

    public Boolean verifyPlaceOrder(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderBtn)).isDisplayed();
    }

    public String getProductTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(prodName)).getText();
    }
}
