package com.bring.flights.page_object;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

// Url which start automation testing
@DefaultUrl("https://www.ryanair.com/gb/en")
public class FindTrips extends PageObject{
    private WebDriverWait wait;
    private WebDriver webDriver;

    // Constructor
    public FindTrips(WebDriver driver) {
        super(driver);
        wait= new WebDriverWait(driver, 8);
        webDriver=driver;
    }

    // Elements locators


    // Cookies Popup Button
    By cookiesAcceptButton = By.cssSelector("#cookie-popup-with-overlay .cookie-popup-with-overlay__button");
    // Select Trip From option
    By tripFromTextBox = By.id("input-button__departure");
    //Select Trip To option
    By tripToTextBox = By.id("input-button__destination");
    //From Airport option
    By fromAirportOption = By.cssSelector("#ry-tooltip-1 .list__airports-scrollable-container>fsw-airport-item");
    //To Airport option
    By toAirportOption = By.cssSelector("#ry-tooltip-3 fsw-airport-item");
    //Depart date field
    By departDateField = By.cssSelector("fsw-input-button[uniqueid=\"dates-from\"]");
    //Return date field
    By returnDateField = By.cssSelector("fsw-input-button[uniqueid=\"dates-to\"]");
    // Passenger Field
    By passengersField = By.cssSelector("fsw-input-button[uniqueid=\"passengers\"]");
    // Adults passengers counter
    By adultsPassengersCounter = By.cssSelector("ry-counter[data-ref=\"passengers-picker__adults\"] div[data-ref=\"counter.counter__increment\"]");
    // Adults Passengers Number
    By adultsPassengersNumber = By.cssSelector("ry-counter[data-ref=\"passengers-picker__adults\"] div[data-ref=\"counter.counter__value\"]");
    // Children passengers counter
    By childrenPassengersCounter = By.cssSelector("ry-counter[data-ref=\"passengers-picker__children\"] div[data-ref=\"counter.counter__increment\"]");
    // Children Passengers Number
    By childrenPassengersNumber = By.cssSelector("ry-counter[data-ref=\"passengers-picker__children\"] div[data-ref=\"counter.counter__value\"]");
    // Search button
    By searchButton = By.cssSelector("button[data-ref=\"flight-search-widget__cta\"]");


    //Methods

    /**
     * Date picker selection
     *
     * @param date desired date to select on depart field or return date
     */
    private void selectDesiredDate(String date)
    {
        By datePicker = By.cssSelector("div[data-id=\"" + date + "\"]");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(datePicker));
        webDriver.findElement(datePicker).click();
    }
    /**
     * Get Current URL
     */
    public void checkCurrentUrl(){
        assertThat(webDriver.getTitle(), containsString("Official Ryanair website"));
    }

    /**
     * Accept Cookies Popup
     */
    public void acceptCookiesPopUp() {
        wait.until(ExpectedConditions.presenceOfElementLocated(cookiesAcceptButton));
        webDriver.findElement(cookiesAcceptButton).click();
    }
    /**
     * Select Departure Airport --> from
     * @param airport Airport to select
     */
    public void selectDepartureAirport(String airport) {
        WebElement departureAirportTextBox = webDriver.findElement(tripFromTextBox);
        departureAirportTextBox.click();
        departureAirportTextBox.clear();
        webDriver.findElement(tripFromTextBox).sendKeys(airport);
        wait.until(ExpectedConditions.elementToBeClickable(fromAirportOption));
        webDriver.findElement(fromAirportOption).click();
    }
    /**
     * Select Return Airport --> To
     * @param airport Airport to select
     */
    public void selectReturnAirport(String airport) {
        WebElement returnAirportTextBox = webDriver.findElement(tripToTextBox);
        returnAirportTextBox.click();
        returnAirportTextBox.clear();
        webDriver.findElement(tripToTextBox).sendKeys(airport);
        wait.until(ExpectedConditions.elementToBeClickable(toAirportOption));
        webDriver.findElement(toAirportOption).click();
    }
    /**
     *Choose Depart date
     * @param date Date to select
     */
    public void chooseDepartDate(String date)  {
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(departDateField)));
        wait.until(ExpectedConditions.elementToBeClickable(departDateField));
        webDriver.findElement(departDateField).click();
        selectDesiredDate(date);
    }
    /**
     *Choose Return date
     * @param date Date to select
     */
    public void chooserReturnDate(String date) {
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(returnDateField)));
        wait.until(ExpectedConditions.elementToBeClickable(returnDateField));
        webDriver.findElement(returnDateField).click();
        selectDesiredDate(date);
    }
    /**
     * Choose Adults Passenger number in the trip
     * @param number number of adults to select
     */
    public void chooseAdultsNumber(String number){
        webDriver.findElement(passengersField).click();
        wait.until(ExpectedConditions.elementToBeClickable(adultsPassengersCounter));
        String numberSelectedAdults = webDriver.findElement(adultsPassengersNumber).getText();
        if(numberSelectedAdults!=number){webDriver.findElement(adultsPassengersCounter).click();}
    }
    /**
     * Choose Children Passenger number in the trip
     * @param number number of children to select
     */
    public void chooseChildrenNumber(String number){
        webDriver.findElement(passengersField).click();
        wait.until(ExpectedConditions.elementToBeClickable(childrenPassengersCounter));
        String numberSelectedChildren = webDriver.findElement(childrenPassengersNumber).getText();
        if(numberSelectedChildren!=number){webDriver.findElement(childrenPassengersCounter).click();}
    }
    /**
     *Click on Search Button
     */
    public void clickOnSearchButton(){
        webDriver.findElement(searchButton).click();
    }
}

