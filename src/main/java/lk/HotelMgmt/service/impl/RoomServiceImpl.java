package lk.HotelMgmt.service.impl;

import jakarta.transaction.Transactional;
import lk.HotelMgmt.dao.RoomDao;
import lk.HotelMgmt.dto.RoomDTO;
import lk.HotelMgmt.entity.RoomEntity;
import lk.HotelMgmt.exceptions.RoomNotFoundException;
import lk.HotelMgmt.service.RoomService;
import lk.HotelMgmt.util.EntityDTOConvert;
import lk.HotelMgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addRoom(RoomDTO roomDTO) {
        roomDTO.setRoomId(UtilData.generateRoomId());
        roomDao.save(entityDTOConvert.convertRoomDTOToRoomEntity(roomDTO));
    }

    @Override
    public void deleteRoom(String roomId) {
        RoomEntity roomEntity=roomDao.findById(roomId).orElseThrow(()->new RoomNotFoundException("Room not found"));
        roomDao.delete(roomEntity);

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
