package reservationapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(String entityType, int id) {
        super(String.format("%s with id %s not found", entityType, id));
    }

    public NotFoundException(String entityType, UUID id) {
        super(String.format("%s with id %s not found", entityType, id));
    }
}
