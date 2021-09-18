package com.id.simian.userservice.utils;

import com.id.simian.userservice.dto.response.ResponseError;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.List;


public class ErrorFieldUtils {

    private ErrorFieldUtils(){}

    public static ResponseEntity<Object> customErrors(List<ObjectError> errors) {
        ResponseError responseError = new ResponseError();
        try {
            String errorMessage = "";
            responseError.setStatus(400);
            responseError.setTimestamp(LocalDateTime.now());
            for (ObjectError objectError : errors) {
                if (objectError instanceof FieldError) {
                    FieldError fieldError = (FieldError) objectError;
                    errorMessage += ", " + fieldError.getDefaultMessage();
                }
            }
            responseError.setError(errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body(responseError);
    }
}
