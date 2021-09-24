package services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class ResultPage extends BasePage {
    private  By pageBy = By.linkText("2");
    private By productBy = By.cssSelector(".image-container");

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public void scrollPage (){

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,6550)");
        driver.findElement(pageBy).click();


    }
    public ProductPage goToProductDetail(){
        driver.findElement(randomSelectProductBy()).click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }
    public By randomSelectProductBy() {
        Random random = new Random();
        int rand = random.nextInt(48) + 1;
        return By.cssSelector(".products-container>li:nth-of-type(" + rand + ")");
    }


}
