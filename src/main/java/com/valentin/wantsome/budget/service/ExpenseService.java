package com.valentin.wantsome.budget.service;

import com.valentin.wantsome.budget.domain_dao.Expense;
import com.valentin.wantsome.budget.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;

    public void ExpenseRepository(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> findALl(){
        return expenseRepository.findALl();
    }

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }
}
