package com.marcoscouto.office.resource.exception;

import com.marcoscouto.office.exceptions.StandardErrors;
import com.marcoscouto.office.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardErrors> handleNotFoundException(UserNotFoundException e) {
        StandardErrors se = new StandardErrors(404, e.getMessage());
        return ResponseEntity.status(se.getCode()).body(se);
    }

}
