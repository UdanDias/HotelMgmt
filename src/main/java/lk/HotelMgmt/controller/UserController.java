package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping
    public String healthTest() {
        return "User controller is running";
    }

    @PostMapping(value = "/adduser", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity<Void> deleteUser(@RequestParam String userId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/updateuser", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@RequestParam String userId, @RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getSelectedUser")
    public ResponseEntity<UserDTO> getSelectedUser(@RequestParam String userId) {
        return ResponseEntity.ok(new UserDTO(
                "USR-001",
                "john_doe",
                "john.doe@example.com",
                "hashed_password_123"));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userList = new ArrayList<>();
        userList.add(new UserDTO(
                "USR-001",
                "john_doe",
                "john.doe@example.com",
                "hashed_password_123"));
        userList.add(new UserDTO(
                "USR-002",
                "sarah_j",
                "sarah.johnson@example.com",
                "hashed_password_456"));
        userList.add(new UserDTO(
                "USR-003",
                "mike_lee",
                "michael.lee@example.com",
                "hashed_password_789"));
        return ResponseEntity.ok(userList);
    }
}