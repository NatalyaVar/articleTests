import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ExampleElements {
    Actions actionList = new Actions(driver);
    public static WebDriver driver = new ChromeDriver();
    JavascriptExecutor je = (JavascriptExecutor) driver;    //JavascriptExecutor нужен для выполнения скриптов (например, скроллить страницу, сделать скриншот)

    int n = 1; //число секунд, которое будет длится явное ожидание

    String homeUrl = "https://7745.by/";
    String productAvailable = "В наличии";

    @FindBy(how = How.CSS, css = "#search")
    WebElement catalogSearch;
    @FindBy(how = How.CSS, css = "button.btn.btn-search")
    WebElement btnSearch;
    @FindBy(how = How.CSS, css = "a.item-block_name.item-block_name--tile")
    WebElement nameItem;
    @FindBy(how = How.CSS, css = "span.item-block_quantity.popup-class-trigger")
    WebElement itemAvailability;
    @FindBy(how = How.CSS, css = "button.btn.btn-orange.btn-buy")
    WebElement btnBuy;
    @FindBy(how = How.XPATH, xpath = "//span [contains(text(), '117.263')]")
    WebElement vacuumCleanerClick;
    @FindBy(how = How.CSS, css = "#panel div:nth-child(2) > div > div.catalog-item__top-container img")
    WebElement secondProduct;
    @FindBy(how = How.CSS, css = "#content > div.product > h1")
    WebElement productHead;
    @FindBy(how = How.CSS, css = "#cart-link div.header-icon__icon > div")
    WebElement cartLink;
    @FindBy(how = How.CSS, css = "#js-cart-products div.text.text--fix-h-60")
    WebElement productInCart;
    @FindBy(how = How.CSS, css = "button.do-cart-remove.order-table__text-button")
    WebElement btnRemove;
    @FindBy(how = How.CSS, css = "#panel div.summary--content div.dot-leaders_item.dot-leaders_item--pt-pos-rltv > div.dot-leaders_value")
    WebElement summaryOrder;
}

