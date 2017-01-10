package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Gleb on 10.01.2017.
 */
public class AdminCountriesPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class = 'button'][text() = ' Add New Country']")
    private WebElement AddNewCountryButton;

    public void clickAddNewCountryButton(){
        AddNewCountryButton.click();
    }
}

