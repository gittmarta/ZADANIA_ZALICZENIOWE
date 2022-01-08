package zadania.zaliczeniowe.drugie.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    @FindBy(className = "discount-percentage")
    private WebElement discountField;

    @FindBy(id = "group_1")
    private WebElement sizeField;

    @FindBy(className = "touchspin-up")
    private WebElement quantityUpBtn;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityField;

    @FindBy(xpath = "/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button/i")
    private WebElement addToCartBtn;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement checkoutBtn;

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String returnDiscount(){
        return discountField.getText();
    }

    public void choseSize(String size) {
        String value = "0";

        if (size.equals("s")){
            value = "1";
        }
        else if (size.equals("m")){
            value = "2";
        }
        else if (size.equals("l")){
            value = "3";
        }
        else if(size.equals("xl")){
            value = "4";
        }

        new Select(sizeField).selectByValue(value);
    }

    public void chooseQuantity(String quantity) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(quantityField));
        quantityField.click();
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(quantityField));
        quantityField.clear();
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(quantityField));
        quantityField.sendKeys(quantity);
    }

    public  void  quantityUp (int quantity){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        int q = quantity;
        quantityField.click();
        for (int i=1; i<q; i++){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(quantityUpBtn));
            quantityUpBtn.click();
        }
    }

    public void clickAddToCartBtn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();
    }

    public void clickCheckoutToCartBtn() {
        checkoutBtn.click();
    }

}
