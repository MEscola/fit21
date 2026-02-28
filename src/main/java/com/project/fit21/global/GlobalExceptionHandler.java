package com.project.fit21.global;

import java.time.LocalDateTime;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.project.fit21.user.exception.EmailAlreadyExistsException;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT) // 409 Conflict
    @ResponseBody
    public ErrorResponse handlerEmailAlreadyExists(EmailAlreadyExistsException ex) {
        return new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(), // 409 Conflict
                ex.getMessage());
    }

    // TRATA ERROS DE VALIDAÇÃO DE DADOS (ex: @NotBlank, @Email, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationErrors(MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");

        return new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                message);
    }

}
