package lk.HotelMgmt.controller;

import lk.HotelMgmt.dto.FeedBackDTO;
import lk.HotelMgmt.exceptions.FeedBackNotFoundException;
import lk.HotelMgmt.service.FeedBackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/feedback")
@RequiredArgsConstructor

public class FeedBackController {

    private final FeedBackService feedBackService;

    @GetMapping
    public String healthTest() {
        return "FeedBack controller is running";
    }

    @PostMapping(value = "/addfeedback", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addFeedBack(@RequestBody FeedBackDTO feedBackDTO) {

        if (feedBackDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            feedBackService.addFeedBack(feedBackDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (FeedBackNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletefeedback")
    public ResponseEntity<Void> deleteFeedBack(@RequestParam String feedBackId) {

        if (feedBackId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            feedBackService.deleteFeedBack(feedBackId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (FeedBackNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/updatefeedback", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateFeedBack(@RequestParam String feedBackId,
                                               @RequestBody FeedBackDTO feedBackDTO) {

        if (feedBackId == null || feedBackDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            feedBackService.updateFeedBack(feedBackId, feedBackDTO);
            return ResponseEntity.noContent().build();

        } catch (FeedBackNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSelectedFeedBack")
    public ResponseEntity<FeedBackDTO> getSelectedFeedBack(@RequestParam String feedBackId) {

        if (feedBackId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            FeedBackDTO feedBackDTO = feedBackService.getSelectedFeedBack(feedBackId);
            return new ResponseEntity<>(feedBackDTO, HttpStatus.OK);

        } catch (FeedBackNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllFeedBacks")
    public ResponseEntity<List<FeedBackDTO>> getAllFeedBacks() {

        try {
            List<FeedBackDTO> feedBackList = feedBackService.getAllFeedBacks();
            return new ResponseEntity<>(feedBackList, HttpStatus.OK);

        } catch (FeedBackNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}