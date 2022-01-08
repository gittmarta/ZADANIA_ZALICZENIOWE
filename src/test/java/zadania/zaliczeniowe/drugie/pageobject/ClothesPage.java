package zadania.zaliczeniowe.drugie.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClothesPage {

    @FindBy(xpath = "/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[1]/div/div[1]/h2/a")
    private WebElement tshirtBtn;

    @FindBy(xpath = "/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[2]/div/div[1]/h2/a")
    private WebElement sweaterBtn;

    public ClothesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickTshirtBtn() {
        tshirtBtn.click();
    }

    public void clickSweaterBtn() {
        sweaterBtn.click();
    }



}
