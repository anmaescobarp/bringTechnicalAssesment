package com.bring.flights.steps;

import com.bring.flights.page_object.FindTrips;
import com.bring.flights.page_object.SelectTrip;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchTrips extends ScenarioSteps {

    FindTrips findTripsPage = new FindTrips(getDriver());
    SelectTrip selectTrip = new SelectTrip(getDriver());


    // Constructor
    public SearchTrips(Pages pages) {
        super(pages);
    }

    // Methods

    /**
     * Go to Ryanair webpage
     */
    public void goToRyanAirWebPage() {
        findTripsPage.open();
        findTripsPage.acceptCookiesPopUp();
        findTripsPage.checkCurrentUrl();
    }

    /**
     * Enter Trip Airports (From - To)
     *
     * @param departAirport Departure Airport
     * @param returnAirport Return Airport
     */
    public void EnterTripAirports(String departAirport, String returnAirport) {
        findTripsPage.selectDepartureAirport(departAirport);
        findTripsPage.selectReturnAirport(returnAirport);
    }

    /**
     * Choose Depart date and return date
     *
     * @param departDate Depart date
     * @param returnDate Return date
     */
    public void ChooseDepartAndReturnDates(String departDate, String returnDate) {
        findTripsPage.chooseDepartDate(departDate);
        findTripsPage.chooserReturnDate(returnDate);
    }
    /**
     * Select Passengers amount
     *
     * @param adultsAmount Adults Amount to select
     * @param childrenAmount children Amount to select
     */
    public void SelectPassengersAmount(String adultsAmount, String childrenAmount) {
        findTripsPage.chooseAdultsNumber(adultsAmount);
        findTripsPage.chooseChildrenNumber(childrenAmount);
    }
    /**
     * Click on search button
     */
    public void ClickOnSearchButton() {
        findTripsPage.clickOnSearchButton();
    }
    /**
     * Select Departure Flight date
     */
    public void SelectDepartureFlightDate(String date) {
        selectTrip.chooseDepartureFlight(date);
    }
    /**
     * Select Return Flight date
     */
    public void SelectReturnFlightDate(String date){
        selectTrip.chooseReturnFlight(date);
    }
    /**
     * Click on Values fares button
     */
    public void ClickOnValuesFaresButton() {
        selectTrip.clickOnValueFaresButton();
    }


}
