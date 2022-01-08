package zadania.zaliczeniowe.drugie.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {

    @FindBy(id = "category-3")
    private WebElement clotchesBtn;

    @FindBy(id = "category-6")
    private WebElement accessoriesBtn;

    @FindBy(id = "category-9")
    private WebElement artBtn;

    public YourAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickClothesBtn() {
        clotchesBtn.click();
    }

    public void clickAccessoriesBtn() {
        accessoriesBtn.click();
    }

    public void clickArtBtn() {
        artBtn.click();
    }

}
