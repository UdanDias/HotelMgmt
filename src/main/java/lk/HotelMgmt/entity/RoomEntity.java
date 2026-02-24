package lk.HotelMgmt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Room")
public class RoomEntity {
    @Id
    private String roomId;
    private String hotelId;
    private String roomNo;
    private String description;
    private String roomType;
    private boolean isBooked;
    private int capacity;
    private double perDayPrice;
}
