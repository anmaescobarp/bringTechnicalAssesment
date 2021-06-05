package com.bring.flights.page_object;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectionPlaneSeats extends PageObject {

    private WebDriverWait wait;
    private WebDriver webDriver;
    private JavascriptExecutor javaScriptObject;

    // Constructor
    public SelectionPlaneSeats(WebDriver driver) {
        super(driver);
        wait= new WebDriverWait(driver, 8);
        webDriver=driver;
        javaScriptObject = (JavascriptExecutor) webDriver;
    }

    //Static Locators
    //PopUp Family seating
    By popUpButton = By.cssSelector("button[class*=\"seats-modal__cta\"]");
    //Next Flight Button
    By nextFlightButton = By.cssSelector("button[data-ref=\"seats-action__button-next\"]");
    //Continue button
    By continueButton = By.cssSelector("button[data-ref=\"seats-action__button-continue\"]");
    // Avoid Crows Pop Up
    By avoidCrowsPopUp = By.cssSelector("div[class*=\"enhanced-takeover-beta\"]:first-child button");


    //Methods

    public void ClosePopUpSeats(){
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(popUpButton)));
        wait.until(ExpectedConditions.elementToBeClickable(popUpButton));
        webDriver.findElement(popUpButton).click();
    }

    public void SelectDesiredSeat (String desiredSeat){
        By desiredSeatToSelect = By.id("seat-"+desiredSeat); // #seat-30D
        WebElement desiredSeatElement = webDriver.findElement(desiredSeatToSelect);
        wait.until(ExpectedConditions.invisibilityOf(desiredSeatElement));
        wait.until(ExpectedConditions.visibilityOf(desiredSeatElement));
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
