package adminpagetests;

import Pages.AdminAddProductPage;
import Pages.AdminCatalogPage;
import Pages.AdminLoginPage;
import Pages.AdminPage;
import base.BaseTest;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Gleb on 31.12.2016.
 */
public class CreateNewProductInAdminPageTest extends BaseTest {

    @Test
    public void addNewProductTest(){

        String productname = "ProductTest 7";

        driver.get("http://localhost/litecart/admin/");

        AdminLoginPage adminLoginPage = PageFactory.initElements(driver,AdminLoginPage.class);
        AdminPage adminPage = PageFactory.initElements(driver,AdminPage.class);
        AdminAddProductPage addProductPage = PageFactory.initElements(driver, AdminAddProductPage.class);
        AdminCatalogPage catalogPage = PageFactory.initElements(driver, AdminCatalogPage.class);

        adminLoginPage.loginAs("admin","admin");
        adminPage.clickSpecificMenuItemFromLeftSidebarByName("Catalog");
        adminPage.addNewProductButtonClick();

        addProductPage.clickOnGeneralTab();
        addProductPage.setProductStatusEnabled();
        addProductPage.setProductName(productname);
        addProductPage.setProductCode("ProductCode 7");
        addProductPage.setProductCategoryByName("Rubber Ducks");
        addProductPage.setProductGroupsByName("Male");
        addProductPage.setProductQuantity("100");
        addProductPage.setProductPicture("D:\\Tools\\test1.png");
        addProductPage.setProductDateValidFrom("01.01.2016");
        addProductPage.setProductDateValidTo("01.01.2020");

        addProductPage.clickOnInformationTab();
        addProductPage.selectProductManufacturerByName("ACME Corp.");
        addProductPage.setKeywords("test keyword");
        addProductPage.setShortDescription("test short description");
        addProductPage.setDescription("test long description test long description test long description test long description");
        addProductPage.setHeadTitle("Test Head Title");
        addProductPage.setMetaDescription("Test meta description");

        addProductPage.clickOnPricesTab();
        addProductPage.setProductPurchasePrice("40.5");
        addProductPage.selectProductPurchasePriceCurrencyByCode("USD");
        addProductPage.setProductPriceUSD("35.5");

        addProductPage.clickOnSaveButton();

        Assert.assertTrue("Test product is not found", catalogPage.isProductNamePresentInProductCatalog(productname));



    }
}
