package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Gleb on 30.12.2016.
 */
public class MainPage {

    private WebDriver driver;

    @FindBy(css = "i[title = 'Home']")
    private WebElement HomeButton;

    @FindBy(css = "input[name = 'email']")
    private WebElement Email;

    @FindBy(css = "input[name = 'password']")
    private WebElement Password;

    @FindBy(css = "button[name = 'login']")
    private WebElement LoginButton;

    @FindBy(xpath ="/*//*[@id='box-account-login']//a[text()='New customers click here']")
    private WebElement NewCustomerLink;

    @FindBy(css = "div.content li.product")
    private List<WebElement> Products;

    @FindBy(xpath = "//div[@id = 'cart']")
    private WebElement CheckOutLink;

    @FindBy(xpath = "//div[@id = 'cart']//span[@class = 'quantity']")
    private WebElement CheckoutProductsQuantity;

    public void HomeButtonClick(){
        HomeButton.click();
    }

    public WebElement getCheckoutProductsQuantity(){
        return CheckoutProductsQuantity;
    }

    public void CheckoutClick(){
        CheckOutLink.click();
    }

    public WebElement getProductByPositionNumber(Integer num){
        return Products.get(num);
    }

    public Integer getProductsListSize(){
        return Products.size();
    }

    public void fillEmailWithText(String text){
        Email.clear();
        Email.sendKeys(text);
    }

    public void fillPasswordWithText(String text){
        Password.clear();
        Password.sendKeys(text);
    }

    public void clickLoginButton(){
        LoginButton.click();
    }

    public void clickNewCustomerLink(){
        NewCustomerLink.click();
    }
}

