package com.api.db.e2e.model;

import com.api.db.e2e.exception.ResourceNotFoundException;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ResultSet<T> {

    private HttpStatus status;

    private T data;

    private ResultSet() {

    }

    public ResultSet(T o, HttpStatus status) throws ResourceNotFoundException {

        this();
        if (o == null || (o instanceof List && ((List) o).isEmpty()))
            throw new ResourceNotFoundException("No Content Found");
        this.status = status;
        this.data = o;
    }


}
