package com.gridnine.testing;

import com.gridnine.testing.filters.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filters.DepartureBeforeNowFilter;
import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.filters.GroundTimeMoreTwoHoursFilter;
import com.gridnine.testing.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("All Flights:");
        flights.forEach(System.out::println);

        applyFilterAndPrint(flights, new DepartureBeforeNowFilter(), "Departure before now");
        applyFilterAndPrint(flights, new ArrivalBeforeDepartureFilter(), "Arrival before departure");
        applyFilterAndPrint(flights, new GroundTimeMoreTwoHoursFilter(), "Ground time exceeding two hours");
    }

    public static void applyFilterAndPrint(List<Flight> flights, Filter filter, String filterName) {
        System.out.println("\nFlights after filtering: " + filterName);
        filter.filter(flights).forEach(System.out::println);
    }
}
