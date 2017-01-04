package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Gleb on 03.01.2017.
 */
public class AdminAddProductPage {

    private WebDriver driver;

    /*General tab objects*/

    @FindBy(xpath = "//div[@class = 'tabs']//a[text()='General']")
    private WebElement GeneralTab;

    @FindBy(xpath = "//input[@name = 'status']")
    private List<WebElement> StatusRadioButton;

    @FindBy(xpath = "//input[@name = 'name[en]']")
    private WebElement Name;

    @FindBy(xpath = "//input[@name = 'code']")
    private WebElement Code;

    @FindBy(xpath = "//input[@name = 'categories[]']")
    private List<WebElement> Categories;

    @FindBy(xpath = "//select[@name = 'default_category_id']")
    private WebElement DefaultCategory;

    @FindBy(xpath = "//input[@name = 'product_groups[]']")
    private List<WebElement> ProductGroups;

    @FindBy(xpath = "//input[@name = 'quantity']")
    private WebElement Quantity;

    @FindBy(xpath = "//select[@name = 'quantity_unit_id']")
    private WebElement QuantityUnit;

    @FindBy(xpath = "//select[@name = 'delivery_status_id']")
    private WebElement DeliveryStatus;

    @FindBy(xpath = "//select[@name = 'sold_out_status_id']")
    private WebElement SoldOutStatus;

    @FindBy(xpath = "//input[@name = 'new_images[]']")
    private List<WebElement> UploadImage;

    @FindBy(xpath = "//input[@name = 'date_valid_from']")
    private WebElement DateValidFrom;

    @FindBy(xpath = "//input[@name = 'date_valid_to']")
    private WebElement DateValidTo;

    public void setProductStatusEnabled(){
        StatusRadioButton.get(0).click();
    }

    public void setProductStatusDisabled(){
        StatusRadioButton.get(1).click();
    }

    public void setProductName(String text){
        Name.clear();
        Name.sendKeys(text);
    }

    public void setProductCode(String text){
        Code.clear();
        Code.sendKeys(text);
    }

    public void setProductCategoryByName(String name){

        for (WebElement category : Categories){
            if (name.equals(category.getAttribute("data-name"))){
                category.click();
            }
        }
    }

    public void setProductGroupsByName(String name){
        switch (name){
            case "Male":
                ProductGroups.get(0).click();
                break;
            case "Female":
                ProductGroups.get(1).click();
                break;
            case "Unisex":
                ProductGroups.get(2).click();
                break;
            default:
                ProductGroups.get(2).click();
        }

    }

    public void setProductQuantity(String text){
        Quantity.clear();
        Quantity.sendKeys(text);
    }

    public void setProductPicture(String path){
        WebElement lastUploadControl = UploadImage.get(UploadImage.size()-1);
        lastUploadControl.sendKeys(path);
    }

    public void setProductDateValidFrom(String text){
        DateValidFrom.sendKeys(text);
    }

    public void setProductDateValidTo(String text){
        DateValidTo.sendKeys(text);
    }

    public void selectDefaultProductCategoryByName(String name){
        Select defaultProductCategory = new Select(DefaultCategory);
        defaultProductCategory.selectByValue(name);
    }

    /*Information tab objects*/

    @FindBy(xpath = "//div[@class = 'tabs']//a[text()='Information']")
    private WebElement InformationTab;

    @FindBy(xpath = "//select[@name = 'manufacturer_id']")
    private WebElement Manufacturer;

    @FindBy(xpath = "//select[@name = 'supplier_id']")
    private WebElement Supplier;

    @FindBy(xpath = "//input[@name = 'keywords']")
    private WebElement Keywords;

    @FindBy(xpath = "//input[@name = 'short_description[en]']")
    private WebElement ShortDescription;

    @FindBy(xpath = "//div[@class = 'trumbowyg-editor']")
    private WebElement Description;

    @FindBy(xpath = "//input[@name = 'head_title[en]']")
    private WebElement HeadTitle;

    @FindBy(xpath = "//input[@name = 'meta_description[en]']")
    private WebElement MetaDescription;


    public void selectProductManufacturerByName(String name){
        Select productManufacturer = new Select(Manufacturer);
        productManufacturer.selectByVisibleText(name);
    }

