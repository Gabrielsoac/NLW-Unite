package rocketseat.com.passin.DTOs.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import rocketseat.com.passin.domain.event.Event;

@Getter
@RequiredArgsConstructor
public class EventResponseDTO {

    EventDetailDTO eventDetailDTO;
    public EventResponseDTO(Event event, Integer numberOfAttendees) {
        this.eventDetailDTO = new EventDetailDTO(event.getId(), event.getTitle(), event.getDetails(), event.getSlug(), event.getMaximumAttendees(), numberOfAttendees);
    }
}
