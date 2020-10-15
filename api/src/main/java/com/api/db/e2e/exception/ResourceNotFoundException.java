package com.api.db.e2e.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String exception){
        super(exception);
    }
}
