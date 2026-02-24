package lk.HotelMgmt.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
@Table(name="Admin")

public class AdminEntity {
    @Id
    private String adminId;
    private String userId;
    private String adminName;
    private String email;;
    private String phone;
}
