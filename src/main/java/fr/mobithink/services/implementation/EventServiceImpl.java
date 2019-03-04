package fr.mobithink.services.implementation;

import fr.mobithink.dao.EventRepository;
import fr.mobithink.entities.Event;
import fr.mobithink.exceptions.EventNotFoundException;
import fr.mobithink.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
    }

    @Override
    public Event modifyEvent(Event event, Long eventId) {
        // l'appelle à cette méthode va garantir une exception en cas ou le Event n'est pas retrouvable
        this.getEventById(eventId);

        event.setEventId(eventId);
        return eventRepository.saveAndFlush(event);
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        // l'appelle à cette méthode va garantir une exception en cas ou le Event n'est pas retrouvable
        this.getEventById(eventId);

        eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> findAllByTrip(Long tripId) {
        return eventRepository.findAllByTrip(tripId);
    }
}
