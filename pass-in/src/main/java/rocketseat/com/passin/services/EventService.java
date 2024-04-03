package rocketseat.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.DTOs.event.EventResponseDTO;
import rocketseat.com.passin.domain.attendee.Attendee;
import rocketseat.com.passin.domain.event.Event;
import rocketseat.com.passin.repositories.AttendeesRepository;
import rocketseat.com.passin.repositories.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final AttendeesRepository attendeesRepository;

    public EventResponseDTO getEventDetail(String eventId ){
        Event event = eventRepository.findById(eventId).orElseThrow(() ->
                new RuntimeException("Event not found with ID" + eventId ));

        List<Attendee> attendeeList = attendeesRepository.findByEventId(eventId);

        Integer numberOfAttendees = attendeeList.size();

        return new EventResponseDTO(event, numberOfAttendees);
    }



}
