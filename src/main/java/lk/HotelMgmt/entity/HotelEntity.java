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
@Table(name="Hotel")
public class HotelEntity {
    @Id
    private String hotelId;
    private String hotelName;
    private String description;
    private String location;
    private Double rating;
    private String phone;
    private String email;
    private Integer availableRooms;
}
