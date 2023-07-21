package sky.pro.java.course2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItIsAbsentException extends RuntimeException {
    public ItIsAbsentException() {
    }

    public ItIsAbsentException(String message) {
        super(message);
    }

    public ItIsAbsentException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItIsAbsentException(Throwable cause) {
        super(cause);
    }

    public ItIsAbsentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
