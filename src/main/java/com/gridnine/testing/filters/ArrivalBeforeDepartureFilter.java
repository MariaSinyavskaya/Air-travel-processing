package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter to exclude flights containing segments in which
 * the arrival date is earlier than the departure date.
 */
public class ArrivalBeforeDepartureFilter implements Filter {
    /**
     * Filters the list of flights, excluding those for which the arrival of any
     * segment occurs before departure.
     *
     * @param flights list of flights that need to be filtered
     * @return filtered list of flights with correct segment timelines
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
