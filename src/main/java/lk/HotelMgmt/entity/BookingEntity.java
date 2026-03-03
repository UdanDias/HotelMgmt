package lk.HotelMgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Book")
public class BookingEntity {
    @Id
    private String bookingId;
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotelId;
    @OneToOne
    @JoinColumn(name = "room_id",nullable = false)
    private RoomEntity roomId;
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity userId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate bookedDate;
    private Time bookedTime;
    private boolean isBookingActive=false;
    private Integer noOfDaysBooked;
}
