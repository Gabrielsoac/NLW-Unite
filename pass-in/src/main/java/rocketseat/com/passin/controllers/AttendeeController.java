package rocketseat.com.passin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rocketseat.com.passin.DTOs.attendees.AttendeeBadgeDTO;
import rocketseat.com.passin.DTOs.attendees.AttendeeBagdeResponseDTO;
import rocketseat.com.passin.services.AttendeeService;

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


}
