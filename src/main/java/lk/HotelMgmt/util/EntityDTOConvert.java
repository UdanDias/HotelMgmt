package lk.HotelMgmt.util;

import lk.HotelMgmt.dto.AdminDTO;
import lk.HotelMgmt.dto.BookingDTO;
import lk.HotelMgmt.dto.HotelDTO;
import lk.HotelMgmt.entity.AdminEntity;
import lk.HotelMgmt.entity.BookingEntity;
import lk.HotelMgmt.entity.HotelEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntityDTOConvert {
    private final ModelMapper modelMapper;

    public AdminEntity convertAdminDTOToAdminEntity(AdminDTO adminDTO){
        return modelMapper.map(adminDTO, AdminEntity.class);
    }
    public AdminDTO convertAdminEntityToAdminDTO(AdminEntity adminEntity){
        return modelMapper.map(adminEntity, AdminDTO.class);
    }
    public List<AdminDTO> convertAdminEntityListToAdminDTOList(List<AdminEntity> adminEntityList){
        return modelMapper.map(adminEntityList, new TypeToken<AdminEntity>(){}.getType());
    }
    public BookingEntity convertBookingDTOToBookingEntity(BookingDTO bookingDTO){
        return modelMapper.map(bookingDTO, BookingEntity.class);
    }
    public BookingDTO convertBookingEntityToBookingDTO(BookingEntity bookingEntity){
        return modelMapper.map(bookingEntity, BookingDTO.class);
    }
    public List<BookingDTO> convertBookingEntityListToBookingDTOList(List<BookingEntity> bookingEntityList){
        return modelMapper.map(bookingEntityList, new TypeToken<BookingDTO>(){}.getType());
    }
    public HotelEntity convertHotelDTOToHotelEntity(HotelDTO hotelDTO){
        return modelMapper.map(hotelDTO, HotelEntity.class);
    }
    public HotelDTO convertHotelEntityToHotelDTO(HotelEntity hotelEntity){
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }
    public List<HotelDTO> convertHotelEntityListToHotelDTOList(List<HotelEntity> hotelEntityList){
        return modelMapper.map(hotelEntityList, new TypeToken<HotelDTO>(){}.getType());
    }
}
