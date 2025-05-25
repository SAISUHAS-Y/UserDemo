package com.user.utility;

import com.user.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponseBuilder {

    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = new ResponseStructure<>(); // ResponseStructure also needs to be <T>
        structure.setStatus(status.value());
        structure.setMessage(message);
        structure.setData(data);

        return new ResponseEntity<>(structure, status);
    }
}
