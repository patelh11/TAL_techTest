package com.takealot.pages;

import com.takealot.utilities.Utility;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage extends Utility {
    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    HomePage homePage = new HomePage();
    @CacheLookup
    @FindBy(id = "firstname")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "surname")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(id = "email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "email2")
    WebElement retypeEmailField;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "password2")
    WebElement retypePasswordField;

    @CacheLookup
    @FindBy(id = "telno1")
    WebElement modileNumField;

    @CacheLookup
    @FindBy(xpath = "//input[@name='registerButton']")
    WebElement registerButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='welcome']/h3[contains(text(),'Welcome to the TAKEALOT.com family!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'here')]")
    WebElement hereLink;

    public String fName = generateRandomString(6);
    public String lName = generateRandomString(6);
    private String email = generateRandomEmail(7);
    private final String password = "Qwerty@123";
    private final String mobileNum = "07771990889";

    public void userFillsRegistrationPageDetails() {
        log.info("Clicking on register link from home page");
        homePage.clickOnRegisterLink();
        log.info("Entering firstname : " + fName);
        sendTextToElement(firstNameField, fName);
        log.info("Entering lastname : " + lName);
        sendTextToElement(lastNameField, lName);
        log.info("Entering email : " + email);
        sendTextToElement(emailField, email);
        log.info("Retyping email: " + email);
        sendTextToElement(retypeEmailField, email);
        log.info("Entering password : " + password);
        sendTextToElement(passwordField, password);
        log.info("Retyping password: " + password);
        sendTextToElement(retypePasswordField, password);
        log.info("Entering mobile number : " + mobileNum);
        sendTextToElement(modileNumField, mobileNum);
    }

    public void clickOnRegisterButton() {
        log.info("Clicking on register button on register page");
        clickOnElement(registerButton);
    }

    public void clickOnHERElinkToContinueShopping() {
        log.info("Clicking on continue to shopping 'here' link");
        clickOnElement(hereLink);
    }

    public String getWelcomeText() {
        log.info("Getting welcom text " + welcomeText.getText());
        return getTextFromElement(welcomeText);
    }

    public String generateRandomEmail(int length) {
        String emailCharacters = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
        String characters = RandomStringUtils.random(length, emailCharacters);
        String email = characters + "@gmail.com";
        return email;
    }

}
