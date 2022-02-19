package com.takealot.steps;

import com.takealot.pages.HomePage;
import com.takealot.pages.RegisterPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class NewRegisterSteps {
    @Given("^User is on homepage of website$")
    public void userIsOnHomepageOfWebsite() {
        String actualTitle = "Takealot.com: Online Shopping | SA's leading online store";
        String expTitle = new HomePage().userIsOnHomepageBeforeRegister();
        Assert.assertEquals(actualTitle, expTitle);
    }

    @When("^User fill registration page details$")
    public void userFillRegistrationPageDetails() {
        new RegisterPage().userFillsRegistrationPageDetails();
    }


    @And("^User clicks on Register Button$")
    public void userClicksOnRegisterButton() {
        new RegisterPage().clickOnRegisterButton();
    }

    @Then("^User should get welcome text <\"([^\"]*)\">$")
    public void userShouldGetWelcomeText(String text) {
        String expText = text;
        String actText = new RegisterPage().getWelcomeText();
        Assert.assertEquals(expText, actText);
    }

    @And("^User should continue shopping on user account page$")
    public void userShouldContinueShoppingOnUserAccountPage() {
        new RegisterPage().clickOnHERElinkToContinueShopping();

    }
}
