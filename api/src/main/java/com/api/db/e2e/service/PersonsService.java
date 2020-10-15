package com.api.db.e2e.service;

import com.api.db.e2e.model.Persons;

public abstract class PersonsService implements MainService<Persons> {

    public abstract Double getPriceById(int id);

}
