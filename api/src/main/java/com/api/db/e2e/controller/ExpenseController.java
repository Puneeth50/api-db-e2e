package com.api.db.e2e.controller;

import com.api.db.e2e.model.Expenses;
import com.api.db.e2e.model.ResponseWrapper;
import com.api.db.e2e.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    @Autowired
    private ExpensesService expensesService;


    @GetMapping(value = "/id")
    public ResponseWrapper<Expenses> getPersonsExpenses(@Valid @PathVariable(value = "id") String id) {
        return new ResponseWrapper<>(expensesService.getById(Integer.parseInt(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseWrapper<Expenses> createExpenses(@Valid @RequestBody Expenses expenses) {
        return new ResponseWrapper<>(expensesService.add(expenses), HttpStatus.OK);

    }


    @PatchMapping(value = "/{id}")
    public ResponseWrapper<Expenses> updateExpenses(@Valid @RequestBody Expenses expenses, @Valid @PathVariable(value = "id") String id) {
        return new ResponseWrapper<>(expensesService.update(expenses, Integer.parseInt(id)), HttpStatus.OK);
    }

}
