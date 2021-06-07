package com.bring.flights.definitions;

import com.bring.flights.steps.ReserveTrip;
import com.bring.flights.steps.SearchTrips;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import java.util.List;

public class FlightsDefinitions {
    @Steps
    SearchTrips searchTrip;
    @Steps
    ReserveTrip reserveTrip;


    @Given("^Enter the information to find the desired travel$")
    public void EnterTheInformationToFindTheDesiredTravel(DataTable dtFindTrip) throws Throwable {
        List<List<String>> listFindTripInfo = dtFindTrip.asLists();
        searchTrip.goToRyanAirWebPage();
        searchTrip.EnterTripAirports(listFindTripInfo.get(1).get(0).trim(), listFindTripInfo.get(1).get(1).trim());
        searchTrip.ChooseDepartAndReturnDates(listFindTripInfo.get(1).get(2).trim(), listFindTripInfo.get(1).get(3).trim());
        searchTrip.SelectPassengersAmount(listFindTripInfo.get(1).get(4).trim(), listFindTripInfo.get(1).get(5).trim());
        searchTrip.ClickOnSearchButton();
    }

    @And("^Change the departure date and return date from lateral scroll$")
    public void ChangeTheDepartureDateAndReturnDateFromLateralScrol(DataTable dtFlightDates) throws Throwable {
        List<List<String>> listDesiredFlights = dtFlightDates.asLists();
        searchTrip.SelectDepartureFlightDate(listDesiredFlights.get(1).get(0));
        searchTrip.SelectReturnFlightDate(listDesiredFlights.get(1).get(1));
        searchTrip.ClickOnValuesFaresButton();
    }

    @When("^I click on Value Fare$")
    public void IClickOnValueFare() throws Throwable {
        reserveTrip.ClickOnLoginLater();
    }

    @And("^I fill the passengers info out$")
    public void IFillThePassengersInfoOut(DataTable dtPassengersInfo) throws Throwable {
        List<List<String>> listDesiredFlights = dtPassengersInfo.asLists();
        reserveTrip.FillOutPassengersInfo(listDesiredFlights);
        reserveTrip.ClickOnContinueToSelectSeats();
    }

    @Then("^I confirm the desired Seats$")
    public void IConfirmTheDesiredSeats(DataTable dtDesiredSeats) throws Throwable {
        reserveTrip.ClosePopUpSeats();
        List<List<String>> listDesiredFlights = dtDesiredSeats.asLists();
        reserveTrip.SelectionDesiredSeats(listDesiredFlights,true);
        reserveTrip.ClickOnNextFlightButton();
        reserveTrip.SelectionDesiredSeats(listDesiredFlights, false);
        reserveTrip.ClickOnContinueButton();
    }

    @And("^The user is taken the to the confirmation flights page$")
    public void TheUserIsTakenTheToTheConfirmationFlightsPage() throws Throwable {
        reserveTrip.CloseAvoidCrowsPopUp();
    }
}
