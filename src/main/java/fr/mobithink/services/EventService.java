package fr.mobithink.services;


import fr.mobithink.entities.Event;

import java.util.List;

public interface EventService {

  List<Event> getAllEvents();
  Event getEventById(Long eventId);
  Event modifyEvent(Event event, Long eventId);
  Event createEvent(Event event);
  void deleteEvent(Long eventId);
  List<Event> findAllByTrip(Long tripId);
}
