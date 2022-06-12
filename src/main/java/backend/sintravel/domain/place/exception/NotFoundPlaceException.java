package backend.sintravel.domain.place.exception;

public class NotFoundPlaceException extends RuntimeException{
    public NotFoundPlaceException(String message) {
        super(message);
    }
}
