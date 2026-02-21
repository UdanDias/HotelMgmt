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

    @GetMapping("/getSelectedBooking")
    public ResponseEntity<BookingDTO> getSelectedBooking(String bookingId ){
        if(bookingId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new BookingDTO(
                "BKG-001",
                "HTL-001",
                "RM-101",
                "USR-201",
                "2024-01-12",
                "2024-01-15",
                "2024-01-30",
                "14:08",
                true,
                5
        ));
    }

    @GetMapping("/getAllBookings")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {

        List<BookingDTO> bookingList = new ArrayList<>();

        bookingList.add(new BookingDTO(
                "BKG-001",
                "HTL-002",
                "RM-101",
                "USR-201",
                "2024, 1, 12",
                "2024, 1, 15",
                "2024, 1, 10",
                "14, 8",
                true,
                3
        ));

        bookingList.add(new BookingDTO(
                "BKG-002",
                "HTL-003",
                "RM-205",
                "USR-202",
                "2024, 2, 5",
                "2024, 2, 8",
                "2024, 2, 1",
                "10, 30",
                true,
                3
        ));

        bookingList.add(new BookingDTO(
                "BKG-003",
                "HTL-004",
                "RM-301",
                "USR-203",
                "2024, 3, 1",
                "2024, 3, 4",
                "2024, 2, 28",
                "9, 15",
                false,
                3
        ));

        return ResponseEntity.ok(bookingList);
    }


}
