package com.valentin.wantsome.budget.domain_dao;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "expense_category")
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String categoryType;
    @OneToMany(mappedBy = "expenseCategory",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Expense> expenses;

    public ExpenseCategory() {}

    public ExpenseCategory(Long id, String categoryName, String categoryType, List<Expense> expenses) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.expenses = expenses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public void add(Expense expense){
        if (expense == null) {
            expenses = new ArrayList<>();
        }
        expenses.add(expense);
        expense.setExpenseCategory(this);
    }

    @Override
    public String toString() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseCategory that = (ExpenseCategory) o;
        return Objects.equals(id, that.id) && categoryName == that.categoryName && Objects.equals(categoryType, that.categoryType) && Objects.equals(expenses, that.expenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, categoryType, expenses);
    }
}
