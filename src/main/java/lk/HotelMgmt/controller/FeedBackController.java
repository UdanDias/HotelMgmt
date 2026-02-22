package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.FeedBackDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/feedback")
public class FeedBackController {

    @GetMapping
    public String healthTest() {
        return "FeedBack controller is running";
    }

    @PostMapping(value = "/addfeedback", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addFeedBack(@RequestBody FeedBackDTO feedBackDTO) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deletefeedback")
    public ResponseEntity<Void> deleteFeedBack(@RequestParam String feedBackId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/updatefeedback", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateFeedBack(@RequestParam String feedBackId, @RequestBody FeedBackDTO feedBackDTO) {
        System.out.println(feedBackDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getSelectedFeedBack")
    public ResponseEntity<FeedBackDTO> getSelectedFeedBack(@RequestParam String feedBackId) {
        return ResponseEntity.ok(new FeedBackDTO(
                "FB-001",
                "USR-101",
                "HTL-201",
                "Excellent service and beautiful rooms. Highly recommended!"));
    }

    @GetMapping("/getAllFeedBacks")
    public ResponseEntity<List<FeedBackDTO>> getAllFeedBacks() {
        List<FeedBackDTO> feedBackList = new ArrayList<>();
        feedBackList.add(new FeedBackDTO(
                "FB-001",
                "USR-101",
                "HTL-201",
                "Excellent service and beautiful rooms. Highly recommended!"));
        feedBackList.add(new FeedBackDTO(
                "FB-002",
                "USR-102",
                "HTL-201",
                "Great location but the food could be better."));
        feedBackList.add(new FeedBackDTO(
                "FB-003",
                "USR-103",
                "HTL-202",
                "Very clean and comfortable. Staff were very friendly!"));
        return ResponseEntity.ok(feedBackList);
    }


}