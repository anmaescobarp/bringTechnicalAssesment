package com.bring.flights.page_object;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SelectionPlaneSeats extends PageObject {

    private WebDriverWait wait;
    private WebDriver webDriver;
    private JavascriptExecutor javaScriptObject;

    // Constructor
    public SelectionPlaneSeats(WebDriver driver) {
        super(driver);
        wait= new WebDriverWait(driver, 9);
        webDriver=driver;
        javaScriptObject = (JavascriptExecutor) webDriver;
    }

    //Static Locators
    // Spinner
    By spinner = By.xpath("//ry-spinner[contains(@class,\"app-spinner\")]//div[contains(@class,\"spinner__icon\")]");
    //PopUp Family seating
    By popUpButton = By.cssSelector("button[class*=\"seats-modal__cta\"]");
    //Next Flight Button
    By nextFlightButton = By.cssSelector("button[data-ref=\"seats-action__button-next\"]");
    //Continue button
    By continueButton = By.cssSelector("button[data-ref=\"seats-action__button-continue\"]");
    // Avoid Crows Pop Up
    By avoidCrowsPopUp = By.cssSelector("div[class*=\"enhanced-takeover-beta\"]:first-child button");
    // Spinner seats
    By spinnerSeats = By.xpath("//div[contains(@class,\"seats-container__spinner\")]//div[contains(@class,\"spinner__icon\")]");

    //Methods

    public void ClosePopUpSeats(){
        wait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(spinner)));
        WebElement popUpButtonElement = webDriver.findElement(popUpButton);
        wait.until(ExpectedConditions.visibilityOf(popUpButtonElement));
        wait.until(ExpectedConditions.elementToBeClickable(popUpButton));
        popUpButtonElement.click();
        wait.until(ExpectedConditions.invisibilityOf(popUpButtonElement));
    }

    public void WaitUntilSpinnerSeatsLost()
    {
        wait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(spinnerSeats)));
    }

    public void SelectDesiredSeat (String desiredSeat){
        By desiredSeatToSelect = By.id("seat-"+desiredSeat.toUpperCase(Locale.ROOT));
        WebElement desiredSeatElement = webDriver.findElement(desiredSeatToSelect);
        wait.until(ExpectedConditions.presenceOfElementLocated(desiredSeatToSelect));
        wait.until(ExpectedConditions.elementToBeClickable(desiredSeatToSelect));
        desiredSeatElement.click();
    }

    public void ClickOnNextFlightButton() {
        WebElement nextFlightButtonElement = webDriver.findElement(nextFlightButton);
        javaScriptObject.executeScript("arguments[0].scrollIntoView(true);",nextFlightButtonElement);
        wait.until(ExpectedConditions.visibilityOf(nextFlightButtonElement));
        wait.until(ExpectedConditions.elementToBeClickable(nextFlightButton));
        nextFlightButtonElement.click();
    }

    public void ClickOnContinueButton(){
        WebElement continueButtonElement = webDriver.findElement(continueButton);
        javaScriptObject.executeScript("arguments[0].scrollIntoView(true);",continueButtonElement);
        wait.until(ExpectedConditions.visibilityOf(continueButtonElement));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButtonElement.click();
    }

    public void CloseAvoidCrowsPopUp() {
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(avoidCrowsPopUp)));
        wait.until(ExpectedConditions.elementToBeClickable(avoidCrowsPopUp));
        webDriver.findElement(avoidCrowsPopUp);
    }



}
