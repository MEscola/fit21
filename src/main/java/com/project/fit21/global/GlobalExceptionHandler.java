package com.project.fit21.global;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.*;
import com.project.fit21.user.exception.EmailAlreadyExistsException;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handlerEmailAlreadyExists(EmailAlreadyExistsException ex) {
        return new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.CONFLICT.value(), // 409 Conflict
            ex.getMessage()
        );
    }

}
