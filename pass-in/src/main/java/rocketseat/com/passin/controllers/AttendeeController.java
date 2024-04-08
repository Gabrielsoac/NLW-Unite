package rocketseat.com.passin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rocketseat.com.passin.DTOs.attendees.AttendeeBadgeDTO;
import rocketseat.com.passin.DTOs.attendees.AttendeeBagdeResponseDTO;
import rocketseat.com.passin.domain.checkin.Checkin;
import rocketseat.com.passin.services.AttendeeService;
import rocketseat.com.passin.services.CheckInService;

@RestController
@RequestMapping("/attendees")
@RequiredArgsConstructor
public class AttendeeController {

    private final AttendeeService attendeeService;

    @GetMapping("/{attendeeId}/badge")
    public ResponseEntity<AttendeeBagdeResponseDTO> getAttendeeBagde(@PathVariable String attendeeId, UriComponentsBuilder uriBuilder){

        AttendeeBagdeResponseDTO responseDTO = this.attendeeService.getAttendeBagde(attendeeId, uriBuilder);

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/{attendeId}/check-in")
    public ResponseEntity registerCheckIn(@PathVariable String attendeId, UriComponentsBuilder uriBuilder){
        this.attendeeService.checkInAttendee(attendeId);

        var uri = uriBuilder.path("/attendees/{attendeeId}/badge}").buildAndExpand(attendeId).toUri();

        return ResponseEntity.created(uri).build();
    }


}
