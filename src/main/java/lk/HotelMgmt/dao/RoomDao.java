package lk.HotelMgmt.dao;

import lk.HotelMgmt.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDao extends JpaRepository<RoomEntity, String> {
    @Query("SELECT r FROM RoomEntity r WHERE r.isBooked = false")
    List<RoomEntity> findAvailableRooms();
}
