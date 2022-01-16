package com.moshin.loan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    
    private String cCampo;

    private String cErrorMessage;
}
