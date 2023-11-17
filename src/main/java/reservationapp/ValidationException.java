package reservationapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
//TODO As this is formatted now, it won't provider users with any info as to what the error is.
//need to revise to provide that info
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