    public void selectProductSupplierByName(String name){
        Select supplier = new Select(Supplier);
        supplier.selectByValue(name);
    }

    public void setKeywords(String text){
        Keywords.clear();
        Keywords.sendKeys(text);
    }

    public void setShortDescription(String text){
        ShortDescription.clear();
        ShortDescription.sendKeys(text);
    }

    public void setDescription(String text){
        Description.clear();
        Description.sendKeys(text);
    }

    public void setHeadTitle(String text){
        HeadTitle.clear();
        HeadTitle.sendKeys(text);
    }

    public void setMetaDescription(String text){
        MetaDescription.clear();
        MetaDescription.sendKeys(text);
    }

    /*Prices tab objects*/

    @FindBy(xpath = "//div[@class = 'tabs']//a[text()='Prices']")
    private WebElement PricesTab;

    @FindBy(xpath = "//input[@name = 'purchase_price']")
    private WebElement ProductPurchasePrice;

    @FindBy(xpath = "//select[@name = 'purchase_price_currency_code']")
    private WebElement ProductPurchasePriceCurrencyCode;

    @FindBy(xpath = "//select[@name = 'tax_class_id']")
    private WebElement ProductTaxClass;

    @FindBy(xpath = "//input[@name = 'prices[USD]']")
    private WebElement ProductPriceUSD;

    @FindBy(xpath = "//input[@name = 'prices[EUR]']")
    private WebElement ProductPriceEUR;

    @FindBy(xpath = "//input[@name = 'gross_prices[USD]']")
    private WebElement ProductGrossPriceUSD;

    @FindBy(xpath = "//input[@name = 'gross_prices[EUR]']")
    private WebElement ProductGrossPriceEUR;

    public void setProductPurchasePrice(String text){
        ProductPurchasePrice.clear();
        ProductPurchasePrice.sendKeys(text);
    }

    public void selectProductPurchasePriceCurrencyByCode(String name){
        Select productPurchasePriceCurrencyCode = new Select(ProductPurchasePriceCurrencyCode);
        productPurchasePriceCurrencyCode.selectByValue(name);
    }

    public void selectProductTaxClassByCode(String name){
        Select productTaxClass = new Select(ProductTaxClass);
        productTaxClass.selectByValue(name);
    }

    public void setProductPriceUSD(String text){
        ProductPriceUSD.clear();
        ProductPriceUSD.sendKeys(text);
    }

    public void setProductPriceEUR(String text){
        ProductPriceEUR.clear();
        ProductPriceEUR.sendKeys(text);
    }

    public void setProductGrossPriceUSD(String text){
        ProductGrossPriceUSD.clear();
        ProductGrossPriceUSD.sendKeys(text);
    }

    public void setProductGrossPriceEUR(String text){
        ProductGrossPriceEUR.clear();
        ProductGrossPriceEUR.sendKeys(text);
    }

    /*Data tab objects TBD*/

    @FindBy(xpath = "//div[@class = 'tabs']//a[text()='Data']")
    private WebElement DataTab;

    /*Options tab objects TBD*/

    @FindBy(xpath = "//div[@class = 'tabs']//a[text()='Options']")
    private WebElement OptionsTab;

    /*Options Stock tab objects TBD*/

    @FindBy(xpath = "//div[@class = 'tabs']//a[text()='Options Stock']")
    private WebElement OptionsStockTab;

    /*Common buttons objects */

    @FindBy(xpath = "//button[@name = 'save']")
    private WebElement SaveButton;

    @FindBy(xpath = "//button[@name = 'delete']")
    private WebElement DeleteButton;

    @FindBy(xpath = "//button[@name = 'cancel']")
    private WebElement CancelButton;

    /*General public methods*/

    public void clickOnGeneralTab(){
        GeneralTab.click();
    }

    public void clickOnInformationTab(){
        InformationTab.click();
    }

    public void clickOnDataTab(){
        DataTab.click();
    }

    public void clickOnPricesTab(){
        PricesTab.click();
    }

    public void clickOnOptionsTab(){
        OptionsTab.click();
    }

    public void clickOnOptionsStockTab(){
        OptionsTab.click();
    }

    public void clickOnSaveButton(){
        SaveButton.click();
    }

    public void clickOnDeleteButton(){
        DeleteButton.click();
    }

    public void clickOnCancelButton(){
        CancelButton.click();
    }


}
