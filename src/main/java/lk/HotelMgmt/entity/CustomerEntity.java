package lk.HotelMgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Customer")
public class CustomerEntity {
    @Id
    private String custId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy ="customer" )
    private List<BookingEntity> bookings;

    private String custName;
    private String email;
    private String phone;
    private String NIC;
    private String DOB;
}
