package com.api.db.e2e.service;


import com.api.db.e2e.exception.ResourceNotFoundException;
import com.api.db.e2e.model.Persons;
import com.api.db.e2e.repository.PersonsRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@SuppressWarnings("unchecked")
@NoArgsConstructor
@Service
public class PersonsServiceImp extends PersonsService {

    @Autowired
    private PersonsRepository personsRepository;

    @Override
    public Double getPriceById(int id) {
        return null;
    }

    @Override
    public Page<Persons> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Persons add(Persons o) {
        return null;
    }

    @Override
    public Persons update(Persons o, int id) {
        return null;
    }

    @Override
    public Persons getById(int id) {
        return null;
    }

    @Override
    public Persons deleteById(int id) {
        return null;
    }


    private Persons checkIfIdIsPresentAndReturnPerson(int id){

        if(!personsRepository.findById(id).isPresent()){
            throw new ResourceNotFoundException("Person id = "+id+" not found");
        }else{
            return personsRepository.findById(id).get();
        }
    }
}
