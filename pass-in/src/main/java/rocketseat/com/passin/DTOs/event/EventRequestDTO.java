package rocketseat.com.passin.DTOs.event;

public record EventRequestDTO (
        String title,
        String details,
        Integer maximumAttendees
) {

}
