package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter to exclude flights whose waiting time between segments exceeds two hours.
 * If the total time on the ground between segments exceeds two hours, such a flight is excluded.
 */
public class GroundTimeMoreTwoHoursFilter implements Filter {
    private static final long MAX_GROUND_TIME = 120;

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
                    long totalGroundTime = 0;

                    for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                        Segment currentSegment = flight.getSegments().get(i);
                        Segment nextSegment = flight.getSegments().get(i + 1);

                        totalGroundTime += Duration.between(currentSegment.getArrivalDate(),
                                nextSegment.getDepartureDate()).toMinutes();

                        if (totalGroundTime > MAX_GROUND_TIME) {
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toList());
    }
}
