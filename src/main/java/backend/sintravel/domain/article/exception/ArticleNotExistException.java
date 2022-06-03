package backend.sintravel.domain.article.exception;

public class ArticleNotExistException extends RuntimeException{
    public ArticleNotExistException(String message) {
        super(message);
    }
}
