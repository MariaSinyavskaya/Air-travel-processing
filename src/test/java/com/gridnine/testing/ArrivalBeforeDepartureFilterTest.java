package com.gridnine.testing;

import com.gridnine.testing.filters.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrivalBeforeDepartureFilterTest {
    @Test
    void testArrivalBeforeDeparture() {
        LocalDateTime dep = LocalDateTime.now().plusHours(1);
        LocalDateTime arr = dep.minusHours(1);
        Flight flight = new Flight(List.of(new Segment(dep, arr)));

        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> result = filter.filter(List.of(flight));

        assertTrue(result.isEmpty());
    }

    @Test
    void testArrivalAfterDeparture() {
        LocalDateTime dep = LocalDateTime.now().plusHours(1);
        LocalDateTime arr = dep.plusHours(2);
        Flight flight = new Flight(List.of(new Segment(dep, arr)));

        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> result = filter.filter(List.of(flight));

        assertFalse(result.isEmpty());
    }
}
