package lk.HotelMgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class HotelDTO implements Serializable{
    private String hotelId;
    private String hotelName;
    private String description;
    private String location;
    private Double rating;
    private String phoneNumber;
    private String email;
    private Integer availableRooms;

}
