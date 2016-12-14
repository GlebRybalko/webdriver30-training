/**
 * Created by Gleb on 14.12.2016.
 */
import org.junit.Test;
import org.openqa.selenium.By;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginAdminPageTest extends BaseTest {

    @Test
    public void logWithValidCredentials(){
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));
    }
}
