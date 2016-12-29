package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Gleb on 30.12.2016.
 */
public class MainPage {

    private WebDriver driver;

    @FindBy(css = "input[name = 'email']")
    private WebElement Email;

    @FindBy(css = "input[name = 'password']")
    private WebElement Password;

    @FindBy(css = "button[name = 'login']")
    private WebElement LoginButton;

    @FindBy(xpath ="/*//*[@id='box-account-login']//a[text()='New customers click here']")
    private WebElement NewCustomerLink;

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

