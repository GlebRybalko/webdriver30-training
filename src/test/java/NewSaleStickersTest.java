import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Gleb on 21.12.2016.
 */
public class NewSaleStickersTest extends BaseTest {

    @Test
    public void NewSaleStickerMostPopuparSectionTest(){
        driver.get("http://localhost/litecart/");

        List<WebElement> productsList = new ArrayList<WebElement>();
        productsList = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
        for (WebElement product : productsList){
            product.findElement(By.cssSelector("a.link > div.image-wrapper > div"));
        }


    }

    @Test
    public void SaleStickerTest(){

    }
}
