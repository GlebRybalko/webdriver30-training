/**
 * Created by glib.rybalko on 12/14/2016.
 */
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class BaseTest {

}
        public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
        public WebDriver driver;
        public WebDriverWait wait;

        @Before
        public void start() {
                if (tlDriver.get() != null) {
                    driver = tlDriver.get();
                    wait = new WebDriverWait(driver, 10);
                    return;
                }

                driver = new ChromeDriver();
                tlDriver.set(driver);
                wait = new WebDriverWait(driver, 10);

                Runtime.getRuntime().addShutdownHook(
                        new Thread(() -> { driver.quit(); driver = null; }));
        }

        @After
        public void stop() {
            driver.quit();
            driver = null;
        }
}

