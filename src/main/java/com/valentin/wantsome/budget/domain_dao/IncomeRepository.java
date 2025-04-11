package com.valentin.wantsome.budget.domain_dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class IncomeRepository {
    private List<Income> income;
    private long idIncome = 1L;

    //constructor to initialize the income list
    public void IncomeRepository() {this.income = new ArrayList<>();}

    //method to return a predefined list of income
    public List<Income> findIncome() {
        return List.of(
               new Income(1L, new Date(), "Salary", 3000, 1L)
        );
    }

    //method to return all saved income
    public List<Income> findALl(){
        return income;
    }

    //method to save an income with automatic ID assignment
    public void save(Income income) {
        income.setIncomeId(idIncome++);
        System.out.println("Income saved " + income);

        income.add(income);
    }
}
