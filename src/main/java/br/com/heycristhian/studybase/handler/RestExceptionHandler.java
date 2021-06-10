package br.com.heycristhian.studybase.handler;

import br.com.heycristhian.studybase.error.RequestError;
import br.com.heycristhian.studybase.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Arrays;

@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<RequestError> handleUserNotFoundException(UserNotFoundException e) {
        var status = HttpStatus.NOT_FOUND;
        RequestError requestError = getRequestError(e, "User not foud", status);
        LOGGER.error("User not found: " + Arrays.toString(e.getStackTrace()));
        return ResponseEntity.status(status).body(requestError);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RequestError> handleIllegalArgumentException(IllegalArgumentException e) {
        var status = HttpStatus.BAD_REQUEST;
        RequestError requestError = getRequestError(e, "Illegal Argument Exception", status);
        LOGGER.error("User not found: " + Arrays.toString(e.getStackTrace()));
        return ResponseEntity.status(status).body(requestError);
    }

    private RequestError getRequestError(Exception e, String title, HttpStatus status) {
        return RequestError.builder()
                .title(title)
                .status(status.value())
                .message(e.getMessage())
                .localDateTime(LocalDateTime.now())
                .classPath(e.getClass().getName())
                .build();
    }
}
