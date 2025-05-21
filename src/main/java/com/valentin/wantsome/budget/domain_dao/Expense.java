package com.valentin.wantsome.budget.domain_dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue
    private Long expenseId;
    private Date expenseDate;
    private String expenseName;
    private double expenseAmount;
    private Long expenseCategoryId;

    public Expense() {
    }

    public Expense(Long expenseId, Date expenseDate, String expenseName, double expenseAmount, Long expenseCategoryId) {
        this.expenseId = expenseId;
        this.expenseDate = expenseDate;
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.expenseCategoryId = expenseCategoryId;
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

    public Long getExpenseCategoryId() {
        return expenseCategoryId;
    }

    public void setExpenseCategoryId(Long expenseCategoryId) {
        this.expenseCategoryId = expenseCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Double.compare(expenseAmount, expense.expenseAmount) == 0 && Objects.equals(expenseId, expense.expenseId) && Objects.equals(expenseDate, expense.expenseDate) && Objects.equals(expenseName, expense.expenseName) && Objects.equals(expenseCategoryId, expense.expenseCategoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId, expenseDate, expenseName, expenseAmount, expenseCategoryId);
    }

    @Override
    public String toString() {
        return "expense{" +
                "expenseId=" + expenseId +
                ", expenseDate=" + expenseDate +
                ", expenseName='" + expenseName + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", categoryId=" + expenseCategoryId +
                '}';
    }
}
