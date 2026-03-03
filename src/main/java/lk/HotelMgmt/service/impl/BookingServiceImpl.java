package lk.HotelMgmt.service.impl;

import jakarta.transaction.Transactional;
import lk.HotelMgmt.dao.BookingDao;
import lk.HotelMgmt.dao.HotelDao;
import lk.HotelMgmt.dao.RoomDao;
import lk.HotelMgmt.dto.BookingDTO;
import lk.HotelMgmt.entity.BookingEntity;
import lk.HotelMgmt.exceptions.BookingNotFoundException;
import lk.HotelMgmt.service.BookingService;
import lk.HotelMgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao;
    private final HotelDao hotelDao;
    private final RoomDao roomDao;



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

        BookingEntity bookingEntity= bookingDao.findById(bookingId).orElseThrow(()->new BookingNotFoundException("Booking not found"));


        bookingEntity.setHotelId(hotelDao.getReferenceById(bookingDTO.getHotelId()));
        bookingEntity.setRoomId(roomDao.getReferenceById(bookingDTO.getRoomId()));
        bookingEntity.setCheckInDate(bookingDTO.getCheckInDate());
        bookingEntity.setBookedDate(UtilData.generateTodayDate());
        bookingEntity.setBookedTime(UtilData.generateCurrentTime());
        bookingEntity.setBookingActive(true);
        bookingEntity.setNoOfDaysBooked(bookingDTO.getNoOfDaysBooked());
        bookingEntity.setCheckOutDate(calculateCheckOutDate(bookingDTO.getBookedDate(),bookingDTO.getNoOfDaysBooked()));
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
