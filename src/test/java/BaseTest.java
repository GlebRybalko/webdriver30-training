/**
 * Created by glib.rybalko on 12/14/2016.
 */
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

        public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
        public WebDriver driver;
        public WebDriverWait wait;

        @Before
        public void start() {
            if (tlDriver.get() != null) {
                driver = tlDriver.get();
                wait = new WebDriverWait(driver, 10);
                return;
            }
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(FirefoxDriver.MARIONETTE, false);
            driver = new FirefoxDriver(caps);
            tlDriver.set(driver);
            System.out.println(((HasCapabilities) driver).getCapabilities());
            wait = new WebDriverWait(driver, 10);

        }

        @After
        public void stop() {
            driver.quit();
            driver = null;
        }
}

