package adminpagetests;

import Pages.AdminPage;
import Pages.AdminLoginPage;
import base.BaseTest;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Gleb on 20.12.2016.
 */
public class LeftSidebarMenuTest extends BaseTest {

    @Test
    public void goThroughAllLinksInLeftSidebarVerifyHeaderTest(){
        driver.get("http://localhost/litecart/admin/");
        int menuItemSize;
        int subMenuItemsListSize;

        AdminLoginPage loginpage = PageFactory.initElements(driver, AdminLoginPage.class);
        AdminPage adminpage = PageFactory.initElements(driver, AdminPage.class);
        loginpage.loginAs("admin","admin");

        List<WebElement> subMenuItemsList = new ArrayList<WebElement>();
        menuItemSize = adminpage.getAllMenuItemsFromLeftSidebarSize();
        for(int i = 1; i < menuItemSize;){

            adminpage.clickSpecificMenuItemFromLeftSidebarByPositionNumber(i);
            subMenuItemsListSize = adminpage.getAllSubMenuItemsFromLeftSidebarSizeByParentPositionNumber(i);
            if (subMenuItemsListSize > 1) {
                for (int j = 0;j < subMenuItemsListSize;){
                    subMenuItemsList = adminpage.getAllSubMenuItemsFromLeftSidebarMenuItemByParentPositionNumber(i);
                    subMenuItemsList.get(j).click();
                    Assert.assertTrue(areElementsPresent(driver, By.xpath("//td[@id='content']//h1")));
                    j++;
                }
            }
            Assert.assertTrue(areElementsPresent(driver, By.xpath("//td[@id='content']//h1")));
            i++;
        }

    }

}

