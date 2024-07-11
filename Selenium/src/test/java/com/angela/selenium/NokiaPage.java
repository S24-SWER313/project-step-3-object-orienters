package com.angela.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NokiaPage {

    private final WebDriver driver;
    private final By addToBagBtnDialog = By.cssSelector("dialog.css-6n4au2.eyp6vha3");
    private final By checkoutBtn = By.cssSelector("button.e8w5g9f4.css-nydlvm.e1af6ugw0");
    private final By unlockedCarrier = By.cssSelector("label.css-1ixugng.e109q1kf2");
    private final By buyFromBtns = By.partialLinkText("Buy from");
    private final By emailInput = By.cssSelector("input.form-input.optimizedCheckout-form-input.floating-input");
    private final By checkoutContactContinueBtn = By.id("checkout-customer-continue");
    private final By checkoutShippingContinueBtn = By.id("checkout-shipping-continue");
    private final By checkoutBillingContinueBtn = By.id("checkout-billing-continue");
    private final By checkoutPaymentContinueBtn = By.id("checkout-payment-continue");
    private final By shippingFirstName = By.id("firstNameInput");
    private final By shippingLastName = By.id("lastNameInput");
    private final By shippingPhone = By.id("phoneInput");
    private final By shippingAddress = By.id("addressLine1Input");
    private final By shippingCity = By.id("cityInput");
    private final By shippingState = By.id("provinceCodeInput");
    private final By shippingZip = By.id("postCodeInput");
    private final By shippingCountry = By.id("countryCodeInput");
    private final By shippingContinueBtn = By.id("checkout-shipping-continue");
    private final By billingSameAsShipping = By.id("div.dtc-checkbox");
    private final By CardNumberInput = By.cssSelector("span.adyen-checkout__input.adyen-checkout__input--large.adyen-checkout__card__cardNumber__input.CardInput-module_adyen-checkout__input__11tlB");
    private final By cardExpiryInput = By.cssSelector("span.adyen-checkout__input.adyen-checkout__input--small.adyen-checkout__card__exp-date__input.CardInput-module_adyen-checkout__input__11tlB");
    private final By cardCvcInput = By.cssSelector("span.adyen-checkout__input.adyen-checkout__input--small.adyen-checkout__card__cvc__input.CardInput-module_adyen-checkout__input__11tlB");
    private final By cardHolderInput = By.id("adyen-checkout-holderName-1720721040006");
    private final By CreditCardOption = By.id("radio-adyenv3-scheme");
    private final By PaypalOption = By.id("radio-paypalcommerce");
    private final By googlePayOption = By.id("radio-googlepayadyenv3");
    private final By checkoutPaypalContinueBtn = By.cssSelector("div.paypal-button paypal-button-number-0.paypal-button-layout-horizontal.paypal-button-number-single.paypal-button-env-production.paypal-button-color-black.paypal-button-text-color-white paypal-logo-color-white.paypal-button-shape-rect");
    public NokiaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToBagBtnDialog() {
        driver.findElement(addToBagBtnDialog).click();
    }

    public void clickCheckoutBtn() {
//        clickAddToBagBtnDialog();
        driver.findElement(checkoutBtn).click();
    }

    public void clickUnlockedCarrier() {
        driver.findElement(unlockedCarrier).click();
    }


    public int BuyFromBtnsCount() {
        return driver.findElements(buyFromBtns).size();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickCheckoutContactContinueBtn() {
        driver.findElement(checkoutContactContinueBtn).click();
    }

    public void clickCheckoutShippingContinueBtn() {
        driver.findElement(checkoutShippingContinueBtn).click();
    }

    public void clickCheckoutBillingContinueBtn() {
        driver.findElement(checkoutBillingContinueBtn).click();
    }

    public void clickCheckoutPaymentContinueBtn() {
        driver.findElement(checkoutPaymentContinueBtn).click();
    }

    public void enterShippingFirstName(String firstName) {
        driver.findElement(shippingFirstName).sendKeys(firstName);
    }

    public void enterShippingLastName(String lastName) {
        driver.findElement(shippingLastName).sendKeys(lastName);
    }

    public void enterShippingPhone(String phone) {
        driver.findElement(shippingPhone).sendKeys(phone);
    }

    public void enterShippingAddress(String address) {
        driver.findElement(shippingAddress).sendKeys(address);
    }

    public void enterShippingCity(String city) {
        driver.findElement(shippingCity).sendKeys(city);
    }

    public void enterShippingState(String state) {
        driver.findElement(shippingState).sendKeys(state);
    }

    public void enterShippingZip(String zip) {
        driver.findElement(shippingZip).sendKeys(zip);
    }

    public void enterShippingCountry(String country) {
        driver.findElement(shippingCountry).sendKeys(country);
    }

    public void clickShippingContinueBtn() {
        driver.findElement(shippingContinueBtn).click();
    }

    public void clickBillingSameAsShipping() {
        driver.findElement(billingSameAsShipping).click();
    }


    public void enterCardNumber(String cardNumber) {
        driver.findElement(CardNumberInput).sendKeys(cardNumber);
    }

    public void enterCardExpiry(String cardExpiry) {
        driver.findElement(cardExpiryInput).sendKeys(cardExpiry);
    }

    public void enterCardCvc(String cardCvc) {
        driver.findElement(cardCvcInput).sendKeys(cardCvc);
    }

    public void enterCardHolder(String cardHolder) {
        driver.findElement(cardHolderInput).sendKeys(cardHolder);
    }

    public void clickCreditCardOption() {
        driver.findElement(CreditCardOption).click();
    }

    public void clickPaypalOption() {
        driver.findElement(PaypalOption).click();
    }

    public void clickGooglePayOption() {
        driver.findElement(googlePayOption).click();
    }

    public void clickCheckoutPaypalContinueBtn() {
        driver.findElement(checkoutPaypalContinueBtn).click();
    }
}
