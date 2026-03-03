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
    @OneToOne()
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity userId;
    @OneToMany
    @JoinColumn(name = "booking_id")
    private List<BookingEntity> bookingId;
    private String custName;
    private String email;
    private String phone;
    private String NIC;
    private String DOB;
}
