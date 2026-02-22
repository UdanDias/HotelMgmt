package lk.HotelMgmt.service;

import lk.HotelMgmt.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    void addHotel(HotelDTO hotelDTO);
    void updateHotel(String hotelId,HotelDTO hotelDTO);
    void deleteHotel(String hotelId);
    HotelDTO getSelectedHotel(String hotelId);
    List<HotelDTO> getAllHotels();
}
