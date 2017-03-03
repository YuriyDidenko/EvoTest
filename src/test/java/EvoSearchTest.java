import exceptions.InvalidBrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CellPhonesPage;
import pages.MainPage;
import pages.ProductPage;
import pages.SearchResultPage;

import java.util.List;


public class EvoSearchTest {

    private WebDriver driver;
    private MainPage mainPage;
    private CellPhonesPage cellPhonesPage;
    private SearchResultPage searchResultPage;
    private ProductPage productPage;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser) throws InvalidBrowserException{
        if ("firefox".equalsIgnoreCase(browser)) {
            driver = new FirefoxDriver();
        } else if ("chrome".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            throw new InvalidBrowserException("Wrong parameter for browser.");
        }

        mainPage = PageFactory.initElements(driver, MainPage.class);
        cellPhonesPage = PageFactory.initElements(driver, CellPhonesPage.class);
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(MainPage.URL);
    }

    @Test
    @Parameters({"model", "elementNumber"})
    public void testSearch(String model, int elementNumber) {

        mainPage.clickShopByCategoryButton();
        mainPage.clickCellPhonesAndAccessoriesLink();

        cellPhonesPage.searchFor(model);

        List<WebElement> resultList = searchResultPage.getSearchResultList();
        Assert.assertTrue(resultList.size() > 0);

        String searchResultProductPageURL = searchResultPage.getProductPageURLBy(elementNumber);
        String searchResultProductName = searchResultPage.getProductNameBy(elementNumber);

        searchResultPage.openProductPageBy(elementNumber);

        String productPageURL = productPage.getPageURL();
        String productName = productPage.getProductName();

        Assert.assertEquals(searchResultProductPageURL, productPageURL);
        Assert.assertEquals(searchResultProductName, productName);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
