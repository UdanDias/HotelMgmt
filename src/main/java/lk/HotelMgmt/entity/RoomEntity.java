package lk.HotelMgmt.entity;

import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "hotel_id",nullable = false)
    private HotelEntity hotelId;
    private String roomNo;
    private String description;
    private String roomType;
    private boolean isBooked=false;
    private int capacity;
    private double perDayPrice;
}
