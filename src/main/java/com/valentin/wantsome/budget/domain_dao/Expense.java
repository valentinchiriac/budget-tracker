package com.valentin.wantsome.budget.domain_dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Expense {
    private Long expenseId;
    private Date expenseDate;
    private String expenseName;
    private double expenseAmount;
    private Long categoryId;

    public Expense(Long expenseId, Date expenseDate, String expenseName, double expenseAmount, Long categoryId) {
        this.expenseId = expenseId;
        this.expenseDate = expenseDate;
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.categoryId = categoryId;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Double.compare(expenseAmount, expense.expenseAmount) == 0 && Objects.equals(expenseId, expense.expenseId) && Objects.equals(expenseDate, expense.expenseDate) && Objects.equals(expenseName, expense.expenseName) && Objects.equals(categoryId, expense.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId, expenseDate, expenseName, expenseAmount, categoryId);
    }

    @Override
    public String toString() {
        return "expense{" +
                "expenseId=" + expenseId +
                ", expenseDate=" + expenseDate +
                ", expenseName='" + expenseName + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", categoryId=" + categoryId +
                '}';
    }
}
