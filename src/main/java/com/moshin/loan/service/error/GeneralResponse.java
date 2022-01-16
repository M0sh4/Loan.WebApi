package com.moshin.loan.service.error;

import java.util.ArrayList;
import java.util.List;

import com.moshin.loan.entity.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class GeneralResponse {
    
    public ResponseEntity<Object> response(BindingResult result){
        List<ErrorResponse> errors = new ArrayList<>();
        result.getFieldErrors().forEach(error -> errors.add(new ErrorResponse(error.getField(), error.getDefaultMessage())));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
