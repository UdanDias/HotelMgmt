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
@Table(name="User")
public class UserEntity {
    @Id
    private String userId;
    private String username;
    private String email;
    private String password;
}
