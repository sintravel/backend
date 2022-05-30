package backend.sintravel.auth.exception;

public class CantSignInException extends RuntimeException{
    public CantSignInException(String message) {
        super(message);
    }
}
