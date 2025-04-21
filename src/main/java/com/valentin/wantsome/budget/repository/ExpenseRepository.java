package com.valentin.wantsome.budget.repository;

import com.valentin.wantsome.budget.domain_dao.Expense;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ExpenseRepository {
    private List<Expense> expenses;
    private long idExpense = 1L;

    //constructor to initialize the expenses list
    public void ExpenseRepository() {this.expenses = new ArrayList<>();}

    //method to return a predefined list of expenses
    public List<Expense> findExpenses() {
        return List.of(
                new Expense(1L, new Date(), "Energy Bill", 1200, 1L)
        );
    }

    //method to return all saved expenses
    public List<Expense> findALl(){
        return expenses;
    }

    //method to save an expense with automatic ID assignment
    public void save(Expense expense) {
        expense.setExpenseId(idExpense++);
        System.out.println("Expense saved " + expense);

        expenses.add(expense);
    }
}