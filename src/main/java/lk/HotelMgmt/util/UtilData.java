package lk.HotelMgmt.util;

import java.util.UUID;

public class UtilData {
     public String generateBookingId(){
         return "B/-"+ UUID.randomUUID().toString();
     }
    public String generateAdminId(){
        return "A/-"+ UUID.randomUUID().toString();
    }public String generateCustomerId(){
        return "C/-"+ UUID.randomUUID().toString();
    }public String generateFeedBackId(){
        return "F/-"+ UUID.randomUUID().toString();
    }public String generateHotelId(){
        return "H/-"+ UUID.randomUUID().toString();
    }public String generateRoomId(){
        return "R/-"+ UUID.randomUUID().toString();
    }public String generateUserId(){
        return "U/-"+ UUID.randomUUID().toString();
    }


}
