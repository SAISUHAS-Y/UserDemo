package com.user.exceptionHandler;

import com.user.exception.UserNotFoundException;
import com.user.utility.ErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> error(UserNotFoundException ex){
        ErrorStructure<String> errorStructure=new ErrorStructure<>();
        errorStructure.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorStructure.setErrorMessage(ex.getMessage());
        errorStructure.setError("User not found in the DB");
        return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
    }
}
