package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Gleb on 05.01.2017.
 */
public class CheckoutPage {
    private WebDriver driver;



    @FindBy(xpath = "//button[@name = 'remove_cart_item']")
    private WebElement RemoveButton;

    @FindBy(xpath = "//button[@name = 'remove_cart_item']")
    private List<WebElement> RemoveButtons;

    @FindBy(css = "div#box-checkout-summary table.dataTable")
    private WebElement OrderSummary;

    @FindBy(css = "div#box-checkout-summary table.dataTable td.item")
    private List<WebElement> ProductsInOrderSummary;

    @FindBy(xpath = "//li[@class = 'item']")
    private List<WebElement> ProductsInBasket;

    @FindBy(xpath = "//li[@class = 'item']")
    private WebElement ProductInBasket;

    public WebElement getProductInBasket(){
        return ProductInBasket;
    }

    public WebElement getOrderSummaryTable(){
        return OrderSummary;
    }

    public WebElement getProductInBasketByPosition(Integer position){
        return ProductsInBasket.get(position);
    }

    public WebElement getProductInOrderSummaryByPosition(Integer position){
        return ProductsInOrderSummary.get(position);
    }

    public List<WebElement> getProductsInBasket(){
        return ProductsInBasket;
    }

    public void RemoveButtonClick(){
        RemoveButton.click();
    }

}
