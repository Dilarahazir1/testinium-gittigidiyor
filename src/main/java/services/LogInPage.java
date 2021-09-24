package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import userdata.User;

public class LogInPage extends BasePage {



    private By mailField = By.id("L-UserNameField");
    private By passwordField = By.id("L-PasswordField");
    //private By checkBox = By.id("recaptcha-anchor");
    private By enterBtn = By.id("gg-login-enter");
    WebDriverWait wait;

    public LogInPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(super.driver, 15);

    }


    public HomePage logIn(String mail, String password){

        sendKeys(mailField, mail);
        sendKeys(passwordField, password);
     //   click(checkBox, 5);
        click(enterBtn, 5);

        return new HomePage(driver);
    }



}
