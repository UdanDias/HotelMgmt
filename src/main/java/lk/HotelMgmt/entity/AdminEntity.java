package lk.HotelMgmt.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Admin")

public class AdminEntity {
    @Id
    private String adminId;
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private UserEntity user;
    private String adminName;
    private String email;
    private String phone;
}
