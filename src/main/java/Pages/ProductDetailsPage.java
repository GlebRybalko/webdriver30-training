package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Gleb on 05.01.2017.
 */
public class ProductDetailsPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@name = 'add_cart_product']")
    private WebElement AddToCartButton;

    public void AddToCartButtonClick(){
        AddToCartButton.click();
    }
}
