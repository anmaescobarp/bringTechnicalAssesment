@BookFlights
Feature: Book Flights on Ryanair.com

  Scenario:
    Given Enter the information to find the desired travel
    |AirportFrom|  AirportTo   |DepartureDate|ReturnDate|AmountAdults|AmountChildren|
    |  Lisbon   |Paris Beauvais| 2021-06-06  |2021-07-20|     2      |      1       |
    And Change the departure date and return date from lateral scroll
    |DepartureDate|ReturnDate|
    | 2021-08-06 |2021-09-22|
    When I click on Value Fare
    And I fill the passengers info out
    |IsAdult|Title|FirstName|LastName|
    |Yes    |Mrs  |Sonia    |Pereira |
    |Yes    |Mr   |Diogo    |Betttencourt|
    |No     |     |Ines     |Marcal      |
    Then I confirm the desired Seats
      |Seats|
      |09D|
      |09E|
      |09F|
    And The user is taken the to the confirmation flights page