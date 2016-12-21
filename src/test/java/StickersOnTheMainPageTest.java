import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Gleb on 21.12.2016.
 */
public class StickersOnTheMainPageTest extends BaseTest {

    @Test
    public void OnlyOneStickerPresentForAllProductsTest(){
        driver.get("http://localhost/litecart/");

        List<WebElement> productsList = new ArrayList<WebElement>();
        productsList = driver.findElements(By.cssSelector("div.content li.product"));
        for (WebElement product : productsList){
            Assert.assertEquals("One sticker per product is expected",1 ,product.findElements(By.cssSelector("div.sticker")).size());
        }
    }
}
