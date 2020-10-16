package com.api.db.e2e.controller;

import com.api.db.e2e.model.Persons;
import com.api.db.e2e.model.ResponseWrapper;
import com.api.db.e2e.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    @Autowired
    private PersonsService personsService;


    @DeleteMapping(value = "/id")
    public ResponseWrapper<Persons> deletePerson(@PathVariable(value = "id") String id){
            return new ResponseWrapper<>(personsService.deleteById(Integer.parseInt(id)), HttpStatus.OK);
    }
}
