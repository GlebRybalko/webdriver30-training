package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Gleb on 21.12.2016.
 */
public class AdminPage {
    By menuItemsListLocator = By.xpath("//*[@id='app-']");

    private final WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllMenuItemsFromLeftSidebar(){
        return driver.findElements(menuItemsListLocator);
    }

    public WebElement getSpecificMenuItemFromLeftSidebarByPositionNumber(int i){
        return driver.findElement(By.xpath("//*[@id='app-'][" + i + "]"));
    }

    public int getAllMenuItemsFromLeftSidebarSize(){
        return getAllMenuItemsFromLeftSidebar().size();
    }

    public void clickSpecificMenuItemFromLeftSidebarByPositionNumber(int i){
        driver.findElement(By.xpath("//*[@id='app-'][" + i + "]")).click();
    }

    public void clickSpecificMenuItemFromLeftSidebarByName(String name){
        driver.findElement(By.xpath("//*[@id='app-']//span[@class='name'][text()='"+name+"']")).click();
    }

    public List<WebElement> getAllSubMenuItemsFromLeftSidebarMenuItemByParentPositionNumber(int i){
        return driver.findElements(By.xpath("//*[@id='app-']" + "[" + i + "]//li"));
    }

    public WebElement getSpecificSubMenuItemFromLeftSidebarByPositionNumber(int i){
        return driver.findElement(By.xpath("//*[@id='app-'][" + i + "]"));
    }

    public int getAllSubMenuItemsFromLeftSidebarSizeByParentPositionNumber(int i){
        return this.getAllSubMenuItemsFromLeftSidebarMenuItemByParentPositionNumber(i).size();
    }

    public void clickSpecificSubMenuItemFromLeftSidebarByPositionNumber(int i){
        driver.findElement(By.xpath("//*[@id='app-'][" + i + "]")).click();
    }
}
