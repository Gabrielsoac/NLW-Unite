package rocketseat.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.DTOs.event.EventIdDTO;
import rocketseat.com.passin.DTOs.event.EventRequestDTO;
import rocketseat.com.passin.DTOs.event.EventResponseDTO;
import rocketseat.com.passin.domain.attendee.Attendee;
import rocketseat.com.passin.domain.event.Event;
import rocketseat.com.passin.domain.event.exceptions.EventNotFoundException;
import rocketseat.com.passin.repositories.EventRepository;

import java.text.Normalizer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final AttendeeService attendeeService;

    public EventResponseDTO getEventDetail(String id){
        Event event = this.eventRepository.findById(id).orElseThrow(() ->
                new EventNotFoundException("Event not found with ID" + id ));

        List<Attendee> attendeeList = this.attendeeService.getAllAttendeesFromEvent(id) ;

        return new EventResponseDTO(event, attendeeList.size());
    }

    public EventIdDTO createEvent(EventRequestDTO eventDTO){
        Event newEvent = new Event();
        newEvent.setTitle(eventDTO.title());
        newEvent.setDetails(eventDTO.details());
        newEvent.setMaximumAttendees(eventDTO.maximumAttendees());
        newEvent.setSlug(createSlug(eventDTO.details()));

        this.eventRepository.save(newEvent);

        return new EventIdDTO(newEvent.getId());
    }

    private String createSlug(String text){
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);

        return normalized.replaceAll("[\\p{InCOMBINING_DIACRITICAL_MARKS}]", "")
                .replaceAll("[^\\w\\s]", "")
                .replaceAll("[\\s+]", "-")
                .toLowerCase();
    }
}
