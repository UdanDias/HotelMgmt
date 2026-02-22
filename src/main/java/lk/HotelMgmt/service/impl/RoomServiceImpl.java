package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dto.RoomDTO;
import lk.HotelMgmt.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Override
    public void addRoom(RoomDTO roomDTO) {

    }

    @Override
    public void deleteRoom(String roomId) {

    }

    @Override
    public void updateRoom(String roomId, RoomDTO roomDTO) {

    }

    @Override
    public RoomDTO getSelectedRoom(String roomId) {
        return null;
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return List.of();
    }

    @Override
    public List<RoomDTO> getAvailableRooms() {
        return List.of();
    }
}
