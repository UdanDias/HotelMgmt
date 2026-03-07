package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.HotelDTO;
import lk.HotelMgmt.exceptions.HotelNotFoundException;
import lk.HotelMgmt.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/v1/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public String healthTest() {
        return "Health controller is running";
    }

    @PostMapping(value = "/addHotel", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addHotel(@RequestBody HotelDTO hotelDTO) {
        if (hotelDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            hotelService.addHotel(hotelDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (HotelNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteHotel")
    public ResponseEntity<Void> deleteHotel(@RequestParam(required = false) String hotelId) {
        if (hotelId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            hotelService.deleteHotel(hotelId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HotelNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/updateHotel", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateHotel(
            @RequestParam(required = false) String hotelId,
            @RequestBody HotelDTO hotelDTO) {
        if (hotelId == null || hotelDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            hotelService.updateHotel(hotelId, hotelDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HotelNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSelectedHotel")
    public ResponseEntity<HotelDTO> getSelectedHotel(@RequestParam(required = false) String hotelId) {
        if (hotelId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            HotelDTO hotelDTO = hotelService.getSelectedHotel(hotelId);
            return ResponseEntity.ok(hotelDTO);
        } catch (HotelNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllHotel")
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        try {
            List<HotelDTO> hotelList = hotelService.getAllHotels();
            return ResponseEntity.ok(hotelList);
        } catch (HotelNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}