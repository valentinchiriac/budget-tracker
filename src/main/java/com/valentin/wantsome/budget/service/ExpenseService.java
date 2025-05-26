package com.valentin.wantsome.budget.service;

import com.valentin.wantsome.budget.domain_dao.Expense;
import com.valentin.wantsome.budget.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;

    public void ExpenseRepository(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;    }

    public List<Expense> getExpense(){
        List<Expense> expenses = (List<Expense>) expenseRepository.findAll();
        return expenses;
    }

    public Expense addExpense(Expense expense) {return expenseRepository.save(expense);}

    public Optional<Expense> getExpense(int id) {return expenseRepository.findById(id);}

    public void updateExpense(Expense expense,int id){
        if (expenseRepository.existsById(id)) {
            expense.setExpenseId(id);
            expenseRepository.save(expense);
        }else{
            throw new RuntimeException("Expense not found");
        }
    }

    public void deleteExpenseById(int id){
        if(expenseRepository.existsById(id)){
            expenseRepository.deleteById(id);
        }else{
            throw new RuntimeException("Expense not found");
        }
    }

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

//    public List<Expense> findALl(){
//        return expenseRepository.findAll();
//    }

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }
}
