package rocketseat.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.domain.attendee.Attendee;
import rocketseat.com.passin.domain.checkin.Checkin;
import rocketseat.com.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import rocketseat.com.passin.repositories.CheckInRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {

    private final CheckInRepository checkInRepository;

    public void registerCheckIn(Attendee attendee){

        verifyCheckInExists(attendee.getId());

        Checkin checkin = new Checkin();
        checkin.setAttendee(attendee);
        checkin.setCreatedAt(LocalDateTime.now());
        checkInRepository.save(checkin);
    }

    private void verifyCheckInExists(String attendeeId) {
        Optional<Checkin> checkinOptional = this.getCheckIn(attendeeId);
        if (checkinOptional.isPresent()) throw new CheckInAlreadyExistsException("Checkin already exists");
    }

    public Optional<Checkin> getCheckIn(String attendeeId) {
        return this.checkInRepository.findByAttendeeId(attendeeId);
    }
}
