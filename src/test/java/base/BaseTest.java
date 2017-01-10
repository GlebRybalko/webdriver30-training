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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {


        public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
        public WebDriver driver;
        public WebDriverWait wait;
        String mainWindow;
        Set<String> oldWindows;

        public boolean areElementsPresent(WebDriver driver, By locator) {
            return driver.findElements(locator).size() > 0;
        }

        public int randomInteger(int min, int max) {
            Random rand = new Random();
            int randomNum = min + (int)(Math.random() * ((max - min) + 1));
            return randomNum;
        }

        public void switchToNewWindowByClickOnWebelement(WebElement elem){
            mainWindow = driver.getWindowHandle();
            oldWindows = driver.getWindowHandles();
            elem.click(); // открывает новое окно
// ожидание появления нового окна,
// идентификатор которого отсутствует в списке oldWindows,
// остаётся в качестве самостоятельного упражнения
            String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
// ...
/*            driver.close();
            driver.switchTo().window(mainWindow);*/
        }

        public void switchToMainWindowAndCloseCurrentWindow(){
            driver.close();
            driver.switchTo().window(mainWindow);
        }

        public ExpectedCondition<String> thereIsWindowOtherThan(Set<String> oldWindows){
            return new ExpectedCondition<String>() {
                @Override
                public String apply(WebDriver webDriver) {
                    Set<String> handles = driver.getWindowHandles();
                    handles.removeAll(oldWindows);
                    return handles.size() > 0 ? handles.iterator().next() : null;
                }
            };
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
                        new Thread(() -> {driver.quit(); driver = null; }));
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

