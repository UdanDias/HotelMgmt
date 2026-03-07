package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.AdminDTO;
import lk.HotelMgmt.exceptions.AdminNotFoundException;
import lk.HotelMgmt.service.AdminService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping
    public String healthtest(){

        return "Health controller is running";
    }

    @PostMapping(value = "addadmin",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addAdmin(@RequestBody AdminDTO adminDTO) {
        if (adminDTO.getUserId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            adminService.addAdmin(adminDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (AdminNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteadmin")
    public ResponseEntity<Void> deleteAdmin(@RequestParam String adminId){
        if (adminId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            adminService.deleteAdmin(adminId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (AdminNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping(value = "/updateadmin", consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAdmin(@RequestParam String adminId,@RequestBody AdminDTO adminDTO){
        if (adminId == null||adminDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            adminService.updateAdmin(adminId,adminDTO);
            return ResponseEntity.noContent().build();

        } catch (AdminNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/getSelectedAdmin")
    public ResponseEntity<AdminDTO> getSelectedAdmin(@RequestParam String adminId){
        if (adminId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            adminService.getSelectedAdmin(adminId);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (AdminNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllAdmins")
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        try {
            adminService.getAllAdmins();
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (AdminNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
