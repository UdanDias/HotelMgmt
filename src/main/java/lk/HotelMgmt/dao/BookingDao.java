package lk.HotelMgmt.dao;

import lk.HotelMgmt.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<BookingEntity, String> {
}
