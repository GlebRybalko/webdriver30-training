package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Gleb on 10.01.2017.
 */
public class AddNewCountryAdminCountriesPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@target = '_blank']//i[@class = 'fa fa-external-link']")
    private List<WebElement> ExternalLinks;

    public WebElement getExternalLinkByPosition(int position){
        return ExternalLinks.get(position);
    }

    public Integer getExternalLinksCount(){
        return ExternalLinks.size();
    }
}
