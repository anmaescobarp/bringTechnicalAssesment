package com.bring.flights.Runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Flights.feature",
        glue="com.bring.flights.definitions",
        plugin = {"pretty"},
        tags = "@BookFlights")
public class TestRunner {
}