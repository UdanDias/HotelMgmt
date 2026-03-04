package lk.HotelMgmt.service.impl;

import jakarta.transaction.Transactional;
import lk.HotelMgmt.dao.HotelDao;
import lk.HotelMgmt.dto.HotelDTO;
import lk.HotelMgmt.entity.HotelEntity;
import lk.HotelMgmt.exceptions.HotelNotFoundException;
import lk.HotelMgmt.service.HotelService;
import lk.HotelMgmt.util.EntityDTOConvert;
import lk.HotelMgmt.util.UtilData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class HotelServiceImpl implements HotelService {
    private final HotelDao hotelDao;
    private final EntityDTOConvert entityDTOConvert;
    @Override
    public void addHotel(HotelDTO hotelDTO) {
        hotelDTO.setHotelId(UtilData.generateHotelId());
        hotelDTO.setHotelName(hotelDTO.getHotelName());
        hotelDTO.setDescription(hotelDTO.getDescription());
        hotelDTO.setLocation(hotelDTO.getLocation());
        hotelDTO.setRating(hotelDTO.getRating());
        hotelDTO.setPhone(hotelDTO.getPhone());
        hotelDTO.setEmail(hotelDTO.getEmail());
        hotelDTO.setAvailableRooms(hotelDTO.getAvailableRooms());

        HotelEntity hotelEntity= entityDTOConvert.convertHotelDTOToHotelEntity(hotelDTO);
        hotelDao.save(hotelEntity);
    }

    @Override
    public void updateHotel(String hotelId, HotelDTO hotelDTO) {
        HotelEntity hotelEntity=hotelDao.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel not found");
        hotelEntity.setHotelName(hotelDTO.getHotelName());
        hotelEntity.setDescription(hotelDTO.getDescription());
        hotelEntity.setLocation(hotelDTO.getLocation());
        hotelEntity.setRating(hotelDTO.getRating());
        hotelEntity.setPhone(hotelDTO.getPhone());
        hotelEntity.setEmail(hotelDTO.getEmail());
        hotelEntity.setAvailableRooms(hotelDTO.getAvailableRooms());

    }

    @Override
    public void deleteHotel(String hotelId) {
        HotelEntity hotelEntity=hotelDao.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel not found"));
        hotelDao.delete(hotelEntity);

    }

    @Override
    public HotelDTO getSelectedHotel(String hotelId) {
        HotelEntity hotelEntity=hotelDao.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel not found"));
        return entityDTOConvert.convertHotelEntityToHotelDTO(hotelEntity);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return entityDTOConvert.convertHotelEntityListToHotelDTOList(hotelDao.findAll());
    }
}
