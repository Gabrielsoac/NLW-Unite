package rocketseat.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.DTOs.attendees.AttendeesListResponseDTO;
import rocketseat.com.passin.domain.attendee.Attendee;
import rocketseat.com.passin.repositories.AttendeesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeService {

    private AttendeesRepository attendeesRepository;

    public List<Attendee> getAllAttendeesFromEvent(String eventId){
        return this.attendeesRepository.findByEventId(eventId);
    }

    public AttendeesListResponseDTO getEventsAttendee(String eventId){
        List<Attendee> attendeeList = this.getAllAttendeesFromEvent(eventId);
    }
}
