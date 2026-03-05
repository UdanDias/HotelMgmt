package lk.HotelMgmt.util;

import lk.HotelMgmt.dto.*;
import lk.HotelMgmt.entity.*;
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
    public RoomDTO convertRoomEntityToRoomDTO(RoomEntity roomEntity){
        return modelMapper.map(roomEntity, RoomDTO.class);
    }
    public RoomEntity convertRoomDTOToRoomEntity(RoomDTO roomDTO){
        return modelMapper.map(roomDTO, RoomEntity.class);
    }
    public List<RoomDTO> convertRoomEntityListToRoomDTOList(List<RoomEntity> roomEntityList){
        return modelMapper.map(roomEntityList, new TypeToken<RoomDTO>(){}.getType());
    }
    public UserEntity convertUserDTOToUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO convertUserEntityToUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> convertUserEntityListToUserDTOList(List<UserEntity> userEntityList){
        return modelMapper.map(userEntityList, new TypeToken<UserDTO>(){}.getType());
    }
    public FeedBackDTO convertFeedBackentityToFeedBackDTO(FeedBackEntity feedBackEntity){
        return modelMapper.map(feedBackEntity, FeedBackDTO.class);
    }
    public FeedBackEntity convertFeedBackDTOToFeedbackEntity(FeedBackDTO feedBackDTO){
        return modelMapper.map(feedBackDTO, FeedBackEntity.class);
    }
    public List<FeedBackDTO> convertFeedBackEntityListToFeedBackDTOList(List<FeedBackEntity> feedBackEntityList){
        return modelMapper.map(feedBackEntityList, new TypeToken<UserDTO>(){}.getType());
    }
    public CustomerEntity convertCustomerDTOToCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }
    public CustomerDTO convertCustomerEntityToCustomerDTO(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }
    public List<CustomerDTO> convertCustomerEntityListToCustomerDTOList(List<CustomerEntity> customerEntityList){
        return modelMapper.map(customerEntityList, new TypeToken<CustomerDTO>(){}.getType());
    }
}
