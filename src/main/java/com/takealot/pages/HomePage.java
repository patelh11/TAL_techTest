package com.takealot.pages;

import com.takealot.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerLink;

    @FindBy(xpath = "//button[contains(text(),'Got it')]")
    WebElement cookiesOK;

    public String userIsOnHomepageBeforeRegister() {
        clickOnElement(cookiesOK);
        log.info("Clicking on OK cookies");
        return driver.getTitle();
    }

    public void clickOnRegisterLink() {
        System.out.println(driver.getTitle());
        clickOnElement(registerLink);
        log.info("Clicking on register link");

    }

}
