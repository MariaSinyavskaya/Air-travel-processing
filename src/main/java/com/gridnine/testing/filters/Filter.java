package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;

import java.util.List;

/**
 * Interface for filtering the list of flights.
 * Classes implementing this interface must provide an implementation of the filter method,
 * which filters the list of flights according to certain criteria.
 */
public interface Filter {
    /**
     * Filters the list of flights according to certain criteria.
     *
     * @param flights list of flights that need to be filtered
     * @return filtered list of flights
     */
    List<Flight> filter(List<Flight> flights);
}
