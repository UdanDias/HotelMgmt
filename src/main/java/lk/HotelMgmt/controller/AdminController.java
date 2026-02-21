package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.AdminDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping
    public String healthtest(){
        return "Health controller is running";
    }
    @PostMapping(value = "addadmin",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addAdmin(@RequestBody AdminDTO adminDTO) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteadmin")
    public ResponseEntity<Void> deleteAdmin(@RequestParam String adminId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/updateadmin", consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAdmin(@RequestParam String adminId,@RequestBody AdminDTO adminDTO){
        System.out.println(adminDTO);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/getSelectedAdmin")
    public ResponseEntity<AdminDTO> getSelectedAdmin(@RequestParam String adminId){
        return ResponseEntity.ok(new AdminDTO(
                "ADM-001",
                "USR-101",
                "John Smith",
                "john.smith@example.com",
                "+1-555-0101"));


    }
    @GetMapping("/getAllAdmins")
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        List<AdminDTO> adminList = new ArrayList<>();
        adminList.add(new AdminDTO(
                "ADM-001",
                "USR-101",
                "John Smith",
                "john.smith@example.com",
                "+1-555-0101"));
        adminList.add(new AdminDTO(
                "ADM-002",
                "USR-102",
                "Sarah Johnson",
                "sarah.johnson@example.com",
                "+1-555-0102"));
        adminList.add(new AdminDTO(
                "ADM-003",
                "USR-103",
                "Michael Lee",
                "michael.lee@example.com",
                "+1-555-0103"));
        return ResponseEntity.ok(adminList);
    }
}
