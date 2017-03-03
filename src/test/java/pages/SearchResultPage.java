package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Realized to represent PageObject for search result page.
 */
public class SearchResultPage extends Page {

    @FindBy(xpath = "//*[@id='ListViewInner']/li")
    private List<WebElement> searchResultList;


    public List<WebElement> getSearchResultList() {
        return searchResultList;
    }

    public void openProductPageBy(int number) {
        searchResultList.get(number - 1).findElement(By.tagName("a")).click();
    }

    public String getProductPageURLBy(int number) {
        return searchResultList.get(number - 1).findElement(By.tagName("a")).getAttribute("href");
    }

    public String getProductNameBy(int number) {
        return searchResultList.get(number - 1).findElement(By.className("vip")).getText();
    }
}