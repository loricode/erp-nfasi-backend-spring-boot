package com.fasi.core.utils.customError;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;
	
    private final HttpStatus status;
    private final Object detail;

    public ApiException(HttpStatus status, String message, Object detail) {
        super(message);
        this.status = status;
        this.detail = detail;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Object getDetail() {
        return detail;
    }
}
