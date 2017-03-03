package exceptions;

/**
 * Custom exception for browser parameter.
 */
public class InvalidBrowserException extends Exception {

    public InvalidBrowserException(String message) {
        super(message);
    }
}
