package fr.mobithink.services;

import fr.mobithink.entities.Trip;

import java.util.List;

public interface TripService {

    List<Trip> getAllTrips();
    Trip getTripById(Long tripId);
    Trip modifyTrip(Trip trip, Long tripId);
    Trip createTrip(Trip trip);
    void deleteTrip(Long tripId);
}
