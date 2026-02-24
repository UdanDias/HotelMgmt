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
@Table(name="Book")
public class BookingEntity {
    @Id
    private String bookingId;
    private String hotelId;
    private String roomId;
    private String userId;
    private String checkInDate;
    private String checkOutDate;
    private String bookedDate;
    private String bookedTime;
    private boolean isBookingActive;
    private Integer noOfDaysBooked;
}
