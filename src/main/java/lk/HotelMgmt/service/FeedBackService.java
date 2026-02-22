package lk.HotelMgmt.service;

import lk.HotelMgmt.dto.FeedBackDTO;

import java.util.List;

public interface FeedBackService {
    void addFeedBack(FeedBackDTO feedBackDTO);
    void deleteFeedBack(String feedBackId);
    void updateFeedBack(String feedBackId,FeedBackDTO feedBackDTO);
    FeedBackDTO getSelectedFeedBack(String feedBackId);
    List<FeedBackDTO> getAllFeedBacks();
}
