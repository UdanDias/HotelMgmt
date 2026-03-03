package lk.HotelMgmt.exceptions;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException() {
        super();
    }

    public AdminNotFoundException(String message) {
        super(message);
    }

    public AdminNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
