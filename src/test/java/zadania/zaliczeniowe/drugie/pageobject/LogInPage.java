package zadania.zaliczeniowe.drugie.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    @FindBy(name = "email")
    private WebElement mailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "submit-login")
    private WebElement signInBtn;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillMail(String mail){
        mailField.sendKeys(mail);
    }

    public void fillPassword(String password){
        passwordField.sendKeys(password);
    }

    public void sendLogInForm() {
        signInBtn.click();
    }

}
