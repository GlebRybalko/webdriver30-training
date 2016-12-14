/**
 * Created by glib.rybalko on 14.12.2016.
 */
import org.junit.Test;
import org.openqa.selenium.By;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class GoogleSearchPageTest extends BaseTest {
    @Test
    public void googleSearchByNameTest() {
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }
}
