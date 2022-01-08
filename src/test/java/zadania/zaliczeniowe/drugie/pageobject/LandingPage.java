package zadania.zaliczeniowe.drugie.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @FindBy(className = "user-info")
    private WebElement signInBtn;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        signInBtn.click();
    }

}
