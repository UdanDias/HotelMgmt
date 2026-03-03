package lk.HotelMgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Feedback")
public class FeedbackEntity {
    @Id
    private String feedBackId;
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity userId;
    @OneToOne
    @JoinColumn(name = "hotel_id",nullable = false)
    private HotelEntity hotelId;
    private String review;
}
