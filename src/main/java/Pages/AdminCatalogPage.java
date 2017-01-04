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
    private List<WebElement> ProductCatalogNames;

    public Boolean isProductNamePresentInProductCatalog(String name){
        Boolean result = false;
        for (WebElement product : ProductCatalogNames){
            if (name.equals(product.getText())){
                result = true;
            }
        }
        return result;
    }

}
