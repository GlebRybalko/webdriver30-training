/**
 * Created by Gleb on 14.12.2016.
 */
import Pages.LoginPage;
import org.junit.Test;
import org.openqa.selenium.By;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginAdminPageTest extends BaseTest {

    @Test
    public void logWithValidCredentials(){
        driver.get("http://localhost/litecart/admin/");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.loginAs("admin","admin");
        wait.until(titleIs("My Store"));
    }
}
