package base; /**
 * Created by glib.rybalko on 12/14/2016.
 */
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {


        public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
        public WebDriver driver;
        public WebDriverWait wait;

        public boolean areElementsPresent(WebDriver driver, By locator) {
            return driver.findElements(locator).size() > 0;
        }

        public void unhide(WebDriver driver, WebElement element) {
            String script = "arguments[0].style.opacity=1;"
                    + "arguments[0].style['transform']='translate(0px, 0px) scale(1)';"
                    + "arguments[0].style['MozTransform']='translate(0px, 0px) scale(1)';"
                    + "arguments[0].style['WebkitTransform']='translate(0px, 0px) scale(1)';"
                    + "arguments[0].style['msTransform']='translate(0px, 0px) scale(1)';"
                    + "arguments[0].style['OTransform']='translate(0px, 0px) scale(1)';"
                    + "return true;";
            ((JavascriptExecutor) driver).executeScript(script, element);
        }

        @Before
        public void start() {
                if (tlDriver.get() != null) {
                    driver = tlDriver.get();
                    wait = new WebDriverWait(driver, 10);
                    return;
                }

                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                tlDriver.set(driver);
                wait = new WebDriverWait(driver, 10);

                Runtime.getRuntime().addShutdownHook(
                        new Thread(() -> { driver.quit(); driver = null; }));
        }
        public Boolean isListSortedInAlphabeticalOrder(List<String> list){
            List<String> tmp = new ArrayList(list);
            Collections.sort(tmp);
            return tmp.equals(list);
        }
 //       @After
 //       public void stop() {
 //           driver.quit();
 //           driver = null;
 //       }
}
