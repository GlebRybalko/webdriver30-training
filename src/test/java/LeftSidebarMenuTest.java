import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Gleb on 20.12.2016.
 */
public class LeftSidebarMenuTest extends BaseTest{

    @Test
    public void goThroughAllLinksInLeftSidebarVerifyHeaderTest(){
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> menuItemsList = new ArrayList<WebElement>();
        List<WebElement> subMenuItemsList = new ArrayList<WebElement>();
        menuItemsList = driver.findElements(By.xpath("//*[@id='app-']"));
        int menuItemSize = menuItemsList.size();
        for(int i = 1; i < menuItemSize;){

            driver.findElement(By.xpath("//*[@id='app-'][" + i + "]")).click();
            subMenuItemsList = driver.findElements(By.xpath("//*[@id='app-'][" + i + "]//li"));
            if (subMenuItemsList.size() > 1) {
                for (int j = 0;j < subMenuItemsList.size();){

                    subMenuItemsList.get(j).click();
                    Assert.assertTrue(areElementsPresent(driver, By.xpath("//td[@id='content']//h1")));
                    subMenuItemsList = driver.findElements(By.xpath("//*[@id='app-'][" + i + "]//li"));
                    j++;
                }
            }
            Assert.assertTrue(areElementsPresent(driver, By.xpath("//td[@id='content']//h1")));
            i++;
        }

    }

}

