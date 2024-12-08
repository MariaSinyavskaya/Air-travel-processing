package com.gridnine.testing;

import com.gridnine.testing.filters.DepartureBeforeNowFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DepartureBeforeNowFilterTest {
    @Test
    void testDepartureBeforeNow() {
        LocalDateTime dep = LocalDateTime.now().plusHours(1);
        LocalDateTime arr = dep.plusHours(2);
        Flight flight = new Flight(List.of(new Segment(dep, arr)));

        DepartureBeforeNowFilter filter = new DepartureBeforeNowFilter();
        List<Flight> result = filter.filter(List.of(flight));

        assertFalse(result.isEmpty());
    }

    @Test
    void testDepartureBeforeNowPastFlight() {
        LocalDateTime dep = LocalDateTime.now().minusDays(1);
        LocalDateTime arr = dep.plusHours(2);
        Flight flight = new Flight(List.of(new Segment(dep, arr)));

        DepartureBeforeNowFilter filter = new DepartureBeforeNowFilter();
        List<Flight> result = filter.filter(List.of(flight));

        assertTrue(result.isEmpty());
    }
}
