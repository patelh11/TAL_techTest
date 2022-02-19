package com.takealot.pages;

import com.takealot.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class SearchItemPage extends Utility {
    private static final Logger log = LogManager.getLogger(SearchItemPage.class.getName());

    public SearchItemPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "search")
    WebElement searchBar;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickSearch;

    @FindBy(id = "_undefined")
    WebElement brandsSearchField;

    @FindBy(xpath = "//div[@id='scroll-container']")
    WebElement brandResult;

    @FindBy(xpath = "//div[@class='grid-container search-listings-module_search-listings_2Lw_d']//div[@class='cell small-3']//div//a/h4")
    List<WebElement> allBrandItems;

    @FindBy(xpath = "//button[contains(text(),'Load More')]")
    WebElement loadMoreButton;

    @FindBy(xpath = "//a[normalize-space()='Add to Cart']")
    WebElement addCartBtn;

    @FindBy(xpath = "//div[@class='mini-cart mini-cart-module_mini-cart_3_CNC']//button")
    WebElement basketButton;

    public void searchForItemInSearchBar(String searchItem) {
        searchBar.clear();
        log.info("Entering item to search : " + searchItem + " in search bar");
        sendTextToElement(searchBar, searchItem);
        log.info("Click on search icon");
        clickOnElement(clickSearch);
    }

    public void searchForBrandInField(String brand) {
        // log.info("Entering brand name: " + brand);
        sendTextToElement(brandsSearchField, brand);
    }

    public void selectBrandNameBox() {
        waitUntilVisibilityOfElementLocated(By.xpath("//div[@id='scroll-container']"), 10);
        log.info("Ticking on matching brand name as searched");
        clickOnElement(brandResult);
    }

    public void pickTheProduct(String item) {
        boolean trigger = true;
        while (trigger) {
            try {
                List<WebElement> productList = allBrandItems;
                for (WebElement product : productList) {
                    if (product.getText().contains(item)) {

                        moveToElementAndClick(product);
                        //  Actions actions = new Actions(driver);
                        //actions.moveToElement(product).click().build().perform();
                        //product.click();
                        trigger = false;
                        break;
                    }
                }
                if (!trigger) {
                    break;
                }
                scrollPageBy("8865");
                log.info("Clicking on load more button");
                clickOnElement(loadMoreButton);
            } catch (StaleElementReferenceException e) {
            }
        }
    }

    public void userClickOnAddToCartButton() {
        String parentHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();

        for (String handle : allHandles) {
            if (!handle.equals(parentHandle)) {
                log.info("Switching to child window");
                driver.switchTo().window(handle);
                moveToElementAndClick(addCartBtn);
                log.info("Clicking on add to cart button");
                driver.close();
                break;
            }
        }
        log.info("Switching to parent window");
        driver.switchTo().window(parentHandle);
    }


    public void refreshThePage() {
        log.info("Refreshing the search page");
        driver.navigate().refresh();
    }

    public void userClickOnBasketButton() {
        log.info("Clicking on basket icon on user account page");
        clickOnElement(basketButton);
    }

}


