package com.valentin.wantsome.budget.service;

import com.valentin.wantsome.budget.domain_dao.Expense;
import com.valentin.wantsome.budget.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository; //made final

    public ExpenseService(ExpenseRepository expenseRepository) { //constructor
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense getExpense(long id) {
        //return expenseRepository.findById(id);
        return expenseRepository.findByExpenseId(id);
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void updateExpense(Expense expense, Long id) {
        if (expenseRepository.existsById(id)) {
            expense.setId(id);
            expenseRepository.save(expense);
        } else {
            throw new RuntimeException("Expense not found");
        }
    }

    public void deleteExpenseById(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Expense not found");
        }
    }

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }
}
