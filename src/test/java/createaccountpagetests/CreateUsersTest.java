package createaccountpagetests;

import Pages.CreateAccountPage;
import Pages.MainPage;
import Pages.UserAccountPage;
import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Gleb on 29.12.2016.
 */

public class CreateUsersTest extends BaseTest{

    @Test
    public void createValidUserTest(){
        driver.get("http://localhost/litecart/en/");

        CreateAccountPage cap = PageFactory.initElements(driver, CreateAccountPage.class);
        UserAccountPage uap = PageFactory.initElements(driver, UserAccountPage.class);
        MainPage map = PageFactory.initElements(driver,MainPage.class);

        map.clickNewCustomerLink();

        cap.fillTaxIDWithText("111");
        cap.fillCompanyWithText("GL");
        cap.fillFirstNameWithText("Glib");
        cap.fillLastNameWithText("Rybalko");
        cap.fillAddressLine1WithText("Addr1");
        cap.fillAddressLine2WithText("Addr2");
        cap.fillPostcodeWithText("61000");
        cap.fillCityWithText("Kharkiv");
        cap.selectCountryByValue("UA");
        cap.fillEmailWithText("1@111test.com");
        cap.fillPhoneWithText("+380111111111");
        cap.fillPasswordWithText("QWErty123");
        cap.fillConfirmPasswordWithText("QWErty123");
        cap.clickCreateAccountButton();

        uap.doLogout();

        map.fillEmailWithText("1@111test.com");
        map.fillPasswordWithText("QWErty123");
        map.clickLoginButton();

        uap.doLogout();

    }

}
