package com.example.filrouge_cowork.Service;

import com.example.filrouge_cowork.Dto.CoworkingSpaceDTO;
import com.example.filrouge_cowork.Dto.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoomService {
    RoomDTO createRoom(RoomDTO roomDTO);
    RoomDTO getRoomById(Long id);
    List<RoomDTO> getAllRooms();

    RoomDTO updateRoom(Long id, RoomDTO roomDTO);

    void deleteRoom(Long id);
    List<RoomDTO> getRoomsByCoworkingSpaceId(Long spaceId);

}
