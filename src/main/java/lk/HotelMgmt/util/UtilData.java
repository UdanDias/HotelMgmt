package lk.HotelMgmt.util;

import java.util.UUID;

public class UtilData {
     public static String generateBookingId(){
         return "B/-"+ UUID.randomUUID().toString();
     }
    public static String generateAdminId(){
        return "A/-"+ UUID.randomUUID().toString();
    }public static String generateCustomerId(){
        return "C/-"+ UUID.randomUUID().toString();
    }public static String generateFeedBackId(){
        return "F/-"+ UUID.randomUUID().toString();
    }public static String generateHotelId(){
        return "H/-"+ UUID.randomUUID().toString();
    }public static String generateRoomId(){
        return "R/-"+ UUID.randomUUID().toString();
    }public static String generateUserId(){
        return "U/-"+ UUID.randomUUID().toString();
    }


}
