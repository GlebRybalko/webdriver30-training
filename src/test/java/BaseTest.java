/**
 * Created by glib.rybalko on 12/14/2016.
 */
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

        public WebDriver driver;
        public WebDriverWait wait;

        @Before
        public void start() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);

        }

        @After
        public void stop() {
            driver.quit();
            driver = null;
        }
}

