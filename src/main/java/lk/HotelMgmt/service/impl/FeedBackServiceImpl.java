package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dto.FeedBackDTO;
import lk.HotelMgmt.service.FeedBackService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Override
    public void addFeedBack(FeedBackDTO feedBackDTO) {

    }

    @Override
    public void deleteFeedBack(String feedBackId) {

    }

    @Override
    public void updateFeedBack(String feedBackId, FeedBackDTO feedBackDTO) {

    }

    @Override
    public FeedBackDTO getSelectedFeedBack(String feedBackId) {
        return null;
    }

    @Override
    public List<FeedBackDTO> getAllFeedBacks() {
        return List.of();
    }
}
