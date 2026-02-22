package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customer")

public class CustomerController {
    @GetMapping
    public String healthTest() {
        return "Health controller is running";
    }

    @PostMapping(value = "addCustomer", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<Void> deleteCustomer(@RequestParam String custId) {
        if (custId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/updateCustomer", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCustomer(@RequestParam String custId, @RequestBody CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getSelectedCustomer")
    public ResponseEntity<CustomerDTO> getSelectedCustomer(@RequestParam String custId) {

        return ResponseEntity.ok(new CustomerDTO(
                "CUST-001",
                "USR-201",
                "BKG-001",
                "Nimal Perera",
                "nimal.perera@gmail.com",
                "0771234567",
                "199512345678",
                "1995-06-15"

        ));
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {

        List<CustomerDTO> customerList = new ArrayList<>();

        customerList.add(new CustomerDTO(
                "CUST-002",
                "USR-202",
                "BKG-002",
                "Kavindi Silva",
                "kavindi.silva@gmail.com",
                "0719876543",
                "200012345678",
                "2000-11-22"
        ));

        customerList.add(new CustomerDTO(
                "CUST-003",
                "USR-203",
                "BKG-003",
                "Rashmi Fernando",
                "rashmi.fernando@gmail.com",
                "0754567890",
                "199812345678",
                "1998-03-10"
        ));

        return ResponseEntity.ok(customerList);

    }

}