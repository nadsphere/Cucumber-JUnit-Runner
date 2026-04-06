package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By search = By.xpath("//input[@type='search']");
    By prdName = By.className("product-name");
    By topDealsText = By.xpath("//a[@href='#/offers']");
    By increBtn = By.xpath("//a[@class='increment']");
    By addCartBtn = By.xpath("//button[contains(text(),'ADD TO CART')]");

    public void searchProduct(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(search)).sendKeys(name);
    }

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(prdName)).getText();
    }

    public void selectTopDeals(){
        wait.until(ExpectedConditions.elementToBeClickable(topDealsText)).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }

    public void addItem(int quantity){
        int i = quantity-1;
        while (i>0){
            wait.until(ExpectedConditions.elementToBeClickable(increBtn)).click();
            i--;
        }
    }

    public void clickAddToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(addCartBtn)).click();
    }
}
