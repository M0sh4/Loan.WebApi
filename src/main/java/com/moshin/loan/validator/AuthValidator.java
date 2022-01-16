package com.moshin.loan.validator;

import com.moshin.loan.exceptions.ApiUnauthorized;

import org.springframework.stereotype.Component;

@Component
public class AuthValidator {
    
    public void validate(String cUsu, String cPass) throws ApiUnauthorized{
        if(cUsu.isEmpty() || cPass.isEmpty()){
            message("Parametros vacios");
        }
    }

    private void message(String message) throws ApiUnauthorized{
        throw new ApiUnauthorized(message);
    }
}
