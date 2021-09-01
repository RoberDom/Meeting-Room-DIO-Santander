package com.dio.meetingmanager.service;

import com.dio.meetingmanager.dto.MessageResponseDTO;
import com.dio.meetingmanager.exception.RoomNotFoundException;
import com.dio.meetingmanager.model.Room;
import com.dio.meetingmanager.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service

public class RoomService {

    public RoomRepository roomRepository;


    public MessageResponseDTO createRoom(Room room ) {
        roomRepository.save (room);
       return createMessageResponse ("Sala criada com sucesso!");
    }


    public List<Room>  listall() {
       return roomRepository.findAll ();
    }

    public MessageResponseDTO update(Room room)  {
        roomRepository.save (room);
        return createMessageResponse ("Sala atualizada com sucesso!");
    }

    public void delete(Long id) throws RoomNotFoundException {
        verifyIfExists (id);
        roomRepository.deleteById (id);

    }

    public Room  getRoomById(Long id) throws RoomNotFoundException{
        verifyIfExists (id);
        return roomRepository.getById (id);

        }

    private MessageResponseDTO createMessageResponse(String s) {
        return MessageResponseDTO
                .builder ()
                .mensagem (s)
                .build ();
    }

    private Room verifyIfExists(Long id) throws RoomNotFoundException {
        return roomRepository.findById (id)
                .orElseThrow (() -> new RoomNotFoundException (id));
    }


    }

