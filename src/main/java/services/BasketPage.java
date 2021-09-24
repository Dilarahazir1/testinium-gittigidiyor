package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    private By basketPriceBy = By.className("total-price");
    private By numberOfProductsBy = By.cssSelector("option[value='2']"); //2 ürün arttırma
    private By totalProductBy = By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-of-type(1)");// toplam ürün adeti
    private By deleteProductBy = By.cssSelector("a[title='Sil']"); // ürün silme
    private By emptyBasketBy = By.cssSelector(".gg-w-22.gg-d-22.gg-t-21.gg-m-18>:nth-child(1)"); //  boş sepet kontrolü



    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String basketProductPrice(){
        return driver.findElement(basketPriceBy).getText();
    }
    public void setNumberOfProducts(){
        click(numberOfProductsBy,10);
    }
    public String getTotalProduct(){
        return driver.findElement(totalProductBy).getText();
    }
    public void deleteProduct(){
        click(deleteProductBy,10);
    }

    public String isEmpty(){
        return driver.findElement(emptyBasketBy).getText();
    }

}
