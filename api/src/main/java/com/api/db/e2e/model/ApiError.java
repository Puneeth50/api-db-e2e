package com.api.db.e2e.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private HttpStatus httpStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime localDateTime;

    private String message;

    private String debugMessage;

    private ApiError() {
        localDateTime = LocalDateTime.now();
    }


    public ApiError(HttpStatus httpStatus) {
        this();
        this.httpStatus = httpStatus;
    }


    public ApiError(HttpStatus httpStatus, Throwable ex) {

        this();
        this.httpStatus = httpStatus;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }


    public ApiError(HttpStatus httpStatus, String message, Throwable ex) {

        this();
        this.httpStatus = httpStatus;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();

    }


}
