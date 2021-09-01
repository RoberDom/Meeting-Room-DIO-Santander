package com.dio.meetingmanager.controller;

import com.dio.meetingmanager.dto.MessageResponseDTO;
import com.dio.meetingmanager.exception.RoomNotFoundException;
import com.dio.meetingmanager.model.Room;
import com.dio.meetingmanager.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/room")

public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping
    public MessageResponseDTO createRoom (@RequestBody @Valid Room room) {
        return roomService.createRoom (room);
    }

    @GetMapping
    public List<Room> listall() {
        return roomService.listall ();
    }

    @GetMapping("/{id}")
    public Room getRoombyId (@PathVariable Long id) throws RoomNotFoundException {
        return roomService.getRoomById (id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws RoomNotFoundException {
        roomService.delete (id);
    }

    @PutMapping
    public MessageResponseDTO updateRoom (@RequestBody @Valid Room room) {
        return roomService.update (room);
    }

    }

