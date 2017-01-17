package adminpagetests;

import Pages.AdminAddProductPage;
import Pages.AdminCatalogPage;
import Pages.AdminLoginPage;
import Pages.AdminPage;
import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Gleb on 17.01.2017.
 */
public class ConsoleLogsAdminPageTest extends BaseTest {

    @Test
    public void checkConsoleLogsWhileSwitchingProductsInCatalog(){

        driver.get("http://localhost/litecart/admin/");

        AdminLoginPage adminLoginPage = PageFactory.initElements(driver,AdminLoginPage.class);
        AdminPage adminPage = PageFactory.initElements(driver,AdminPage.class);
        AdminAddProductPage editExistingProductPage = PageFactory.initElements(driver,AdminAddProductPage.class);
        AdminCatalogPage catalogPage = PageFactory.initElements(driver, AdminCatalogPage.class);

        adminLoginPage.loginAs("admin","admin");
        adminPage.clickSpecificMenuItemFromLeftSidebarByName("Catalog");

        //opening all subfolders in Products catalog to get complete products list
        int countOfOpenedFolders = 0;
        while(catalogPage.getExistingProductsFoldersSize() > 0){
            catalogPage.getExistingProductsList().get(countOfOpenedFolders).click();
            countOfOpenedFolders++;
        }

        //iterating over all products and checking browser logs
        int countOfProducts = catalogPage.getExistingProductsList().size();
        for (int i =1; i<=countOfProducts; i++){

            catalogPage.clickProductExistingByPosition(i);
            editExistingProductPage.clickOnCancelButton();

        }


    }
}
