package com.gridnine.testing;

import com.gridnine.testing.filters.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrivalBeforeDepartureFilterTest {
    private List<Flight> flights;

    @BeforeEach
    void setUp() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    void filterShouldRemoveFlightsWithArrivalBeforeDeparture() {
        Filter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredFlights = filter.filter(flights);

        assertEquals(5, filteredFlights.size());
    }
}
