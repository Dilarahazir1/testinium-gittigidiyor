
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.junit.Assert;

import org.testng.annotations.Test;
import services.*;
import userdata.User;


import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class CaseTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LogInPage.class);


    @Test

    public void allTest() throws InterruptedException {


        // Ana sayfa giriş kontrol
        HomePage homePage = new HomePage(driver);

        try {
            Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi", driver.getTitle());
        } catch (Exception e) {
            logger.error("Web sitesine giriş yapılamadı");
        }

        logger.info(" Başarılı şekilde giriş yapıldı");



        //Kullanıcının giriş bilgileri ve Ana sayfaya giriş
        User user = new User();
        user.setEmail("testiniumi@gmail.com");
        user.setPassword("testinium123");
        LogInPage logInPage =  homePage.clickItemPage();
        logger.info("Login açıldı");
        logInPage.logIn(user.getEmail(), user.getPassword());
        logger.info("Giriş başarılı");


        //Bilgisayar kelimesinin bulunması

        ResultPage resultPage = homePage.searchItem();
        resultPage.scrollPage(); // sayfa sonuna gelinerek 2. sayfaya geçildi
        assertTrue(driver.getCurrentUrl().contains("2"));


        //Sepete ürün ekleme
        ProductPage productPage = resultPage.goToProductDetail();
        String productPrice = productPage.getProductPrice();
        productPage.addToBasket();
        logger.info("Ürün sepete eklendi.");

        //Sepete gidiyoruz ve ürünün ilk fiyatı ile sepetteki fiyatını karşılaştırma
        BasketPage basketPage = productPage.clickToBasket();
        logger.info("Sepet sayfasına başarıyla giriş yapıldı");

        Assert.assertEquals(productPrice, basketPage.basketProductPrice());
        logger.info("İki fiyat karşılaştırması yapılmıştır.");

        //Ürün miktarı arttırma ve 2 ürün eklendi.
        basketPage.setNumberOfProducts();
        Thread.sleep(2000);
        logger.info("Ürün miktarı arttırıldı");
        assertTrue(basketPage.getTotalProduct().contains("2 Adet"));//sipariş özeti kontrol ediliyor.


        //Ürün silme ve kontrol etme
        basketPage.deleteProduct();
        Thread.sleep(2000);
        String basketMessage = "Sepetinizde ürün bulunmamaktadır.";
        assertEquals(basketMessage, basketPage.isEmpty());
        logger.info("Sepetiniz boş");

    }
}

























