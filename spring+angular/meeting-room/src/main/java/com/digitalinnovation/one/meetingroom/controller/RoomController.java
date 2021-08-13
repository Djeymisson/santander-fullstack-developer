package com.digitalinnovation.one.meetingroom.controller;

import com.digitalinnovation.one.meetingroom.exception.ResourceNotFoundException;
import com.digitalinnovation.one.meetingroom.model.Room;
import com.digitalinnovation.one.meetingroom.repository.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) throws ResourceNotFoundException {
         Room room = roomRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Room not found:: " + id));

         return ResponseEntity.ok().body(room);
    }

    @PostMapping
    public Room createRoom (@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @Valid @RequestBody Room roomDetails) throws ResourceNotFoundException {
        if(!roomRepository.existsById(id))
            throw  new ResourceNotFoundException("Room not found:: " + id);

        roomDetails.setId(id);

        return ResponseEntity.ok().body(roomRepository.save(roomDetails));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable Long id) throws ResourceNotFoundException {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found:: " + id));

        roomRepository.delete(room);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

}
