package com.gridnine.testing;

import com.gridnine.testing.filters.DepartureBeforeNowFilter;
import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartureBeforeNowFilterTest {
    private List<Flight> flights;

    @BeforeEach
    void setUp() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    void filterShouldRemoveFlightsWithDepartureBeforeNow() {
        Filter filter = new DepartureBeforeNowFilter();
        List<Flight> filteredFlights = filter.filter(flights);

        assertEquals(5, filteredFlights.size());
    }
}
