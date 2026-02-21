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
    private String checkInDate;
    private String checkOutDate;
    private String bookedDate;
    private String bookedTime;
    private boolean isBookingActive;
    private Integer noOfDaysBooked;
}
