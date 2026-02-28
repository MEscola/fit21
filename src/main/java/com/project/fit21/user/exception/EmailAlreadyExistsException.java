package com.project.fit21.user.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException (String email) {
        super("Email já cadastrado: " + email);
    }

}
