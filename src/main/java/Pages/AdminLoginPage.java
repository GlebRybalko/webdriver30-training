package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Gleb on 21.12.2016.
 */
public class AdminLoginPage {
    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement usernameLocator;

    @FindBy(name = "password")
    private WebElement passwordLocator;

    @FindBy(name = "login")
    private WebElement loginButtonLocator;

    public void typeUsername(String username) {
        usernameLocator.sendKeys(username);
    }

    public void typePassword(String password) {
        passwordLocator.sendKeys(password);
    }

    public void submitLogin() {
        loginButtonLocator.click();
    }

    public void submitLoginExpectingFailure() {
        loginButtonLocator.click();
    }

    public void loginAs(String username, String password) {

        typeUsername(username);
        typePassword(password);
        submitLogin();
    }
}
