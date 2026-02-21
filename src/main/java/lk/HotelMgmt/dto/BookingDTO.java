package lk.HotelMgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookingDTO implements Serializable {
    private String bookingId;
    private String hotelId;
    private String roomId;
    private String userId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate bookedDate;
    private Time bookedTime;
    private boolean isBookingActive;
    private Integer noOfDaysBooked;
}
