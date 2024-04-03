package rocketseat.com.passin.DTOs.event;

import org.antlr.v4.runtime.misc.NotNull;

public record EventDetailDTO(
        String id,
        String title,
        String details,
        String slug,
        Integer maximumAttendees,
        Integer attendeesAmount) {
}
