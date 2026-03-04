package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dao.FeedBackDao;
import lk.HotelMgmt.dto.FeedBackDTO;
import lk.HotelMgmt.service.FeedBackService;
import lk.HotelMgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FeedBackServiceImpl implements FeedBackService {
    private final FeedBackDao feedBackDao;
    @Override
    public void addFeedBack(FeedBackDTO feedBackDTO) {
        feedBackDTO.setFeedBackId(UtilData.generateFeedBackId());

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
