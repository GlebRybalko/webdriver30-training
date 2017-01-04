package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Gleb on 21.12.2016.
 */
public class AdminPage {

    private WebDriver driver;

    @FindBy(xpath ="//*[@id='app-']")
    private List<WebElement> menuItemsListLocator;

    @FindBy(xpath ="//*[@id='app-']//a")
    private List<WebElement> menuItemNamesListLocator;

    @FindBy(xpath = "//a[@class = 'button'][text() = ' Add New Product']")
    private WebElement AddNewProductButton;

    public void addNewProductButtonClick(){
        AddNewProductButton.click();
    }

    public List<WebElement> getAllMenuItemsFromLeftSidebar(){
        return menuItemsListLocator;
    }

    public WebElement getSpecificMenuItemFromLeftSidebarByPositionNumber(int i){
        return menuItemsListLocator.get(i);
    }

    public int getAllMenuItemsFromLeftSidebarSize(){

        return getAllMenuItemsFromLeftSidebar().size();
    }

    public void clickSpecificMenuItemFromLeftSidebarByPositionNumber(int i){
         menuItemsListLocator.get(i).click();
    }

    public void clickSpecificMenuItemFromLeftSidebarByName(String name){
        String temp = "";
        for(WebElement el : menuItemNamesListLocator){
            temp = el.getText();
            if (name.equals(temp)){
                el.click();
                //System.out.println(el.getText() + " clicked");
                return;
            }

        }
    }

    public List<WebElement> getAllSubMenuItemsFromLeftSidebarMenuItemByParentPositionNumber(int i){
        return menuItemsListLocator.get(i).findElements(By.xpath("//li"));
    }

    public WebElement getSpecificSubMenuItemFromLeftSidebarByPositionNumber(int i){
        return menuItemsListLocator.get(i);
    }

    public int getAllSubMenuItemsFromLeftSidebarSizeByParentPositionNumber(int i){
        return this.getAllSubMenuItemsFromLeftSidebarMenuItemByParentPositionNumber(i).size();
    }

    public void clickSpecificSubMenuItemFromLeftSidebarByPositionNumber(int i){
        menuItemsListLocator.get(i).click();
    }

    public void clickSpecificSubMenuItemFromLeftSidebarByName(String name){
        driver.findElement(By.xpath("//*[@id='app-']//span[@class='name'][text()='"+name+"'][1]")).click();
    }

    public void unhide(WebDriver driver, WebElement element) {
        String script = "arguments[0].style.opacity=1;"
                + "arguments[0].style['transform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['MozTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['WebkitTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['msTransform']='translate(0px, 0px) scale(1)';"
                + "arguments[0].style['OTransform']='translate(0px, 0px) scale(1)';"
                + "return true;";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public void attachFile(WebDriver driver, WebElement element, String file) {
        WebElement input = element;
        unhide(driver, input);
        input.sendKeys(file);
    }
}
