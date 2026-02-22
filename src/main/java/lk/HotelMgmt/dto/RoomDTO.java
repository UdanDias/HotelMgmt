package lk.HotelMgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO implements Serializable {
    private String roomId;
    private String hotelId;
    private String roomNo;
    private String description;
    private String roomType;
    private boolean isBooked;
    private int capacity;
    private double perDayPrice;
}
