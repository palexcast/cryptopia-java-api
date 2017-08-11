package no.avexis.cryptopia.exceptions;

public class CryptopiaException extends Exception {
    public CryptopiaException() {
    }

    public CryptopiaException(String message) {
        super(message);
    }

    public CryptopiaException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptopiaException(Throwable cause) {
        super(cause);
    }

    public CryptopiaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
