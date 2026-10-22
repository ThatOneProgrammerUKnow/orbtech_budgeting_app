package org.example.orbech_budgeting_app.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse(int status, String error, String message) {
        this.timeStamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public LocalDateTime getTimeStamp() { return this.timeStamp; }
    public int getStatus() { return this.status; }
    public String getError() { return this.error; }
    public String getMessage() { return this.message; }
}
