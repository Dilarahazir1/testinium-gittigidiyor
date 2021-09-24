import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    public WebElement element(By Locator){
        return driver.findElement(Locator);
    }

    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        System.setProperty("chromedriver.exe","./driver/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.gittigidiyor.com/");
    }
    @AfterMethod

    public void tearDown(){
      //  driver.quit();

    }


}
/*TODO:
   1.www.gittigidiyor.com sitesi açılır. +
   2.Ana sayfanın açılıdığı kontrol edilir ve siteye login olunur. +
   3.Login işlemi kontrol edilir. +
   4.Arama kutusuna "bilgisayar" kelimesi girilir+
   5.Arama sonuçlarında 2. sayfa açılır.+
   6.Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.+
   7.Seçilen ürün sepete atılır.+
   8.Ürün sayfasındaki fiyat ile sepet fiyatı karşılaştırılır+
   9.Adet arttırılarak ürün adetinin 2 olduğu doğrulanır
   10.Ürün sepetten silinerek sepetin boş olduğu doğrulanır.





 */


