package com.takealot.pages;

import com.takealot.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends Utility {

    private static final Logger log = LogManager.getLogger(CartPage.class.getName());

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='grid-x']//h3")
    List<WebElement> totalItemInCart;

    public boolean isBasketContainsTheItem(String item) {
        log.info("Checking if basket contains intended products");
        boolean contains = false;
        for (WebElement e : totalItemInCart) {
            if (e.getText().contains(item)) {
                contains = true;
            }
        }
        return contains;
    }


}
