package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OfferPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public OfferPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By searchField = By.xpath("//input[@id='search-field']");
    By prdItem = By.xpath("//tr/td[1]");

    public void searchItem(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(name);
    }

    public void getSearchText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).getText();
    }

    public String getProductItem(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(prdItem)).getText();
    }
}
