package zadania.zaliczeniowe.drugie.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    @FindBy(className = "checkout")
    private WebElement checkOutBtn;

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkOutToOrder() {
        checkOutBtn.click();
    }

}
