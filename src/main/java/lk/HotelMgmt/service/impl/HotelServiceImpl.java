package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dto.HotelDTO;
import lk.HotelMgmt.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Override
    public void addHotel(HotelDTO hotelDTO) {

    }

    @Override
    public void updateHotel(String hotelId, HotelDTO hotelDTO) {

    }

    @Override
    public void deleteHotel(String hotelId) {

    }

    @Override
    public HotelDTO getSelectedHotel(String hotelId) {
        return null;
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return List.of();
    }
}
