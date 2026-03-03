package lk.HotelMgmt.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
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


    public static LocalDate generateTodayDate(){
         return LocalDate.now();
    }
    public static Time generateCurrentTime(){
         return Time.valueOf(LocalTime.now());
    }


}
