package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * PageObject for common logic of all pages.
 */
public abstract class Page {

    @FindBy(id = "gh-shop-a")
    private WebElement shopByCategoryButton;

    @FindBy(xpath = "//*[@_sp='m570.l3652']")
    private WebElement cellPhonesAndAccessoriesLink;

    @FindBy(id = "gh-ac")
    private WebElement searchInputField;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    public void clickShopByCategoryButton() {
        shopByCategoryButton.click();
    }

    public void clickCellPhonesAndAccessoriesLink() {
        cellPhonesAndAccessoriesLink.click();
    }

    private void inputSearchValue(String value) {
        searchInputField.clear();
        searchInputField.sendKeys(value);
    }

    private void clickSearchButton() {
        searchButton.click();
    }

    /**
     * Searching for specified query.
     *
     * @param value specified query
     */
    public void searchFor(String value) {
        inputSearchValue(value);
        clickSearchButton();
    }
}
