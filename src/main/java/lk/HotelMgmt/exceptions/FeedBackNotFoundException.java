package lk.HotelMgmt.exceptions;

public class FeedBackNotFoundException extends RuntimeException {
    public FeedBackNotFoundException() {
        super();
    }

    public FeedBackNotFoundException(String message) {
        super(message);
    }

    public FeedBackNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
