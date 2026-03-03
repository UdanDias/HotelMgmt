package lk.HotelMgmt.dao;

import lk.HotelMgmt.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackDao extends JpaRepository<FeedbackEntity,String> {
}
