package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter to exclude flights whose segments start before the current time.
 */
public class DepartureBeforeNowFilter implements Filter {
    /**
     * Filters the list of flights, excluding those for which the departure of any
     * segment occurs before the current time.
     *
     * @param flights list of flights that need to be filtered
     * @return filtered list of flights with departures after the current time
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .collect(Collectors.toList());
    }
}
