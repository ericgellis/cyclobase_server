package fr.mobithink.restController;


import fr.mobithink.entities.Trip;
import fr.mobithink.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripRestController {

    private TripService tripService;

    @Autowired
    public TripRestController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @GetMapping(value = "/{tripId}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long tripId) {
        return ResponseEntity.ok(tripService.getTripById(tripId));
    }

    @PutMapping(value = "/{tripId}")
    public ResponseEntity<Trip> modifyTrip(@RequestBody Trip trip,@PathVariable Long tripId) {
        tripService.modifyTrip(trip, tripId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        tripService.createTrip(trip);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{tripId}")
    public void deleteTrip(@PathVariable Long tripId) {
        tripService.deleteTrip(tripId);
    }
}
