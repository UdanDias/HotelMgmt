package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.HotelDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class HotelController {
    public ResponseEntity<Void> addHotel(HotelDTO hotelDTO){
        if(hotelDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    public ResponseEntity<Void> deleteHotel(String hotelId){
        if(hotelId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    public ResponseEntity<Void> updateHotel(String hotelId, HotelDTO hotelDTO){
        if(hotelDTO == null || hotelId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    public ResponseEntity<HotelDTO> getSelectedHotel(String hotelId ){
        if(hotelId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    public ResponseEntity<List<HotelDTO>> getAllHotels(){
        return null;
    }
}
