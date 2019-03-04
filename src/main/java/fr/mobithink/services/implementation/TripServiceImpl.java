package fr.mobithink.services.implementation;

import fr.mobithink.dao.TripRepository;
import fr.mobithink.entities.Trip;
import fr.mobithink.exceptions.TripNotFoundException;
import fr.mobithink.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip getTripById(Long tripId) {
        return tripRepository.findById(tripId).orElseThrow(() -> new TripNotFoundException(tripId));
    }

    @Override
    public Trip modifyTrip(Trip trip, Long tripId) {
        // l'appelle à cette méthode va garantir une exception en cas ou le trip n'est pas retrouvable
        this.getTripById(tripId);

        trip.setTripId(tripId);
        return tripRepository.saveAndFlush(trip);
    }

    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public void deleteTrip(Long tripId) {
        // l'appelle à cette méthode va garantir une exception en cas ou le trip n'est pas retrouvable
        this.getTripById(tripId);

        tripRepository.deleteById(tripId);
    }
}
