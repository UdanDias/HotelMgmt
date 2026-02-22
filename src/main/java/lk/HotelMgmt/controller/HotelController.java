package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.HotelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/v1/hotel")
@RequiredArgsConstructor

public class HotelController {
    @GetMapping
    public String healthTest(){
        return "Health controller is running";
    }

    @PostMapping(value = "addHotel",consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addHotel(@RequestBody HotelDTO hotelDTO){
        if(hotelDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteHotel")
    public ResponseEntity<Void> deleteHotel(@RequestParam String hotelId){
        if(hotelId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/updateHotel",consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> updateHotel(@RequestParam String hotelId,@RequestBody HotelDTO hotelDTO){
        if(hotelDTO == null || hotelId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println(hotelDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getSelectedHotel")
    public ResponseEntity<HotelDTO> getSelectedHotel(@RequestParam String hotelId ){
        if(hotelId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new HotelDTO(
                "HTL-001",
                "Hilton Colombo",
                "Luxury hotel near Galle Face Green",
                "Colombo, Sri Lanka",
                4.5,
                "0112345678",
                "info@hiltoncolombo.com",
                25

        ));
    }

    @GetMapping("/getAllHotel")
    public ResponseEntity<List<HotelDTO>> getAllHotels(){
        List<HotelDTO> hotelList = new ArrayList<>();

        hotelList.add(new HotelDTO(
                "HTL-002",
                "City of Dreams",
                "Luxury hotel near Galle Face",
                "Colombo",
                8.0,
                "0112345678",
                "info@cityofdreams.com",
                100
        ));

        hotelList.add(new HotelDTO(
                "HTL-003",
                "Shangri-La Colombo",
                "Five-star hotel with sea view",
                "Colombo",
                4.8,
                "0771234567",
                "contact@shangrila.com",
                40
        ));

        hotelList.add(new HotelDTO(
                "HTL-004",
                "Cinnamon Grand",
                "Premium business hotel",
                "Colombo",
                4.3,
                "0719876543",
                "info@cinnamongrand.com",
                30
        ));

        return ResponseEntity.ok(hotelList);
    }
}
