package adminpagetests;

import Pages.AdminPage;
import Pages.LoginPage;
import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gleb on 23.12.2016.
 */
public class CountriesAdminPageTest extends BaseTest {

    @Test
    public void countriesSortTest() {

        driver.get("http://localhost/litecart/admin/");
        LoginPage loginpage = new LoginPage(driver);
        AdminPage adminpage = loginpage.loginAs("admin","admin");

        List<WebElement> countriesNamesList = new ArrayList<>();
        List <String> countryNames = new ArrayList<>();
        List<WebElement> countriesList = new ArrayList<>();
        List<WebElement> zonesNamesInCountriesList = new ArrayList<>();

        WebElement countryZoneCounter;
        Integer countriesListSize = 0;

        adminpage.clickSpecificMenuItemFromLeftSidebarByName("Countries");
        countriesNamesList = driver.findElements(By.cssSelector("form[name=countries_form] tr.row td:nth-child(5)"));
        countriesListSize = countriesNamesList.size();

        for (WebElement country : countriesNamesList){
            countryNames.add( country.getAttribute("outerText"));
        }

        Assert.assertTrue("List is not sorted in alphabetical order", isListSortedInAlphabeticalOrder(countryNames));

        for (int i = 0; i < countriesListSize; i++){
            countriesList = driver.findElements(By.cssSelector("form[name=countries_form] tr.row"));
            countryZoneCounter = countriesList.get(i).findElement(By.cssSelector("td:nth-child(6)"));

            if (Integer.valueOf(countryZoneCounter.getAttribute("innerText")) > 0){
                countriesNamesList = driver.findElements(By.cssSelector("form[name=countries_form] tr.row td:nth-child(5)"));
                driver.get(countriesNamesList.get(i).findElement(By.cssSelector("a")).getAttribute("href"));
                zonesNamesInCountriesList = driver.findElements(By.cssSelector("table#table-zones tr > td:nth-child(3)"));
                zonesNamesInCountriesList.remove(zonesNamesInCountriesList.size()-1);

                List <String> zoneNamesInCountries = new ArrayList<>();
                for (WebElement zone : zonesNamesInCountriesList){
                    zoneNamesInCountries.add(zone.getAttribute("innerText"));
                }
                Assert.assertTrue("List is not sorted in alphabetical order", isListSortedInAlphabeticalOrder(zoneNamesInCountries));
                driver.findElement(By.cssSelector("button[name = 'cancel']")).click();
            }
        }
    }
}
