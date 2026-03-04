package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dao.FeedBackDao;
import lk.HotelMgmt.dao.HotelDao;
import lk.HotelMgmt.dto.FeedBackDTO;
import lk.HotelMgmt.entity.FeedBackEntity;
import lk.HotelMgmt.entity.HotelEntity;
import lk.HotelMgmt.exceptions.FeedBackNotFoundException;
import lk.HotelMgmt.exceptions.HotelNotFoundException;
import lk.HotelMgmt.service.FeedBackService;
import lk.HotelMgmt.util.EntityDTOConvert;
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
    private final EntityDTOConvert entityDTOConvert;
    private final HotelDao hotelDao;

    @Override
    public void addFeedBack(FeedBackDTO feedBackDTO) {
        feedBackDTO.setFeedBackId(UtilData.generateFeedBackId());
        FeedBackEntity feedBackEntity=entityDTOConvert.convertFeedBackDTOToFeedbackEntity(feedBackDTO);
        feedBackDao.save(feedBackEntity);

    }

    @Override
    public void deleteFeedBack(String feedBackId) {
        FeedBackEntity feedBackEntity=feedBackDao.findById(feedBackId).orElseThrow(() -> new FeedBackNotFoundException("FeedBack not found"));
        feedBackDao.delete(feedBackEntity);
    }

    @Override
    public void updateFeedBack(String feedBackId, FeedBackDTO feedBackDTO) {
        FeedBackEntity feedBackEntity=feedBackDao.findById(feedBackId).orElseThrow(() -> new FeedBackNotFoundException("feedBack not found"));
        HotelEntity hotelEntity=hotelDao.findById(feedBackDTO.getHotelId()).orElseThrow(() -> new HotelNotFoundException("hotel not found"));
        feedBackEntity.setHotelId(hotelEntity);
        feedBackEntity.setReview(feedBackDTO.getReview());
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
