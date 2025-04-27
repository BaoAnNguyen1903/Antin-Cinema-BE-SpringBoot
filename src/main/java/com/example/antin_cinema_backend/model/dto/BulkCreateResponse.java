package com.example.antin_cinema_backend.model.dto;

public class BulkCreateResponse {
    private int countSuccess;
    private int countError;
    private String message;

    // Constructor
    public BulkCreateResponse(int countSuccess, int countError, String message) {
        this.countSuccess = countSuccess;
        this.countError = countError;
        this.message = message;
    }

    // Getter và Setter
    public int getCountSuccess() {
        return countSuccess;
    }

    public void setCountSuccess(int countSuccess) {
        this.countSuccess = countSuccess;
    }

    public int getCountError() {
        return countError;
    }

    public void setCountError(int countError) {
        this.countError = countError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}