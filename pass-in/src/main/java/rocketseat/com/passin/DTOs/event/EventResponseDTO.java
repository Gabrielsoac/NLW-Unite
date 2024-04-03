package rocketseat.com.passin.DTOs.event;

import rocketseat.com.passin.domain.event.Event;

public class EventResponseDTO {
    EventDetailDTO eventDetailDTO;
    public EventResponseDTO(Event event, Integer numberOfAttendees) {
        this.eventDetailDTO = new EventDetailDTO(event.getId(), event.getTitle(), event.getDetail(), event.getSlug(), event.getMaximumAttendees(), numberOfAttendees);
    }
}
