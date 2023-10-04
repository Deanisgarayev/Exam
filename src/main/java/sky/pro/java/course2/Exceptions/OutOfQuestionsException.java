package sky.pro.java.course2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OutOfQuestionsException extends RuntimeException {
    public OutOfQuestionsException() {
    }

    public OutOfQuestionsException(String message) {
        super(message);
    }

    public OutOfQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfQuestionsException(Throwable cause) {
        super(cause);
    }

    public OutOfQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
