package lk.HotelMgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO implements Serializable {
    private Long roomId;
    private Long hotelId;
    private String roomNo;
    private String description;
    private String roomType;
    private boolean isBooked;
    private int capacity;
    private double perDayPrice;
}
