package rocketseat.com.passin.DTOs.attendees;

import lombok.Getter;

import java.util.List;

public record AttendeesListResponseDTO (List<AttendeeDetails> attendees){}

