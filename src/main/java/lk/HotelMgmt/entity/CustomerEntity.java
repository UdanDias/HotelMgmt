package lk.HotelMgmt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Customer")
public class CustomerEntity {
    @Id
    private String custId;
    private String userId;
    private String bookingId;
    private String custName;
    private String email;
    private String phone;
    private String NIC;
    private String DOB;
}
