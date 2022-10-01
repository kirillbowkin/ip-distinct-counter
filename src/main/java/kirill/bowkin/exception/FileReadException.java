package kirill.bowkin.exception;

/**
 * @author Кирилл
 */
public class FileReadException extends RuntimeException{
    public FileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
