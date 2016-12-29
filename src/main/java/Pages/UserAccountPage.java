package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Gleb on 30.12.2016.
 */
public class UserAccountPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id = 'box-account']//div[@class = 'content']//a[text()='Logout']")
    private WebElement LogoutLink;

    public void doLogout(){
        LogoutLink.click();
    }


}
