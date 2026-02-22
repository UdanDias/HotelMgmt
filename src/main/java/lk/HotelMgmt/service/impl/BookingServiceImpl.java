package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dto.BookingDTO;
import lk.HotelMgmt.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public void addBooking(BookingDTO bookingDTO) {

    }

    @Override
    public void updateBooking(String bookingId, BookingDTO bookingDTO) {

    }

    @Override
    public void deleteBooking(String bookingId) {

    }

    @Override
    public BookingDTO getSelectedBooking(String bookingId) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return List.of();
    }
}
