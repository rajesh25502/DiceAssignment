package com.example.AssignmentDice.Exception;

import org.springframework.http.HttpStatus;

public class CustomErrorResponse {

    HttpStatus status;
    String message;
    Object stackTrace;
    Object data;
    public CustomErrorResponse(HttpStatus status, String message, Object stackTrace,Object data)
    {
        this.data=data;
        this.message=message;
        this.stackTrace=stackTrace;
        this.status=status;
    }

}
