package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Gleb on 04.01.2017.
 */
public class AdminCatalogPage {

    private WebDriver driver;

    @FindBy(xpath = "//tr[@class = 'row']//td[3]//a")
    private List<WebElement> ProductCatalogWithFoldersNames;

    @FindBy(xpath = "//tr[@class = 'row']/td[3]/a")
    private List<WebElement> ProductCatalogNames;

    @FindBy(xpath = "//i[@class = 'fa fa-folder']/following-sibling::a")
    private List<WebElement> ProductClosedFolders;

    public Boolean isProductNamePresentInProductCatalog(String name){
        Boolean result = false;
        for (WebElement product : ProductCatalogWithFoldersNames){
            if (name.equals(product.getText())){
                result = true;
            }
        }
        return result;
    }

    public void clickProductExistingByPosition(int position){
        ProductCatalogNames.get(position).click();
    }

    public Integer getExistingProductsListSize(){
        return ProductCatalogNames.size();
    }

    public List<WebElement> getExistingProductsList(){
        return ProductCatalogNames;
    }

    public Integer getExistingProductsFoldersSize(){
        return ProductClosedFolders.size();
    }

    public List<WebElement> getExistingProductsFoldersList(){
        return ProductClosedFolders;
    }

    public void clickSpecificProductInProductsListByName(String name){
        String temp = "";
        for(WebElement el : ProductCatalogNames){
            temp = el.getText();
            if (name.equals(temp)){
                el.click();
                //System.out.println(el.getText() + " clicked");
                return;
            }

        }
    }
}
