package mainpagetests;

import base.BaseTest;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by Gleb on 25.12.2016.
 */
public class ProductsOnMainPageTest extends BaseTest {
    @Test
    public void ProductDetailsScreenTest(){
        driver.get("http://localhost/litecart/");
        WebElement Product;
        String MainPageProductLabel;
        String MainPageRegularPriceLabel;
        String MainPageRegularPriceFontSize;
        String MainPageRegularPriceTextStyle;
        String MainPageRegularPriceFontColor;
        String MainPageDiscountPriceLabel;
        String MainPageDiscountPriceFontSize;
        String MainPageDiscountPriceTextStyle;
        String MainPageDiscountPriceFontColor;


        String ProductDetailsProductLabel;
        String ProductDetailsRegularPriceLabel;
        String ProductDetailsRegularPriceFontSize;
        String ProductDetailsRegularPriceTextStyle;
        String ProductDetailsRegularPriceFontColor;
        String ProductDetailsDiscountPriceLabel;
        String ProductDetailsDiscountPriceFontSize;
        String ProductDetailsDiscountPriceTextStyle;
        String ProductDetailsDiscountPriceFontColor;

        Product = driver.findElement(By.cssSelector("div#box-campaigns div.content li.product"));
        MainPageProductLabel = Product.findElement(By.cssSelector("div.name")).getAttribute("innerText");

        MainPageRegularPriceLabel = Product.findElement(By.cssSelector("div.price-wrapper .regular-price")).getAttribute("innerText");
        MainPageRegularPriceFontSize = Product.findElement(By.cssSelector("div.price-wrapper .regular-price")).getCssValue("font-size");
        MainPageRegularPriceTextStyle = Product.findElement(By.cssSelector("div.price-wrapper .regular-price")).getCssValue("text-decoration");
        MainPageRegularPriceFontColor = Product.findElement(By.cssSelector("div.price-wrapper .regular-price")).getCssValue("color");

        MainPageDiscountPriceLabel = Product.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getAttribute("innerText");
        MainPageDiscountPriceFontSize = Product.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getCssValue("font-size");
        MainPageDiscountPriceTextStyle = Product.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getCssValue("font-weight");
        MainPageDiscountPriceFontColor = Product.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getCssValue("color");

        Assert.assertThat(MainPageRegularPriceFontSize, IsEqual.equalTo("14.4px"));
        Assert.assertThat(MainPageRegularPriceTextStyle, IsEqual.equalTo("line-through"));
        Assert.assertThat(MainPageRegularPriceFontColor, IsEqual.equalTo("rgba(119, 119, 119, 1)"));

        Assert.assertThat(MainPageDiscountPriceFontSize, IsEqual.equalTo("18px"));
        Assert.assertThat(MainPageDiscountPriceTextStyle, IsEqual.equalTo("bold"));
        Assert.assertThat(MainPageDiscountPriceFontColor, IsEqual.equalTo("rgba(204, 0, 0, 1)"));

        Product.click();

        ProductDetailsProductLabel = driver.findElement(By.cssSelector("div#box-product h1.title")).getAttribute("innerText");

        ProductDetailsRegularPriceLabel = driver.findElement(By.cssSelector("div#box-product div.price-wrapper .regular-price")).getAttribute("innerText");
        ProductDetailsRegularPriceFontSize = driver.findElement(By.cssSelector("div#box-product div.price-wrapper .regular-price")).getCssValue("font-size");
        ProductDetailsRegularPriceTextStyle = driver.findElement(By.cssSelector("div#box-product div.price-wrapper .regular-price")).getCssValue("text-decoration");
        ProductDetailsRegularPriceFontColor = driver.findElement(By.cssSelector("div#box-product div.price-wrapper .regular-price")).getCssValue("color");

        ProductDetailsDiscountPriceLabel = driver.findElement(By.cssSelector("div#box-product div.price-wrapper .campaign-price")).getAttribute("innerText");
        ProductDetailsDiscountPriceFontSize = driver.findElement(By.cssSelector("div#box-product div.price-wrapper .campaign-price")).getCssValue("font-size");
        ProductDetailsDiscountPriceTextStyle = driver.findElement(By.cssSelector("div#box-product div.price-wrapper .campaign-price")).getCssValue("font-weight");
        ProductDetailsDiscountPriceFontColor = driver.findElement(By.cssSelector("div#box-product div.price-wrapper .campaign-price")).getCssValue("color");


        Assert.assertThat(ProductDetailsProductLabel, IsEqual.equalTo(MainPageProductLabel));
        Assert.assertThat(ProductDetailsRegularPriceLabel, IsEqual.equalTo(MainPageRegularPriceLabel));
        Assert.assertThat(ProductDetailsDiscountPriceLabel, IsEqual.equalTo(MainPageDiscountPriceLabel));

        Assert.assertThat(ProductDetailsRegularPriceFontSize, IsEqual.equalTo("16px"));
        Assert.assertThat(ProductDetailsRegularPriceTextStyle, IsEqual.equalTo("line-through"));
        Assert.assertThat(ProductDetailsRegularPriceFontColor, IsEqual.equalTo("rgba(102, 102, 102, 1)"));


        Assert.assertThat(ProductDetailsDiscountPriceFontSize, IsEqual.equalTo("22px"));
        Assert.assertThat(ProductDetailsDiscountPriceTextStyle, IsEqual.equalTo("bold"));
        Assert.assertThat(ProductDetailsDiscountPriceFontColor, IsEqual.equalTo("rgba(204, 0, 0, 1)"));


    }
}
