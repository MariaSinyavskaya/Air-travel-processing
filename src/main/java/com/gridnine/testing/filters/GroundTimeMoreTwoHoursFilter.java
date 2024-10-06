package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter to exclude flights whose waiting time between segments exceeds two hours.
 * If the total time on the ground between segments exceeds two hours, such a flight is excluded.
 */
public class GroundTimeMoreTwoHoursFilter implements Filter {
    /**
     * Filters the list of flights, excluding those where the waiting time between
     * segments exceeds two hours.
     *
     * @param flights list of flights that need to be filtered
     * @return filtered list of flights with acceptable waiting time between segments
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                        if ((flight.getSegments().get(i + 1).getDepartureDate().getHour()
                                - flight.getSegments().get(i).getArrivalDate().getHour()) > 2) {
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toList());
    }
}
