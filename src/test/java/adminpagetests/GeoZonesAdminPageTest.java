package adminpagetests;

import Pages.AdminPage;
import Pages.AdminLoginPage;
import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gleb on 25.12.2016.
 */
public class GeoZonesAdminPageTest extends BaseTest {
    @Test
    public void geoZonePageSortTest(){
        driver.get("http://localhost/litecart/admin/");
        AdminLoginPage loginpage = PageFactory.initElements(driver, AdminLoginPage.class);
        AdminPage adminpage = PageFactory.initElements(driver, AdminPage.class);
        loginpage.loginAs("admin","admin");

        List<WebElement> geoZonesList = new ArrayList<>();

        adminpage.clickSpecificMenuItemFromLeftSidebarByPositionNumber(5); //id 5 =>"Geo Zones"

        geoZonesList = driver.findElements(By.cssSelector("form[name = 'geo_zones_form'] td:nth-child(3) > a"));

        int geoZonesListSize = geoZonesList.size();

        for (int i = 0; i < geoZonesListSize; i++){
            driver.get(
                    driver.findElements(
                            By.cssSelector("form[name = 'geo_zones_form'] td:nth-child(3) > a")).
                            get(i).
                            getAttribute("href"));
            List<WebElement> ZonesInGeoZonesList = new ArrayList<>();
            ZonesInGeoZonesList = driver.findElements(
                    By.cssSelector("form[name = 'form_geo_zone'] td:nth-child(3) option[selected = 'selected']"));
            List <String> zoneNamesInGeoZonesList = new ArrayList<>();
            for (WebElement zone : ZonesInGeoZonesList){
                zoneNamesInGeoZonesList.add(zone.getAttribute("innerText"));
            }
            Assert.assertTrue("List is not sorted in alphabetical order", isListSortedInAlphabeticalOrder(zoneNamesInGeoZonesList));
            driver.findElement(By.cssSelector("button[name = 'cancel']")).click();

        }


    }
}
