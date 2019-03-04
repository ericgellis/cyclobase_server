package fr.mobithink.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RollingPointNotFoundException extends RuntimeException {

    public RollingPointNotFoundException(Long rollingPointId) {
        super("could not find rollingPoint with id : " + rollingPointId);
    }
}
