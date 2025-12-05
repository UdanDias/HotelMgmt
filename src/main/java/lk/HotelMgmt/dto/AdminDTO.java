package lk.HotelMgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO implements Serializable {
    private String adminId;
    private String userId;
    private String adminName;
    private String email;
    private String phone;

}
