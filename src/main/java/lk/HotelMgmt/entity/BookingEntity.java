package lk.HotelMgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.resilience.annotation.EnableResilientMethods;

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
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @ManyToMany
    @JoinTable(name = "booking_room",
    joinColumns = @JoinColumn(name = "bookingId"),
    inverseJoinColumns = @JoinColumn(name = "roomId"))
    private List<RoomEntity> rooms;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate bookedDate;
    private Time bookedTime;
    private boolean isBookingActive=false;
    private Integer noOfDaysBooked;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
