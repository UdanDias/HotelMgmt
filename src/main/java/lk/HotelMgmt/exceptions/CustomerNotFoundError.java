package lk.HotelMgmt.exceptions;

public class CustomerNotFoundError extends RuntimeException {
    public CustomerNotFoundError() {
        super();
    }

    public CustomerNotFoundError(String message) {
        super(message);
    }

    public CustomerNotFoundError(String message, Throwable cause) {
        super(message, cause);
    }
}
