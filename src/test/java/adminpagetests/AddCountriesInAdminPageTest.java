package adminpagetests;

import Pages.AddNewCountryAdminCountriesPage;
import Pages.AdminCountriesPage;
import Pages.AdminLoginPage;
import Pages.AdminPage;
import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Gleb on 10.01.2017.
 */
public class AddCountriesInAdminPageTest extends BaseTest {

    @Test
    public void switchBetweenWindowsOnAddNewCountryPageTest(){

        driver.get("http://localhost/litecart/admin/");
        AdminLoginPage loginpage = PageFactory.initElements(driver, AdminLoginPage.class);
        AdminPage adminpage = PageFactory.initElements(driver, AdminPage.class);
        AdminCountriesPage admincountriespage = PageFactory.initElements(driver, AdminCountriesPage.class);
        AddNewCountryAdminCountriesPage addNewCountryPage = PageFactory.initElements(driver, AddNewCountryAdminCountriesPage.class);
        loginpage.loginAs("admin","admin");
        adminpage.clickSpecificMenuItemFromLeftSidebarByName("Countries");
        admincountriespage.clickAddNewCountryButton();

        Integer externalLinksCount = addNewCountryPage.getExternalLinksCount();
        for (Integer i = 0; i < externalLinksCount; i++){
            WebElement externalLink = addNewCountryPage.getExternalLinkByPosition(i);
            switchToNewWindowByClickOnWebelement(externalLink);
            switchToMainWindowAndCloseCurrentWindow();
        }
    }
}
