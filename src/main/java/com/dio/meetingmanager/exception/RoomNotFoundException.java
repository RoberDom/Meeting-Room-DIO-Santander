package com.dio.meetingmanager.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomNotFoundException extends Exception{

    public RoomNotFoundException (Long id) {
        super ("Room não encontrada com o id informado" + id);
    }

}
