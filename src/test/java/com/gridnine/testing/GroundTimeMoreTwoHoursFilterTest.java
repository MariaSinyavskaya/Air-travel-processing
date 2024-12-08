package com.gridnine.testing;

import com.gridnine.testing.filters.GroundTimeMoreTwoHoursFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GroundTimeMoreTwoHoursFilterTest {
    @Test
    void testGroundTimeLessThanTwoHours() {
        LocalDateTime dep1 = LocalDateTime.now().plusHours(1);
        LocalDateTime arr1 = dep1.plusHours(2);
        LocalDateTime dep2 = arr1.plusHours(1);
        LocalDateTime arr2 = dep2.plusHours(2);

        Flight flight = new Flight(List.of(new Segment(dep1, arr1), new Segment(dep2, arr2)));

        GroundTimeMoreTwoHoursFilter filter = new GroundTimeMoreTwoHoursFilter();
        List<Flight> result = filter.filter(List.of(flight));

        assertFalse(result.isEmpty());
    }

    @Test
    void testGroundTimeMoreThanTwoHours() {
        LocalDateTime dep1 = LocalDateTime.now().plusHours(1);
        LocalDateTime arr1 = dep1.plusHours(2);
        LocalDateTime dep2 = arr1.plusHours(1).plusMinutes(30);
        LocalDateTime arr2 = dep2.plusHours(2);
        LocalDateTime dep3 = arr2.plusHours(1).plusMinutes(40);
        LocalDateTime arr3 = dep3.plusHours(3);

        Flight flight = new Flight(List.of(new Segment(dep1, arr1), new Segment(dep2, arr2),
                new Segment(dep3, arr3)));

        GroundTimeMoreTwoHoursFilter filter = new GroundTimeMoreTwoHoursFilter();
        List<Flight> result = filter.filter(List.of(flight));

        assertTrue(result.isEmpty());
    }
}
