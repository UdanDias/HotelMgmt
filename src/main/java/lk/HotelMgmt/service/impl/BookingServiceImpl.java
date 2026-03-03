package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dto.BookingDTO;
import lk.HotelMgmt.service.BookingService;
import lk.HotelMgmt.util.UtilData;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public void addBooking(BookingDTO bookingDTO) {
        bookingDTO.setBookingId(UtilData.generateBookingId());
        bookingDTO.setHotelId(bookingDTO.getHotelId());
        bookingDTO.setRoomId(bookingDTO.getRoomId());
        bookingDTO.setCheckInDate(bookingDTO.getCheckInDate());
        bookingDTO.setBookedDate(UtilData.generateTodayDate());
        bookingDTO.setBookedTime(UtilData.generateCurrentTime());
        bookingDTO.setBookingActive(true);
        bookingDTO.setNoOfDaysBooked(bookingDTO.getNoOfDaysBooked());
        bookingDTO.setCheckOutDate(calculateCheckOutDate(bookingDTO.getBookedDate(),bookingDTO.getNoOfDaysBooked()));
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

    public LocalDate calculateCheckOutDate(LocalDate bookedDate,int noOfDaysBooked) {
        return bookedDate.plusDays(noOfDaysBooked);
    }
}
