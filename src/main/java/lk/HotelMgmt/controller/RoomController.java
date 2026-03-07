package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.RoomDTO;
import lk.HotelMgmt.exceptions.RoomNotFoundException;
import lk.HotelMgmt.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public String healthTest() {
        return "Room controller is running";
    }

    @PostMapping(value = "/addroom", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addRoom(@RequestBody RoomDTO roomDTO) {
        if (roomDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            roomService.addRoom(roomDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RoomNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteroom")
    public ResponseEntity<Void> deleteRoom(@RequestParam String roomId) {
        if (roomId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            roomService.deleteRoom(roomId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RoomNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/updateroom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateRoom(
            @RequestParam String roomId,
            @RequestBody RoomDTO roomDTO) {
        if (roomId == null || roomDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            roomService.updateRoom(roomId, roomDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RoomNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSelectedRoom")
    public ResponseEntity<RoomDTO> getSelectedRoom(@RequestParam String roomId) {
        if (roomId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            RoomDTO roomDTO = roomService.getSelectedRoom(roomId);
            return ResponseEntity.ok(roomDTO);
        } catch (RoomNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllRooms")
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        try {
            List<RoomDTO> roomList = roomService.getAllRooms();
            return ResponseEntity.ok(roomList);
        } catch (RoomNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAvailableRooms")
    public ResponseEntity<List<RoomDTO>> getAvailableRooms() {
        try {
            List<RoomDTO> availableRooms = roomService.getAvailableRooms();
            return ResponseEntity.ok(availableRooms);
        } catch (RoomNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}