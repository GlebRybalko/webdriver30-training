package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Gleb on 21.12.2016.
 */
public class AdminLoginPage {
    By usernameLocator = By.name("username");
    By passwordLocator = By.name("password");
    By loginButtonLocator = By.name("login");

    private final WebDriver driver;

    public AdminLoginPage(WebDriver driver) {
        this.driver = driver;


/*        if (!"My Store".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }*/
    }

    public AdminLoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public AdminLoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public AdminPage submitLogin() {
        driver.findElement(loginButtonLocator).click();
        return new AdminPage(driver);
    }

    public AdminLoginPage submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).click();
        return new AdminLoginPage(driver);
    }

    public AdminPage loginAs(String username, String password) {

        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}
