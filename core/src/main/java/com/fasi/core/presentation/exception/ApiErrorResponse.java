package com.fasi.core.presentation.exception;

public class ApiErrorResponse {

    private int status;
    private String message;
    private Object detail;
    
    public ApiErrorResponse(int status, String message, Object detail) {
        this.status = status;
        this.message = message;
        this.detail = detail;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getDetail() {
        return detail;
    }
}