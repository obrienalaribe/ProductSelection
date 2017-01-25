package com.sky.acceptance;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ProductSelectionPageAcceptanceTest {
    public static final String PRODUCT_SELECTION_PAGE = "http://localhost:4567/products";

    private static ChromeDriverService service;
    private WebDriver driver;
    static Wait<WebDriver> wait;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Applications/chromedriver"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @Before
    public void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
        wait = new WebDriverWait(driver, 1000);

    }


    @Test
    public void customerCanAddAndRemoveProductsInBasket() throws Exception {
        givenACustomerWithCustomerID();
        whenTheySelectAFewProducts();
        thenTheSelectedProductShouldBeAddedToTheBasket();
        whenTheyUnselectAProduct();
        thenTheUnSelectedProductShouldBeRemovedFromTheBasket();
    }

    @Test
    public void customerCanCheckoutProducts() throws Exception {
        givenACustomerWithCustomerID();
        whenTheySelectAFewProducts();
        thenTheSelectedProductShouldBeAddedToTheBasket();
        whenTheyCheckout();
        thenTheyShouldBePostedToTheConfirmationPageWithTheirCustomerIdAndSelectedProducts();
    }



    @After
    public void quitDriver() {
        driver.quit();
    }

    private void givenACustomerWithCustomerID(){
        driver.get(PRODUCT_SELECTION_PAGE);
        driver.manage().addCookie(new Cookie("customerID", "123"));
        assertEquals("Sky- Product Selection", driver.getTitle());

    }

    private void whenTheySelectAFewProducts(){
        assertEquals(0, basketContent().size());
        WebElement skyNews = driver.findElement(By.xpath("//*[@id=\"news\"]/div/label/input"));
        WebElement skySportsNews = driver.findElement(By.xpath("//*[@id=\"news\"]/div/div/label/input"));

        skyNews.click();
        skySportsNews.click();
    }

    private void thenTheSelectedProductShouldBeAddedToTheBasket(){
        assertEquals(2, basketContent().size());
    }

    private void whenTheyUnselectAProduct(){
        assertEquals(2, basketContent().size());
        WebElement skyNews = driver.findElement(By.xpath("//*[@id=\"news\"]/div/label/input"));

        skyNews.click();
    }

    private void thenTheUnSelectedProductShouldBeRemovedFromTheBasket() {
        assertEquals(1, basketContent().size());
    }


    private void whenTheyCheckout(){
        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();
    }

    private void thenTheyShouldBePostedToTheConfirmationPageWithTheirCustomerIdAndSelectedProducts() {
        assertEquals("Sky- Product Confirmation",driver.getTitle());
        String customerID = driver.findElement(By.id("c_id")).getText();
        assertEquals("123", customerID);
    }

    private List<WebElement> basketContent(){
        WebElement basket = driver.findElement(By.id("basket"));

        return basket.findElements(By.xpath(".//*"));
    }



}
