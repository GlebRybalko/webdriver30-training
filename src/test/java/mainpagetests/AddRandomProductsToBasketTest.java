package mainpagetests;

import Pages.CheckoutPage;
import Pages.MainPage;
import Pages.ProductDetailsPage;
import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Created by Gleb on 05.01.2017.
 */
public class AddRandomProductsToBasketTest extends BaseTest{

    @Test
    public void AddRandomProductsToBasketAndDeleteThemTest() throws InterruptedException {

        driver.get("http://localhost/litecart/");
        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        ProductDetailsPage productDetailsPage = PageFactory.initElements(driver,ProductDetailsPage.class);
        CheckoutPage checkoutPage = PageFactory.initElements(driver,CheckoutPage.class);

        for(int i =0;i < 3;i++){
            mainPage.getProductByPositionNumber(randomInteger(0,mainPage.getProductsListSize()-1)).click();
            productDetailsPage.AddToCartButtonClick();
            wait.until(textToBePresentInElement(mainPage.getCheckoutProductsQuantity(),Integer.toString(i+1)));
            mainPage.HomeButtonClick();
        }

        mainPage.CheckoutClick();
        Integer productsCounter = checkoutPage.getProductsInBasket().size() - 1;
        while(checkoutPage.getProductsInBasket().size() > 0){

            checkoutPage.RemoveButtonClick();
            //wait until product to be removed in Order Summary section
            wait.until(stalenessOf(checkoutPage.getProductInOrderSummaryByPosition(productsCounter)));
            productsCounter--;
            System.out.println("Element clicked");

        }
    }

}
