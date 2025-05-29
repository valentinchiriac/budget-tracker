package com.valentin.wantsome.budget.domain_dao;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date expenseDate;
    private String expenseName;
    private double expenseAmount;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="category_id")
    private ExpenseCategory expenseCategory;

    public Expense() {
    }

    public Expense(long id, Date expenseDate, String expenseName, double expenseAmount, ExpenseCategory expenseCategory) {
        this.id = id;
        this.expenseDate = expenseDate;
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.expenseCategory = expenseCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Double.compare(expenseAmount, expense.expenseAmount) == 0 && Objects.equals(id, expense.id) && Objects.equals(expenseDate, expense.expenseDate) && Objects.equals(expenseName, expense.expenseName) && Objects.equals(expenseCategory, expense.expenseCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expenseDate, expenseName, expenseAmount, expenseCategory);
    }

    @Override
    public String toString() {
        return "expense{" +
                "expenseId=" + id +
                ", expenseDate=" + expenseDate +
                ", expenseName='" + expenseName + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", categoryId=" + expenseCategory +
                '}';
    }
}
