package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Realized to represent PageObject for product page.
 */
public class ProductPage extends Page {

    @FindBy(id = "itemTitle")
    private WebElement productName;

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    public String getProductName() {
        return productName.getText();
    }
}
