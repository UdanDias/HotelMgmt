package lk.HotelMgmt.controller;


import lk.HotelMgmt.dto.RoomDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    @GetMapping
    public String healthTest() {
        return "Room controller is running";
    }

    @PostMapping(value = "/addroom", consumes = MediaType. APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addRoom(@RequestBody RoomDTO roomDTO) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteroom")
    public ResponseEntity<Void> deleteRoom(@RequestParam String roomId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/updateroom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateRoom(@RequestParam Long roomId, @RequestBody RoomDTO roomDTO) {
        System.out.println(roomDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getSelectedRoom")
    public ResponseEntity<RoomDTO> getSelectedRoom(@RequestParam String roomId) {
        return ResponseEntity.ok(new RoomDTO(
                "R001",
                "H001",
                "R-201",
                "A spacious deluxe room with ocean view",
                "DELUXE",
                false,
                2,
                150.00));
    }

    @GetMapping("/getAllRooms")
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        List<RoomDTO> roomList = new ArrayList<>();
        roomList.add(new RoomDTO(
                "R001",
                "H001",
                "R-201",
                "A spacious deluxe room with ocean view",
                "DELUXE",
                false,
                2,
                150.00));
        roomList.add(new RoomDTO(
                "R002",
                "H002",
                "R-202",
                "Standard room with garden view",
                "STANDARD",
                true,
                2,
                80.00));

        return ResponseEntity.ok(roomList);
    }

    @GetMapping("/getAvailableRooms")
    public ResponseEntity<List<RoomDTO>> getAvailableRooms() {
        List<RoomDTO> availableRooms = new ArrayList<>();
        availableRooms.add(new RoomDTO(
                "R001",
                "H001",
                "R-201",
                "A spacious deluxe room with ocean view",
                "DELUXE",
                false,
                2,
                150.00));
        availableRooms.add(new RoomDTO(
                "R002",
                "H002",
                "R-202",
                "Standard room with garden view",
                "STANDARD",
                true,
                2,
                80.00));
        return ResponseEntity.ok(availableRooms);
    }
}
