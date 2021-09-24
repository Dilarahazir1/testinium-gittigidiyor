package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    Actions actions;


    private By logInBy = By.name("profile");
    private By logBy   = By.cssSelector(".sc-12t95ss-3.fDarBX");
    private By searchBy = By.cssSelector(".sc-4995aq-0");
    private By findBy = By.cssSelector(".qjixn8-0");
    private String searchText = "bilgisayar";


    public HomePage(WebDriver driver){
        super(driver);
        actions = new Actions(driver);
    }

    public void waitForLoadHover() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logInBy));

    }
    public LogInPage clickItemPage() {

       waitForLoadHover();
       hoverOver(driver.findElement(logInBy));
       click(logBy,5);
       LogInPage logInPage = new LogInPage(driver);
       return logInPage;
    }

    public ResultPage searchItem(){
        driver.findElement(searchBy).sendKeys(searchText);
        driver.findElement(findBy).click();
        return new ResultPage(driver);
    }
}
