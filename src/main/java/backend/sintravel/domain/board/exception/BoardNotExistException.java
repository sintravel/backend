package backend.sintravel.domain.board.exception;

public class BoardNotExistException extends RuntimeException{
    public BoardNotExistException() {
        super();
    }

    public BoardNotExistException(String message) {
        super(message);
    }
}
