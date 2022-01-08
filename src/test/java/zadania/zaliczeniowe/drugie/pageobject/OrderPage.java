package zadania.zaliczeniowe.drugie.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    @FindBy(name = "confirm-addresses")
    private WebElement addressConfirmationBtn;

    @FindBy(id = "delivery_option_1")
    private WebElement pickUpInStoreBtn;

    @FindBy(id = "delivery_option_2")
    private WebElement deliveryNextDayBtn;

    @FindBy (name = "confirmDeliveryOption")
    private WebElement deliveryConfirmationBtn;

    @FindBy (id = "payment-option-1")
    private WebElement payByCheckBtn;

    @FindBy (id = "payment-option-2")
    private WebElement payByBankWireBtn;

    @FindBy (name = "conditions_to_approve[terms-and-conditions]")
    private  WebElement conditionsField;

    @FindBy (id = "payment-confirmation")
    private WebElement  orderBtn;

    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAddressConfirmationBtn() {
        addressConfirmationBtn.click();
    }

    public void clickPickUpInStoreBtn(){
        if(pickUpInStoreBtn.isSelected() == false) {
            pickUpInStoreBtn.click();
        }
    }

    public void clickDeliveryNextDayBtn(){
        if(deliveryNextDayBtn.isSelected() == false) {
            deliveryNextDayBtn.click();
        }
    }

    public void clickDeliveryConfirmationBtn(){
        deliveryConfirmationBtn.click();
    }

    public void clickPayByCheckBtn(){
        payByCheckBtn.click();
    }

    public void clickPayByBankWireBtn(){
        payByBankWireBtn.click();
    }

    public void clickConditionsField(){
        conditionsField.click();
    }

    public void clickOrderBtn(){
        orderBtn.click();
    }


}
