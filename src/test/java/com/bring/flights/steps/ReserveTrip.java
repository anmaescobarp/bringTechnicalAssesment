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
     * Enter Trip Airports (From - To)
     *
     */
    public void ClickOnLoginLater() {
        reserveTripPage.clickOnLoginLater();
    }

    /**
     * Enter Trip Airports (From - To)
     *
     * @param passengersInfo Departure Airport
     */
    public void FillOutPassengersInfo(List<List<String>> passengersInfo) throws InterruptedException {
        reserveTripPage.FillOutPassengersInfo(passengersInfo);
    }

    public void ClickOnContinueToSelectSeats(){
        reserveTripPage.ClickOnContinue();
    }

    public void ClosePopUpSeats()
    {
        selectionPlaneSeats.ClosePopUpSeats();
    }

    public void SelectionDesiredSeats(List<List<String>> desiredSeats)
    {
        System.out.println(desiredSeats);
        for(int i=1; i<desiredSeats.size(); i++){
            System.out.println(desiredSeats.get(i).get(0));
            selectionPlaneSeats.SelectDesiredSeat(desiredSeats.get(i).get(0));
        }
    }

    public void ClickOnNextFlightButton() {
        selectionPlaneSeats.ClickOnNextFlightButton();
    }

    public void ClickOnContinueButton(){
        selectionPlaneSeats.ClickOnContinueButton();
    }

    public void CloseAvoidCrowsPopUp() throws InterruptedException {
        selectionPlaneSeats.CloseAvoidCrowsPopUp();
    }
}
