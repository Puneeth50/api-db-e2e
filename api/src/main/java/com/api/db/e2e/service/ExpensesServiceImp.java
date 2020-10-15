package com.api.db.e2e.service;

import com.api.db.e2e.exception.ResourceNotFoundException;
import com.api.db.e2e.model.Expenses;
import com.api.db.e2e.repository.ExpensesRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@SuppressWarnings("unchecked")
public class ExpensesServiceImp extends ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public Page<Expenses> getAll(Pageable pageable) {
        return expensesRepository.findAll(pageable);
    }

    @Override
    public Expenses add(Expenses o) {
        return expensesRepository.save(o);
    }

    @Override
    public Expenses update(Expenses o, int id) {
        Expenses expenses = checkIfIdIsPresentAndReturnExpenses(id);
        expenses.setId(o.getId());
        expenses.setDescription(o.getDescription());
        expenses.setPersonId(o.getPersonId());
        expenses.setPrice(o.getPrice());
        return expensesRepository.save(expenses);
    }

    @Override
    public Expenses getById(int id) {
        return checkIfIdIsPresentAndReturnExpenses(id);
    }

    @Override
    public Expenses deleteById(int id) {
        Expenses expenses = checkIfIdIsPresentAndReturnExpenses(id);
        expensesRepository.deleteById(id);
        return expenses;
    }


    private Expenses checkIfIdIsPresentAndReturnExpenses(int id){

        if(!expensesRepository.findById(id).isPresent()){
            throw new ResourceNotFoundException("Person id = "+id+" not found");
        }else{
            return expensesRepository.findById(id).get();
        }
    }
}
