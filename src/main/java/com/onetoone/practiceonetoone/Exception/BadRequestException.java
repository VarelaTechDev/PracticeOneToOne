package com.onetoone.practiceonetoone.Exception;

public class BadRequestException extends RuntimeException{
    private String message;

    public BadRequestException(String message) {
        this.message = message;
    }

    public BadRequestException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
