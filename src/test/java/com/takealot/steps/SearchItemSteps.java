package com.takealot.steps;

import com.takealot.pages.CartPage;
import com.takealot.pages.SearchItemPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class SearchItemSteps {
    @And("^User search for <\"([^\"]*)\"> in the search bar$")
    public void userSearchForInTheSearchBar(String searchItem) {
        new SearchItemPage().searchForItemInSearchBar(searchItem);
    }

    @And("^User select <\"([^\"]*)\"> brand$")
    public void userSelectBrand(String brandName) {
        new SearchItemPage().searchForBrandInField(brandName);
        new SearchItemPage().selectBrandNameBox();
    }

    @And("^User select \"([^\"]*)\"$")
    public void userSelect(String item) {
        new SearchItemPage().pickTheProduct(item);
    }

    @And("^User adds product to cart$")
    public void userAddsProductToCart() {
        new SearchItemPage().userClickOnAddToCartButton();
    }

    @And("^User click on basket button$")
    public void userClickOnCartButtonFromHomepage() {
        new SearchItemPage().userClickOnBasketButton();
    }

    @And("^User refresh the homepage$")
    public void userRefreshTheHomepage() {
        new SearchItemPage().refreshThePage();
    }

    @Then("^User can see the product/s inside the basket/cart$")
    public void userCanSeeTheProductSInsideTheBasketCart(DataTable table) {
        List<String> itemList = table.asList(String.class);
        for (String s : itemList) {
            Assert.assertTrue(new CartPage().isBasketContainsTheItem(s));
        }
    }

}
