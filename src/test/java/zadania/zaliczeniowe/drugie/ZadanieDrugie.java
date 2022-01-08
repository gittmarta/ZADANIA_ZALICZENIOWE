package zadania.zaliczeniowe.drugie;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import zadania.zaliczeniowe.drugie.pageobject.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZadanieDrugie {

    private WebDriver driver;

    private String url = "https://mystore-testlab.coderslab.pl";
    private String mail = "zadaniezaliczeniowedrugie@gmail.com";
    private String password = "zadaniezaliczeniowedrugie";


    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get(url);
    }

    @AfterEach
    public void closeBrowser(){
        this.driver.quit();
    }


    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);

        Path targetPath = Paths.get("C:\\Users\\Administrator\\Desktop\\", "order-evidence" + ".png");
        Files.deleteIfExists(targetPath);
        Files.copy(tmpScreenshot.toPath(), targetPath);
    }

    @Test
    public void shouldSignInExistingUser(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignIn();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillMail(mail);
        logInPage.fillPassword(password);
        logInPage.sendLogInForm();

        WebElement confirmLogIn = driver.findElement(By.className("account"));
        assertTrue(confirmLogIn.getText().contains("Zadanie Zaliczeniowe"));

        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.clickClothesBtn();

        ClothesPage clothesPage = new ClothesPage(driver);
        clothesPage.clickSweaterBtn();

        ProductPage productPage = new ProductPage(driver);
        assertTrue(productPage.returnDiscount().contains("20%"));

        productPage.choseSize("m");

        productPage.chooseQuantity("5");

//        productPage.quantityUp(5);

        productPage.clickAddToCartBtn();

        productPage.clickCheckoutToCartBtn();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.checkOutToOrder();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickAddressConfirmationBtn();

        orderPage.clickPickUpInStoreBtn();

        orderPage.clickDeliveryConfirmationBtn();

        orderPage.clickPayByCheckBtn();

        orderPage.clickConditionsField();

        orderPage.clickOrderBtn();

        try {
            takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
