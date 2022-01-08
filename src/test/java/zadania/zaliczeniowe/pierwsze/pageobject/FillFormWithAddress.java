package zadania.zaliczeniowe.pierwsze.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FillFormWithAddress {

    @FindBy(name = "alias")
    private WebElement aliasField;

    @FindBy(name = "address1")
    private WebElement addressField;

    @FindBy(name = "city")
    private WebElement cityField;

    @FindBy(name = "postcode")
    private WebElement zipField;

    @FindBy(name = "id_country")
    private WebElement countryField;

    @FindBy(name = "phone")
    private WebElement phoneField;


    public FillFormWithAddress(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String alias, String address, String city, String zip, String phone) {
        aliasField.sendKeys(alias);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        zipField.sendKeys(zip);
        phoneField.sendKeys(phone);
        new Select(countryField).selectByValue("17");
    }

}
