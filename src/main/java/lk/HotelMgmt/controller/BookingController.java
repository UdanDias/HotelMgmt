package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.BookingDTO;
import lk.HotelMgmt.dto.HotelDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class BookingController {
    @GetMapping
    public String healthtest(){
        return "Health controller is running";
    }

    @PostMapping(value = "addbooking",consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBooking(@RequestBody BookingDTO bookingDTO){
        if(bookingDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping("/deletebooking")
    public ResponseEntity<Void> deleteBooking(String bookingId){
        if(bookingId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/updatebooking",consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> updateBooking(String bookingId, BookingDTO bookingDTO){
        if(bookingDTO == null || bookingId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println(bookingDTO);
        return ResponseEntity.noContent().build();
    }



}
