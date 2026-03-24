package lk.HotelMgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Room")
public class RoomEntity {
    @Id
    private String roomId;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    private String roomNo;
    private String description;
    private String roomType;
    private boolean isBooked=false;
    private int capacity;
    private double perDayPrice;

    @ManyToMany(mappedBy = "rooms")
    private List<BookingEntity> bookings;



}
