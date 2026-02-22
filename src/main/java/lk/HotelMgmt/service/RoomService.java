package lk.HotelMgmt.service;

import lk.HotelMgmt.dto.RoomDTO;

import java.awt.print.Pageable;
import java.util.List;

public interface RoomService {
    void addRoom(RoomDTO roomDTO);
    void deleteRoom(String roomId);
    void updateRoom(String roomId,RoomDTO roomDTO);
    RoomDTO getSelectedRoom(String roomId);
    List<RoomDTO> getAllRooms();
    List<RoomDTO> getAvailableRooms();
}
