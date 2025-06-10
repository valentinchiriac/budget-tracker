package com.valentin.wantsome.budget.service;

import com.valentin.wantsome.budget.domain_dao.ExpenseCategory;
import com.valentin.wantsome.budget.repository.ExpenseCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryService {
    private ExpenseCategoryRepository expenseCategoryRepository;

    public ExpenseCategoryService(ExpenseCategoryRepository expenseCategoryRepository) { //constructor
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    public List<ExpenseCategory> findAll() {
        return expenseCategoryRepository.findAll();
    }

    public void save(ExpenseCategory expenseCategory) {
        expenseCategoryRepository.save(expenseCategory);
    }
}
