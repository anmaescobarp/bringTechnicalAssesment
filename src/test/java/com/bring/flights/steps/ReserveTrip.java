package com.bring.flights.steps;

import com.bring.flights.page_object.SelectionPlaneSeats;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import com.bring.flights.page_object.ReserveTripPage;

import java.util.List;

public class ReserveTrip extends ScenarioSteps {

    // Constructor
    public ReserveTrip(Pages pages) {
        super(pages);
    }

    ReserveTripPage reserveTripPage = new ReserveTripPage(getDriver());
    SelectionPlaneSeats selectionPlaneSeats = new SelectionPlaneSeats(getDriver());

    /**
     * Click on Login Later button
     *
     */
    public void ClickOnLoginLater() {
        reserveTripPage.clickOnLoginLater();
    }

    /**
     * Fill out the passengers info
     *
     * @param passengersInfo Passenger info List
     */
    public void FillOutPassengersInfo(List<List<String>> passengersInfo) throws InterruptedException {
        reserveTripPage.FillOutPassengersInfo(passengersInfo);
    }

    /**
     * Click on Continue to select seats
     *
     */
    public void ClickOnContinueToSelectSeats(){
        reserveTripPage.ClickOnContinue();
    }

    /**
     * Close PopUp to select Seats
     *
     */
    public void ClosePopUpSeats()
    {
        selectionPlaneSeats.ClosePopUpSeats();
    }

    /**
     * Selection of desired seats to passengers
     *
     * @param desiredSeats Desired seats to select on the flights
     */
    public void SelectionDesiredSeats(List<List<String>> desiredSeats)
    {
        System.out.println(desiredSeats);
        for(int i=1; i<desiredSeats.size(); i++){
            System.out.println(desiredSeats.get(i).get(0));
            selectionPlaneSeats.SelectDesiredSeat(desiredSeats.get(i).get(0));
        }
    }

    /**
     * Click on Next Flight
     *
     */
    public void ClickOnNextFlightButton() {
        selectionPlaneSeats.ClickOnNextFlightButton();
    }

    /**
     * Click on Continue button to confirm the flights
     *
     */
    public void ClickOnContinueButton(){
        selectionPlaneSeats.ClickOnContinueButton();
    }

    /**
     * Close Avoid Crowds Pop up to go to confirmation flights page
     *
     */
    public void CloseAvoidCrowsPopUp() throws InterruptedException {
        selectionPlaneSeats.CloseAvoidCrowsPopUp();
    }
}
