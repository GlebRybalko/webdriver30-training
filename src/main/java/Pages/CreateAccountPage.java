package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Gleb on 29.12.2016.
 */
public class CreateAccountPage {

    private WebDriver driver;

    @FindBy(css = "input[name='tax_id']")
    private WebElement TaxID;

    @FindBy(css = "input[name='company']")
    private WebElement Company;

    @FindBy(css = "input[name='firstname']")
    private WebElement FirstName;

    @FindBy(css = "input[name='lastname']")
    private WebElement LastName;

    @FindBy(css = "input[name='address1']")
    private WebElement AddressLine1;

    @FindBy(css = "input[name='address2']")
    private WebElement AddressLine2;

    @FindBy(css = "input[name='postcode']")
    private WebElement Postcode;

    @FindBy(css = "input[name='city']")
    private WebElement City;

    @FindBy(css = "select[name='country_code']")
    private WebElement Country;

    @FindBy(css = "input[name='zone_code']")
    private WebElement State;

    @FindBy(css = "input[name='email']")
    private WebElement Email;

    @FindBy(css = "input[name='phone']")
    private WebElement Phone;

    @FindBy(css = "input[name='newsletter']")
    private WebElement Subscribe;

    @FindBy(css = "input[name='password']")
    private WebElement Password;

    @FindBy(css = "input[name='confirmed_password']")
    private WebElement ConfirmPassword;

    @FindBy(css = "button[name='create_account']")
    private WebElement CreateAccountButton;

    @FindBy(css = "input[name='accept_cookies']")
    private WebElement AcceptCookiesButton;

    public void fillTaxIDWithText(String text){
        TaxID.clear();
        TaxID.sendKeys(text);
    }

    public void fillCompanyWithText(String text){
        Company.clear();
        Company.sendKeys(text);
    }

    public void fillFirstNameWithText(String text){
        FirstName.clear();
        FirstName.sendKeys(text);
    }

    public void fillLastNameWithText(String text){
        LastName.clear();
        LastName.sendKeys(text);
    }

    public void fillAddressLine1WithText(String text){
        AddressLine1.clear();
        AddressLine1.sendKeys(text);
    }

    public void fillAddressLine2WithText(String text){
        AddressLine2.clear();
        AddressLine2.sendKeys(text);
    }

    public void fillPostcodeWithText(String text){
        Postcode.clear();
        Postcode.sendKeys(text);
    }

    public void fillCityWithText(String text){
        City.clear();
        City.sendKeys(text);
    }

    public void selectCountryByValue(String code){
        Select country = new Select(Country);
        country.selectByValue(code);
    }
    public void fillEmailWithText(String text){
        Email.clear();
        Email.sendKeys(text);
    }

    public void fillPhoneWithText(String text){
        Phone.clear();
        Phone.sendKeys(text);
    }

    public void selectSubscribe(){
        Subscribe.clear();
        Subscribe.click();
    }

    public void fillPasswordWithText(String text){
        Password.clear();
        Password.sendKeys(text);
    }

    public void fillConfirmPasswordWithText(String text){
        ConfirmPassword.clear();
        ConfirmPassword.sendKeys(text);
    }

    public void clickCreateAccountButton(){
        CreateAccountButton.click();
    }

    public void clickAcceptCookiesButtonButton(){
        AcceptCookiesButton.click();
    }
}
