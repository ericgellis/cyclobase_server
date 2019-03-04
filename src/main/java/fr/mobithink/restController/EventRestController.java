package fr.mobithink.restController;

import fr.mobithink.entities.Event;
import fr.mobithink.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventRestController {

    private EventService eventService;

    @Autowired
    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping(value = "/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable Long eventId) {
        return ResponseEntity.ok(eventService.getEventById(eventId));
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        this.eventService.createEvent(event);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{eventId}")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event, @PathVariable Long eventId) {
        this.eventService.modifyEvent(event, eventId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/tripId/{tripId}")
    public ResponseEntity<List<Event>> getAllEventByTripId(@PathVariable Long tripId) {
        return ResponseEntity.ok(eventService.findAllByTrip(tripId));
    }

    @DeleteMapping(value = "/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }
}
