package lk.HotelMgmt.service;

import lk.HotelMgmt.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    void addBooking(BookingDTO bookingDTO);
    void updateBooking(String bookingId,BookingDTO bookingDTO);
    void deleteBooking(String bookingId);
    BookingDTO getSelectedBooking(String bookingId);
    List<BookingDTO> getAllBookings();
}
