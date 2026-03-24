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
@Table(name="User")
public class UserEntity {
    @Id
    private String userId;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<FeedBackEntity> feedbacks;

}
