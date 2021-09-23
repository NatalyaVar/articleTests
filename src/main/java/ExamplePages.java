import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import com.codeborne.selenide.WebDriverRunner;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ExamplePages extends ExampleElements {
    public ExamplePages() throws IOException {
    }

    private WebDriverWait wait = new WebDriverWait(driver, n);
    JavascriptExecutor je = (JavascriptExecutor) driver;    //JavascriptExecutor нужен для выполнения скриптов (например, скроллить страницу, сделать скриншот)

    @BeforeClass
    public static void setUp() throws IOException {
        try {
            WebDriverRunner.setWebDriver(driver);
            driver.manage().window().maximize();    //чтобы максимизировать браузер.
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //Время неявного ожидания = 2 секунды
            try {
                //Перейти на домашнюю страницу
                driver.navigate().to("https://7745.by/");
                driver.manage().window().maximize();
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void DDD() throws IOException {
        driver.quit(); //завершения работы драйвера после выполнения теста
    }


    public void orderVacuumCleaner() throws IOException {
        driver.navigate().to(homeUrl);
//       В поле поиска ввести "Пылесос", нажать Поиск
        $(catalogSearch).shouldBe(visible).sendKeys("Пылесос");
        $(btnSearch).shouldBe(visible).click();

// Проверить, что открыласть страница https://7745.by/search?keys=Пылесос
        String URL = driver.getCurrentUrl();
        System.out.println("Переход на страницу  " + URL);
        Assert.assertEquals(URL, "https://7745.by/search?keys=%D0%9F%D1%8B%D0%BB%D0%B5%D1%81%D0%BE%D1%81");
        //Выбрать второй товар на странице
        $(secondProduct).shouldBe(visible).click();
        //Проверить, что товар есть в наличии
        String productAvailablePage = $(itemAvailability).getText().trim();
        System.out.println("productAvailablePage     " + productAvailablePage);
        Assert.assertEquals(productAvailable, productAvailablePage);
        //Запомнить название товара
        String productHeadTxt = productHead.getText().trim();
        System.out.println("Выбранный товар    " + productHeadTxt);
        sleep(2000);
        //Отправить товар в корзину
        $(btnBuy).shouldBe(visible).click();
        sleep(2000);
        //Перейти в корзину
        $(cartLink).shouldBe(visible).click();
        //Проверить, что название товара в корзине = названию товара, который отправлен в корзину
        String productInCartTxt = productInCart.getText().trim();
        Assert.assertEquals(productHeadTxt, productInCartTxt);
        //Проверить, что сумма заказа не равно 0
        String sumOrderTxt = $(summaryOrder).shouldBe(visible).getText();
        Assert.assertNotEquals(sumOrderTxt, "0,00 р.");
        //Удалить товар из корзины
        $(btnRemove).shouldBe(visible).click();
        sleep(2000);//ожидание 2 секунды. (Нужно добавить проверку, что элемент изменился)
        //Проверить, что корзина пуста - сумма заказа = 0
        String sumOrderTxtZero = $(summaryOrder).shouldBe(visible).getText();
        Assert.assertEquals(sumOrderTxtZero, "0,00 р.");
    }

}
