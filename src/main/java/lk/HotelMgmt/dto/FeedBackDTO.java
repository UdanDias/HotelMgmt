package lk.HotelMgmt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedBackDTO implements Serializable {

    private String feedBackId;
    private String userId;
    private String hotelId;
    private String review;
}
