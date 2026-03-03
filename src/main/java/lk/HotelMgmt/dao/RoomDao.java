package lk.HotelMgmt.dao;

import lk.HotelMgmt.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends JpaRepository<RoomEntity, String> {
}
