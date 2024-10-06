package com.gridnine.testing;

import com.gridnine.testing.filters.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filters.DepartureBeforeNowFilter;
import com.gridnine.testing.filters.GroundTimeMoreTwoHoursFilter;
import com.gridnine.testing.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("All Flights:");
        flights.forEach(System.out::println);

        System.out.println("\nFlights after filtering: Departure before now");
        List<Flight> flightsFilteredByDeparture = new DepartureBeforeNowFilter().filter(flights);
        flightsFilteredByDeparture.forEach(System.out::println);

        System.out.println("\nFlights after filtering: Arrival before departure");
        List<Flight> flightsFilteredByArrival = new ArrivalBeforeDepartureFilter().filter(flights);
        flightsFilteredByArrival.forEach(System.out::println);

        System.out.println("\nFlights after filtering: Ground time exceeding two hours");
        List<Flight> flightsFilteredByGroundTime = new GroundTimeMoreTwoHoursFilter().filter(flights);
        flightsFilteredByGroundTime.forEach(System.out::println);
    }
}
