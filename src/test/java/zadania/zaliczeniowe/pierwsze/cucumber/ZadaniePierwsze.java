package zadania.zaliczeniowe.pierwsze.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import zadania.zaliczeniowe.pierwsze.pageobject.FillFormWithAddress;

import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class ZadaniePierwsze {

    private WebDriver driver;

    @Given("^Web landing page (.*) opened in browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    @When("^Click \"Sign in\"$")
    public void signIn() {
        WebElement signInBtn = driver.findElement(By.id("_desktop_user_info"));
        signInBtn.click();
    }

    @And("^Fill e-mail field with \"(.*)\"$")
    public void eMail(String mail) {
        WebElement eMailField = driver.findElement(By.name("email"));
        eMailField.clear();
        eMailField.sendKeys(mail);
    }

    @And("^Fill password field with \"(.*)\"$")
    public void password(String password) {
        WebElement eMailField = driver.findElement(By.name("password"));
        eMailField.clear();
        eMailField.sendKeys(password);
    }

    @And("^Click \"SIGN IN\" button$")
    public void logIn() {
        WebElement logInBtn = driver.findElement(By.id("submit-login"));
        logInBtn.click();
    }


    @And("^Click \"ADD FIRST ADDRESS\" button or click \"ADDRESSES\" and then \"Create new address\" button$")
    public void addAddress() {
        WebElement accountContentArea = driver.findElement(By.id("content"));

        if (accountContentArea.getText().toLowerCase(Locale.ROOT).contains("add first address")) {
            WebElement addNewAddressBtn = driver.findElement(By.id("address-link"));
            addNewAddressBtn.click();
        }
        else if (accountContentArea.getText().toLowerCase(Locale.ROOT).contains("addresses")) {
            WebElement addAddressBtn = driver.findElement(By.id("addresses-link"));
            addAddressBtn.click();
            WebElement createNewAddressBtn = driver.findElement(By.xpath("//span[.='Create new address']"));
            createNewAddressBtn.click();
        }
        else {
            fail();
        }
    }

    @And("^Fill the form with (.*), (.*), (.*), (.*), country and (.*)$")
    public void fillAddressForm(String alias, String address, String city, String zip, String phone) {
        FillFormWithAddress fillAddressForm = new FillFormWithAddress(driver);
        fillAddressForm.fillForm(alias, address, city, zip, phone);

    }

    @And("^Click \"SAVE\" button$")
    public void saveAddress() {
        WebElement saveAddressBtn = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/footer/button"));
        saveAddressBtn.click();
    }

    @And ("^Confirm created address by (.*), check (.*), (.*), (.*), country and (.*)$")
    public void confirmAddress(String alias, String address, String city, String zip, String phone){
        String country = "United Kingdom";
        WebElement addressName = driver.findElement(By.xpath("//h4[.='"+alias+"']/.."));
        assertTrue(addressName.getText().contains(address) && addressName.getText().contains(city) && addressName.getText().contains(zip) && addressName.getText().contains(phone) && addressName.getText().contains(country));
    }

    @And("^Click \"DELETE\" button by (.*)$")
    public void deleteAddress(String alias) {
        WebElement deleteAddressBtn = driver.findElement(By.xpath("//h4[.='"+alias+"']/../../div[2]/a[2]/span"));
        deleteAddressBtn.click();
    }

    @Then("^Address will be deleted and webpage display message: \"(.*)\"$")
    public void checkResult(String expPhrase) {
        WebElement content = driver.findElement(By.id("addresses"));
        assertTrue(content.getText().contains(expPhrase));
        this.driver.quit();
    }


}
