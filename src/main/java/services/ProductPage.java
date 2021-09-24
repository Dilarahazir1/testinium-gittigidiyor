package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    private By basketBtnBy = By.id("add-to-basket");
    private By clickBasketBy = By.cssSelector(".dIB");
    private By productPriceBy =By.id("sp-price-lowPrice");
    private By highProductPriceBy = By.id("sp-price-highPrice");
    private By lowProductPriceBy  = By.id("sp-price-lowPrice");





    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void addToBasket(){
        driver.findElement(basketBtnBy).click();

    }
    public BasketPage clickToBasket(){
        driver.findElement(clickBasketBy).click();
        BasketPage basketPage =  new BasketPage(driver);
        return basketPage;
    }
    public  String  getProductPrice() {
        String productPrice = driver.findElement(productPriceBy).getText();
        if (productPrice.isEmpty()) {
            return driver.findElement(highProductPriceBy).getText();
        }
        return driver.findElement(lowProductPriceBy).getText();

    }


}
