package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.BookingDTO;
import lk.HotelMgmt.exceptions.BookingNotFoundException;
import lk.HotelMgmt.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public String healthTest(){
        return "Health controller is running";
    }

    @PostMapping(value = "addBooking", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBooking(@RequestBody BookingDTO bookingDTO){

        if (bookingDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try{
            bookingService.addBooking(bookingDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (BookingNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBooking")
    public ResponseEntity<Void> deleteBooking(@RequestParam String bookingId){

        if (bookingId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try{
            bookingService.deleteBooking(bookingId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (BookingNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/updateBooking", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBooking(@RequestParam String bookingId,
                                              @RequestBody BookingDTO bookingDTO){

        if (bookingId == null || bookingDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try{
            bookingService.updateBooking(bookingId, bookingDTO);
            return ResponseEntity.noContent().build();

        }catch (BookingNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSelectedBooking")
    public ResponseEntity<BookingDTO> getSelectedBooking(@RequestParam String bookingId){

        if (bookingId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try{
            BookingDTO bookingDTO = bookingService.getSelectedBooking(bookingId);
            return new ResponseEntity<>(bookingDTO, HttpStatus.OK);

        }catch (BookingNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllBookings")
    public ResponseEntity<List<BookingDTO>> getAllBookings(){

        try{
            List<BookingDTO> bookingList = bookingService.getAllBookings();
            return new ResponseEntity<>(bookingList, HttpStatus.OK);

        }catch (BookingNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}