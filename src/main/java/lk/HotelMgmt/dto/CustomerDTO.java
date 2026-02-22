package lk.HotelMgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerDTO implements Serializable {
    private String custId;
    private String userId;
    private String bookingId;
    private String custName;
    private String email;
    private String phone;
    private String NIC;
    private String DOB;
}
