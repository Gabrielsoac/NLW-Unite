package rocketseat.com.passin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rocketseat.com.passin.DTOs.attendees.AttendeesListResponseDTO;
import rocketseat.com.passin.DTOs.event.EventIdDTO;
import rocketseat.com.passin.DTOs.event.EventRequestDTO;
import rocketseat.com.passin.DTOs.event.EventResponseDTO;
import rocketseat.com.passin.services.AttendeeService;
import rocketseat.com.passin.services.EventService;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final AttendeeService attendeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable String id) {
        EventResponseDTO event = eventService.getEventDetail(id);
        return ResponseEntity.ok(event);
    }
    @GetMapping("/{eventId}/attendees")
    public ResponseEntity<AttendeesListResponseDTO> listAttendeesForEvent(@PathVariable String eventId) {

        AttendeesListResponseDTO attendeesListResponseDTO = attendeeService.getEventsAttendee(eventId);

        return ResponseEntity.ok(attendeesListResponseDTO);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent(@RequestBody EventRequestDTO body, UriComponentsBuilder uriComponentsBuilder){
        EventIdDTO newEvent = this.eventService.createEvent(body);
        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(newEvent.eventId()).toUri();
        return ResponseEntity.created(uri).body(newEvent);
    }
}
